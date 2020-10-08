CREATE DATABASE  IF NOT EXISTS `mstuddb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mstuddb`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: mstuddb
-- ------------------------------------------------------
-- Server version	5.6.10

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
-- Table structure for table `chart`
--

DROP TABLE IF EXISTS `chart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chart` (
  `id` int(11) NOT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chart`
--

LOCK TABLES `chart` WRITE;
/*!40000 ALTER TABLE `chart` DISABLE KEYS */;
INSERT INTO `chart` VALUES (1,70),(2,85),(3,100),(4,60),(5,90);
/*!40000 ALTER TABLE `chart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empt`
--

DROP TABLE IF EXISTS `empt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `dob` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `isact` int(11) DEFAULT NULL,
  `rdate` datetime DEFAULT NULL,
  `hash` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empt`
--

LOCK TABLES `empt` WRITE;
/*!40000 ALTER TABLE `empt` DISABLE KEYS */;
INSERT INTO `empt` VALUES (13,'samiksha','sharma','Female','1992-06-09','samiksha12@gmail.com','samik',1,'2020-09-07 14:47:38',NULL),(14,'sonia','singh','Female','2020-09-02','sonia@gmail.com','sonia12',1,'2020-09-07 14:49:22',NULL),(15,'saq','hghg','Male','2020-09-02','samikshasingh883@gmail.com','fgtr',0,'2020-09-17 20:15:39','68332fdb3a0820aa8ef3f49b21e56ecd'),(16,'sawe','qwqe','Male','2020-09-04','samikshasingh883@gmail.com','saqw',1,'2020-09-17 20:23:08','f25d796ddac720cde5e4ebdcc7f9b801'),(17,'sakshi','sukhwani','Female','2020-09-19','samikshasingh883@gmail.com','samik123',1,'2020-09-17 20:48:04','c792e20209ec177a34d3ffc6b13fc521'),(18,'sameer','rajput','Male','2020-09-02','samikshasingh883@gmail.com','1234',1,'2020-09-17 20:52:57','c622d010f70c6168ef5b1edd6bb815e2'),(19,'sohail','sukhwani','Male','2020-09-16','samikshasingh883@gmail.com','sohail123',1,'2020-09-17 21:09:25','7406211c9556777c29d1abcfbec3b1d3'),(20,'sachin','sharma','Male','2020-09-18','samikshasingh883@gmail.com','12345',1,'2020-09-18 14:09:25','8e73177b71223695f379dd822b9ecfab'),(21,'priyanka','Pabalkar','Female','2020-10-05','tqpriyanka@gmail.com','priyanka12',1,'2020-10-06 14:54:02','3c2a0431bda987547d345b41d258b8a5'),(23,'a','b','Male','2020-10-06','a@gmail.com','aa',0,'2020-10-07 16:02:13','db35a3a90080230cf9df56431602a63'),(24,'b','c','Male','2020-10-07','b@gmail.com','123',NULL,'2020-10-07 23:04:58','81de866fa5c8dba0ec40f6b39800cb11'),(25,'b','c','Male','2020-10-07','b@gmail.com','123',NULL,'2020-10-07 23:11:32','1c2770f4dcbb5319b3921a922597a7bc'),(26,'sakshi','sukhwani','Male','2020-10-07','sonia@gmail.com','12',NULL,'2020-10-07 23:12:09','e0e27a622073718923d919b6222d0bf3'),(27,'sakshi','sukhwani','Male','2020-10-07','sonia@gmail.com','12',NULL,'2020-10-07 23:15:25','90cf85314a50ff7d3d57fbb7e9ef47c5'),(28,'e','s','Male','2020-10-07','sonia@gmail.com','12',NULL,'2020-10-07 23:15:48','22a3a2e4164aeb6d76df40fa0038840c'),(29,'sayara','ae','Female','2020-10-07','sayra@gmail.com','sasa',NULL,'2020-10-07 23:25:04','d69d3c263376751f3557d2fd90531d76'),(30,'sakshi','sukhwani','Male','2020-10-07','sonia@gmail.com','1234',NULL,'2020-10-07 23:30:18','f3c7129d9c6a446b7d511364b5987622'),(31,'saurbha','sigh','Male','2020-10-06','saurbha@gmail.com','saur',NULL,'2020-10-07 23:35:47','0c81f89d328d5a74991630f1c7fd4950');
/*!40000 ALTER TABLE `empt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `ProductName` varchar(45) NOT NULL,
  `UnitsInStock` varchar(45) DEFAULT NULL,
  `CategoryID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ProductName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('a','23',1),('b','20',1),('c','50',1),('d','70',1),('e','90',1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `result` (
  `testid` int(11) NOT NULL,
  `marks` int(11) DEFAULT NULL,
  `sid` int(11) NOT NULL,
  `outof` int(11) DEFAULT NULL,
  `testdate` date DEFAULT NULL,
  PRIMARY KEY (`testid`,`sid`),
  KEY `sid_fk_idx` (`sid`),
  CONSTRAINT `sid_fk` FOREIGN KEY (`sid`) REFERENCES `stud` (`sid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` VALUES (1,7,103,10,'2020-06-06'),(1,4,105,10,'2020-06-27'),(1,4,109,10,'2020-06-24'),(2,9,103,10,'2020-06-25'),(2,3,105,10,'2020-06-23'),(2,2,109,10,'2020-06-29'),(3,9,103,10,'2020-06-30'),(3,2,105,10,'2020-07-04'),(3,4,109,10,'2020-07-05');
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stud`
--

DROP TABLE IF EXISTS `stud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stud` (
  `sid` int(11) NOT NULL,
  `sname` varchar(45) DEFAULT NULL,
  `adress` varchar(45) DEFAULT NULL,
  `mobileno` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stud`
--

LOCK TABLES `stud` WRITE;
/*!40000 ALTER TABLE `stud` DISABLE KEYS */;
INSERT INTO `stud` VALUES (103,'sameer','pune','+919750097500','sa@gmail.com','1996-05-09'),(105,'akshay','mumbai','+918668678153','wagholeganesh20@gmail.com','1997-02-12'),(109,'sonia','banglore','+918668678153','wagholeganesh20@gmail.com','1995-03-07');
/*!40000 ALTER TABLE `stud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `tname` varchar(45) DEFAULT NULL,
  `tdesc` varchar(45) DEFAULT NULL,
  `tstatus` varchar(45) DEFAULT NULL,
  `tdate` datetime DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (14,'add field','implenetation','completed',NULL),(18,'check box ','chk box add','new',NULL),(19,'add radio buttoton','implenetation','completed',NULL),(21,'add parameter','testing','completed',NULL),(22,'add html fun','impl','completed',NULL),(23,'add js code','implenetation','new',NULL),(24,'add graph','implementation','new','2020-10-07 22:55:04'),(25,'email notification','new task','new','2020-10-07 22:55:31'),(26,'add cnfirm password','new','new','2020-10-07 22:55:52'),(27,'add css','new','new','2020-10-07 22:56:32');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-08 21:12:40
