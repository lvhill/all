CREATE DATABASE  IF NOT EXISTS `meile_system` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `meile_system`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: meile_system
-- ------------------------------------------------------
-- Server version	5.6.16

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
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `config_key` varchar(250) NOT NULL,
  `config_value` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`config_key`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='系统配置';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES ('theme','default');
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_member`
--

DROP TABLE IF EXISTS `system_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_member` (
  `id` int(11) NOT NULL COMMENT '主键',
  `name` varchar(250) DEFAULT NULL COMMENT '用户名',
  `password` varchar(250) DEFAULT NULL COMMENT '密码',
  `level` int(11) DEFAULT NULL COMMENT '权限等级'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='系统用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_member`
--

LOCK TABLES `system_member` WRITE;
/*!40000 ALTER TABLE `system_member` DISABLE KEYS */;
INSERT INTO `system_member` VALUES (1,'admin','admin123',1);
/*!40000 ALTER TABLE `system_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_menu`
--

DROP TABLE IF EXISTS `system_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_menu` (
  `parent_menuid` int(11) DEFAULT NULL COMMENT '上一菜单id',
  `menuid` int(11) NOT NULL COMMENT '菜单id',
  `name` varchar(225) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(300) DEFAULT NULL COMMENT '地址',
  `annotation` varchar(225) DEFAULT NULL COMMENT '注释',
  `status` int(11) DEFAULT NULL COMMENT '状态:是否开启',
  `order` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menuid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='后台菜单节点';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_menu`
--

LOCK TABLES `system_menu` WRITE;
/*!40000 ALTER TABLE `system_menu` DISABLE KEYS */;
INSERT INTO `system_menu` VALUES (0,3,'系统设置','menuFrame',NULL,1,0),(3,4,'基本设置','config.html',NULL,1,0),(3,5,'地域管理','cache.html',NULL,1,1),(3,6,'支付接口设置','cache.html',NULL,1,2),(3,7,'提醒设置','cache.html',NULL,1,3),(3,8,'邮件模版','cache.html',NULL,1,4),(3,9,'数据库备份','cache.html',NULL,1,5),(3,10,'数据库恢复','cache.html',NULL,1,6),(3,11,'计划任务','cache.html',NULL,1,7),(0,12,'商店管理','menuFrame',NULL,1,1),(12,13,'商铺列表','cache.html',NULL,1,0),(12,14,'未审核商铺','cache.html',NULL,1,1),(12,15,'商铺分类','cache.html',NULL,1,2),(12,16,'商铺信用等级','cache.html',NULL,1,3),(0,17,'用户管理','menuFrame',NULL,1,2),(17,18,'会员列表','cache.html',NULL,1,0),(17,19,'会员级别设置','cache.html',NULL,1,1),(17,20,'管理员列表','cache.html',NULL,1,2),(17,21,'管理员组管理','cache.html',NULL,1,3),(17,22,'修改管理员密码','cache.html',NULL,1,4),(0,23,'商品管理','menuFrame',NULL,1,3),(23,24,'商品列表','cache.html',NULL,1,0),(23,25,'品牌列表','cache.html',NULL,1,1),(23,26,'商品分类列表','cache.html',NULL,1,2),(23,27,'商品属性管理','cache.html',NULL,1,3),(23,28,'团购列表','cache.html',NULL,1,4),(23,29,'搜索关键字管理','cache.html',NULL,1,5),(23,30,'标签集管理','cache.html',NULL,1,6),(0,31,'交易管理','menuFrame',NULL,1,4),(31,32,'所有订单列表','cache.html',NULL,1,0),(31,33,'已付款订单列表','cache.html',NULL,1,1),(31,34,'投诉列表','cache.html',NULL,1,2),(31,35,'投诉标题管理','cache.html',NULL,1,3),(0,36,'网站管理','menuFrame',NULL,1,5),(36,37,'广告位列表','cache.html',NULL,1,0),(36,38,'广告列表','cache.html',NULL,1,1),(36,39,'自定义导航栏','cache.html',NULL,1,2),(36,40,'首页轮显图片','cache.html',NULL,1,3),(36,41,'友情链接列表','cache.html',NULL,1,4),(36,42,'网站地图','cache.html',NULL,1,5),(0,43,'扩展管理','menuFrame',NULL,1,6),(43,44,'模板管理','cache.html',NULL,1,0),(43,45,'插件管理','cache.html',NULL,1,1),(43,46,'工具列表','cache.html',NULL,1,2),(43,47,'工具管理','cache.html',NULL,1,3);
/*!40000 ALTER TABLE `system_menu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-02 13:29:28
