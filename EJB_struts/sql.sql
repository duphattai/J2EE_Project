CREATE DATABASE `quanlyxekhach`;
USE quanlyxekhach;


--
-- Table structure for table `tblbaocaodoanhthuchuyendi`
--

DROP TABLE IF EXISTS `tblbaocaodoanhthuchuyendi`;

CREATE TABLE `tblbaocaodoanhthuchuyendi` (
  `machuyendi` int(11) NOT NULL,
  `thoigian` datetime DEFAULT NULL,
  `sove` int(11) DEFAULT NULL,
  `doanhthu` int(11) DEFAULT NULL,
  `tile` float DEFAULT NULL,
  PRIMARY KEY (`machuyendi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblbaocaodoanhthuchuyendi`
--

LOCK TABLES `tblbaocaodoanhthuchuyendi` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `tblbaocaodoanhthunam`
--

DROP TABLE IF EXISTS `tblbaocaodoanhthunam`;

CREATE TABLE `tblbaocaodoanhthunam` (
  `nam` int(11) NOT NULL,
  `doanhthu` int(11) DEFAULT NULL,
  PRIMARY KEY (`nam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `tblbaocaodoanhthunam`
--

LOCK TABLES `tblbaocaodoanhthunam` WRITE;

UNLOCK TABLES;

--
-- Table structure for table `tblbaocaodoanhthuthang`
--

DROP TABLE IF EXISTS `tblbaocaodoanhthuthang`;

CREATE TABLE `tblbaocaodoanhthuthang` (
  `thang` int(11) NOT NULL,
  `nam` int(11) NOT NULL,
  `sochuyendi` int(11) DEFAULT NULL,
  `doanhthu` int(11) DEFAULT NULL,
  `tile` float DEFAULT NULL,
  PRIMARY KEY (`thang`,`nam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `tblbaocaodoanhthuthang`
--

LOCK TABLES `tblbaocaodoanhthuthang` WRITE;

UNLOCK TABLES;

--
-- Table structure for table `tblbenxe`
--

DROP TABLE IF EXISTS `tblbenxe`;

CREATE TABLE `tblbenxe` (
  `mabenxe` int(11) NOT NULL AUTO_INCREMENT,
  `tenbenxe` varchar(45) NOT NULL,
  PRIMARY KEY (`mabenxe`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;


--
-- Dumping data for table `tblbenxe`
--

LOCK TABLES `tblbenxe` WRITE;
INSERT INTO `tblbenxe` VALUES (1,'Bến xe Miền Đông'),
								(2,'Bến xe Miền Tây'),
								(3,'Bến xe Chợ Lớn'),
								(4,'Sóc Trăng'),
								(5,'Cần Thơ'),
								(6,'Cà Mau'),
								(7,'Nha Trang'),
								(8,'Long An'),
								(9,'An Giang'),
								(10,'Vũng Tàu'),
								(11,'Huế');
UNLOCK TABLES;

--
-- Table structure for table `tblchitietphieudatcho`
--

DROP TABLE IF EXISTS `tblchitietphieudatcho`;
CREATE TABLE `tblchitietphieudatcho` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `maphieu` int(11) NOT NULL,
  `machuyendi` int(11) NOT NULL,
  `layve` bit(1) NOT NULL,
  `vitrighe` varchar(45) NOT NULL,
  `ngaylay` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblchitietphieudatcho`
--

LOCK TABLES `tblchitietphieudatcho` WRITE;
INSERT INTO `tblchitietphieudatcho` VALUES (1,1,1,'1','1A','2016-06-08 13:52:27'),(2,1,1,'1','2A','2016-06-08 13:53:36'),(3,1,1,'1','3A','2016-06-08 13:53:36'),(4,2,1,'\0','1B','2016-06-08 13:53:36'),(5,2,1,'\0','2B','2016-06-08 13:53:36'),(6,3,0,'1','4A','2016-06-11 13:52:52'),(7,3,0,'1','5A','2016-06-11 13:52:55'),(8,3,0,'1','6A','2016-06-11 13:52:57');
UNLOCK TABLES;

--
-- Table structure for table `tblchitiettuyen`
--

DROP TABLE IF EXISTS `tblchitiettuyen`;
CREATE TABLE `tblchitiettuyen` (
  `matuyen` int(11) NOT NULL AUTO_INCREMENT,
  `mabenxetrunggian` int(11) NOT NULL,
  `thoigiandung` int(11) NOT NULL,
  `ghichu` text,
  PRIMARY KEY (`matuyen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblchitiettuyen`
--

LOCK TABLES `tblchitiettuyen` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `tblchuyendi`
--

DROP TABLE IF EXISTS `tblchuyendi`;
CREATE TABLE `tblchuyendi` (
  `machuyendi` int(11) NOT NULL AUTO_INCREMENT,
  `maxe` int(11) NOT NULL,
  `khoihanh` datetime DEFAULT NULL,
  `ketthuc` datetime DEFAULT NULL,
  `soghetrong` int(11) NOT NULL,
  `soghedat` int(11) NOT NULL,
  PRIMARY KEY (`machuyendi`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblchuyendi`
--

LOCK TABLES `tblchuyendi` WRITE;
INSERT INTO `tblchuyendi` VALUES (1,1,'1970-01-01 11:00:00','1970-01-01 16:00:00',46,0),(2,2,'2016-06-07 07:00:57','2016-06-07 12:00:57',26,20),(3,3,'2016-06-07 12:00:57','2016-06-07 16:50:57',16,30),(4,1,'1970-01-01 12:00:00','1970-01-01 17:00:00',0,0),(5,1,'1970-01-01 05:00:00','1970-01-01 10:00:00',0,0),(6,4,'1970-01-01 03:00:00','1970-01-01 11:20:00',0,0),(7,4,'1970-01-01 12:00:00','1970-01-01 20:20:00',0,0);
UNLOCK TABLES;

--
-- Table structure for table `tblloaixe`
--

DROP TABLE IF EXISTS `tblloaixe`;
CREATE TABLE `tblloaixe` (
  `maloaixe` int(11) NOT NULL AUTO_INCREMENT,
  `loaixe` varchar(100) NOT NULL,
  PRIMARY KEY (`maloaixe`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblloaixe`
--

LOCK TABLES `tblloaixe` WRITE;
INSERT INTO `tblloaixe` VALUES (1,'Giường nằm'),(2,'Ghế ngồi');
UNLOCK TABLES;

--
-- Table structure for table `tblphanquyen`
--

DROP TABLE IF EXISTS `tblphanquyen`;
CREATE TABLE `tblphanquyen` (
  `id` int(11) NOT NULL,
  `Quyen` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblphanquyen`
--

LOCK TABLES `tblphanquyen` WRITE;
INSERT INTO `tblphanquyen` VALUES (1,'Admin'),(2,'Nhân viên');
UNLOCK TABLES;

--
-- Table structure for table `tblphieudatcho`
--

DROP TABLE IF EXISTS `tblphieudatcho`;
CREATE TABLE `tblphieudatcho` (
  `maphieu` int(11) NOT NULL AUTO_INCREMENT,
  `hoten` varchar(100) NOT NULL,
  `dienthoai` varchar(45) NOT NULL,
  `ngaydat` datetime DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`maphieu`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblphieudatcho`
--

LOCK TABLES `tblphieudatcho` WRITE;
INSERT INTO `tblphieudatcho` VALUES (1,'Nguyễn Văn A','123456789','2016-06-11 15:27:24','test@gmail.com'),(2,'Nguyễn Văn A','987654321','2016-06-11 15:27:46','test1@gmail.com');
UNLOCK TABLES;

--
-- Table structure for table `tbltaikhoan`
--

DROP TABLE IF EXISTS `tbltaikhoan`;
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

--
-- Dumping data for table `tbltaikhoan`
--

LOCK TABLES `tbltaikhoan` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `tblthamso`
--

DROP TABLE IF EXISTS `tblthamso`;
CREATE TABLE `tblthamso` (
  `id` int(11) NOT NULL,
  `tenthamso` varchar(45) NOT NULL,
  `giatri` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblthamso`
--

LOCK TABLES `tblthamso` WRITE;
INSERT INTO `tblthamso` VALUES (1,'Thời gian bay tối thiểu',30),(2,'Bến xe trung gian tối đa',2),(3,'Thời gian dừng tối thiểu',10),(4,'Thời gian dừng tối đa',20);
UNLOCK TABLES;

--
-- Table structure for table `tbltuyenxe`
--

DROP TABLE IF EXISTS `tbltuyenxe`;
CREATE TABLE `tbltuyenxe` (
  `matuyen` int(11) NOT NULL AUTO_INCREMENT,
  `mabendi` int(11) NOT NULL,
  `mabenden` int(11) NOT NULL,
  `thoigian` int(11) NOT NULL,
  `dongia` int(11) NOT NULL,
  PRIMARY KEY (`matuyen`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbltuyenxe`
--

LOCK TABLES `tbltuyenxe` WRITE;
INSERT INTO `tbltuyenxe` VALUES (1,2,4,300,140000),(2,4,2,300,140000),(3,1,7,400,170000),(4,7,1,400,170000),(5,3,11,500,220000);
UNLOCK TABLES;

--
-- Table structure for table `tblxekhach`
--

DROP TABLE IF EXISTS `tblxekhach`;
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

--
-- Dumping data for table `tblxekhach`
--

LOCK TABLES `tblxekhach` WRITE;
INSERT INTO `tblxekhach` VALUES (1,1,'Nguyễn Văn A','51B-006.64',1,46),(2,1,'Nguyễn Văn B','83B-085.85',3,46),(3,1,'Nguyễn Văn C','53B-085.85',2,46),(4,1,'Nguyễn Văn D','73B-083.83',5,46);
UNLOCK TABLES;


-- Dump completed on 2016-06-12 22:49:21
