-- MySQL dump 10.13  Distrib 5.7.19, for macos10.12 (x86_64)
--
-- Host: localhost    Database: growth
-- ------------------------------------------------------
-- Server version	5.7.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `growth`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `growth` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `growth`;

--
-- Table structure for table `secu_menu`
--

DROP TABLE IF EXISTS `secu_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secu_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `menu_url` varchar(200) NOT NULL COMMENT '菜单地址',
  `menu_module` varchar(20) DEFAULT NULL,
  `menu_order` int(5) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(20) DEFAULT NULL COMMENT '创建人',
  `rec_status` int(1) DEFAULT NULL COMMENT '记录状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COMMENT='菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secu_menu`
--

LOCK TABLES `secu_menu` WRITE;
/*!40000 ALTER TABLE `secu_menu` DISABLE KEYS */;
INSERT INTO `secu_menu` VALUES (2,'secuUser','/sys/user/list','System Manage',10,'2018-08-13 23:59:58','admin',1),(3,'secuRole','/sys/role/list','System Manage',15,'2018-08-14 00:07:30','admin',1),(4,'secuMenu','/sys/menu/list','System Manage',20,'2018-08-14 00:07:36','admin',1),(5,'sysParam','/sys/param/list','Others',900,'2018-08-14 00:10:37','admin',1),(6,'组织机构管理','/sys/org/list','系统设置',10,'2018-09-05 21:56:36','admin',1),(7,'部门用户管理','/sys/user/list','系统设置',20,'2018-09-05 21:56:28','admin',1),(8,'外发流程设置','/process','系统设置',30,'2018-12-30 21:48:19','admin',1),(10,'操作系统日志','/sys/log/list','审计监控',10,'2018-08-28 23:58:01','admin',1),(20,'sysLog','/sys/log/list','Others',90,'2018-08-28 22:59:46','admin',1),(21,'secuOrg','/sys/org/list','System Manage',40,'2018-09-03 21:40:15','admin',1);
/*!40000 ALTER TABLE `secu_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secu_org`
--

DROP TABLE IF EXISTS `secu_org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secu_org` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` bigint(20) NOT NULL COMMENT '父机构id',
  `org_name` varchar(100) NOT NULL COMMENT '机构名称',
  `org_address` varchar(50) DEFAULT NULL COMMENT '机构地址',
  `found_date` datetime DEFAULT NULL COMMENT '成立时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(20) DEFAULT NULL COMMENT '创建人',
  `rec_status` int(1) DEFAULT NULL COMMENT '记录状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COMMENT='机构';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secu_org`
--

LOCK TABLES `secu_org` WRITE;
/*!40000 ALTER TABLE `secu_org` DISABLE KEYS */;
INSERT INTO `secu_org` VALUES (8,0,'Human Resources','abc','2018-09-03 00:00:00','2018-09-03 22:29:12','admin',1),(12,0,'investiment','',NULL,'2018-09-04 20:47:32','admin',1),(13,12,'subinvest','',NULL,'2018-09-04 21:54:54','admin',1),(14,13,'4th org','',NULL,'2018-09-04 22:16:53','admin',1),(15,12,'subinvest2','',NULL,'2018-09-05 22:07:09','admin',1),(16,0,'finance','','2018-08-28 00:00:00','2018-09-05 22:12:48','nuo1',1),(17,16,'finance it','',NULL,'2018-09-05 22:12:59','nuo1',1);
/*!40000 ALTER TABLE `secu_org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secu_role`
--

DROP TABLE IF EXISTS `secu_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secu_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_name` varchar(20) NOT NULL COMMENT '角色名称',
  `role_description` varchar(200) NOT NULL COMMENT 'KEY',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(20) DEFAULT NULL COMMENT '创建人',
  `rec_status` int(1) DEFAULT NULL COMMENT '记录状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COMMENT='角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secu_role`
--

LOCK TABLES `secu_role` WRITE;
/*!40000 ALTER TABLE `secu_role` DISABLE KEYS */;
INSERT INTO `secu_role` VALUES (8,'systemAdmin','系统管理员','2018-08-05 23:45:47','admin',1);
/*!40000 ALTER TABLE `secu_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secu_role_menu`
--

DROP TABLE IF EXISTS `secu_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secu_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_name` varchar(20) NOT NULL COMMENT '角色',
  `menu_name` varchar(40) NOT NULL COMMENT '菜单',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(20) DEFAULT NULL COMMENT '创建人',
  `rec_status` int(1) DEFAULT NULL COMMENT '记录状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=388 DEFAULT CHARSET=utf8mb4 COMMENT='角色菜单关联关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secu_role_menu`
--

LOCK TABLES `secu_role_menu` WRITE;
/*!40000 ALTER TABLE `secu_role_menu` DISABLE KEYS */;
INSERT INTO `secu_role_menu` VALUES (370,'systemAdmin','secuUser','2019-04-13 20:49:20','admin',1),(371,'systemAdmin','secuRole','2019-04-13 20:49:20','admin',1),(372,'systemAdmin','secuMenu','2019-04-13 20:49:20','admin',1),(373,'systemAdmin','sysParam','2019-04-13 20:49:20','admin',1),(374,'systemAdmin','组织机构管理','2019-04-13 20:49:20','admin',1),(375,'systemAdmin','部门用户管理','2019-04-13 20:49:20','admin',1),(376,'systemAdmin','外发流程设置','2019-04-13 20:49:20','admin',1),(378,'systemAdmin','操作系统日志','2019-04-13 20:49:20','admin',1),(385,'systemAdmin','sysLog','2019-04-13 20:49:20','admin',1),(386,'systemAdmin','secuOrg','2019-04-13 20:49:20','admin',1);
/*!40000 ALTER TABLE `secu_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secu_user`
--

DROP TABLE IF EXISTS `secu_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secu_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_name` varchar(20) NOT NULL COMMENT '帐号',
  `org_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '机构id',
  `password` varchar(32) NOT NULL COMMENT '密码MD5(密码+盐)',
  `salt` varchar(32) DEFAULT NULL COMMENT '盐',
  `real_name` varchar(200) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `gender` varchar(6) DEFAULT NULL COMMENT '性别',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(20) DEFAULT NULL COMMENT '创建人',
  `rec_status` int(1) DEFAULT NULL COMMENT '记录状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secu_user`
--

LOCK TABLES `secu_user` WRITE;
/*!40000 ALTER TABLE `secu_user` DISABLE KEYS */;
INSERT INTO `secu_user` VALUES (1,'admin',0,'4b32c05ea8826d70454cf185db2113da',NULL,'Administrator','110','110@163.com','female','2018-08-05 23:28:12','admin',1),(3,'nuo1',0,'aa3e11a08bf9b89b7a1772dfa5f597d7',NULL,'诺伊','','','female','2018-08-05 23:28:19','admin',1),(4,'Harper',0,'23779198414665f7d7f8071a9b639bad',NULL,'Harper','','harper@110.com','male','2018-09-02 17:01:59','admin',1),(5,'hr1',8,'28d253a3bb52ba9ccac05b2977261fab',NULL,'HR1','','','male','2018-09-04 00:00:48','admin',1),(8,'iv3',8,'d93219da04ea474ff90bf9b248e3f530',NULL,'iv3','','1',NULL,'2018-09-04 20:36:45','admin',1),(9,'iv1',12,'d9be74be2df88153b112147bc2c352d1',NULL,'','','',NULL,'2018-09-04 20:47:49','admin',1),(10,'bottom',13,'33bf1fc5ee756536a715c4b317b934d3',NULL,'','','','male','2018-09-04 22:09:41','admin',1);
/*!40000 ALTER TABLE `secu_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secu_user_role`
--

DROP TABLE IF EXISTS `secu_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secu_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_name` varchar(20) NOT NULL COMMENT '用户',
  `role_name` varchar(20) NOT NULL COMMENT '角色',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(20) DEFAULT NULL COMMENT '创建人',
  `rec_status` int(1) DEFAULT NULL COMMENT '记录状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关联关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secu_user_role`
--

LOCK TABLES `secu_user_role` WRITE;
/*!40000 ALTER TABLE `secu_user_role` DISABLE KEYS */;
INSERT INTO `secu_user_role` VALUES (15,'Harper','systemAdmin','2018-08-05 23:50:03','admin',1),(25,'nuo1','lower','2018-08-14 23:59:58','admin',1),(29,'admin','systemAdmin','2018-08-15 00:00:08','admin',1),(31,'admin','lower','2018-08-15 00:09:18','admin',1),(44,'nuo1','管理员','2018-08-22 23:49:20','admin',1),(47,'iv3','systemAdmin','2018-09-04 20:42:38','admin',1);
/*!40000 ALTER TABLE `secu_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_blob`
--

DROP TABLE IF EXISTS `sys_blob`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_blob` (
  `blob_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `data` blob COMMENT '数据',
  `business_id` bigint(20) DEFAULT NULL COMMENT '业务id',
  PRIMARY KEY (`blob_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统BLOB数据表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_blob`
--

LOCK TABLES `sys_blob` WRITE;
/*!40000 ALTER TABLE `sys_blob` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_blob` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_log`
--

DROP TABLE IF EXISTS `sys_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `log_type` varchar(20) NOT NULL COMMENT '日志类型',
  `login` varchar(20) NOT NULL COMMENT '创建人',
  `operate_time` datetime NOT NULL COMMENT '创建时间',
  `operate_ip` varchar(30) DEFAULT NULL COMMENT '操作IP',
  `log_content` varchar(20) DEFAULT NULL COMMENT '日志内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='系统日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_log`
--

LOCK TABLES `sys_log` WRITE;
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;
INSERT INTO `sys_log` VALUES (1,'login','admin','2019-12-09 20:42:58','0:0:0:0:0:0:0:1',NULL),(2,'login','admin','2019-12-09 20:55:57','0:0:0:0:0:0:0:1',NULL),(3,'login','admin','2019-12-09 21:03:15','0:0:0:0:0:0:0:1',NULL),(4,'login','admin','2019-12-09 21:13:04','0:0:0:0:0:0:0:1',NULL),(5,'login','admin','2019-12-09 21:17:38','0:0:0:0:0:0:0:1',NULL);
/*!40000 ALTER TABLE `sys_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_param`
--

DROP TABLE IF EXISTS `sys_param`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_param` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `param_name` varchar(20) NOT NULL COMMENT '参数名',
  `param_description` varchar(200) NOT NULL COMMENT '参数描述',
  `not_allow_edit` int(1) NOT NULL COMMENT '不允许编辑',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(20) DEFAULT NULL COMMENT '创建人',
  `rec_status` int(1) DEFAULT NULL COMMENT '记录状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COMMENT='系统参数表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_param`
--

LOCK TABLES `sys_param` WRITE;
/*!40000 ALTER TABLE `sys_param` DISABLE KEYS */;
INSERT INTO `sys_param` VALUES (9,'record_status','记录状态',0,'2018-08-11 22:43:30','admin',1),(10,'menu_module','菜单模块',0,'2018-08-11 22:44:55','admin',1),(11,'param_data_type','参数数据类型',0,'2018-08-12 17:31:07','admin',1),(12,'Alternative','是否',0,'2018-08-12 22:54:56','admin',1),(13,'gender','性别',0,'2018-08-17 23:02:22','admin',1),(14,'terminal_status','终端状态',0,'2018-08-22 22:25:10','admin',1),(15,'application_type','应用软件类型',0,'2018-08-23 23:49:12','admin',1),(17,'system_log_type','系统日志类型',0,'2018-08-28 22:56:34','admin',1),(18,'system_config','系统基本配置信息',1,'2018-09-02 19:08:43','admin',1),(19,'outgoing_level','外发策略申请级别',0,'2018-09-11 22:44:00','admin',1),(20,'strategy_type','策略类型',0,'2018-09-12 23:09:33','admin',1),(21,'watermark_layout','水印版式',0,'2018-09-20 22:08:20','admin',1),(22,'watermark_condition','水印显示条件',0,'2018-09-20 22:08:59','admin',1),(23,'approve_status','审批状态',0,'2018-12-29 22:24:30','admin',1);
/*!40000 ALTER TABLE `sys_param` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_param_config`
--

DROP TABLE IF EXISTS `sys_param_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_param_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `param_name` varchar(20) NOT NULL COMMENT '参数名',
  `config_name` varchar(90) NOT NULL COMMENT '配置名',
  `data_type` varchar(20) NOT NULL COMMENT '数据类型',
  `show_name` varchar(200) NOT NULL COMMENT '显示名称',
  `data_length` int(3) DEFAULT NULL COMMENT '数据类型',
  `not_null` int(1) DEFAULT NULL COMMENT '是否为空',
  `is_of_uniq` int(1) DEFAULT NULL COMMENT '是否唯一属性之一',
  `config_order` int(5) DEFAULT NULL COMMENT '序号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(20) DEFAULT NULL COMMENT '创建人',
  `rec_status` int(1) DEFAULT NULL COMMENT '记录状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COMMENT='参数配置信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_param_config`
--

LOCK TABLES `sys_param_config` WRITE;
/*!40000 ALTER TABLE `sys_param_config` DISABLE KEYS */;
INSERT INTO `sys_param_config` VALUES (9,'menu_module','module_name','String','模块名',20,1,1,10,'2018-08-18 17:41:33','admin',1),(10,'menu_module','module_order','Integer','模块顺序',3,NULL,NULL,20,'2018-08-13 23:42:23','admin',1),(11,'record_status','status_code','Integer','状态代码',1,1,1,10,'2018-08-18 17:39:56','admin',1),(12,'record_status','status_description','String','状态描述',50,NULL,NULL,20,'2018-08-13 23:30:35','admin',1),(13,'param_data_type','type_code','String','类型代码',20,1,1,10,'2018-08-18 17:41:44','admin',1),(14,'param_data_type','type_name','String','类型名称',50,1,NULL,20,'2018-08-12 22:25:58','admin',1),(15,'Alternative','code','Integer','代码',1,1,1,10,'2018-08-18 17:41:53','admin',1),(16,'Alternative','value','String','值',2,1,NULL,20,'2018-08-13 00:04:22','admin',1),(17,'gender','code','String','代码',10,1,1,10,'2018-08-18 17:42:01','admin',1),(18,'gender','name','String','名字',30,1,NULL,20,'2018-08-17 23:03:27','admin',1),(19,'gender','description','String','描述',50,NULL,NULL,30,'2018-08-17 23:03:51','admin',1),(20,'terminal_status','code','Integer','代码',2,1,1,10,'2018-08-22 22:25:40','admin',1),(21,'terminal_status','name','String','名称',20,1,0,20,'2018-08-22 22:26:27','admin',1),(22,'application_type','code','Integer','类型代码',2,1,1,10,'2018-08-23 23:50:02','admin',1),(23,'application_type','name','String','类型名称',50,1,0,20,'2018-08-23 23:50:33','admin',1),(24,'application_type','description','String','类型描述',200,0,NULL,30,'2018-08-23 23:51:09','admin',1),(25,'log_type','type','String','类型',20,1,1,10,'2018-08-26 22:08:19','admin',1),(26,'log_type','name','String','日志类型名称',40,1,0,20,'2018-08-26 22:06:39','admin',1),(27,'log_type','description','String','描述',200,NULL,NULL,30,'2018-08-26 22:07:07','admin',1),(28,'system_log_type','type','String','类型',20,1,1,10,'2018-08-28 22:57:14','admin',1),(29,'system_log_type','type_name','String','类型名称',90,0,NULL,20,'2018-08-28 22:57:50','admin',1),(33,'system_config','db_backup_path','String','数据库备份路径',100,1,NULL,NULL,'2018-09-01 21:16:28','admin',1),(34,'system_config','max_login_num','Integer','登录人数上限',9,1,NULL,NULL,'2018-09-01 21:18:45','admin',1),(35,'outgoing_level','level_code','Integer','级别代码',1,1,1,10,'2018-09-11 22:44:37','admin',1),(36,'outgoing_level','level_description','String','级别描述',60,1,0,20,'2018-09-11 22:45:06','admin',1),(37,'strategy_type','code','String','代码',20,1,1,10,'2018-09-12 23:10:12','admin',1),(38,'strategy_type','description','String','类型描述',80,0,0,20,'2018-09-12 23:10:46','admin',1),(39,'watermark_layout','code','String','代码',18,1,1,10,'2018-09-20 22:13:21','admin',1),(40,'watermark_layout','name','String','版式名称',200,0,1,20,'2018-09-20 22:11:23','admin',1),(41,'watermark_condition','code','String','代码',18,1,1,10,'2018-09-20 22:13:33','admin',1),(42,'watermark_condition','name','String','名称',100,1,1,20,'2018-09-20 22:12:19','admin',1),(43,'watermark_layout','order','Integer','排序号',5,0,0,30,'2018-09-20 22:14:38','admin',1),(44,'watermark_condition','order','Integer','排序',5,1,0,30,'2018-09-20 22:15:11','admin',1),(45,'approve_status','status_code','String','状态代码',10,1,1,10,'2018-12-29 22:27:10','admin',1),(46,'approve_status','status_name','String','状态名称',50,1,0,20,'2018-12-29 22:26:09','admin',1);
/*!40000 ALTER TABLE `sys_param_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_param_value`
--

DROP TABLE IF EXISTS `sys_param_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_param_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `param_name` varchar(20) NOT NULL COMMENT '参数名',
  `value_1` varchar(200) DEFAULT NULL COMMENT 'value1',
  `value_2` varchar(200) DEFAULT NULL COMMENT 'value2',
  `value_3` varchar(200) DEFAULT NULL COMMENT 'value3',
  `value_4` varchar(200) DEFAULT NULL COMMENT 'value4',
  `value_5` varchar(200) DEFAULT NULL COMMENT 'value5',
  `value_6` varchar(200) DEFAULT NULL COMMENT 'value6',
  `value_7` varchar(200) DEFAULT NULL COMMENT 'value7',
  `value_8` varchar(200) DEFAULT NULL COMMENT 'value8',
  `value_9` varchar(200) DEFAULT NULL COMMENT 'value9',
  `value_10` varchar(200) DEFAULT NULL COMMENT 'value10',
  `value_11` varchar(200) DEFAULT NULL COMMENT 'value11',
  `value_12` varchar(200) DEFAULT NULL COMMENT 'value12',
  `value_13` varchar(200) DEFAULT NULL COMMENT 'value13',
  `value_14` varchar(200) DEFAULT NULL COMMENT 'value14',
  `value_15` varchar(200) DEFAULT NULL COMMENT 'value15',
  `value_16` varchar(200) DEFAULT NULL COMMENT 'value16',
  `value_17` varchar(200) DEFAULT NULL COMMENT 'value17',
  `value_18` varchar(200) DEFAULT NULL COMMENT 'value18',
  `value_19` varchar(200) DEFAULT NULL COMMENT 'value19',
  `value_20` varchar(200) DEFAULT NULL COMMENT 'value20',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(20) DEFAULT NULL COMMENT '创建人',
  `rec_status` int(1) DEFAULT NULL COMMENT '记录状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COMMENT='参数值';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_param_value`
--

LOCK TABLES `sys_param_value` WRITE;
/*!40000 ALTER TABLE `sys_param_value` DISABLE KEYS */;
INSERT INTO `sys_param_value` VALUES (9,'','1','2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-12 16:10:37','admin',1),(10,'menu_module','System Manage','10',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-13 23:45:23','admin',1),(11,'record_status','1',' 有效',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-17 22:14:55','admin',1),(13,'param_data_type','String','字符',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-14 23:57:27','admin',1),(14,'param_data_type','Integer','数值（整型）',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-12 17:34:33','admin',1),(15,'alternative','1','是',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-13 00:04:47','admin',1),(16,'alternative','0','否',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-09-02 00:33:15','admin',1),(17,'menu_module','Others','90',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-13 23:45:34','admin',1),(18,'menu_module','系统设置','20',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-14 22:38:15','admin',1),(19,'menu_module','审计监控','60',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-14 23:20:33','admin',1),(20,'menu_module','安全策略','40',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-14 22:38:57','admin',1),(21,'record_status','0','无效',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-17 22:15:05','admin',1),(22,'gender','male','男','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-17 23:04:15','admin',1),(23,'gender','female','女','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-18 18:19:54','admin',1),(24,'terminal_status','1','正常',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-22 22:32:19','admin',1),(25,'terminal_status','2','离线',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-22 22:32:46','admin',1),(26,'application_type','1','文档转化类','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-23 23:51:28','admin',1),(27,'application_type','2','图片查看类','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-23 23:51:43','admin',1),(28,'application_type','3','桌面资源类','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-23 23:51:55','admin',1),(29,'application_type','4','文字处理类','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-23 23:52:08','admin',1),(30,'application_type','5','工程设计类','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-23 23:52:23','admin',1),(31,'application_type','6','电子设计类','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-23 23:52:38','admin',1),(32,'log_type','login','登录日志','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-26 22:08:35','admin',1),(33,'log_type','logout','登出日志','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-26 22:09:00','admin',1),(34,'system_log_type','login','系统登录',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-28 22:58:09','admin',1),(35,'system_log_type','logout','系统登出',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-28 22:58:34','admin',1),(36,'system_log_type','menu_click','菜单点击',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-08-28 22:58:49','admin',1),(37,'system_config','/d/temp','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-09-02 00:41:58','admin',1),(38,'outgoing_level','1','本地制作外发，不上传任何记录',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-09-11 22:46:29','admin',1),(39,'outgoing_level','2','本地制作外发，上传记录',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-09-11 22:46:40','admin',1),(40,'outgoing_level','3','本地制作外发，上传记录和文件',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-09-11 22:47:33','admin',1),(41,'outgoing_level','4','上传申请记录，后台制作外发',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-09-11 22:48:14','admin',1),(42,'strategy_type','outgoing','外发策略',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-09-12 23:11:03','admin',1),(43,'strategy_type','encrypt','加密策略',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-09-12 23:11:23','admin',1),(44,'watermark_layout','oblique','斜式','10',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-09-20 22:15:29','admin',1),(45,'watermark_layout','horizontal','水平','20',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-09-20 22:15:59','admin',1),(46,'watermark_layout','vertical','垂直','30',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-09-20 22:16:20','admin',1),(47,'watermark_condition','always','始终显示','10',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-09-20 22:16:55','admin',1),(48,'watermark_condition','whenopen','打开软件时','20',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-09-20 22:17:25','admin',1),(49,'approve_status','draft','草稿',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-12-29 22:27:24','admin',1),(50,'approve_status','pending','待审批',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-12-29 22:27:53','admin',1),(51,'approve_status','approved','已审批',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-12-29 22:28:06','admin',1),(52,'approve_status','rejected','驳回',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-01-02 23:11:45','admin',1),(53,'menu_module','文件外发','50',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-01-06 22:52:20','admin',1),(54,'system_log_type','approved','审批通过',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-04-10 23:12:03','admin',1),(55,'system_log_type','rejected','驳回审批',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-04-10 23:12:07','admin',1);
/*!40000 ALTER TABLE `sys_param_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_profile`
--

DROP TABLE IF EXISTS `sys_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `login` varchar(20) NOT NULL COMMENT '登录名',
  `page_size` int(11) DEFAULT '15' COMMENT '分页页面记录数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(20) DEFAULT NULL COMMENT '创建人',
  `rec_status` int(1) DEFAULT NULL COMMENT '记录状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='系统用户配置';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_profile`
--

LOCK TABLES `sys_profile` WRITE;
/*!40000 ALTER TABLE `sys_profile` DISABLE KEYS */;
INSERT INTO `sys_profile` VALUES (1,'admin',13,'2018-09-04 20:36:56','admin',1);
/*!40000 ALTER TABLE `sys_profile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-09 21:27:09
