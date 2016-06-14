CREATE DATABASE `quanlyxekhach`;
USE quanlyxekhach;

-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlyxekhach
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `tblbaocaodoanhthuchuyendi`
--

DROP TABLE IF EXISTS `tblbaocaodoanhthuchuyendi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblbaocaodoanhthuchuyendi` (
  `machuyendi` int(11) NOT NULL,
  `thoigian` datetime DEFAULT NULL,
  `sove` int(11) DEFAULT NULL,
  `doanhthu` int(11) DEFAULT NULL,
  `tile` float DEFAULT NULL,
  PRIMARY KEY (`machuyendi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblbaocaodoanhthuchuyendi`
--

LOCK TABLES `tblbaocaodoanhthuchuyendi` WRITE;
/*!40000 ALTER TABLE `tblbaocaodoanhthuchuyendi` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblbaocaodoanhthuchuyendi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblbaocaodoanhthunam`
--

DROP TABLE IF EXISTS `tblbaocaodoanhthunam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblbaocaodoanhthunam` (
  `nam` int(11) NOT NULL,
  `doanhthu` int(11) DEFAULT NULL,
  PRIMARY KEY (`nam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblbaocaodoanhthunam`
--

LOCK TABLES `tblbaocaodoanhthunam` WRITE;
/*!40000 ALTER TABLE `tblbaocaodoanhthunam` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblbaocaodoanhthunam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblbaocaodoanhthuthang`
--

DROP TABLE IF EXISTS `tblbaocaodoanhthuthang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblbaocaodoanhthuthang` (
  `thang` int(11) NOT NULL,
  `nam` int(11) NOT NULL,
  `sochuyendi` int(11) DEFAULT NULL,
  `doanhthu` int(11) DEFAULT NULL,
  `tile` float DEFAULT NULL,
  PRIMARY KEY (`thang`,`nam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblbaocaodoanhthuthang`
--

LOCK TABLES `tblbaocaodoanhthuthang` WRITE;
/*!40000 ALTER TABLE `tblbaocaodoanhthuthang` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblbaocaodoanhthuthang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblbenxe`
--

DROP TABLE IF EXISTS `tblbenxe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblbenxe` (
  `mabenxe` int(11) NOT NULL AUTO_INCREMENT,
  `tenbenxe` varchar(45) NOT NULL,
  PRIMARY KEY (`mabenxe`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblbenxe`
--

LOCK TABLES `tblbenxe` WRITE;
/*!40000 ALTER TABLE `tblbenxe` DISABLE KEYS */;
INSERT INTO `tblbenxe` VALUES (1,'Bến xe Miền Đông'),(2,'Bến xe Miền Tây'),(3,'Bến xe Chợ Lớn'),(4,'Sóc Trăng'),(5,'Cần Thơ'),(6,'Cà Mau'),(7,'Nha Trang'),(8,'Long An'),(9,'An Giang'),(10,'Vũng Tàu'),(11,'Huế');
/*!40000 ALTER TABLE `tblbenxe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblchitietphieudatcho`
--

DROP TABLE IF EXISTS `tblchitietphieudatcho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblchitietphieudatcho` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `maphieu` int(11) NOT NULL,
  `machuyendi` int(11) NOT NULL,
  `layve` bit(1) NOT NULL,
  `vitrighe` varchar(45) NOT NULL,
  `ngaylay` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblchitietphieudatcho`
--

LOCK TABLES `tblchitietphieudatcho` WRITE;
/*!40000 ALTER TABLE `tblchitietphieudatcho` DISABLE KEYS */;
INSERT INTO `tblchitietphieudatcho` VALUES (4,2,2,'','1A','2016-06-14 19:31:12'),(5,2,2,'','2A','2016-06-14 19:31:12'),(6,2,2,'','5A','2016-06-14 19:31:12'),(7,2,2,'','4A','2016-06-14 19:31:12'),(8,2,2,'','20A','2016-06-14 19:31:12'),(9,2,2,'','8A','2016-06-14 19:31:12');
/*!40000 ALTER TABLE `tblchitietphieudatcho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblchitiettuyen`
--

DROP TABLE IF EXISTS `tblchitiettuyen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblchitiettuyen` (
  `matuyen` int(11) NOT NULL AUTO_INCREMENT,
  `mabenxetrunggian` int(11) NOT NULL,
  `thoigiandung` int(11) NOT NULL,
  `ghichu` text,
  PRIMARY KEY (`matuyen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblchitiettuyen`
--

LOCK TABLES `tblchitiettuyen` WRITE;
/*!40000 ALTER TABLE `tblchitiettuyen` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblchitiettuyen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblchuyendi`
--

DROP TABLE IF EXISTS `tblchuyendi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblchuyendi` (
  `machuyendi` int(11) NOT NULL AUTO_INCREMENT,
  `maxe` int(11) NOT NULL,
  `khoihanh` datetime DEFAULT NULL,
  `ketthuc` datetime DEFAULT NULL,
  `soghetrong` int(11) NOT NULL,
  `soghedat` int(11) NOT NULL,
  PRIMARY KEY (`machuyendi`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblchuyendi`
--

LOCK TABLES `tblchuyendi` WRITE;
/*!40000 ALTER TABLE `tblchuyendi` DISABLE KEYS */;
INSERT INTO `tblchuyendi` VALUES (1,1,'2016-06-15 19:10:27','2016-06-16 00:10:27',0,0),(2,1,'2016-06-12 23:00:23','2016-06-13 04:00:23',0,0),(3,1,'2016-05-31 12:00:37','2016-05-31 17:00:37',0,0),(4,1,'2016-06-01 19:00:52','2016-06-02 00:00:52',0,0),(5,1,'2016-06-01 20:00:08','2016-06-02 01:00:08',0,0);
/*!40000 ALTER TABLE `tblchuyendi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblloaixe`
--

DROP TABLE IF EXISTS `tblloaixe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblloaixe` (
  `maloaixe` int(11) NOT NULL AUTO_INCREMENT,
  `loaixe` varchar(100) NOT NULL,
  PRIMARY KEY (`maloaixe`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblloaixe`
--

LOCK TABLES `tblloaixe` WRITE;
/*!40000 ALTER TABLE `tblloaixe` DISABLE KEYS */;
INSERT INTO `tblloaixe` VALUES (1,'Giường nằm'),(2,'Ghế ngồi');
/*!40000 ALTER TABLE `tblloaixe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblphanquyen`
--

DROP TABLE IF EXISTS `tblphanquyen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblphanquyen` (
  `id` int(11) NOT NULL,
  `Quyen` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblphanquyen`
--

LOCK TABLES `tblphanquyen` WRITE;
/*!40000 ALTER TABLE `tblphanquyen` DISABLE KEYS */;
INSERT INTO `tblphanquyen` VALUES (1,'Admin'),(2,'Nhân viên');
/*!40000 ALTER TABLE `tblphanquyen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblphieudatcho`
--

DROP TABLE IF EXISTS `tblphieudatcho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblphieudatcho` (
  `maphieu` int(11) NOT NULL AUTO_INCREMENT,
  `hoten` varchar(100) NOT NULL,
  `dienthoai` varchar(45) NOT NULL,
  `ngaydat` datetime DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `ngaydi` datetime NOT NULL,
  PRIMARY KEY (`maphieu`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblphieudatcho`
--

LOCK TABLES `tblphieudatcho` WRITE;
/*!40000 ALTER TABLE `tblphieudatcho` DISABLE KEYS */;
INSERT INTO `tblphieudatcho` VALUES (2,'Nguyễn Văn A','123456789','2016-06-14 19:31:12','','2016-06-12 23:00:00');
/*!40000 ALTER TABLE `tblphieudatcho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbltaikhoan`
--

DROP TABLE IF EXISTS `tbltaikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbltaikhoan` (
  `tentaikhoan` varchar(20) NOT NULL,
  `maquyen` int(11) NOT NULL,
  `matkhau` varchar(20) NOT NULL,
  `hoten` varchar(50) NOT NULL,
  `cmnd` varchar(45) NOT NULL,
  `diachi` varchar(100) DEFAULT NULL,
  `ngaysinh` datetime DEFAULT NULL,
  PRIMARY KEY (`tentaikhoan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbltaikhoan`
--

LOCK TABLES `tbltaikhoan` WRITE;
/*!40000 ALTER TABLE `tbltaikhoan` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbltaikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblthamso`
--

DROP TABLE IF EXISTS `tblthamso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblthamso` (
  `id` int(11) NOT NULL,
  `tenthamso` varchar(45) NOT NULL,
  `giatri` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblthamso`
--

LOCK TABLES `tblthamso` WRITE;
/*!40000 ALTER TABLE `tblthamso` DISABLE KEYS */;
INSERT INTO `tblthamso` VALUES (1,'Thời gian bay tối thiểu',30),(2,'Bến xe trung gian tối đa',2),(3,'Thời gian dừng tối thiểu',10),(4,'Thời gian dừng tối đa',20);
/*!40000 ALTER TABLE `tblthamso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbltuyenxe`
--

DROP TABLE IF EXISTS `tbltuyenxe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbltuyenxe` (
  `matuyen` int(11) NOT NULL AUTO_INCREMENT,
  `mabendi` int(11) NOT NULL,
  `mabenden` int(11) NOT NULL,
  `thoigian` int(11) NOT NULL,
  `dongia` int(11) NOT NULL,
  PRIMARY KEY (`matuyen`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbltuyenxe`
--

LOCK TABLES `tbltuyenxe` WRITE;
/*!40000 ALTER TABLE `tbltuyenxe` DISABLE KEYS */;
INSERT INTO `tbltuyenxe` VALUES (1,2,4,300,140000),(2,4,2,300,140000),(3,1,7,400,170000),(4,7,1,400,170000),(5,3,11,500,220000);
/*!40000 ALTER TABLE `tbltuyenxe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblxekhach`
--

DROP TABLE IF EXISTS `tblxekhach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblxekhach` (
  `maxe` int(11) NOT NULL AUTO_INCREMENT,
  `maloaixe` int(11) NOT NULL,
  `taixe` varchar(100) NOT NULL,
  `biensoxe` varchar(20) NOT NULL,
  `matuyen` int(11) DEFAULT NULL,
  `soghe` int(11) NOT NULL,
  PRIMARY KEY (`maxe`),
  UNIQUE KEY `biensoxe_UNIQUE` (`biensoxe`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblxekhach`
--

LOCK TABLES `tblxekhach` WRITE;
/*!40000 ALTER TABLE `tblxekhach` DISABLE KEYS */;
INSERT INTO `tblxekhach` VALUES (1,1,'Nguyễn Văn A','51B-006.64',1,46),(2,1,'Nguyễn Văn B','83B-085.85',3,46),(3,1,'Nguyễn Văn C','53B-085.85',2,46),(4,1,'Nguyễn Văn D','73B-083.83',5,46);
/*!40000 ALTER TABLE `tblxekhach` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-14 20:06:38
