package cn.wizzer.app.web.commons.es;

import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.nutz.ioc.impl.PropertiesProxy;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.lang.Lang;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import java.net.InetAddress;
import java.util.List;

import static org.elasticsearch.rest.RestStatus.OK;

/**
 * Created by wizzer on 2017/6/1.
 */
@IocBean(create = "getClient", depose = "destroy")
public class EsService {
    private final static Log log = Logs.get();
    public static TransportClient client;
    @Inject
    private PropertiesProxy config;

    /**
     * 判断指定的索引是否存在
     *
     * @param indexName 索引名
     * @return true/false
     */
    public boolean isExistsIndex(String indexName) {
        IndicesExistsResponse response =
                getClient().admin().indices().exists(
                        new IndicesExistsRequest().indices(new String[]{indexName})).actionGet();
        return response.isExists();
    }

    /**
     * 判断指定的索引的类型是否存在
     *
     * @param indexName 索引名
     * @param indexType 索引类型
     * @return true/false
     */
    public boolean isExistsType(String indexName, String indexType) {
        TypesExistsResponse response =
                getClient().admin().indices()
                        .typesExists(new TypesExistsRequest(new String[]{indexName}, indexType)
                        ).actionGet();
        return response.isExists();
    }

    /**
     * 删除索引
     *
     * @param indexName 索引名
     * @return true/false
     */
    public boolean deleteIndex(String indexName) {
        DeleteIndexResponse response =
                getClient().admin().indices().prepareDelete(indexName).execute().actionGet();
        return response.isAcknowledged();
    }

    /**
     * 创建索引
     *
     * @param indexName 索引名
     * @return true/false
     */
    public boolean createIndex(String indexName) {
        CreateIndexResponse response =
                getClient().admin().indices().prepareCreate(indexName).execute().actionGet();
        return response.isAcknowledged();
    }

    /**
     * 创建或更新文档
     *
     * @param indexName 索引名
     * @param type      数据类型
     * @param id        主键
     * @param obj       对象
     * @return
     */
    public boolean createOrUpdateData(String indexName, String type, String id, Object obj) {
        IndexResponse response = getClient().prepareIndex(indexName, type).setId(id).setSource(Lang.obj2map(obj)).execute().actionGet();
        log.debug("createOrUpdateData response:::" + Json.toJson(response));
        return response.getResult() == DocWriteResponse.Result.CREATED || response.getResult() == DocWriteResponse.Result.UPDATED;
    }

    /**
     * 创建或更新文档
     *
     * @param indexName 索引名
     * @param type      数据类型
     * @param id        主键
     * @return
     */
    public boolean deleteData(String indexName, String type, String id) {
        DeleteResponse response = getClient().prepareDelete().setIndex(indexName).setType(type).setId(id).execute().actionGet();
        return response.getResult() == DocWriteResponse.Result.DELETED;
    }

    /**
     * 批量创建或更新文档
     *
     * @param indexName 索引名
     * @param type      数据类型
     * @param list      包含id和obj的NutMao集合对象
     */
    public void createOrUpdateData(String indexName, String type, List<NutMap> list) {
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        if (list.size() > 0) {
            for (NutMap nutMap : list) {
                bulkRequest.add(getClient().prepareIndex(indexName, type).setId(nutMap.getString("id")).setSource(Lang.obj2map(nutMap.get("obj"))));
            }
            bulkRequest.execute().actionGet();
        }
    }

    /**
     * 初始化ES客户端
     *
     * @return TransportClient
     */
    public TransportClient getClient() {
        try {
            if (client == null) {
                Settings esSettings = Settings.builder()
                        .put("cluster.name", config.get("es.cluster.name", "elasticsearch")) //设置ES实例的名称
                        .put("client.transport.sniff", config.getBoolean("es.client.transport.sniff", true)) //自动嗅探整个集群的状态，把集群中其他ES节点的ip添加到本地的客户端列表中
                        .build();
                client = new PreBuiltTransportClient(esSettings);
                client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(config.get("es.ip", "127.0.0.1")), config.getInt("es.port", 9300)));
            }
        } catch (Exception e) {
            log.error(e);
        }
        return client;
    }

    public void destroy() {
        try {
            client.close();
        } catch (Exception e) {
            log.error(e);
        }
    }
}
