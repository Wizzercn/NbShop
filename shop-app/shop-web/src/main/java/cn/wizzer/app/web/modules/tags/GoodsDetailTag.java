package cn.wizzer.app.web.modules.tags;

import cn.wizzer.app.goods.modules.models.Goods_goods;
import cn.wizzer.app.goods.modules.services.GoodsClassService;
import cn.wizzer.app.web.commons.ext.es.EsService;
import org.beetl.core.GeneralVarTagBinding;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.nutz.ioc.impl.PropertiesProxy;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import java.util.Map;

/**
 * Created by wizzer on 2017/6/3.
 */
@IocBean
public class GoodsDetailTag extends GeneralVarTagBinding {
    private final static Log log = Logs.get();
    @Inject
    private EsService esService;
    @Inject
    private GoodsClassService goodsClassService;
    @Inject
    private PropertiesProxy cfg;

    @Override
    public void render() {
        String id = Strings.sNull(this.getAttributeValue("id"));
        BoolQueryBuilder query = QueryBuilders.boolQuery();
        query.must(QueryBuilders.termQuery("id", id));
        //没有删除的商品
        query.must(QueryBuilders.termQuery("delFlag", false));
        //是上架商品
        query.must(QueryBuilders.termQuery("disabled", false));
        //log.debug("query:::\r\n" + query.toString());
        SearchRequestBuilder srb = esService.getClient().prepareSearch(cfg.get("es.index.name"))
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setTypes("goods")
                .setQuery(query);
        SearchResponse response = srb.execute().actionGet();
        SearchHits hits = response.getHits();
        Goods_goods goods = new Goods_goods();
        if (hits.getTotalHits() > 0) {
            Map<String, Object> source = hits.getAt(0).getSource();
            goods = Lang.map2Object(source, Goods_goods.class);
        }
        this.binds(goods);
        this.doBodyRender();
    }
}
