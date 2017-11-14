/*
SQLyog Ultimate v8.32 
MySQL - 5.7.18-log : Database - nutzshop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `cms_article` */

CREATE TABLE `cms_article` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `shopid` varchar(32) DEFAULT NULL COMMENT '预留商城ID',
  `title` varchar(120) DEFAULT NULL COMMENT '文章标题',
  `info` varchar(500) DEFAULT NULL COMMENT '文章简介',
  `author` varchar(50) DEFAULT NULL COMMENT '文章作者',
  `url` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `picurl` varchar(255) DEFAULT NULL COMMENT '标题图',
  `content` text COMMENT '文章内容',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `publishAt` int(32) DEFAULT NULL COMMENT '发布时间',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `channelId` varchar(32) DEFAULT NULL,
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_article` */

/*Table structure for table `cms_channel` */

CREATE TABLE `cms_channel` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `shopid` varchar(32) DEFAULT NULL COMMENT '预留商城ID',
  `parentId` varchar(32) DEFAULT NULL COMMENT '父级ID',
  `path` varchar(100) DEFAULT NULL COMMENT '树路径',
  `name` varchar(100) DEFAULT NULL COMMENT '栏目名称',
  `code` varchar(100) DEFAULT NULL COMMENT '栏目名称',
  `type` varchar(20) DEFAULT NULL COMMENT '栏目类型',
  `url` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `target` varchar(20) DEFAULT NULL COMMENT '打开方式',
  `isShow` tinyint(1) DEFAULT NULL COMMENT '是否显示',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `hasChildren` tinyint(1) DEFAULT NULL COMMENT '有子节点',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_CMS_CHANNEL` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_channel` */

/*Table structure for table `cms_class_link` */

CREATE TABLE `cms_class_link` (
  `classId` varchar(32) DEFAULT NULL,
  `linkId` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_class_link` */

/*Table structure for table `cms_link` */

CREATE TABLE `cms_link` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `name` varchar(120) DEFAULT NULL COMMENT '链接名称',
  `type` varchar(20) DEFAULT NULL COMMENT '链接类型',
  `picurl` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `url` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `target` varchar(20) DEFAULT NULL COMMENT '打开方式',
  `classId` varchar(32) DEFAULT NULL,
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_link` */

/*Table structure for table `cms_link_class` */

CREATE TABLE `cms_link_class` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `name` varchar(120) DEFAULT NULL COMMENT '分类名称',
  `code` varchar(120) DEFAULT NULL COMMENT '分类编码',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_CMS_LINK_CLASS` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_link_class` */

/*Table structure for table `cms_site` */

CREATE TABLE `cms_site` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `shopid` varchar(32) DEFAULT NULL COMMENT '预留商城ID',
  `site_name` varchar(120) DEFAULT NULL COMMENT '名称',
  `site_domain` varchar(120) DEFAULT NULL COMMENT '域名',
  `site_icp` varchar(120) DEFAULT NULL COMMENT 'ICP',
  `site_logo` varchar(255) DEFAULT NULL COMMENT 'LOGO',
  `site_wap_logo` varchar(255) DEFAULT NULL COMMENT 'WAPLOGO',
  `site_qq` varchar(20) DEFAULT NULL COMMENT '客服QQ',
  `site_email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `site_tel` varchar(20) DEFAULT NULL COMMENT '电话',
  `weibo_name` varchar(50) DEFAULT NULL COMMENT '微博',
  `weibo_url` varchar(255) DEFAULT NULL COMMENT '微博地址',
  `weibo_qrcode` varchar(255) DEFAULT NULL COMMENT '微博二维码',
  `wechat_name` varchar(50) DEFAULT NULL COMMENT '微信名称',
  `wechat_id` varchar(50) DEFAULT NULL COMMENT '微信ID',
  `wechat_qrcode` varchar(255) DEFAULT NULL COMMENT '微信二维码',
  `seo_keywords` varchar(255) DEFAULT NULL COMMENT '关键词',
  `seo_description` varchar(255) DEFAULT NULL COMMENT '描述',
  `footer_content` text COMMENT '底部版权',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cms_site` */

/*Table structure for table `goods_brand` */

CREATE TABLE `goods_brand` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `name` varchar(255) DEFAULT NULL COMMENT '品牌名称',
  `url` varchar(255) DEFAULT NULL COMMENT '品牌网址',
  `imgurl` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `note` text COMMENT '品牌介绍',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_brand` */

insert  into `goods_brand`(`id`,`name`,`url`,`imgurl`,`note`,`location`,`opBy`,`opAt`,`delFlag`) values ('64cdd974fbdd4438ae18a706bdb3ed4b','苹果','http://weibo.com/ajaxlogin.php?framelogin=1&callback=parent.sinaSSOController.feedBackUrlCallBack','/upload/image/20171114/3ar8bjbqouh01r0010hl8tpg4j.jpg','<p>事实上</p>',1,'afe39b04690c4a5c8d74e7d8b8668d7d',1510636518,0);

/*Table structure for table `goods_class` */

CREATE TABLE `goods_class` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `parentId` varchar(32) DEFAULT NULL COMMENT '父级ID',
  `path` varchar(100) DEFAULT NULL COMMENT '树路径',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `typeId` varchar(32) DEFAULT NULL COMMENT '商品类型',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `hasChildren` tinyint(1) DEFAULT NULL COMMENT '有子节点',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_class` */

insert  into `goods_class`(`id`,`parentId`,`path`,`name`,`typeId`,`disabled`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('89f629e187d64c97b1dc6c5a1b39f4d7','','0001','手机数码','',0,1,1,'afe39b04690c4a5c8d74e7d8b8668d7d',1510638833,0);
insert  into `goods_class`(`id`,`parentId`,`path`,`name`,`typeId`,`disabled`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('d093e2576ea84e3aa342940567c590ee','89f629e187d64c97b1dc6c5a1b39f4d7','00010001','智能手机','8d821957b963478dab94ba93b81c15ed',0,2,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1510638845,0);

/*Table structure for table `goods_goods` */

CREATE TABLE `goods_goods` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `storeId` varchar(32) DEFAULT NULL COMMENT '预留商城ID',
  `name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `title` varchar(255) DEFAULT NULL COMMENT '商品标题',
  `classId` varchar(32) DEFAULT NULL COMMENT '商品分类',
  `typeId` varchar(32) DEFAULT NULL COMMENT '商品类型',
  `brandId` varchar(32) DEFAULT NULL COMMENT '商品品牌',
  `imgurl` varchar(255) DEFAULT NULL COMMENT '商品主图',
  `note` text COMMENT '商品详情',
  `prop` text COMMENT '属性详情',
  `spec` text COMMENT '规格详情',
  `param` text COMMENT '参数详情',
  `hasSpec` tinyint(1) DEFAULT NULL COMMENT '启用规格',
  `unit` varchar(25) DEFAULT NULL COMMENT '计量单位',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否下架',
  `upAt` int(32) DEFAULT NULL COMMENT '上架时间',
  `downAt` int(32) DEFAULT NULL COMMENT '下架时间',
  `numView` int(32) DEFAULT '0' COMMENT '浏览量',
  `numComment` int(32) DEFAULT '0' COMMENT '评论量',
  `numSale` int(32) DEFAULT '0' COMMENT '销售量',
  `numSaleWeek` int(32) DEFAULT '0' COMMENT '周销售量',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_goods` */

insert  into `goods_goods`(`id`,`storeId`,`name`,`title`,`classId`,`typeId`,`brandId`,`imgurl`,`note`,`prop`,`spec`,`param`,`hasSpec`,`unit`,`disabled`,`upAt`,`downAt`,`numView`,`numComment`,`numSale`,`numSaleWeek`,`location`,`opBy`,`opAt`,`delFlag`) values ('0202550cacab4b5eafcab95154f6d965',NULL,'全宇宙第一强机','','d093e2576ea84e3aa342940567c590ee','8d821957b963478dab94ba93b81c15ed','64cdd974fbdd4438ae18a706bdb3ed4b','/upload/image/20171114/5voleogjrmjg7ragdrjp7tm0o0_s.jpg','<p>飒飒飒飒</p>','[]','[[{\"spec_name\":\"颜色\",\"spec_type\":\"0\",\"spec_id\":\"7d018e54e8564207ae0761c8fe07bc39\",\"spec_value_id\":\"91e5fd0781854ac39b9a0069d95ab488\",\"spec_value_name\":\"红色\"},{\"spec_name\":\"颜色\",\"spec_type\":\"0\",\"spec_id\":\"7d018e54e8564207ae0761c8fe07bc39\",\"spec_value_id\":\"ea0a0a8d78ed48d38b62f4cf0210eed3\",\"spec_value_name\":\"白色\"}],[{\"spec_name\":\"内存\",\"spec_type\":\"0\",\"spec_id\":\"519138945cdd4fac9013d460a976718d\",\"spec_value_id\":\"be0cdf50825246d085956bc3504a0052\",\"spec_value_name\":\"32G\"},{\"spec_name\":\"内存\",\"spec_type\":\"0\",\"spec_id\":\"519138945cdd4fac9013d460a976718d\",\"spec_value_id\":\"a13605312856406b8113bddf906eec14\",\"spec_value_name\":\"64G\"}]]','[{\"name\":\"显示\",\"value\":[{\"name\":\"分辨率\",\"value\":\"800*600\"}]}]',1,'部',0,1510639076,NULL,0,0,0,0,1,'',1510639143,0);

/*Table structure for table `goods_images` */

CREATE TABLE `goods_images` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `goodsId` varchar(32) DEFAULT NULL COMMENT '商品ID',
  `imgurl` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_images` */

insert  into `goods_images`(`id`,`goodsId`,`imgurl`,`location`,`opBy`,`opAt`,`delFlag`) values ('4b5e0da6ce8f4c36b35536526b3f9f3b','0202550cacab4b5eafcab95154f6d965','/upload/image/20171114/5voleogjrmjg7ragdrjp7tm0o0_s.jpg',1,'afe39b04690c4a5c8d74e7d8b8668d7d',1510639143,0);

/*Table structure for table `goods_lv_price` */

CREATE TABLE `goods_lv_price` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `goodsId` varchar(32) DEFAULT NULL COMMENT '商品ID',
  `productId` varchar(32) DEFAULT NULL COMMENT '货品ID',
  `lvId` varchar(128) DEFAULT NULL COMMENT '等级ID',
  `lvPrice` int(32) DEFAULT NULL COMMENT '等级价格',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_lv_price` */

/*Table structure for table `goods_product` */

CREATE TABLE `goods_product` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `sku` varchar(32) DEFAULT NULL COMMENT 'SKU',
  `goodsId` varchar(32) DEFAULT NULL COMMENT '商品ID',
  `name` varchar(255) DEFAULT NULL COMMENT '货品名',
  `spec` varchar(255) DEFAULT NULL COMMENT '货品规格',
  `price` int(32) DEFAULT NULL COMMENT '销售价',
  `priceMarket` int(32) DEFAULT NULL COMMENT '市场价',
  `weight` int(32) DEFAULT NULL COMMENT '重量',
  `stock` int(32) DEFAULT NULL COMMENT '库存',
  `buyMin` int(32) DEFAULT NULL COMMENT '最小购买量',
  `buyMax` int(32) DEFAULT NULL COMMENT '最大购买量',
  `unit` varchar(25) DEFAULT NULL COMMENT '计量单位',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否下架',
  `isDefault` tinyint(1) DEFAULT NULL COMMENT '是否默认',
  `upAt` int(32) DEFAULT NULL COMMENT '上架时间',
  `downAt` int(32) DEFAULT NULL COMMENT '下架时间',
  `numSale` int(32) DEFAULT NULL COMMENT '销售量',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_GOODS_PRODUCT` (`sku`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_product` */

insert  into `goods_product`(`id`,`sku`,`goodsId`,`name`,`spec`,`price`,`priceMarket`,`weight`,`stock`,`buyMin`,`buyMax`,`unit`,`disabled`,`isDefault`,`upAt`,`downAt`,`numSale`,`location`,`opBy`,`opAt`,`delFlag`) values ('32e346abb01e4c2788cb914f884bd849','S6IESFQM94IC-3','0202550cacab4b5eafcab95154f6d965','白色 32G ','颜色:白色*内存:32G',343200,12200,2,1,1,100,'部',0,0,0,0,0,3,'afe39b04690c4a5c8d74e7d8b8668d7d',1510639143,0);
insert  into `goods_product`(`id`,`sku`,`goodsId`,`name`,`spec`,`price`,`priceMarket`,`weight`,`stock`,`buyMin`,`buyMax`,`unit`,`disabled`,`isDefault`,`upAt`,`downAt`,`numSale`,`location`,`opBy`,`opAt`,`delFlag`) values ('3c7bb7dabffc41fcab3425e9deb84f69','S6IESFQM94IC-4','0202550cacab4b5eafcab95154f6d965','白色 64G ','颜色:白色*内存:64G',1233200,31332100,34,1,1,100,'部',0,0,0,0,0,4,'afe39b04690c4a5c8d74e7d8b8668d7d',1510639143,0);
insert  into `goods_product`(`id`,`sku`,`goodsId`,`name`,`spec`,`price`,`priceMarket`,`weight`,`stock`,`buyMin`,`buyMax`,`unit`,`disabled`,`isDefault`,`upAt`,`downAt`,`numSale`,`location`,`opBy`,`opAt`,`delFlag`) values ('863094262d5c47d1aaec6ec95b702071','S6IESFQM94IC-1','0202550cacab4b5eafcab95154f6d965','红色 32G ','颜色:红色*内存:32G',788700,900000,12,1,1,2,'部',0,1,0,0,0,1,'afe39b04690c4a5c8d74e7d8b8668d7d',1510639143,0);
insert  into `goods_product`(`id`,`sku`,`goodsId`,`name`,`spec`,`price`,`priceMarket`,`weight`,`stock`,`buyMin`,`buyMax`,`unit`,`disabled`,`isDefault`,`upAt`,`downAt`,`numSale`,`location`,`opBy`,`opAt`,`delFlag`) values ('c68781c50f894519a38470fb39125025','S6IESFQM94IC-2','0202550cacab4b5eafcab95154f6d965','红色 64G ','颜色:红色*内存:64G',65500,223300,3,1,1,100,'部',0,0,0,0,0,2,'afe39b04690c4a5c8d74e7d8b8668d7d',1510639143,0);

/*Table structure for table `goods_spec` */

CREATE TABLE `goods_spec` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `name` varchar(100) DEFAULT NULL COMMENT '规格名称',
  `type` int(32) DEFAULT NULL COMMENT '规格类型 0文字 1图片',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_spec` */

insert  into `goods_spec`(`id`,`name`,`type`,`location`,`opBy`,`opAt`,`delFlag`) values ('519138945cdd4fac9013d460a976718d','内存',0,2,'afe39b04690c4a5c8d74e7d8b8668d7d',1510636555,0);
insert  into `goods_spec`(`id`,`name`,`type`,`location`,`opBy`,`opAt`,`delFlag`) values ('7d018e54e8564207ae0761c8fe07bc39','颜色',0,1,'afe39b04690c4a5c8d74e7d8b8668d7d',1510636537,0);

/*Table structure for table `goods_spec_values` */

CREATE TABLE `goods_spec_values` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `specId` varchar(32) DEFAULT NULL COMMENT '规格ID',
  `spec_value` varchar(100) DEFAULT NULL COMMENT '规格值',
  `spec_picurl` varchar(255) DEFAULT NULL COMMENT '规格图片',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_spec_values` */

insert  into `goods_spec_values`(`id`,`specId`,`spec_value`,`spec_picurl`,`location`,`opBy`,`opAt`,`delFlag`) values ('91e5fd0781854ac39b9a0069d95ab488','7d018e54e8564207ae0761c8fe07bc39','红色',NULL,1,'afe39b04690c4a5c8d74e7d8b8668d7d',1510636537,0);
insert  into `goods_spec_values`(`id`,`specId`,`spec_value`,`spec_picurl`,`location`,`opBy`,`opAt`,`delFlag`) values ('a13605312856406b8113bddf906eec14','519138945cdd4fac9013d460a976718d','64G',NULL,4,'afe39b04690c4a5c8d74e7d8b8668d7d',1510636555,0);
insert  into `goods_spec_values`(`id`,`specId`,`spec_value`,`spec_picurl`,`location`,`opBy`,`opAt`,`delFlag`) values ('be0cdf50825246d085956bc3504a0052','519138945cdd4fac9013d460a976718d','32G',NULL,3,'afe39b04690c4a5c8d74e7d8b8668d7d',1510636555,0);
insert  into `goods_spec_values`(`id`,`specId`,`spec_value`,`spec_picurl`,`location`,`opBy`,`opAt`,`delFlag`) values ('ea0a0a8d78ed48d38b62f4cf0210eed3','7d018e54e8564207ae0761c8fe07bc39','白色',NULL,2,'afe39b04690c4a5c8d74e7d8b8668d7d',1510636537,0);

/*Table structure for table `goods_tag` */

CREATE TABLE `goods_tag` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `name` varchar(50) DEFAULT NULL COMMENT '标签名称',
  `onIndex` tinyint(1) DEFAULT NULL COMMENT '前台显示',
  `imgurl` varchar(255) DEFAULT NULL COMMENT '标签图片',
  `transparency` int(32) DEFAULT NULL COMMENT '图片透明度',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_tag` */

/*Table structure for table `goods_tag_link` */

CREATE TABLE `goods_tag_link` (
  `goodsId` varchar(32) DEFAULT NULL,
  `tagId` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_tag_link` */

/*Table structure for table `goods_type` */

CREATE TABLE `goods_type` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `name` varchar(100) DEFAULT NULL COMMENT '类型名称',
  `isPhysical` tinyint(1) DEFAULT NULL COMMENT '实物商品',
  `hasSpec` tinyint(1) DEFAULT NULL COMMENT '使用规格',
  `hasProp` tinyint(1) DEFAULT NULL COMMENT '使用属性',
  `hasParam` tinyint(1) DEFAULT NULL COMMENT '使用参数',
  `hasTab` tinyint(1) DEFAULT NULL COMMENT '自定义Tab',
  `hasBrand` tinyint(1) DEFAULT NULL COMMENT '关联品牌',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_type` */

insert  into `goods_type`(`id`,`name`,`isPhysical`,`hasSpec`,`hasProp`,`hasParam`,`hasTab`,`hasBrand`,`opBy`,`opAt`,`delFlag`) values ('8d821957b963478dab94ba93b81c15ed','手机',1,1,0,1,1,1,'',1510638796,0);

/*Table structure for table `goods_type_brand` */

CREATE TABLE `goods_type_brand` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `typeId` varchar(32) DEFAULT NULL COMMENT '类型ID',
  `brandId` varchar(32) DEFAULT NULL COMMENT '品牌ID',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_type_brand` */

insert  into `goods_type_brand`(`id`,`typeId`,`brandId`,`location`,`opBy`,`opAt`,`delFlag`) values ('d21238381ef243e6a16d5d23e8495eb4','8d821957b963478dab94ba93b81c15ed','64cdd974fbdd4438ae18a706bdb3ed4b',1,'afe39b04690c4a5c8d74e7d8b8668d7d',1510638796,0);

/*Table structure for table `goods_type_paramg` */

CREATE TABLE `goods_type_paramg` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `typeId` varchar(32) DEFAULT NULL COMMENT '类型ID',
  `name` varchar(100) DEFAULT NULL COMMENT '分组名称',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_type_paramg` */

insert  into `goods_type_paramg`(`id`,`typeId`,`name`,`location`,`opBy`,`opAt`,`delFlag`) values ('09f61c43ebf6407b987241dc30f659b9','8d821957b963478dab94ba93b81c15ed','显示',1,'afe39b04690c4a5c8d74e7d8b8668d7d',1510638796,0);

/*Table structure for table `goods_type_params` */

CREATE TABLE `goods_type_params` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `typeId` varchar(32) DEFAULT NULL COMMENT '类型ID',
  `groupId` varchar(32) DEFAULT NULL COMMENT '分组ID',
  `name` varchar(100) DEFAULT NULL COMMENT '参数名称',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_type_params` */

insert  into `goods_type_params`(`id`,`typeId`,`groupId`,`name`,`location`,`opBy`,`opAt`,`delFlag`) values ('81cff7132f694e2c8c123e4142adbf5e','8d821957b963478dab94ba93b81c15ed','09f61c43ebf6407b987241dc30f659b9','分辨率',1,'afe39b04690c4a5c8d74e7d8b8668d7d',1510638796,0);

/*Table structure for table `goods_type_props` */

CREATE TABLE `goods_type_props` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `typeId` varchar(32) DEFAULT NULL COMMENT '类型ID',
  `name` varchar(100) DEFAULT NULL COMMENT '类型名称',
  `type` varchar(10) DEFAULT NULL COMMENT '类型 select input',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_type_props` */

/*Table structure for table `goods_type_props_values` */

CREATE TABLE `goods_type_props_values` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `typeId` varchar(32) DEFAULT NULL COMMENT '类型ID',
  `propsId` varchar(32) DEFAULT NULL COMMENT '属性ID',
  `name` varchar(100) DEFAULT NULL COMMENT '属性值',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_type_props_values` */

/*Table structure for table `goods_type_spec` */

CREATE TABLE `goods_type_spec` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `typeId` varchar(32) DEFAULT NULL COMMENT '类型ID',
  `specId` varchar(32) DEFAULT NULL COMMENT '规格ID',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_type_spec` */

insert  into `goods_type_spec`(`id`,`typeId`,`specId`,`location`,`opBy`,`opAt`,`delFlag`) values ('464d3dd790174c7cb3bbd376f6a69259','8d821957b963478dab94ba93b81c15ed','7d018e54e8564207ae0761c8fe07bc39',1,'afe39b04690c4a5c8d74e7d8b8668d7d',1510638796,0);
insert  into `goods_type_spec`(`id`,`typeId`,`specId`,`location`,`opBy`,`opAt`,`delFlag`) values ('e821ed052559431f8eea4fa1597f0194','8d821957b963478dab94ba93b81c15ed','519138945cdd4fac9013d460a976718d',2,'afe39b04690c4a5c8d74e7d8b8668d7d',1510638796,0);

/*Table structure for table `goods_type_spec_values` */

CREATE TABLE `goods_type_spec_values` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `typeId` varchar(32) DEFAULT NULL COMMENT '类型ID',
  `specId` varchar(32) DEFAULT NULL COMMENT '规格ID',
  `specValueId` varchar(32) DEFAULT NULL COMMENT '规格值ID',
  `specValText` varchar(32) DEFAULT NULL COMMENT '规格值名称',
  `specValUrl` varchar(255) DEFAULT NULL COMMENT '规格值图片',
  `typeSpecId` varchar(32) DEFAULT NULL COMMENT '类型规格ID',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_type_spec_values` */

insert  into `goods_type_spec_values`(`id`,`typeId`,`specId`,`specValueId`,`specValText`,`specValUrl`,`typeSpecId`,`location`,`opBy`,`opAt`,`delFlag`) values ('04b1f9cb2437450ea01d69c9ac87cdbc','8d821957b963478dab94ba93b81c15ed','519138945cdd4fac9013d460a976718d','be0cdf50825246d085956bc3504a0052','32G',NULL,'e821ed052559431f8eea4fa1597f0194',3,'afe39b04690c4a5c8d74e7d8b8668d7d',1510638796,0);
insert  into `goods_type_spec_values`(`id`,`typeId`,`specId`,`specValueId`,`specValText`,`specValUrl`,`typeSpecId`,`location`,`opBy`,`opAt`,`delFlag`) values ('2fdacb9c5fa746a387d8a0130fae67fd','8d821957b963478dab94ba93b81c15ed','7d018e54e8564207ae0761c8fe07bc39','91e5fd0781854ac39b9a0069d95ab488','红色',NULL,'464d3dd790174c7cb3bbd376f6a69259',1,'afe39b04690c4a5c8d74e7d8b8668d7d',1510638796,0);
insert  into `goods_type_spec_values`(`id`,`typeId`,`specId`,`specValueId`,`specValText`,`specValUrl`,`typeSpecId`,`location`,`opBy`,`opAt`,`delFlag`) values ('7f4ed50ea0924aecb63e89265cd114c5','8d821957b963478dab94ba93b81c15ed','519138945cdd4fac9013d460a976718d','a13605312856406b8113bddf906eec14','64G',NULL,'e821ed052559431f8eea4fa1597f0194',4,'afe39b04690c4a5c8d74e7d8b8668d7d',1510638796,0);
insert  into `goods_type_spec_values`(`id`,`typeId`,`specId`,`specValueId`,`specValText`,`specValUrl`,`typeSpecId`,`location`,`opBy`,`opAt`,`delFlag`) values ('a61652ccfcf941e389d4377df2b853bf','8d821957b963478dab94ba93b81c15ed','7d018e54e8564207ae0761c8fe07bc39','ea0a0a8d78ed48d38b62f4cf0210eed3','白色',NULL,'464d3dd790174c7cb3bbd376f6a69259',2,'afe39b04690c4a5c8d74e7d8b8668d7d',1510638796,0);

/*Table structure for table `goods_type_tab` */

CREATE TABLE `goods_type_tab` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `typeId` varchar(32) DEFAULT NULL COMMENT '类型ID',
  `name` varchar(100) DEFAULT NULL COMMENT '标签名称',
  `note` text COMMENT '标签内容',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods_type_tab` */

insert  into `goods_type_tab`(`id`,`typeId`,`name`,`note`,`location`,`opBy`,`opAt`,`delFlag`) values ('fb427d737f324880a3876f404d457f3e','8d821957b963478dab94ba93b81c15ed','售后','<p>售后</p><p><br/></p><p>售后售后售后</p>',1,'afe39b04690c4a5c8d74e7d8b8668d7d',1510638796,0);

/*Table structure for table `member_address` */

CREATE TABLE `member_address` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `province` varchar(32) DEFAULT NULL COMMENT '所在省',
  `city` varchar(32) DEFAULT NULL COMMENT '所在市',
  `county` varchar(32) DEFAULT NULL COMMENT '所在县区',
  `town` varchar(32) DEFAULT NULL COMMENT '所在街道',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `postCode` varchar(20) DEFAULT NULL COMMENT '邮政编码',
  `fullName` varchar(255) DEFAULT NULL COMMENT '收货人姓名',
  `mobile` varchar(20) DEFAULT NULL COMMENT '收货人手机',
  `phone` varchar(20) DEFAULT NULL COMMENT '收货人电话',
  `defaultValue` tinyint(1) DEFAULT NULL COMMENT '是否默认',
  `memberId` varchar(32) DEFAULT NULL COMMENT '会员ID',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `INDEX_MEMBER_USER_ADDRESS` (`memberId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `member_address` */

/*Table structure for table `member_bind` */

CREATE TABLE `member_bind` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `bind_type` varchar(20) DEFAULT NULL COMMENT '第三方类型',
  `bind_openid` varchar(255) DEFAULT NULL COMMENT '第三方帐号',
  `bind_nickname` varchar(255) DEFAULT NULL COMMENT '第三方昵称',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `binded` tinyint(1) DEFAULT NULL COMMENT '是否绑定',
  `bindAt` int(32) DEFAULT NULL COMMENT '绑定时间',
  `memberId` varchar(32) DEFAULT NULL COMMENT '帐号ID',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `INDEX_MEMBER_BIND` (`memberId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `member_bind` */

/*Table structure for table `member_cart` */

CREATE TABLE `member_cart` (
  `id` varchar(128) NOT NULL COMMENT 'ID',
  `memberId` varchar(32) DEFAULT NULL COMMENT '会员ID',
  `goodsId` varchar(32) DEFAULT NULL COMMENT '商品ID',
  `productId` varchar(32) DEFAULT NULL COMMENT '货品ID',
  `sku` varchar(32) DEFAULT NULL COMMENT 'SKU',
  `num` int(32) DEFAULT NULL COMMENT '数量',
  `price` int(32) DEFAULT NULL COMMENT '购买价',
  `imgurl` varchar(255) DEFAULT NULL COMMENT '商品图片',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `INDEX_MEMBER_USER_CART` (`memberId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `member_cart` */

/*Table structure for table `member_coupon` */

CREATE TABLE `member_coupon` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `memberId` varchar(32) DEFAULT NULL COMMENT '会员ID',
  `coupon_id` varchar(32) DEFAULT NULL COMMENT '优惠券ID',
  `coupon_name` varchar(100) DEFAULT NULL COMMENT '优惠券名称',
  `coupon_money` int(32) DEFAULT '0' COMMENT '优惠券金额',
  `createAt` int(32) DEFAULT NULL COMMENT '获取时间',
  `orderAt` int(32) DEFAULT NULL COMMENT '使用时间',
  `orderId` varchar(32) DEFAULT NULL COMMENT '订单ID',
  `status` int(32) DEFAULT '0' COMMENT '优惠券状态',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `member_coupon` */

/*Table structure for table `member_level` */

CREATE TABLE `member_level` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `name` varchar(100) DEFAULT NULL COMMENT '等级名称',
  `logo` varchar(255) DEFAULT NULL COMMENT '等级图标',
  `dis_count` int(32) DEFAULT NULL COMMENT '折扣率',
  `point` int(32) DEFAULT NULL COMMENT '所需积分',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `defaultValue` tinyint(1) DEFAULT NULL COMMENT '是否默认',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `member_level` */

/*Table structure for table `member_user` */

CREATE TABLE `member_user` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `typeId` varchar(32) DEFAULT NULL COMMENT '会员类型',
  `levelId` varchar(32) DEFAULT NULL COMMENT '会员等级',
  `loginname` varchar(255) DEFAULT NULL COMMENT '登录名',
  `email` varchar(255) DEFAULT NULL COMMENT '登录邮箱',
  `mobile` varchar(20) DEFAULT NULL COMMENT '登录手机号',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(50) DEFAULT NULL COMMENT '密码盐',
  `money` int(32) DEFAULT NULL COMMENT '会员余额',
  `freezeMoney` int(32) DEFAULT NULL COMMENT '冻结余额',
  `payPassword` varchar(32) DEFAULT NULL COMMENT '支付密码',
  `score` int(32) DEFAULT NULL COMMENT '会员积分',
  `freezeScore` int(32) DEFAULT NULL COMMENT '冻结积分',
  `allScore` int(32) DEFAULT NULL COMMENT '会员历史总积分',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(5) DEFAULT NULL COMMENT '性别',
  `b_year` int(32) DEFAULT NULL COMMENT '生日年',
  `b_month` int(32) DEFAULT NULL COMMENT '生日月',
  `b_day` int(32) DEFAULT NULL COMMENT '生日日',
  `astro` varchar(5) DEFAULT NULL COMMENT '星座',
  `provinceId` varchar(32) DEFAULT NULL COMMENT '所在省',
  `cityId` varchar(32) DEFAULT NULL COMMENT '所在市',
  `regSrc` varchar(32) DEFAULT NULL COMMENT '注册来源',
  `regAt` int(32) DEFAULT NULL COMMENT '注册时间',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_MEMBER_USER_LOGINNAMAE` (`loginname`),
  UNIQUE KEY `INDEX_MEMBER_USER_MOBILE` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `member_user` */

/*Table structure for table `member_user_money` */

CREATE TABLE `member_user_money` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `memberId` varchar(32) DEFAULT NULL COMMENT '会员ID',
  `orderId` varchar(32) DEFAULT NULL COMMENT '订单ID',
  `type` varchar(32) DEFAULT NULL COMMENT '交易类型',
  `payType` varchar(32) DEFAULT NULL COMMENT '支付类型',
  `trade_no` varchar(255) DEFAULT NULL COMMENT '交易单据号',
  `note` varchar(255) DEFAULT NULL COMMENT '交易说明',
  `oldMoney` int(32) DEFAULT '0' COMMENT '原余额',
  `newMoney` int(32) DEFAULT '0' COMMENT '现金额',
  `diffMoney` int(32) DEFAULT '0' COMMENT '差额',
  `creatAt` int(32) DEFAULT NULL COMMENT '产生时间',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `INDEX_MEMBER_USER_MONEY` (`memberId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `member_user_money` */

/*Table structure for table `member_user_score` */

CREATE TABLE `member_user_score` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `memberId` varchar(32) DEFAULT NULL COMMENT '会员ID',
  `orderId` varchar(32) DEFAULT NULL COMMENT '订单ID',
  `type` varchar(32) DEFAULT NULL COMMENT '交易类型',
  `goodsId` varchar(32) DEFAULT NULL COMMENT '商品ID',
  `productId` varchar(32) DEFAULT NULL COMMENT '货品ID',
  `note` varchar(255) DEFAULT NULL COMMENT '交易说明',
  `oldScore` int(32) DEFAULT '0' COMMENT '原积分',
  `newScore` int(32) DEFAULT '0' COMMENT '现积分',
  `diffScore` int(32) DEFAULT '0' COMMENT '差额',
  `creatAt` int(32) DEFAULT NULL COMMENT '产生时间',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `INDEX_MEMBER_USER_SCORE` (`memberId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `member_user_score` */

/*Table structure for table `order_order1` */

CREATE TABLE `order_order1` (
  `id` varchar(128) NOT NULL COMMENT 'ID',
  `memberId` varchar(32) DEFAULT NULL COMMENT '会员ID',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order_order1` */

/*Table structure for table `sales_coupon` */

CREATE TABLE `sales_coupon` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `name` varchar(255) DEFAULT NULL COMMENT '优惠券名称',
  `money` int(32) DEFAULT NULL COMMENT '金额',
  `total_num` int(32) DEFAULT '0' COMMENT '总数量',
  `send_num` int(32) DEFAULT '0' COMMENT '已发数量',
  `limit_sartAt` int(32) DEFAULT NULL COMMENT '使用期限起',
  `limit_endAt` int(32) DEFAULT NULL COMMENT '使用期限至',
  `limit_number` int(32) DEFAULT '1' COMMENT '允许领取数量',
  `has_score` tinyint(1) DEFAULT NULL COMMENT '允许积分兑换',
  `score` int(32) DEFAULT '0' COMMENT '所需积分',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sales_coupon` */

/*Table structure for table `shop_area` */

CREATE TABLE `shop_area` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `parentId` varchar(32) DEFAULT NULL COMMENT '父级ID',
  `path` varchar(100) DEFAULT NULL COMMENT '树路径',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `code` varchar(100) DEFAULT NULL COMMENT '编码',
  `isCash` tinyint(1) DEFAULT NULL COMMENT '货到付款',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `hasChildren` tinyint(1) DEFAULT NULL COMMENT '有子节点',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_area` */

/*Table structure for table `shop_config` */

CREATE TABLE `shop_config` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `shop_stock` int(32) DEFAULT NULL COMMENT '库存预警',
  `point_rate` int(32) DEFAULT NULL COMMENT '积分比率',
  `tax_disabled` tinyint(1) DEFAULT NULL COMMENT '发票',
  `tax_price` int(32) DEFAULT NULL COMMENT '开票金额',
  `logistics_open` tinyint(1) DEFAULT NULL COMMENT '物流跟踪',
  `logistics_info` text COMMENT '物流跟踪配置',
  `oauth_open` tinyint(1) DEFAULT NULL COMMENT '第三方登录',
  `oauth_wechat` tinyint(1) DEFAULT NULL COMMENT '微信登录',
  `oauth_wechat_info` text COMMENT '微信登录配置',
  `oauth_qq` tinyint(1) DEFAULT NULL COMMENT 'QQ登录',
  `oauth_qq_info` text COMMENT 'QQ登录配置',
  `s_width` int(32) DEFAULT NULL COMMENT '缩略图宽',
  `s_height` int(32) DEFAULT NULL COMMENT '缩略图高',
  `m_width` int(32) DEFAULT NULL COMMENT '列表图宽',
  `m_height` int(32) DEFAULT NULL COMMENT '列表图高',
  `b_width` int(32) DEFAULT NULL COMMENT '相册图宽',
  `b_height` int(32) DEFAULT NULL COMMENT '相册图高',
  `img_save_local` tinyint(1) DEFAULT NULL COMMENT '本地存储',
  `img_qiniu` tinyint(1) DEFAULT NULL COMMENT '七牛云配置',
  `img_qiniu_info` text COMMENT '七牛云配置',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_config` */

insert  into `shop_config`(`id`,`shop_stock`,`point_rate`,`tax_disabled`,`tax_price`,`logistics_open`,`logistics_info`,`oauth_open`,`oauth_wechat`,`oauth_wechat_info`,`oauth_qq`,`oauth_qq_info`,`s_width`,`s_height`,`m_width`,`m_height`,`b_width`,`b_height`,`img_save_local`,`img_qiniu`,`img_qiniu_info`,`opBy`,`opAt`,`delFlag`) values ('system',0,0,0,0,1,'{\"lg_appname\":\"kdn\",\"lg_appid\":\"\",\"lg_appkey\":\"\"}',0,0,'{\"wechat_appid\":\"\",\"wechat_appkey\":\"\",\"wechat_appcontent\":\"\"}',0,'{\"qq_appid\":\"\",\"qq_appkey\":\"\",\"qq_appcontent\":\"\"}',400,300,400,300,400,300,1,0,'{\"qiniu_sk\":\"\",\"qiniu_ak\":\"\",\"qiniu_bucket\":\"\",\"qiniu_domain\":\"\"}','afe39b04690c4a5c8d74e7d8b8668d7d',1510638963,0);

/*Table structure for table `shop_estemp` */

CREATE TABLE `shop_estemp` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `goodsId` varchar(32) DEFAULT NULL COMMENT '商品ID',
  `action` varchar(32) DEFAULT NULL COMMENT '操作类型',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_estemp` */

insert  into `shop_estemp`(`id`,`goodsId`,`action`,`opBy`,`opAt`,`delFlag`) values ('0202550cacab4b5eafcab95154f6d965','0202550cacab4b5eafcab95154f6d965','create',NULL,0,NULL);
insert  into `shop_estemp`(`id`,`goodsId`,`action`,`opBy`,`opAt`,`delFlag`) values ('27f8aa2297e24bc3996ddfec9c6da3d3','0202550cacab4b5eafcab95154f6d965','update','afe39b04690c4a5c8d74e7d8b8668d7d',1510639143,0);

/*Table structure for table `shop_express` */

CREATE TABLE `shop_express` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `code` varchar(32) DEFAULT NULL COMMENT '公司编码',
  `name` varchar(50) DEFAULT NULL COMMENT '公司名称',
  `website` varchar(255) DEFAULT NULL COMMENT '公司网站',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_express` */

/*Table structure for table `shop_payment` */

CREATE TABLE `shop_payment` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `logo` varchar(255) DEFAULT NULL COMMENT 'Logo',
  `data` text COMMENT '配置内容',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `defaultValue` tinyint(1) DEFAULT NULL COMMENT '是否默认',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_payment` */

/*Table structure for table `shop_shipping` */

CREATE TABLE `shop_shipping` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `name` varchar(50) DEFAULT NULL COMMENT '配送方式',
  `method` varchar(10) DEFAULT NULL COMMENT '计价方式',
  `flatprice` int(32) DEFAULT NULL COMMENT '统一价格',
  `lv1_number` int(32) DEFAULT NULL COMMENT '首重量/首件数',
  `lv1_price` int(32) DEFAULT NULL COMMENT '首重价/首件价',
  `lv2_number` int(32) DEFAULT NULL COMMENT '续重量/续件数',
  `lv2_price` int(32) DEFAULT NULL COMMENT '续重价/续件价',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `defaultValue` tinyint(1) DEFAULT NULL COMMENT '是否默认',
  `note` varchar(500) DEFAULT NULL COMMENT '描述',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_shipping` */

/*Table structure for table `shop_shipping_express` */

CREATE TABLE `shop_shipping_express` (
  `shippingId` varchar(32) DEFAULT NULL,
  `expressId` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop_shipping_express` */

/*Table structure for table `sms_config` */

CREATE TABLE `sms_config` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `app_key` varchar(255) DEFAULT NULL,
  `app_secret` varchar(255) DEFAULT NULL,
  `sms_sign_name` varchar(32) DEFAULT NULL COMMENT '短信签名',
  `sms_reg_template` varchar(32) DEFAULT NULL COMMENT '用户注册验证码模板',
  `sms_check_template` varchar(32) DEFAULT NULL COMMENT '身份验证验证码模板',
  `sms_login_template` varchar(32) DEFAULT NULL COMMENT '登陆确认验证码模板',
  `sms_password_template` varchar(32) DEFAULT NULL COMMENT '修改密码验证码模板',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sms_config` */

/*Table structure for table `sms_log` */

CREATE TABLE `sms_log` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号码',
  `code` varchar(32) DEFAULT NULL COMMENT '模板ID',
  `note` text COMMENT '短信内容',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sms_log` */

/*Table structure for table `sys_api` */

CREATE TABLE `sys_api` (
  `id` varchar(32) NOT NULL,
  `appName` varchar(20) DEFAULT NULL COMMENT 'appName',
  `appId` varchar(255) DEFAULT NULL COMMENT 'appId',
  `appSecret` varchar(255) DEFAULT NULL COMMENT 'appSecret',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_api` */

/*Table structure for table `sys_config` */

CREATE TABLE `sys_config` (
  `configKey` varchar(100) NOT NULL,
  `configValue` varchar(100) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`configKey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_config` */

insert  into `sys_config`(`configKey`,`configValue`,`note`,`opBy`,`opAt`,`delFlag`) values ('AppDomain','127.0.0.1','系统域名','',1504172034,0);
insert  into `sys_config`(`configKey`,`configValue`,`note`,`opBy`,`opAt`,`delFlag`) values ('AppName','NutzShop','系统名称','',1504172034,0);
insert  into `sys_config`(`configKey`,`configValue`,`note`,`opBy`,`opAt`,`delFlag`) values ('AppShrotName','NutzShop','系统短名称','',1504172034,0);
insert  into `sys_config`(`configKey`,`configValue`,`note`,`opBy`,`opAt`,`delFlag`) values ('AppUploadPath','/upload','文件上传文件夹','',1504172034,0);

/*Table structure for table `sys_dict` */

CREATE TABLE `sys_dict` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `parentId` varchar(32) DEFAULT NULL COMMENT '父级ID',
  `path` varchar(100) DEFAULT NULL COMMENT '树路径',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `code` varchar(20) DEFAULT NULL COMMENT '机构编码',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `hasChildren` tinyint(1) DEFAULT NULL COMMENT '有子节点',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_SYS_DICT_PATH` (`path`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_dict` */

/*Table structure for table `sys_log` */

CREATE TABLE `sys_log` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL COMMENT '创建昵称',
  `type` varchar(20) DEFAULT NULL COMMENT '日志类型',
  `tag` varchar(50) DEFAULT NULL COMMENT '日志标识',
  `src` varchar(255) DEFAULT NULL COMMENT '执行类',
  `ip` varchar(255) DEFAULT NULL COMMENT '来源IP',
  `msg` text COMMENT '日志内容',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;

/*Data for the table `sys_log` */

/*Table structure for table `sys_menu` */

CREATE TABLE `sys_menu` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `parentId` varchar(32) DEFAULT NULL COMMENT '父级ID',
  `path` varchar(100) DEFAULT NULL COMMENT '树路径',
  `name` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `aliasName` varchar(100) DEFAULT NULL COMMENT '菜单别名',
  `type` varchar(10) DEFAULT NULL COMMENT '资源类型',
  `href` varchar(255) DEFAULT NULL COMMENT '菜单链接',
  `target` varchar(50) DEFAULT NULL COMMENT '打开方式',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `isShow` tinyint(1) DEFAULT NULL COMMENT '是否显示',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `permission` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `note` varchar(255) DEFAULT NULL COMMENT '菜单介绍',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `hasChildren` tinyint(1) DEFAULT NULL COMMENT '有子节点',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_SYS_MENU_PATH` (`path`),
  UNIQUE KEY `INDEX_SYS_MENU_PREM` (`permission`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('002bf91c98ce4364bdafff334ce0f39f','932317d1c0f94731b17794cabc93cb57','0004000200040003','删除品牌',NULL,'data','','','',0,0,'goods.conf.brand.delete',NULL,0,0,'',1475998374,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('007af6aa4e534246823ba49cc5021085','','0007','营销',NULL,'menu','','','',1,0,'sales',NULL,18,1,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172865,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('02e86a61e99746bea34236ea73dd52a5','','0003','CMS','CMS','menu','','','',1,0,'cms',NULL,46,1,'',1468895671,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('055a496251724329a569200e3bf30750','bc24dbcccaa941c8906223072be16a37','0004000100010002','修改商品','Edit','data','','','',0,0,'goods.manager.goods.edit',NULL,0,0,'',1475997733,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('0706112ff5dc46e388064a99bcdb0561','4cd8e4e9519e4cff95465194fdcc8d88','000200030004','关键词回复','Keyword','menu','/platform/wx/reply/conf/keyword','data-pjax','',1,0,'wx.reply.keyword',NULL,38,0,'',1467472362,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('077cb6be4c7c41cc8955ee045a4f0286','68cdbf694f71445c8587a20234d6fe31','0003000300020001','添加链接','Add','data','','','',0,0,'cms.link.link.add',NULL,0,0,'',1468897043,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('087e77c9106b453bb9e56eed136901c4','75b293b699fa4be98cd5379c962da634','000100010001','单位管理','Unit','menu','/platform/sys/unit','data-pjax',NULL,1,0,'sys.manager.unit',NULL,57,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('0a43d291e0c94ad88c8b690009279e34','2fab774f8b6d40cb9d7e187babab2d91','0002000400020004','保存排序','Save','data','','','',0,0,'wx.conf.menu.sort',NULL,0,0,'',1467474314,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('0a972ce655cb4c84809d58668b655900','17e1ee23ca1443f1bc886c2f5eb7c24b','0002000300020002','修改图文','Edit','data','','','',0,0,'wx.reply.news.edit',NULL,0,0,'',1467473596,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('0ccc9e5e814d485baa33c909a362afb4','087e77c9106b453bb9e56eed136901c4','0001000100010002','修改单位','Edit','data',NULL,NULL,NULL,0,0,'sys.manager.unit.edit',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('0e09445caec24fd0951e63495dd8d631','','0001','系统','System','menu','','','',1,0,'sys','系统',55,1,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('111894faedfd447fa2ca29959f2aa2ad','087e77c9106b453bb9e56eed136901c4','0001000100010003','删除单位','Delete','data',NULL,NULL,NULL,0,0,'sys.manager.unit.delete',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('1385ae887e5c4b8aa33fbf228be7f907','6afc5075913d4df4b44a6476080e35a0','000200050001','模板编号','Id','menu','/platform/wx/tpl/id','data-pjax','',1,0,'wx.tpl.id',NULL,43,0,'',1470406854,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('1734e586e96941268a4c5248b593cef9','f426468abf714b1599729f8c36ebbb0d','0002000200010001','回复消息','Reply','data','','','',0,0,'wx.msg.user.reply',NULL,0,0,'',1467473127,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('17500ef3a9e44b4fabb240162a164fcb','6075fc0cf0ef441b9d93cc3cab3445bf','0003000200020003','删除文章','Delete','data','','','',0,0,'cms.content.article.delete',NULL,0,0,'',1468896170,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('17e1ee23ca1443f1bc886c2f5eb7c24b','4cd8e4e9519e4cff95465194fdcc8d88','000200030002','图文内容','News','menu','/platform/wx/reply/news','data-pjax','',1,0,'wx.reply.news',NULL,36,0,'',1467471926,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('199c032cc9624c5d8ee06bd45dd09f48','baa75b5c09ba485eaf41fb53d64ec2d4','000400020002','商品类型','Type','menu','/platform/goods/type','data-pjax','',1,0,'goods.conf.type',NULL,5,0,'',1475998140,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('1f86a8a6debd41829d6a1c2a53677b1e','c49a9c7db8f44b5f98876b760299c94d','000500020001','会员等级',NULL,'menu','/platform/member/level','data-pjax','',1,0,'member.config.level',NULL,13,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172417,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('20da12f4940445b8a92a95af5ed99860','9d0a1379922d427ea2722cc0b4cd4d97','0001000100030003','删除角色','Delete','data',NULL,NULL,NULL,0,0,'sys.manager.role.delete',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('225ab206fe324db6805d4de4e2aa4380','','0006','装修',NULL,'menu','','','',1,0,'dec',NULL,14,1,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172717,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('2275cb125710414e91b617dd7c62f12c','17e1ee23ca1443f1bc886c2f5eb7c24b','0002000300020001','添加图文','add','data','','','',0,0,'wx.reply.news.add',NULL,0,0,'',1467473585,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('234f8ec3c2bc42bf9f6202aecae36fd6','4cd8e4e9519e4cff95465194fdcc8d88','000200030001','文本内容','Txt','menu','/platform/wx/reply/txt','data-pjax','',1,0,'wx.reply.txt',NULL,35,0,'',1467471884,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('24834040360b42e6abe37cac8fbac7b1','9086b227603d4f28ab6cb8bdfcac7642','0001000100050002','修改参数','Edit','data',NULL,NULL,NULL,0,0,'sys.manager.conf.edit',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('25759929f81a4444976d710932e2a7b8','98464e4910d84bcd815023a32e7247ac','0004000200030001','添加规格','Add','data','','','',0,0,'goods.conf.spec.add',NULL,0,0,'',1475998246,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('29f8858251cf4e5d83b5620f0d60e477','9faf2fee6ede4984ab67ab78bdba72cf','0001000100020001','添加用户','Add','data',NULL,NULL,NULL,0,0,'sys.manager.user.add',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('2a63040409094f1e9dc535dd78ce15b7','2cb327ad59b140828fd26eb2a46cb948','0002000300030003','删除绑定','Delete','data','','','',0,0,'wx.reply.follow.delete',NULL,0,0,'',1467474080,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('2cb327ad59b140828fd26eb2a46cb948','4cd8e4e9519e4cff95465194fdcc8d88','000200030003','关注自动回复','Follow','menu','/platform/wx/reply/conf/follow','data-pjax','',1,0,'wx.reply.follow',NULL,37,0,'',1467472280,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('2efbf1f2d2bf44f79cad9cde67c7c2e2','e65a2eef4ce44fc4a0312b6fa06e0d57','0007000100010003','删除',NULL,'data','','','',0,0,'sales.coupon.manager.delete',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172958,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('2f5b80fcea254e2fbd17c00acf0e7cd7','75b293b699fa4be98cd5379c962da634','000100010009','应用管理','App','menu','/platform/sys/api','data-pjax',NULL,1,0,'sys.manager.api',NULL,65,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('2fab774f8b6d40cb9d7e187babab2d91','bcf64d623fdd4519ae345b7a08c071a1','000200040002','菜单配置','Menu','menu','/platform/wx/conf/menu','data-pjax','',1,0,'wx.conf.menu',NULL,41,0,'',1467472649,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('3099f497480c4b1987bce3f3a26c3fb4','6bb17a41f6394ed0a8a6faf5ff781354','0002000200020003','群发消息','Push','data','','','',0,0,'wx.msg.mass.pushNews',NULL,0,0,'',1467473400,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('309dc29ad3c34408a68df8f867a5c9ff','66cc21d7ce104dd6877cbce114c59fb3','0002000400010001','添加帐号','Add','data','','','',0,0,'wx.conf.account.add',NULL,0,0,'',1467474187,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('30a5e70a1456447ebf90b5546e9bc321','2cb327ad59b140828fd26eb2a46cb948','0002000300030002','修改绑定','Edit','data','','','',0,0,'wx.reply.follow.edit',NULL,0,0,'',1467474056,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('31ed2243077c44448cce26abfd5ae574','9822bafbe3454dfd8e8b974ebc304d03','0003000300010002','修改分类','Edit','data','','','',0,0,'cms.link.class.edit',NULL,0,0,'',1468896957,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('3202a3c02d804137b08d4ec3deac8984','6776829efb244438b024b177e42b60aa','0004000200010002','修改分类','Edit','data','','','',0,0,'goods.conf.class.edit',NULL,0,0,'',1475997884,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('32439a7ada26498f8b4fedbfc67b3ebe','4d4cd6d0132a40e5992c8a9313b12d17','0009000100020002','修改',NULL,'data','','','',0,0,'shop.logistics.area.edit',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504173269,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('328ddb2ef7bf40828f1c407cd98c891b','2f5b80fcea254e2fbd17c00acf0e7cd7','0001000100090001','添加应用','Add','data',NULL,NULL,NULL,0,0,'sys.manager.api.add',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('33aed9298643424783116e0cf0f7fcbe','6075fc0cf0ef441b9d93cc3cab3445bf','0003000200020001','添加文章','Add','data','','','',0,0,'cms.content.article.add',NULL,0,0,'',1468896151,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('33d6d0fe153d4f9092b4f68be5725844','199c032cc9624c5d8ee06bd45dd09f48','0004000200020003','删除类型','Delete','data','','','',0,0,'goods.conf.type.delete',NULL,0,0,'',1475998176,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('3556cce488ba46d18f22edd6b639bb37','fca4f6790c4b472f8898e3b645fd70f9','0001000100040003','删除菜单','Delete','data',NULL,NULL,NULL,0,0,'sys.manager.menu.delete',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('35adf5275419411d81453a268e39ee8c','ac4cc07654da4611ad4007b2c9548aa1','000900010005','物流模板',NULL,'menu','/platform/shop/shipping','data-pjax','',1,0,'shop.logistics.shipping',NULL,27,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504173452,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('364bc883d5634c8b9c398ddd534165b5','98464e4910d84bcd815023a32e7247ac','0004000200030003','删除规格','Delete','data','','','',0,0,'goods.conf.spec.delete',NULL,0,0,'',1475998268,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('369f1827f8224fcebd59cd98e484e60f','b37974239e054319a77e323a6bbcdf65','0009000100030001','添加',NULL,'data','','','',0,0,'shop.logistics.express.add',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504173346,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('36e0faf5062b4f6b95d4167cbb1f8fea','68cdbf694f71445c8587a20234d6fe31','0003000300020002','修改链接','Edit','data','','','',0,0,'cms.link.link.edit',NULL,0,0,'',1468897051,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('3888f05aa4064f788ba7ec51c495ce7c','1385ae887e5c4b8aa33fbf228be7f907','0002000500010002','删除编号','Delete','data','','','',0,0,'wx.tpl.id.delete',NULL,0,0,'',1470407068,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('3c24111091ad4a70ad2d9cc361311d2f','68cdbf694f71445c8587a20234d6fe31','0003000300020003','删除链接','Delete','data','','','',0,0,'cms.link.link.delete',NULL,0,0,'',1468897060,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('3f1fd4f0965745e487b919fcb0f9f704','35adf5275419411d81453a268e39ee8c','0009000100050002','修改',NULL,'data','','','',0,0,'shop.logistics.shipping.edit',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504173469,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('3f330d729ca34dc9825c46122be1bfae','02e86a61e99746bea34236ea73dd52a5','00030003','广告链接','AD','menu','','','ti-link',1,0,'cms.link',NULL,52,1,'',1468896230,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('41369bfd41d9435aaf7336d97f4b2936','9086b227603d4f28ab6cb8bdfcac7642','0001000100050001','添加参数','Add','data',NULL,NULL,NULL,0,0,'sys.manager.conf.add',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('436930d21dd1424990f683a6193eab43','b37974239e054319a77e323a6bbcdf65','0009000100030003','删除',NULL,'data','','','',0,0,'shop.logistics.express.delete',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504173360,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('44da90bc76a5419a841f4924333f7a66','2fab774f8b6d40cb9d7e187babab2d91','0002000400020002','修改菜单','Edit','data','','','',0,0,'wx.conf.menu.edit',NULL,0,0,'',1467474294,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('45d958ca78304f25b51f6c71cf66f6d8','2fab774f8b6d40cb9d7e187babab2d91','0002000400020001','添加菜单','Add','data','','','',0,0,'wx.conf.menu.add',NULL,0,0,'',1467474283,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('46f2fbb80f644c5bb36a73d8a4befb01','','0008','订单',NULL,'menu','','','',1,0,'order',NULL,8,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172981,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('4781372b00bb4d52b429b58e72b80c68','b2631bbdbf824cc4b74d819c87962c0d','0003000200010001','添加栏目','Add','data','','','',0,0,'cms.content.channel.add',NULL,0,0,'',1468896049,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('4849cd1e2c42427fac66decfe3760898','007af6aa4e534246823ba49cc5021085','00070001','优惠券',NULL,'menu','','','',1,0,'sales.coupon',NULL,19,1,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172902,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('487c7c9b6ce249c992013c1b88524867','35adf5275419411d81453a268e39ee8c','0009000100050001','添加',NULL,'data','','','',0,0,'shop.logistics.shipping.add',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504173463,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('4cd8e4e9519e4cff95465194fdcc8d88','b0edc6861a494b79b97990dc05f0a524','00020003','自动回复','AutoReply','menu','','','ti-back-left',1,0,'wx.reply',NULL,34,1,'',1467471610,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('4d27b7bdb2d64ce59a7b8c70ed9e3d14','e65a2eef4ce44fc4a0312b6fa06e0d57','0007000100010001','添加',NULL,'data','','','',0,0,'sales.coupon.manager.add',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172943,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('4d4cd6d0132a40e5992c8a9313b12d17','ac4cc07654da4611ad4007b2c9548aa1','000900010002','区域管理',NULL,'menu','/platform/shop/area','data-pjax','',1,0,'shop.logistics.area',NULL,24,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504173240,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('4dc997fef71e4862b9db22de8e99a618','b19b23b0459a4754bf1fb8cb234450f2','0002000100010001','同步会员信息','Sync','data','','','',0,0,'wx.user.list.sync',NULL,0,0,'',1467473044,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('4dd7fa3506c44e21a026a8290afb1837','225ab206fe324db6805d4de4e2aa4380','00060001','店铺装修',NULL,'menu','','','',1,0,'dec.manger',NULL,15,1,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172761,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('4ff53ad173be425a844d71d82624f1e2','75b293b699fa4be98cd5379c962da634','000100010011','插件管理','Plugin','menu','/platform/sys/plugin','data-pjax',NULL,1,0,'sys.manager.plugin',NULL,67,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('503d154482c943a18ae326ce1adebef8','a603af011d574069894debc71f7a6206','0001000100100001','添加字典','Add','data',NULL,NULL,NULL,0,0,'sys.manager.dict.add',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('50ba60ee650e4c739e6abc3ab71e4960','b2631bbdbf824cc4b74d819c87962c0d','0003000200010004','栏目排序','Sort','data','','','',0,0,'cms.content.channel.sort',NULL,0,0,'',1468896092,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('5244f5c38eb24b918e9ad64d456daa38','2fab774f8b6d40cb9d7e187babab2d91','0002000400020005','推送到微信','Push','data','','','',0,0,'wx.conf.menu.push',NULL,0,0,'',1467474330,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('557c2d4c41b24e0594b4cbdf250df904','087e77c9106b453bb9e56eed136901c4','0001000100010001','添加单位','Add','data',NULL,NULL,NULL,0,0,'sys.manager.unit.add',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('55d83cf6d3064747b1328f27472ff682','6776829efb244438b024b177e42b60aa','0004000200010001','添加分类','Add','data','','','',0,0,'goods.conf.class.add',NULL,0,0,'',1475997871,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('56d0658c5a8848818ac05e8ffa5c0570','6bb17a41f6394ed0a8a6faf5ff781354','0002000200020001','添加图文','Add','data','','','',0,0,'wx.msg.mass.addNews',NULL,0,0,'',1467473338,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('5723deb629e744edadfec0455175c09a','bc24dbcccaa941c8906223072be16a37','0004000100010003','删除商品','Delete','data','','','',0,0,'goods.manager.goods.delete',NULL,0,0,'',1475997710,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('5e4f7d4692e746a480b44f625b373cea','97131f60ce9e43aba9a6c636b3e83d3c','0009000100040003','删除',NULL,'data','','','',0,0,'shop.payment.method.delete',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504173416,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('5ef841b114704008a6eeb22ee78bdf0c','98464e4910d84bcd815023a32e7247ac','0004000200030002','修改规格','Edit','data','','','',0,0,'goods.conf.spec.edit',NULL,0,0,'',1475998258,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('5fec95aaa738485da39c1901d47ce2d2','ea54835bfd1649548ea539f3e5216daa','00040001','商品管理','Manager','menu','','','ti-shopping-cart',1,0,'goods.manager',NULL,1,1,'',1475997543,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('6075fc0cf0ef441b9d93cc3cab3445bf','6b6de8c720c645a1808e1c3e9ccbfc90','000300020002','文章管理','Article','menu','/platform/cms/article','data-pjax','',1,0,'cms.content.article',NULL,51,0,'',1468896141,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('636de845072b45dfb5cd6784879ba586','75b293b699fa4be98cd5379c962da634','000100010006','日志管理','Log','menu','/platform/sys/log','data-pjax',NULL,1,0,'sys.manager.log',NULL,62,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('64599d53010a49d693b54c21d5424345','e6c9cf5a543744c18e5d395f8676996b','0005000100010001','添加',NULL,'data','','','',0,0,'member.manager.user.add',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172337,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('651cd3971a58401ab8383daeba9bb0d6','4ff53ad173be425a844d71d82624f1e2','0001000100110002','启用禁用','Update','data',NULL,NULL,NULL,0,0,'sys.manager.plugin.update',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('66cc21d7ce104dd6877cbce114c59fb3','bcf64d623fdd4519ae345b7a08c071a1','000200040001','帐号配置','Account','menu','/platform/wx/conf/account','data-pjax','',1,0,'wx.conf.account',NULL,40,0,'',1467472624,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('6776829efb244438b024b177e42b60aa','baa75b5c09ba485eaf41fb53d64ec2d4','000400020001','商品分类','Class','menu','/platform/goods/class','data-pjax','',1,0,'goods.conf.class',NULL,4,0,'',1475997849,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('68cdbf694f71445c8587a20234d6fe31','3f330d729ca34dc9825c46122be1bfae','000300030002','链接管理','Link','menu','/platform/cms/link/link','data-pjax','',1,0,'cms.link.link',NULL,54,0,'',1468897031,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('6abdf1e8dd13441b875c1a0dbbb3c99f','75b293b699fa4be98cd5379c962da634','000100010007','定时任务','Task','menu','/platform/sys/task','data-pjax',NULL,1,0,'sys.manager.task',NULL,63,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('6ad426c1ec82460a89b89dcd41818396','e3fb9df52c9043aa893f1b0f453f718c','0001000100080001','添加路由','Add','data',NULL,NULL,NULL,0,0,'sys.manager.route.add',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('6afc5075913d4df4b44a6476080e35a0','b0edc6861a494b79b97990dc05f0a524','00020005','模板消息','Template','menu','','','ti-notepad',1,0,'wx.tpl',NULL,42,1,'',1470406797,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('6b6de8c720c645a1808e1c3e9ccbfc90','02e86a61e99746bea34236ea73dd52a5','00030002','内容管理','Content','menu','','','ti-pencil-alt',1,0,'cms.content',NULL,49,1,'',1468895990,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('6bb17a41f6394ed0a8a6faf5ff781354','9f20a757a6bc40ddbb650c70debbf660','000200020002','群发消息','Mass','menu','/platform/wx/msg/mass','data-pjax','',1,0,'wx.msg.mass',NULL,33,0,'',1467471561,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('6d6b51ed76924904b570acfdf2ebcee3','bc24dbcccaa941c8906223072be16a37','0004000100010001','添加商品','Add','data','','','',0,0,'goods.manager.goods.add',NULL,0,0,'',1475997721,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('71072e421bec4f79a32dff8e94c1158a','4ff53ad173be425a844d71d82624f1e2','0001000100110001','添加插件','Add','data',NULL,NULL,NULL,0,0,'sys.manager.plugin.add',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('7125a72beee34b21ab3df9bf01b7bce6','9822bafbe3454dfd8e8b974ebc304d03','0003000300010003','删除分类','Delete','data','','','',0,0,'cms.link.class.delete',NULL,0,0,'',1468896968,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('733d3f35d49f45af99ca9220048583ba','0706112ff5dc46e388064a99bcdb0561','0002000300040003','删除绑定','Delete','data','','','',0,0,'wx.reply.keyword.delete',NULL,0,0,'',1467474136,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('73a29d3f99224426b5a87c92da122275','d1e991ad38a8424daf9f7eb000ee27f4','0003000100010001','保存配置','Save','data','','','',0,0,'cms.site.settings.save',NULL,0,0,'',1468895899,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('74d31e653e2c43d6937fb4538ece6a55','6776829efb244438b024b177e42b60aa','0004000200010003','删除分类','Delete','data','','','',0,0,'goods.conf.class.delete',NULL,0,0,'',1475997916,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('75b293b699fa4be98cd5379c962da634','0e09445caec24fd0951e63495dd8d631','00010001','系统管理','Manager','menu','','','ti-settings',1,0,'sys.manager','系统管理',56,1,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('788abb22d3a943a0aa3f3557cc7ee611','fca4f6790c4b472f8898e3b645fd70f9','0001000100040001','添加菜单','Add','data',NULL,NULL,NULL,0,0,'sys.manager.menu.add',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('793751112e604545b8a6f5b587d1b20c','','0005','会员',NULL,'menu','','','',1,0,'member',NULL,9,1,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172241,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('7a74d6be67144e9b995cc3706954a056','e6c9cf5a543744c18e5d395f8676996b','0005000100010003','删除',NULL,'data','','','',0,0,'member.manager.user.delete',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172353,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('7c040dfd8db347e5956a3bc1764653dc','234f8ec3c2bc42bf9f6202aecae36fd6','0002000300010003','删除文本','Delete','data','','','',0,0,'wx.reply.txt.delete',NULL,0,0,'',1467473540,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('7db6207d0dab4d6e95a7eee4f2efe875','9822bafbe3454dfd8e8b974ebc304d03','0003000300010001','添加分类','Add','data','','','',0,0,'cms.link.class.add',NULL,0,0,'',1468896947,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('8275e9ad283c4882a9de8099987017ef','1f86a8a6debd41829d6a1c2a53677b1e','0005000200010001','添加',NULL,'data','','','',0,0,'member.config.level.add',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172428,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('897f5deddb584a4cb1733a5b52536f41','6abdf1e8dd13441b875c1a0dbbb3c99f','0001000100070002','修改任务','Edit','data',NULL,NULL,NULL,0,0,'sys.manager.task.edit',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('8c0a03c1bee24e2d9888b0f1cc17aac1','ac4cc07654da4611ad4007b2c9548aa1','000900010001','商城配置',NULL,'menu','/platform/shop/config','data-pjax','',1,0,'shop.config.config',NULL,23,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504173179,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('8e2212ccbba840e382996bbb4b2bfb20','35adf5275419411d81453a268e39ee8c','0009000100050003','删除',NULL,'data','','','',0,0,'shop.logistics.shipping.delete',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504173476,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('8e3899ae0f3741a9b70c6dce461855f4','4dd7fa3506c44e21a026a8290afb1837','000600010001','资源管理',NULL,'menu','/platform/dec/res','data-pjax','',1,0,'dec.manger.res',NULL,16,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172791,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('9086b227603d4f28ab6cb8bdfcac7642','75b293b699fa4be98cd5379c962da634','000100010005','系统参数','Param','menu','/platform/sys/conf','data-pjax',NULL,1,0,'sys.manager.conf',NULL,61,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('932317d1c0f94731b17794cabc93cb57','baa75b5c09ba485eaf41fb53d64ec2d4','000400020004','商品品牌',NULL,'menu','/platform/goods/brand','data-pjax','',1,0,'goods.conf.brand',NULL,7,0,'',1475998340,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('93ddb8e7219f4a39b3c0c9caaaae756b','9d0a1379922d427ea2722cc0b4cd4d97','0001000100030004','分配菜单','SetMenu','data',NULL,NULL,NULL,0,0,'sys.manager.role.menu',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('9469919feb634522866907cf4b6cf923','e65a2eef4ce44fc4a0312b6fa06e0d57','0007000100010002','修改',NULL,'data','','','',0,0,'sales.coupon.manager.edit',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172950,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('9506c656e12d44eda6092a50f6d90191','793751112e604545b8a6f5b587d1b20c','00050001','会员管理',NULL,'menu','','','',1,0,'member.manager',NULL,10,1,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172278,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('9580baf08e0443d18cca4643c48feb8d','a603af011d574069894debc71f7a6206','0001000100100003','删除字典','Delete','data',NULL,NULL,NULL,0,0,'sys.manager.dict.delete',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('96554b09a2dd4f82bab7546fa59acd35','66cc21d7ce104dd6877cbce114c59fb3','0002000400010002','修改帐号','Edit','data','','','',0,0,'wx.conf.account.edit',NULL,0,0,'',1467474197,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('96be1d23c91241508466a351dbaf23fd','4d4cd6d0132a40e5992c8a9313b12d17','0009000100020001','添加',NULL,'data','','','',0,0,'shop.logistics.area.add',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504173261,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('97131f60ce9e43aba9a6c636b3e83d3c','ac4cc07654da4611ad4007b2c9548aa1','000900010004','支付方式',NULL,'menu','/platform/shop/payment','data-pjax','',1,0,'shop.payment.method',NULL,26,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504173391,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('9753811ab96841c4abab1bc2f01dab41','1f86a8a6debd41829d6a1c2a53677b1e','0005000200010002','修改',NULL,'data','','','',0,0,'member.config.level.edit',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172437,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('9822bafbe3454dfd8e8b974ebc304d03','3f330d729ca34dc9825c46122be1bfae','000300030001','链接分类','Class','menu','/platform/cms/link/class','data-pjax','',1,0,'cms.link.class',NULL,53,0,'',1468896932,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('98464e4910d84bcd815023a32e7247ac','baa75b5c09ba485eaf41fb53d64ec2d4','000400020003','商品规格','Spec','menu','/platform/goods/spec','data-pjax','',1,0,'goods.conf.spec',NULL,6,0,'',1475998233,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('99078dfbdbf1414a997aa46eee3a7310','97131f60ce9e43aba9a6c636b3e83d3c','0009000100040002','修改',NULL,'data','','','',0,0,'shop.payment.method.edit',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504173409,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('9a9557177d334c209cf73c3817fe3b63','2fab774f8b6d40cb9d7e187babab2d91','0002000400020003','删除菜单','Delete','data','','','',0,0,'wx.conf.menu.delete',NULL,0,0,'',1467474304,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('9d0a1379922d427ea2722cc0b4cd4d97','75b293b699fa4be98cd5379c962da634','000100010003','角色管理','Role','menu','/platform/sys/role','data-pjax',NULL,1,0,'sys.manager.role',NULL,59,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('9da77acc40174d36b185db429d865f55','2f5b80fcea254e2fbd17c00acf0e7cd7','0001000100090002','修改应用','Edit','data',NULL,NULL,NULL,0,0,'sys.manager.api.edit',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('9f20a757a6bc40ddbb650c70debbf660','b0edc6861a494b79b97990dc05f0a524','00020002','消息管理','Message','menu','','','ti-pencil-alt',1,0,'wx.msg',NULL,31,1,'',1467471415,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('9faf2fee6ede4984ab67ab78bdba72cf','75b293b699fa4be98cd5379c962da634','000100010002','用户管理','User','menu','/platform/sys/user','data-pjax',NULL,1,0,'sys.manager.user',NULL,58,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('a01046ca48db4938baac64aea97c61d3','e3fb9df52c9043aa893f1b0f453f718c','0001000100080003','删除路由','Delete','data',NULL,NULL,NULL,0,0,'sys.manager.route.delete',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('a0109ff37c6240c58632b53b533fd4c0','e3fb9df52c9043aa893f1b0f453f718c','0001000100080002','修改路由','Edit','data',NULL,NULL,NULL,0,0,'sys.manager.route.edit',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('a11163584dfe456cbfd6fb2d4b74391b','cabbe834a7474675b899e8442b5c2604','0002000500020001','获取列表','Get','data','','','',0,0,'wx.tpl.list.get',NULL,0,0,'',1470407390,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('a603af011d574069894debc71f7a6206','75b293b699fa4be98cd5379c962da634','000100010010','数据字典','Dict','menu','/platform/sys/dict','data-pjax',NULL,1,0,'sys.manager.dict',NULL,66,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('a7eca82f33804a5ea9b19bda9bff104f','4ff53ad173be425a844d71d82624f1e2','0001000100110003','删除插件','Delete','data',NULL,NULL,NULL,0,0,'sys.manager.plugin.delete',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('ac4cc07654da4611ad4007b2c9548aa1','bd06ed742344450291cf2fa3933683e3','00090001','商城配置',NULL,'menu','','','',1,0,'shop.config',NULL,22,1,'afe39b04690c4a5c8d74e7d8b8668d7d',1504173125,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('afac59e5f0f54dbd80454055cdad8dee','9d0a1379922d427ea2722cc0b4cd4d97','0001000100030001','添加角色','Add','data',NULL,NULL,NULL,0,0,'sys.manager.role.add',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('b0edc6861a494b79b97990dc05f0a524','','0002','微信','Wechat','menu','','','',1,0,'wx',NULL,28,1,'',1467471229,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('b19b23b0459a4754bf1fb8cb234450f2','e4256d7b0ffc4a02906cf900322b6213','000200010001','会员列表','List','menu','/platform/wx/user/index','data-pjax','',1,0,'wx.user.list',NULL,30,0,'',1467471357,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('b2631bbdbf824cc4b74d819c87962c0d','6b6de8c720c645a1808e1c3e9ccbfc90','000300020001','栏目管理','Channel','menu','/platform/cms/channel','data-pjax','',1,0,'cms.content.channel',NULL,50,0,'',1468896018,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('b2fa74e682fc4742aa5823a05f4b4a06','9faf2fee6ede4984ab67ab78bdba72cf','0001000100020003','删除用户','Delete','data',NULL,NULL,NULL,0,0,'sys.manager.user.delete',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('b37974239e054319a77e323a6bbcdf65','ac4cc07654da4611ad4007b2c9548aa1','000900010003','快递公司',NULL,'menu','/platform/shop/express','data-pjax','',1,0,'shop.logistics.express',NULL,25,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504173490,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('b6a9b0fbca754539b14202060d133985','8c0a03c1bee24e2d9888b0f1cc17aac1','0009000100010001','保存',NULL,'data','','','',0,0,'shop.config.config.update',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504173199,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('baa75b5c09ba485eaf41fb53d64ec2d4','ea54835bfd1649548ea539f3e5216daa','00040002','商品配置','Config','menu','','','ti-settings',1,0,'goods.conf',NULL,3,1,'',1475997799,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('bbdca10769d44f76932b2f9dcd5964d5','199c032cc9624c5d8ee06bd45dd09f48','0004000200020002','修改类型','Edit','data','','','',0,0,'goods.conf.type.edit',NULL,0,0,'',1475998166,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('bc24dbcccaa941c8906223072be16a37','5fec95aaa738485da39c1901d47ce2d2','000400010001','商品列表','List','menu','/platform/goods/goods','data-pjax','',1,0,'goods.manager.goods',NULL,2,0,'',1475997652,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('bcf64d623fdd4519ae345b7a08c071a1','b0edc6861a494b79b97990dc05f0a524','00020004','微信配置','Config','menu','','','fa fa-weixin',1,0,'wx.conf',NULL,39,1,'',1467472498,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('bd06ed742344450291cf2fa3933683e3','','0009','配置',NULL,'menu','','','',1,0,'shop',NULL,21,1,'afe39b04690c4a5c8d74e7d8b8668d7d',1504173102,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('c02abccd1b914a1b9f7d1f095dbfa390','97131f60ce9e43aba9a6c636b3e83d3c','0009000100040001','添加',NULL,'data','','','',0,0,'shop.payment.method.add',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504173402,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('c34668177d3c4dd9abf246e0aaf115ae','e6c9cf5a543744c18e5d395f8676996b','0005000100010002','修改',NULL,'data','','','',0,0,'member.manager.user.edit',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172344,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('c3a44b478d3241b899b9c3f4611bc2b6','234f8ec3c2bc42bf9f6202aecae36fd6','0002000300010001','添加文本','Add','data','','','',0,0,'wx.reply.txt.add',NULL,0,0,'',1467473460,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('c427ebcd8dda40738d905b928a7c0aa1','9086b227603d4f28ab6cb8bdfcac7642','0001000100050003','删除参数','Delete','data',NULL,NULL,NULL,0,0,'sys.manager.conf.delete',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('c49a9c7db8f44b5f98876b760299c94d','793751112e604545b8a6f5b587d1b20c','00050002','会员配置',NULL,'menu','','','',1,0,'member.config',NULL,12,1,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172388,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('c4df1823d7034d5684e100e468e050a8','a603af011d574069894debc71f7a6206','0001000100100002','修改字典','Edit','data',NULL,NULL,NULL,0,0,'sys.manager.dict.edit',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('c731aafcaf8d4d208a0d05deca9a9806','932317d1c0f94731b17794cabc93cb57','0004000200040001','添加品牌',NULL,'data','','','',0,0,'goods.conf.brand.add',NULL,0,0,'',1475998356,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('c76a84f871d047db955dd1465c845ac1','6afc5075913d4df4b44a6476080e35a0','000200050003','发送记录','Log','menu','/platform/wx/tpl/log','data-pjax','',1,0,'wx.tpl.log',NULL,45,0,'',1470406926,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('cabbe834a7474675b899e8442b5c2604','6afc5075913d4df4b44a6476080e35a0','000200050002','模板列表','List','menu','/platform/wx/tpl/list','data-pjax','',1,0,'wx.tpl.list',NULL,44,0,'',1470406883,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('ce709456e867425297955b3c40406d7e','6bb17a41f6394ed0a8a6faf5ff781354','0002000200020002','删除图文','Delete','data','','','',0,0,'wx.msg.mass.delNews',NULL,0,0,'',1467473363,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('d12c1fc3c4f24ad7b626b08408b55bfd','9faf2fee6ede4984ab67ab78bdba72cf','0001000100020002','修改用户','Edit','data',NULL,NULL,NULL,0,0,'sys.manager.user.edit',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('d1e991ad38a8424daf9f7eb000ee27f4','d920314e925c451da6d881e7a29743b7','000300010001','网站配置','Settings','menu','/platform/cms/site','data-pjax','',1,0,'cms.site.settings',NULL,48,0,'',1468895881,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('d269a4a48e684b048aa699688a733779','fca4f6790c4b472f8898e3b645fd70f9','0001000100040002','修改菜单','Edit','data',NULL,NULL,NULL,0,0,'sys.manager.menu.edit',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('d4b69fdad57642eca27bf837743a8513','1f86a8a6debd41829d6a1c2a53677b1e','0005000200010003','删除',NULL,'data','','','',0,0,'member.config.level.delete',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172444,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('d568f4c2b687404e8aec7b9edcae5767','66cc21d7ce104dd6877cbce114c59fb3','0002000400010003','删除帐号','Delete','data','','','',0,0,'wx.conf.account.delete',NULL,0,0,'',1467474209,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('d920314e925c451da6d881e7a29743b7','02e86a61e99746bea34236ea73dd52a5','00030001','站点管理','Site','menu','','','ti-world',1,0,'cms.site',NULL,47,1,'',1468895821,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('d9f512d5dd9e4671927468426ab3306a','9d0a1379922d427ea2722cc0b4cd4d97','0001000100030005','分配用户','SetUser','data',NULL,NULL,NULL,0,0,'sys.manager.role.user',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('dc7bc8053b5746338b49040567d9b3f5','9d0a1379922d427ea2722cc0b4cd4d97','0001000100030002','修改角色','Edit','data',NULL,NULL,NULL,0,0,'sys.manager.role.edit',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('dd965b2c1dfd493fb5efc7e4bcac99d4','2cb327ad59b140828fd26eb2a46cb948','0002000300030001','添加绑定','Add','data','','','',0,0,'wx.reply.follow.add',NULL,0,0,'',1467474026,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('defdfd4a5ab8421bb0a859823736a9d0','6abdf1e8dd13441b875c1a0dbbb3c99f','0001000100070003','删除任务','Delete','data',NULL,NULL,NULL,0,0,'sys.manager.task.delete',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('e25c9f04f4204157a271833973f30b1c','636de845072b45dfb5cd6784879ba586','0001000100060001','清除日志','Delete','data',NULL,NULL,NULL,0,0,'sys.manager.log.delete',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('e3fb9df52c9043aa893f1b0f453f718c','75b293b699fa4be98cd5379c962da634','000100010008','自定义路由','Route','menu','/platform/sys/route','data-pjax',NULL,1,0,'sys.manager.route',NULL,64,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('e4256d7b0ffc4a02906cf900322b6213','b0edc6861a494b79b97990dc05f0a524','00020001','微信会员','Member','menu','','','fa fa-user',1,0,'wx.user',NULL,29,1,'',1467471292,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('e461c62a1d5441619cd35612f3b40691','b2631bbdbf824cc4b74d819c87962c0d','0003000200010002','修改栏目','Edit','data','','','',0,0,'cms.content.channel.edit',NULL,0,0,'',1468896060,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('e65a2eef4ce44fc4a0312b6fa06e0d57','4849cd1e2c42427fac66decfe3760898','000700010001','优惠券配置',NULL,'menu','/platform/sales/coupon','data-pjax','',1,0,'sales.coupon.manager',NULL,20,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172927,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('e6b6224617b04090a76e46a4b048fb96','1385ae887e5c4b8aa33fbf228be7f907','0002000500010001','添加编号','Add','data','','','',0,0,'wx.tpl.id.add',NULL,0,0,'',1470407055,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('e6c9cf5a543744c18e5d395f8676996b','9506c656e12d44eda6092a50f6d90191','000500010001','会员列表',NULL,'menu','/platform/member/user','data-pjax','',1,0,'member.manager.user',NULL,11,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172311,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('e6ee9e2eff664f8da5b37a1417427e51','932317d1c0f94731b17794cabc93cb57','0004000200040002','修改品牌',NULL,'data','','','',0,0,'goods.conf.brand.edit',NULL,0,0,'',1475998365,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('e864c78aba63448892cbcb6a3a7f4da7','0706112ff5dc46e388064a99bcdb0561','0002000300040001','添加绑定','Add','data','','','',0,0,'wx.reply.keyword.add',NULL,0,0,'',1467474113,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('ea480a379bf648e1883b1a2599e98b61','4dd7fa3506c44e21a026a8290afb1837','000600010002','模板管理',NULL,'menu','/platform/dec/tpl','data-pjax','',1,0,'dec.manger.tpl',NULL,17,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504172837,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('ea54835bfd1649548ea539f3e5216daa','','0004','商品','Goods','menu','','','',1,0,'goods',NULL,0,1,'',1475997459,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('ed374f48b814427484c51dd12481b5e9','199c032cc9624c5d8ee06bd45dd09f48','0004000200020001','添加类型','Add','data','','','',0,0,'goods.conf.type.add',NULL,0,0,'',1475998156,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('ef9f436c61654ec09efbfa79a40061cf','6075fc0cf0ef441b9d93cc3cab3445bf','0003000200020002','修改文章','Edit','data','','','',0,0,'cms.content.article.edit',NULL,0,0,'',1468896159,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('f426468abf714b1599729f8c36ebbb0d','9f20a757a6bc40ddbb650c70debbf660','000200020001','会员消息','Msg','menu','/platform/wx/msg/user','data-pjax','',1,0,'wx.msg.user',NULL,32,1,'',1467471478,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('f42dfddc3b824be7b206421cff92921e','6abdf1e8dd13441b875c1a0dbbb3c99f','0001000100070001','添加任务','Add','data',NULL,NULL,NULL,0,0,'sys.manager.task.add',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('f4b43cf7d7c14e93bf126cd6dcbad1a3','4d4cd6d0132a40e5992c8a9313b12d17','0009000100020003','删除',NULL,'data','','','',0,0,'shop.logistics.area.delete',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504173276,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('f6fba69c3b704d79834b8bd2cc753729','b2631bbdbf824cc4b74d819c87962c0d','0003000200010003','删除栏目','Delete','data','','','',0,0,'cms.content.channel.delete',NULL,0,0,'',1468896072,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('fbf3c27d36a04593bb049455f5f3cf89','b37974239e054319a77e323a6bbcdf65','0009000100030002','修改',NULL,'data','','','',0,0,'shop.logistics.express.edit',NULL,0,0,'afe39b04690c4a5c8d74e7d8b8668d7d',1504173353,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('fc52d5284b8f4522802383c1ef732242','17e1ee23ca1443f1bc886c2f5eb7c24b','0002000300020003','删除图文','Delete','data','','','',0,0,'wx.reply.news.delete',NULL,0,0,'',1467473606,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('fca4f6790c4b472f8898e3b645fd70f9','75b293b699fa4be98cd5379c962da634','000100010004','菜单管理','Menu','menu','/platform/sys/menu','data-pjax',NULL,1,0,'sys.manager.menu',NULL,60,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('fced2b72c09e45e98a38fb9ae903a2b6','2f5b80fcea254e2fbd17c00acf0e7cd7','0001000100090003','删除应用','Delete','data',NULL,NULL,NULL,0,0,'sys.manager.api.delete',NULL,0,0,'',1504172034,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('fd63a8e389e04ff3a86c3cea53a3b9d5','234f8ec3c2bc42bf9f6202aecae36fd6','0002000300010002','修改文本','Edit','data','','','',0,0,'wx.reply.txt.edit',NULL,0,0,'',1467473519,0);
insert  into `sys_menu`(`id`,`parentId`,`path`,`name`,`aliasName`,`type`,`href`,`target`,`icon`,`isShow`,`disabled`,`permission`,`note`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('ff6cd243a77c4ae98dacf6149c816c75','0706112ff5dc46e388064a99bcdb0561','0002000300040002','修改绑定','Edit','data','','','',0,0,'wx.reply.keyword.edit',NULL,0,0,'',1467474125,0);

/*Table structure for table `sys_qrtz_blob_triggers` */

CREATE TABLE `sys_qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `sys_qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `sys_qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_qrtz_blob_triggers` */

/*Table structure for table `sys_qrtz_calendars` */

CREATE TABLE `sys_qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_qrtz_calendars` */

/*Table structure for table `sys_qrtz_cron_triggers` */

CREATE TABLE `sys_qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `sys_qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `sys_qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_qrtz_cron_triggers` */

/*Table structure for table `sys_qrtz_fired_triggers` */

CREATE TABLE `sys_qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_SYS_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_SYS_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_SYS_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_SYS_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_SYS_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_SYS_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_qrtz_fired_triggers` */

/*Table structure for table `sys_qrtz_job_details` */

CREATE TABLE `sys_qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_SYS_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_SYS_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_qrtz_job_details` */

/*Table structure for table `sys_qrtz_locks` */

CREATE TABLE `sys_qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_qrtz_locks` */

insert  into `sys_qrtz_locks`(`SCHED_NAME`,`LOCK_NAME`) values ('defaultScheduler','STATE_ACCESS');
insert  into `sys_qrtz_locks`(`SCHED_NAME`,`LOCK_NAME`) values ('defaultScheduler','TRIGGER_ACCESS');

/*Table structure for table `sys_qrtz_paused_trigger_grps` */

CREATE TABLE `sys_qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_qrtz_paused_trigger_grps` */

/*Table structure for table `sys_qrtz_scheduler_state` */

CREATE TABLE `sys_qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_qrtz_scheduler_state` */

insert  into `sys_qrtz_scheduler_state`(`SCHED_NAME`,`INSTANCE_NAME`,`LAST_CHECKIN_TIME`,`CHECKIN_INTERVAL`) values ('defaultScheduler','DESKTOP-WIZZER1510638791371',1510639611598,20000);

/*Table structure for table `sys_qrtz_simple_triggers` */

CREATE TABLE `sys_qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `sys_qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `sys_qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_qrtz_simple_triggers` */

/*Table structure for table `sys_qrtz_simprop_triggers` */

CREATE TABLE `sys_qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `sys_qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `sys_qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_qrtz_simprop_triggers` */

/*Table structure for table `sys_qrtz_triggers` */

CREATE TABLE `sys_qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_SYS_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_SYS_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_SYS_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_SYS_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_SYS_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_SYS_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_SYS_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_SYS_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_SYS_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_SYS_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_SYS_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_SYS_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `sys_qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `sys_qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_qrtz_triggers` */

/*Table structure for table `sys_role` */

CREATE TABLE `sys_role` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `aliasName` varchar(50) DEFAULT NULL,
  `disabled` tinyint(1) DEFAULT NULL,
  `unitid` varchar(32) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_SYS_ROLE_CODE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`name`,`code`,`aliasName`,`disabled`,`unitid`,`note`,`opBy`,`opAt`,`delFlag`) values ('832a801f1b4e498b8704328b9d71e5e7','公共角色','public','Public',0,'','All user has role','',1504172034,0);
insert  into `sys_role`(`id`,`name`,`code`,`aliasName`,`disabled`,`unitid`,`note`,`opBy`,`opAt`,`delFlag`) values ('bcaec2a22f3f4493aefafe222cca7774','系统管理员','sysadmin','Sysadmin',0,'','System Admin','',1504172034,0);

/*Table structure for table `sys_role_menu` */

CREATE TABLE `sys_role_menu` (
  `roleId` varchar(32) DEFAULT NULL,
  `menuId` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','6d6b51ed76924904b570acfdf2ebcee3');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','055a496251724329a569200e3bf30750');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','5723deb629e744edadfec0455175c09a');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','55d83cf6d3064747b1328f27472ff682');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','3202a3c02d804137b08d4ec3deac8984');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','74d31e653e2c43d6937fb4538ece6a55');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','ed374f48b814427484c51dd12481b5e9');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','bbdca10769d44f76932b2f9dcd5964d5');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','33d6d0fe153d4f9092b4f68be5725844');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','25759929f81a4444976d710932e2a7b8');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','5ef841b114704008a6eeb22ee78bdf0c');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','364bc883d5634c8b9c398ddd534165b5');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','c731aafcaf8d4d208a0d05deca9a9806');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','e6ee9e2eff664f8da5b37a1417427e51');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','002bf91c98ce4364bdafff334ce0f39f');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','46f2fbb80f644c5bb36a73d8a4befb01');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','64599d53010a49d693b54c21d5424345');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','c34668177d3c4dd9abf246e0aaf115ae');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','7a74d6be67144e9b995cc3706954a056');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','8275e9ad283c4882a9de8099987017ef');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','9753811ab96841c4abab1bc2f01dab41');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','d4b69fdad57642eca27bf837743a8513');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','4dc997fef71e4862b9db22de8e99a618');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','1734e586e96941268a4c5248b593cef9');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','56d0658c5a8848818ac05e8ffa5c0570');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','ce709456e867425297955b3c40406d7e');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','3099f497480c4b1987bce3f3a26c3fb4');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','c3a44b478d3241b899b9c3f4611bc2b6');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','fd63a8e389e04ff3a86c3cea53a3b9d5');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','7c040dfd8db347e5956a3bc1764653dc');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','2275cb125710414e91b617dd7c62f12c');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','0a972ce655cb4c84809d58668b655900');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','fc52d5284b8f4522802383c1ef732242');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','dd965b2c1dfd493fb5efc7e4bcac99d4');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','30a5e70a1456447ebf90b5546e9bc321');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','2a63040409094f1e9dc535dd78ce15b7');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','e864c78aba63448892cbcb6a3a7f4da7');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','ff6cd243a77c4ae98dacf6149c816c75');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','733d3f35d49f45af99ca9220048583ba');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','309dc29ad3c34408a68df8f867a5c9ff');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','96554b09a2dd4f82bab7546fa59acd35');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','d568f4c2b687404e8aec7b9edcae5767');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','45d958ca78304f25b51f6c71cf66f6d8');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','44da90bc76a5419a841f4924333f7a66');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','9a9557177d334c209cf73c3817fe3b63');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','0a43d291e0c94ad88c8b690009279e34');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','5244f5c38eb24b918e9ad64d456daa38');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','e6b6224617b04090a76e46a4b048fb96');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','3888f05aa4064f788ba7ec51c495ce7c');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','a11163584dfe456cbfd6fb2d4b74391b');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','c76a84f871d047db955dd1465c845ac1');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','8e3899ae0f3741a9b70c6dce461855f4');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','ea480a379bf648e1883b1a2599e98b61');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','4d27b7bdb2d64ce59a7b8c70ed9e3d14');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','9469919feb634522866907cf4b6cf923');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','2efbf1f2d2bf44f79cad9cde67c7c2e2');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','73a29d3f99224426b5a87c92da122275');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','4781372b00bb4d52b429b58e72b80c68');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','e461c62a1d5441619cd35612f3b40691');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','f6fba69c3b704d79834b8bd2cc753729');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','50ba60ee650e4c739e6abc3ab71e4960');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','33aed9298643424783116e0cf0f7fcbe');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','ef9f436c61654ec09efbfa79a40061cf');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','17500ef3a9e44b4fabb240162a164fcb');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','7db6207d0dab4d6e95a7eee4f2efe875');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','31ed2243077c44448cce26abfd5ae574');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','7125a72beee34b21ab3df9bf01b7bce6');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','077cb6be4c7c41cc8955ee045a4f0286');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','36e0faf5062b4f6b95d4167cbb1f8fea');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','3c24111091ad4a70ad2d9cc361311d2f');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','557c2d4c41b24e0594b4cbdf250df904');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','0ccc9e5e814d485baa33c909a362afb4');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','111894faedfd447fa2ca29959f2aa2ad');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','29f8858251cf4e5d83b5620f0d60e477');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','d12c1fc3c4f24ad7b626b08408b55bfd');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','b2fa74e682fc4742aa5823a05f4b4a06');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','afac59e5f0f54dbd80454055cdad8dee');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','dc7bc8053b5746338b49040567d9b3f5');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','20da12f4940445b8a92a95af5ed99860');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','93ddb8e7219f4a39b3c0c9caaaae756b');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','d9f512d5dd9e4671927468426ab3306a');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','788abb22d3a943a0aa3f3557cc7ee611');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','d269a4a48e684b048aa699688a733779');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','3556cce488ba46d18f22edd6b639bb37');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','41369bfd41d9435aaf7336d97f4b2936');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','24834040360b42e6abe37cac8fbac7b1');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','c427ebcd8dda40738d905b928a7c0aa1');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','e25c9f04f4204157a271833973f30b1c');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','f42dfddc3b824be7b206421cff92921e');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','897f5deddb584a4cb1733a5b52536f41');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','defdfd4a5ab8421bb0a859823736a9d0');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','6ad426c1ec82460a89b89dcd41818396');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','a0109ff37c6240c58632b53b533fd4c0');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','a01046ca48db4938baac64aea97c61d3');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','328ddb2ef7bf40828f1c407cd98c891b');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','9da77acc40174d36b185db429d865f55');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','fced2b72c09e45e98a38fb9ae903a2b6');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','503d154482c943a18ae326ce1adebef8');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','c4df1823d7034d5684e100e468e050a8');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','9580baf08e0443d18cca4643c48feb8d');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','71072e421bec4f79a32dff8e94c1158a');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','651cd3971a58401ab8383daeba9bb0d6');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','a7eca82f33804a5ea9b19bda9bff104f');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','bd06ed742344450291cf2fa3933683e3');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','ac4cc07654da4611ad4007b2c9548aa1');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','8c0a03c1bee24e2d9888b0f1cc17aac1');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','b6a9b0fbca754539b14202060d133985');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','4d4cd6d0132a40e5992c8a9313b12d17');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','96be1d23c91241508466a351dbaf23fd');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','32439a7ada26498f8b4fedbfc67b3ebe');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','f4b43cf7d7c14e93bf126cd6dcbad1a3');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','b37974239e054319a77e323a6bbcdf65');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','369f1827f8224fcebd59cd98e484e60f');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','fbf3c27d36a04593bb049455f5f3cf89');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','436930d21dd1424990f683a6193eab43');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','97131f60ce9e43aba9a6c636b3e83d3c');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','c02abccd1b914a1b9f7d1f095dbfa390');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','99078dfbdbf1414a997aa46eee3a7310');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','5e4f7d4692e746a480b44f625b373cea');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','35adf5275419411d81453a268e39ee8c');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','487c7c9b6ce249c992013c1b88524867');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','3f1fd4f0965745e487b919fcb0f9f704');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','8e2212ccbba840e382996bbb4b2bfb20');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','ea54835bfd1649548ea539f3e5216daa');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','5fec95aaa738485da39c1901d47ce2d2');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','bc24dbcccaa941c8906223072be16a37');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','baa75b5c09ba485eaf41fb53d64ec2d4');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','6776829efb244438b024b177e42b60aa');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','199c032cc9624c5d8ee06bd45dd09f48');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','98464e4910d84bcd815023a32e7247ac');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','932317d1c0f94731b17794cabc93cb57');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','793751112e604545b8a6f5b587d1b20c');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','9506c656e12d44eda6092a50f6d90191');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','e6c9cf5a543744c18e5d395f8676996b');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','c49a9c7db8f44b5f98876b760299c94d');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','1f86a8a6debd41829d6a1c2a53677b1e');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','b0edc6861a494b79b97990dc05f0a524');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','e4256d7b0ffc4a02906cf900322b6213');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','b19b23b0459a4754bf1fb8cb234450f2');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','9f20a757a6bc40ddbb650c70debbf660');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','f426468abf714b1599729f8c36ebbb0d');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','6bb17a41f6394ed0a8a6faf5ff781354');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','4cd8e4e9519e4cff95465194fdcc8d88');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','234f8ec3c2bc42bf9f6202aecae36fd6');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','17e1ee23ca1443f1bc886c2f5eb7c24b');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','2cb327ad59b140828fd26eb2a46cb948');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','0706112ff5dc46e388064a99bcdb0561');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','bcf64d623fdd4519ae345b7a08c071a1');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','66cc21d7ce104dd6877cbce114c59fb3');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','2fab774f8b6d40cb9d7e187babab2d91');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','6afc5075913d4df4b44a6476080e35a0');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','1385ae887e5c4b8aa33fbf228be7f907');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','cabbe834a7474675b899e8442b5c2604');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','225ab206fe324db6805d4de4e2aa4380');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','4dd7fa3506c44e21a026a8290afb1837');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','007af6aa4e534246823ba49cc5021085');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','4849cd1e2c42427fac66decfe3760898');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','e65a2eef4ce44fc4a0312b6fa06e0d57');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','02e86a61e99746bea34236ea73dd52a5');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','d920314e925c451da6d881e7a29743b7');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','d1e991ad38a8424daf9f7eb000ee27f4');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','6b6de8c720c645a1808e1c3e9ccbfc90');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','b2631bbdbf824cc4b74d819c87962c0d');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','6075fc0cf0ef441b9d93cc3cab3445bf');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','3f330d729ca34dc9825c46122be1bfae');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','9822bafbe3454dfd8e8b974ebc304d03');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','68cdbf694f71445c8587a20234d6fe31');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','0e09445caec24fd0951e63495dd8d631');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','75b293b699fa4be98cd5379c962da634');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','087e77c9106b453bb9e56eed136901c4');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','9faf2fee6ede4984ab67ab78bdba72cf');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','9d0a1379922d427ea2722cc0b4cd4d97');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','fca4f6790c4b472f8898e3b645fd70f9');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','9086b227603d4f28ab6cb8bdfcac7642');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','636de845072b45dfb5cd6784879ba586');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','6abdf1e8dd13441b875c1a0dbbb3c99f');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','e3fb9df52c9043aa893f1b0f453f718c');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','2f5b80fcea254e2fbd17c00acf0e7cd7');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','a603af011d574069894debc71f7a6206');
insert  into `sys_role_menu`(`roleId`,`menuId`) values ('bcaec2a22f3f4493aefafe222cca7774','4ff53ad173be425a844d71d82624f1e2');

/*Table structure for table `sys_route` */

CREATE TABLE `sys_route` (
  `id` varchar(32) NOT NULL,
  `url` varchar(255) DEFAULT NULL COMMENT '原始路径',
  `toUrl` varchar(255) DEFAULT NULL COMMENT '跳转路径',
  `type` varchar(10) DEFAULT NULL COMMENT '转发类型',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_route` */

insert  into `sys_route`(`id`,`url`,`toUrl`,`type`,`disabled`,`opBy`,`opAt`,`delFlag`) values ('ecd899e1098d411492ad5f45665dc4de','/sysadmin','/platform/login','hide',0,'',1504172037,0);

/*Table structure for table `sys_task` */

CREATE TABLE `sys_task` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '任务名',
  `jobClass` varchar(255) DEFAULT NULL COMMENT '执行类',
  `note` varchar(255) DEFAULT NULL COMMENT '任务说明',
  `cron` varchar(50) DEFAULT NULL COMMENT '定时规则',
  `data` text COMMENT '执行参数',
  `exeAt` int(32) DEFAULT NULL COMMENT '执行时间',
  `exeResult` text COMMENT '执行结果',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_task` */

insert  into `sys_task`(`id`,`name`,`jobClass`,`note`,`cron`,`data`,`exeAt`,`exeResult`,`disabled`,`opBy`,`opAt`,`delFlag`) values ('53e71ff336c54744ba1fd764bb9e4707','测试任务','cn.wizzer.app.web.commons.quartz.job.TestJob','微信号：wizzer | 欢迎发送红包以示支持，多谢。。','*/5 * * * * ?','{\"hi\":\"Wechat:wizzer | send red packets of support,thank u\"}',NULL,NULL,1,'',1504172036,0);

/*Table structure for table `sys_unit` */

CREATE TABLE `sys_unit` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `parentId` varchar(32) DEFAULT NULL COMMENT '父级ID',
  `path` varchar(100) DEFAULT NULL COMMENT '树路径',
  `name` varchar(100) DEFAULT NULL COMMENT '单位名称',
  `aliasName` varchar(100) DEFAULT NULL COMMENT '单位别名',
  `unitcode` varchar(20) DEFAULT NULL COMMENT '机构编码',
  `note` varchar(255) DEFAULT NULL COMMENT '单位介绍',
  `address` varchar(100) DEFAULT NULL COMMENT '单位地址',
  `telephone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(100) DEFAULT NULL COMMENT '单位邮箱',
  `website` varchar(100) DEFAULT NULL COMMENT '单位网站',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `hasChildren` tinyint(1) DEFAULT NULL COMMENT '有子节点',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_SYS_UNIT_PATH` (`path`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_unit` */

insert  into `sys_unit`(`id`,`parentId`,`path`,`name`,`aliasName`,`unitcode`,`note`,`address`,`telephone`,`email`,`website`,`location`,`hasChildren`,`opBy`,`opAt`,`delFlag`) values ('fad66e50491f468dbb599889181f76e2','','0001','系统管理','System',NULL,NULL,'银河-太阳系-地球','','wizzer@qq.com','http://www.wizzer.cn',1,0,'',1504172034,0);

/*Table structure for table `sys_user` */

CREATE TABLE `sys_user` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `loginname` varchar(120) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(50) DEFAULT NULL COMMENT '密码盐',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `isOnline` tinyint(1) DEFAULT NULL COMMENT '是否在线',
  `disabled` tinyint(1) DEFAULT NULL COMMENT '是否禁用',
  `email` varchar(255) DEFAULT NULL,
  `loginAt` int(32) DEFAULT NULL COMMENT '登陆时间',
  `loginIp` varchar(255) DEFAULT NULL COMMENT '登陆IP',
  `loginCount` int(32) DEFAULT NULL COMMENT '登陆次数',
  `customMenu` varchar(255) DEFAULT NULL COMMENT '常用菜单',
  `loginTheme` varchar(100) DEFAULT NULL COMMENT '皮肤样式',
  `loginSidebar` tinyint(1) DEFAULT NULL,
  `loginBoxed` tinyint(1) DEFAULT NULL,
  `loginScroll` tinyint(1) DEFAULT NULL,
  `loginPjax` tinyint(1) DEFAULT NULL,
  `unitid` varchar(32) DEFAULT NULL,
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_SYS_USER_LOGINNAMAE` (`loginname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`loginname`,`password`,`salt`,`username`,`isOnline`,`disabled`,`email`,`loginAt`,`loginIp`,`loginCount`,`customMenu`,`loginTheme`,`loginSidebar`,`loginBoxed`,`loginScroll`,`loginPjax`,`unitid`,`opBy`,`opAt`,`delFlag`) values ('afe39b04690c4a5c8d74e7d8b8668d7d','superadmin','tDdI2tf9Y2IZ3WLalMGiVG5bGYPrYtEInNnvBYYFUqc=','BhB+jRHU4UcqUmerFmREUQ==','超级管理员',1,0,'wizzer@qq.com',1510636482,'127.0.0.1',5,NULL,'palette.css',0,0,0,1,'fad66e50491f468dbb599889181f76e2','',1504172034,0);

/*Table structure for table `sys_user_role` */

CREATE TABLE `sys_user_role` (
  `userId` varchar(32) DEFAULT NULL,
  `roleId` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`userId`,`roleId`) values ('afe39b04690c4a5c8d74e7d8b8668d7d','bcaec2a22f3f4493aefafe222cca7774');

/*Table structure for table `sys_user_unit` */

CREATE TABLE `sys_user_unit` (
  `userId` varchar(32) DEFAULT NULL,
  `unitId` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_unit` */

insert  into `sys_user_unit`(`userId`,`unitId`) values ('afe39b04690c4a5c8d74e7d8b8668d7d','fad66e50491f468dbb599889181f76e2');

/*Table structure for table `wx_config` */

CREATE TABLE `wx_config` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `appname` varchar(120) DEFAULT NULL COMMENT '公众号名称',
  `ghid` varchar(100) DEFAULT NULL COMMENT '原始ID',
  `appid` varchar(50) DEFAULT NULL COMMENT 'Appid',
  `appsecret` varchar(50) DEFAULT NULL COMMENT 'Appsecret',
  `encodingAESKey` varchar(100) DEFAULT NULL COMMENT 'EncodingAESKey',
  `token` varchar(100) DEFAULT NULL COMMENT 'Token',
  `access_token` varchar(255) DEFAULT NULL COMMENT 'access_token',
  `access_token_expires` int(32) DEFAULT NULL COMMENT 'access_token_expires',
  `access_token_lastat` varchar(50) DEFAULT NULL COMMENT 'access_token_lastat',
  `payEnabled` tinyint(1) DEFAULT NULL COMMENT '禁用支付',
  `payInfo` text COMMENT '支付信息',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wx_config` */

/*Table structure for table `wx_mass` */

CREATE TABLE `wx_mass` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `name` varchar(255) DEFAULT NULL COMMENT '群发名称',
  `type` varchar(20) DEFAULT NULL COMMENT '群发类型',
  `media_id` varchar(255) DEFAULT NULL COMMENT '媒体文件ID',
  `scope` varchar(20) DEFAULT NULL COMMENT 'Scope',
  `content` text COMMENT 'Content',
  `status` int(32) DEFAULT NULL COMMENT '发送状态',
  `wxid` varchar(32) DEFAULT NULL COMMENT '微信ID',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wx_mass` */

/*Table structure for table `wx_mass_news` */

CREATE TABLE `wx_mass_news` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `thumb_media_id` varchar(255) DEFAULT NULL COMMENT '缩略图',
  `author` varchar(120) DEFAULT NULL COMMENT '作者',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content_source_url` varchar(255) DEFAULT NULL COMMENT '原地址',
  `content` text COMMENT '图文内容',
  `digest` text COMMENT '摘要',
  `show_cover_pic` int(32) DEFAULT NULL COMMENT '显示封面',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `wxid` varchar(32) DEFAULT NULL COMMENT '微信ID',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wx_mass_news` */

/*Table structure for table `wx_mass_send` */

CREATE TABLE `wx_mass_send` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `massId` varchar(32) DEFAULT NULL COMMENT '群发ID',
  `receivers` text COMMENT 'Openid列表',
  `status` int(32) DEFAULT NULL COMMENT '发送状态',
  `msgId` varchar(32) DEFAULT NULL COMMENT 'msgId',
  `errCode` varchar(32) DEFAULT NULL COMMENT 'errCode',
  `errMsg` varchar(255) DEFAULT NULL COMMENT 'errMsg',
  `wxid` varchar(32) DEFAULT NULL COMMENT '微信ID',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wx_mass_send` */

/*Table structure for table `wx_menu` */

CREATE TABLE `wx_menu` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `parentId` varchar(32) DEFAULT NULL COMMENT '父ID',
  `path` varchar(100) DEFAULT NULL COMMENT '树路径',
  `menuName` varchar(20) DEFAULT NULL COMMENT '菜单名称',
  `menuType` varchar(20) DEFAULT NULL COMMENT '菜单类型',
  `menuKey` varchar(20) DEFAULT NULL COMMENT '关键词',
  `url` varchar(255) DEFAULT NULL COMMENT '网址',
  `appid` varchar(255) DEFAULT NULL COMMENT '小程序appid',
  `pagepath` varchar(255) DEFAULT NULL COMMENT '小程序入口页',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `hasChildren` tinyint(1) DEFAULT NULL COMMENT '有子节点',
  `wxid` varchar(32) DEFAULT NULL COMMENT '微信ID',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wx_menu` */

/*Table structure for table `wx_msg` */

CREATE TABLE `wx_msg` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `openid` varchar(50) DEFAULT NULL COMMENT 'openid',
  `nickname` varchar(255) DEFAULT NULL COMMENT '微信昵称',
  `type` varchar(20) DEFAULT NULL COMMENT '信息类型',
  `content` text COMMENT '信息内容',
  `replyId` varchar(32) DEFAULT NULL COMMENT '回复ID',
  `wxid` varchar(32) DEFAULT NULL COMMENT '微信ID',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wx_msg` */

/*Table structure for table `wx_msg_reply` */

CREATE TABLE `wx_msg_reply` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `msgid` varchar(32) DEFAULT NULL COMMENT 'msgid',
  `openid` varchar(50) DEFAULT NULL COMMENT 'openid',
  `type` varchar(20) DEFAULT NULL COMMENT '信息类型',
  `content` text COMMENT '信息内容',
  `wxid` varchar(32) DEFAULT NULL COMMENT '微信ID',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wx_msg_reply` */

/*Table structure for table `wx_reply` */

CREATE TABLE `wx_reply` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `type` varchar(20) DEFAULT NULL COMMENT '回复类型',
  `msgType` varchar(20) DEFAULT NULL COMMENT '消息类型',
  `keyword` varchar(50) DEFAULT NULL COMMENT '关键词',
  `content` text COMMENT '回复内容',
  `wxid` varchar(32) DEFAULT NULL COMMENT '微信ID',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wx_reply` */

/*Table structure for table `wx_reply_news` */

CREATE TABLE `wx_reply_news` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `description` varchar(255) DEFAULT NULL COMMENT '摘要',
  `picUrl` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `url` varchar(255) DEFAULT NULL COMMENT '文章路径',
  `location` int(32) DEFAULT NULL COMMENT '排序字段',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wx_reply_news` */

/*Table structure for table `wx_reply_txt` */

CREATE TABLE `wx_reply_txt` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wx_reply_txt` */

/*Table structure for table `wx_tpl_id` */

CREATE TABLE `wx_tpl_id` (
  `id` varchar(32) NOT NULL COMMENT '模板编号',
  `template_id` varchar(255) DEFAULT NULL COMMENT '模板ID',
  `wxid` varchar(32) DEFAULT NULL COMMENT '微信ID',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wx_tpl_id` */

/*Table structure for table `wx_tpl_list` */

CREATE TABLE `wx_tpl_list` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `template_id` varchar(100) DEFAULT NULL COMMENT '模板ID',
  `title` varchar(255) DEFAULT NULL COMMENT '模板标题',
  `primary_industry` varchar(100) DEFAULT NULL COMMENT '主营行业',
  `deputy_industry` varchar(100) DEFAULT NULL COMMENT '副营行业',
  `content` varchar(300) DEFAULT NULL COMMENT '模板内容',
  `example` varchar(300) DEFAULT NULL COMMENT '模板示例',
  `wxid` varchar(32) DEFAULT NULL COMMENT '微信ID',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_WX_TPL_LIST` (`template_id`,`wxid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wx_tpl_list` */

/*Table structure for table `wx_tpl_log` */

CREATE TABLE `wx_tpl_log` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `openid` varchar(50) DEFAULT NULL COMMENT 'openid',
  `nickname` varchar(255) DEFAULT NULL COMMENT '微信昵称',
  `content` text COMMENT '发送内容',
  `status` int(32) DEFAULT NULL COMMENT '发送状态',
  `result` text COMMENT '发送结果',
  `wxid` varchar(32) DEFAULT NULL COMMENT '微信ID',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wx_tpl_log` */

/*Table structure for table `wx_user` */

CREATE TABLE `wx_user` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `openid` varchar(50) DEFAULT NULL COMMENT 'openid',
  `unionid` varchar(50) DEFAULT NULL COMMENT 'unionid',
  `nickname` varchar(255) DEFAULT NULL COMMENT '微信昵称',
  `subscribe` tinyint(1) DEFAULT NULL COMMENT '是否关注',
  `subscribeAt` int(32) DEFAULT NULL COMMENT '关注时间',
  `sex` int(32) DEFAULT NULL COMMENT '性别',
  `country` varchar(50) DEFAULT NULL COMMENT '国家',
  `province` varchar(50) DEFAULT NULL COMMENT '省份',
  `city` varchar(50) DEFAULT NULL COMMENT '城市',
  `headimgurl` varchar(255) DEFAULT NULL COMMENT '头像',
  `wxid` varchar(32) DEFAULT NULL COMMENT '微信ID',
  `opBy` varchar(32) DEFAULT NULL COMMENT '操作人',
  `opAt` int(32) DEFAULT NULL COMMENT '操作时间',
  `delFlag` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`),
  UNIQUE KEY `INDEX_WX_USER_OPENID` (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wx_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
