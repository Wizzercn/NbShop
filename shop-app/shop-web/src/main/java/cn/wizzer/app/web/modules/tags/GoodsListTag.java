package cn.wizzer.app.web.modules.tags;

import cn.wizzer.app.goods.modules.models.Goods_class;
import cn.wizzer.app.goods.modules.models.Goods_goods;
import cn.wizzer.app.goods.modules.models.Goods_product;
import cn.wizzer.app.goods.modules.services.GoodsClassService;
import cn.wizzer.app.goods.modules.services.GoodsProductService;
import cn.wizzer.app.web.commons.ext.es.EsService;
import cn.wizzer.framework.page.Pagination;
import cn.wizzer.framework.util.CookieUtil;
import cn.wizzer.framework.util.StringUtil;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.beetl.core.GeneralVarTagBinding;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.nutz.dao.Cnd;
import org.nutz.ioc.impl.PropertiesProxy;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wizzer on 2017/6/3.
 */
@IocBean
public class GoodsListTag extends GeneralVarTagBinding {
    private final static Log log = Logs.get();
    @Inject
    private EsService esService;
    @Inject
    private GoodsClassService goodsClassService;
    @Inject
    private GoodsProductService goodsProductService;
    @Inject
    private PropertiesProxy cfg;

    @Override
    public void render() {
        String classId = Strings.sNull(this.getAttributeValue("classId"));
        String title = Strings.sNull(this.getAttributeValue("title"));
        String keyword = Strings.sNull(this.getAttributeValue("keyword"));
        String sortName = Strings.sNull(this.getAttributeValue("sortName"));
        String sortOrder = Strings.sNull(this.getAttributeValue("sortOrder"));
        boolean explain = BooleanUtils.toBoolean(Strings.sNull(this.getAttributeValue("explain")));
        int pageNumber = NumberUtils.toInt(Strings.sNull(this.getAttributeValue("pageNumber")), 1);
        int pageSize = NumberUtils.toInt(Strings.sNull(this.getAttributeValue("pageSize")), 10);
        Pagination page = new Pagination();
        page.setPageNo(pageNumber);
        page.setPageSize(pageSize);
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        //商品分类（包含子分类）
        if (Strings.isNotBlank(classId)) {
            List<String> classIdList = new ArrayList<>();
            classIdList.add(classId);
            Goods_class gc = goodsClassService.getGoodsClass(Cnd.where("id", "=", classId));
            if (gc != null && Strings.isNotBlank(gc.getPath())) {
                List<Goods_class> list = goodsClassService.getList(Cnd.where("path", "like", gc.getPath() + "_%").and("disabled","=",false));
                for (Goods_class goodsClass : list)
                    classIdList.add(goodsClass.getId());
            }
            for (String id : classIdList) {
                query.must(QueryBuilders.matchPhraseQuery("classId", id));
            }
        }
        //根据商品名称查询
        if (Strings.isNotBlank(title)) {
            String[] keys = StringUtils.split(title, " ");
            BoolQueryBuilder titleQuery = QueryBuilders.boolQuery();
            for (String key : keys) {
                if (Strings.isNotBlank(key)) {
                    titleQuery.should(QueryBuilders.wildcardQuery("name", "*" + key.toLowerCase() + "*"));
                    titleQuery.should(QueryBuilders.wildcardQuery("title", "*" + key.toLowerCase() + "*"));
                    titleQuery.should(QueryBuilders.wildcardQuery("spec", "*" + key.toLowerCase() + "*"));
                }
            }
            query.must(titleQuery);
        }
        //根据关键词查询
        if (Strings.isNotBlank(keyword)) {
            String[] keys = StringUtils.split(keyword, " ");
            BoolQueryBuilder keywordQuery = QueryBuilders.boolQuery();
            for (String key : keys) {
                if (Strings.isNotBlank(key)) {
                    keywordQuery.should(QueryBuilders.wildcardQuery("name", "*" + key.toLowerCase() + "*"));
                    keywordQuery.should(QueryBuilders.matchPhraseQuery("name", key));
                    keywordQuery.should(QueryBuilders.matchPhraseQuery("title", key));
                    keywordQuery.should(QueryBuilders.matchPhraseQuery("spec", key));
                    keywordQuery.should(QueryBuilders.matchPhraseQuery("note", key));
                }
            }
            query.must(keywordQuery);
        }
        //没有删除的商品
        query.must(QueryBuilders.termQuery("delFlag", false));
        //是上架商品
        query.must(QueryBuilders.termQuery("disabled", false));
        //log.debug("query:::\r\n" + query.toString());
        SearchRequestBuilder srb = esService.getClient().prepareSearch(cfg.get("es.index.name"))
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setTypes("goods")
                .setQuery(query)
                //分页
                .setFrom((pageNumber - 1) * pageSize).setSize(pageSize)
                //是否高亮
                .setExplain(explain);
        if (explain) {
            HighlightBuilder highlightBuilder = new HighlightBuilder().field("*").requireFieldMatch(false);
            highlightBuilder.preTags("<span style=\"color:red\">");
            highlightBuilder.postTags("</span>");
            srb.highlighter(highlightBuilder);
        }
        if (Strings.isNotBlank(sortName)) {
            String[] sortNames = StringUtils.split(sortName, ",");
            if ("asc".equalsIgnoreCase(sortOrder)) {
                for (String s : sortNames)
                    srb.addSort(s, SortOrder.ASC);
            } else {
                for (String s : sortNames)
                    srb.addSort(s, SortOrder.DESC);
            }
        }
        SearchResponse response = srb.execute().actionGet();
        SearchHits hits = response.getHits();
        page.setTotalCount((int) hits.getTotalHits());
        List<NutMap> list = new ArrayList<>();
        hits.forEach(searchHit -> {
            Map<String, Object> source = searchHit.getSource();
            Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();
            //name高亮
            HighlightField nameField = highlightFields.get("name");
            if (nameField != null) {
                Text[] fragments = nameField.fragments();
                String tmp = "";
                for (Text text : fragments) {
                    tmp += text;
                }
                source.put("name", tmp);
            }
            //name高亮
            HighlightField titleField = highlightFields.get("title");
            if (titleField != null) {
                Text[] fragments = titleField.fragments();
                String tmp = "";
                for (Text text : fragments) {
                    tmp += text;
                }
                source.put("title", tmp);
            }
            Goods_goods goods = Lang.map2Object(source, Goods_goods.class);
            String pid = "";
            for (Goods_product p : goods.getProductList()) {
                if (p.isDefault()) {
                    pid = p.getId();
                    break;
                }
            }
            NutMap map = goodsProductService.getPrice(goods.getId(), pid, StringUtil.getMemberUid());
            list.add(NutMap.NEW().addv("id", goods.getId()).addv("title", goods.getTitle()).addv("name", goods.getName()).addv("imgurl", goods.getImgurl()).addv("pid", pid)
                    .addv("price", map.getInt("price")).addv("priceMarket", map.getInt("priceMarket")));
        });
        page.setList(list);
        this.binds(page);
        this.doBodyRender();
    }
}
