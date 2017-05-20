# NutzShop
基于NutzWk的开源商城系统

(因工作及成本问题,目前只完成了商品规格、商品类型、商品类别、商品分类、商品发布功能……）

# redis (必须启用)
用在shiro二级缓存、主键生成器等处

# elasticsearch（暂未用到）
1、搜索引擎服务  https://www.elastic.co/downloads/elasticsearch    v5.0.1

2、中文分词插件  https://github.com/NLPchina/elasticsearch-analysis-ansj

./bin/elasticsearch-plugin install http://maven.nlpcn.org/org/ansj/elasticsearch-analysis-ansj/5.0.1.0/elasticsearch-analysis-ansj-5.0.1.0-release.zip

3、elasticsearch-head v5插件安装：
安装node
>git clone git://github.com/mobz/elasticsearch-head.git
>cd elasticsearch-head
>npm i
>npm i grunt-cli -g
>grunt server

1）elasticsearch.yml 增加配置项
>http.cors.enabled: true
>http.cors.allow-origin: /http?:\/\/127.0.0.1(:[0-9]+)?/

2）Gruntfile.js 增加hostname配置项

connect: {
			server: {
				options: {
					port: 9100,
					hostname: '*',
					base: '.',
					keepalive: true
				}
			}
		}

http://localhost:9100/
