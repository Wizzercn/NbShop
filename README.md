# NutzShop
基于NutzWk的开源商城系统


# elasticsearch
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