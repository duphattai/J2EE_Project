CREATE DATABASE `quanlyxekhach`;
USE quanlyxekhach;

CREATE TABLE `tblbaocaodoanhthuchuyendi` (
  `machuyendi` int(11) NOT NULL,
  `thoigian` datetime DEFAULT NULL,
  `sove` int(11) DEFAULT NULL,
  `doanhthu` int(11) DEFAULT NULL,
  `tile` float DEFAULT NULL,
  PRIMARY KEY (`machuyendi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tblbaocaodoanhthunam` (
  `nam` int(11) NOT NULL,
  `doanhthu` int(11) DEFAULT NULL,
  PRIMARY KEY (`nam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tblbaocaodoanhthuthang` (
  `thang` int(11) NOT NULL,
  `nam` int(11) NOT NULL,
  `sochuyendi` int(11) DEFAULT NULL,
  `doanhthu` int(11) DEFAULT NULL,
  `tile` float DEFAULT NULL,
  PRIMARY KEY (`thang`,`nam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tblbenxe` (
  `mabenxe` int(11) NOT NULL,
  `tenbenxe` varchar(45) NOT NULL,
  PRIMARY KEY (`mabenxe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tblchitietphieudatcho` (
  `id` int(11) NOT NULL,
  `maphieu` int(11) NOT NULL,
  `machuyendi` int(11) NOT NULL,
  `layve` bit(1) NOT NULL,
  `vitrighe` varchar(45) NOT NULL,
  `ngaylay` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tblchitiettuyen` (
  `matuyen` int(11) NOT NULL,
  `mabenxetrunggian` int(11) NOT NULL,
  `thoigiandung` int(11) NOT NULL,
  `ghichu` text,
  PRIMARY KEY (`matuyen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tblchuyendi` (
  `machuyendi` int(11) NOT NULL,
  `maxe` int(11) NOT NULL,
  `khoihanh` datetime DEFAULT NULL,
  `ketthuc` datetime DEFAULT NULL,
  `dongia` int(11) NOT NULL,
  `soghetrong` int(11) NOT NULL,
  `soghedat` int(11) NOT NULL,
  PRIMARY KEY (`machuyendi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tblloaixe` (
  `maloaixe` int(11) NOT NULL,
  `loaixe` varchar(100) NOT NULL,
  PRIMARY KEY (`maloaixe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tblphanquyen` (
  `id` int(11) NOT NULL,
  `Quyen` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tblphieudatcho` (
  `maphieu` int(11) NOT NULL,
  `hoten` varchar(100) NOT NULL,
  `dienthoai` varchar(45) NOT NULL,
  `ngaydat` datetime DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`maphieu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

CREATE TABLE `tblthamso` (
  `id` int(11) NOT NULL,
  `tenthamso` varchar(45) NOT NULL,
  `giatri` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbltuyenxe` (
  `matuyen` int(11) NOT NULL,
  `mabendi` int(11) NOT NULL,
  `mabenden` int(11) NOT NULL,
  `thoigian` int(11) NOT NULL,
  PRIMARY KEY (`matuyen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tblxekhach` (
  `maxe` int(11) NOT NULL,
  `maloaixe` int(11) NOT NULL,
  `taixe` varchar(100) NOT NULL,
  `biensoxe` varchar(20) NOT NULL,
  `matuyen` int(11) DEFAULT NULL,
  `soghe` int(11) NOT NULL,
  PRIMARY KEY (`maxe`),
  UNIQUE KEY `biensoxe_UNIQUE` (`biensoxe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `quanlyxekhach`.`tblthamso`(`id`,`tenthamso`,`giatri`)VALUES
																		(1,"Thời gian bay tối thiểu",30),
                                                                        (2,"Bến xe trung gian tối đa",2),
                                                                        (3,"Thời gian dừng tối thiểu",10),
                                                                        (4,"Thời gian dừng tối đa",20);

INSERT INTO `quanlyxekhach`.`tblphanquyen`(`id`,`Quyen`)VALUES
																(1,"Admin"),
                                                                (2,"Nhân viên"),
                                                                (3,"Quản lý");

INSERT INTO `tblbenxe` VALUES 
								(1,'Bến xe Miền Đông'),
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

INSERT INTO `tbltuyenxe` VALUES 
								(1,2,4,300),
								(2,4,2,300),
								(3,1,7,400),
								(4,7,1,400),
								(5,3,11,500);

INSERT INTO `tblxekhach` VALUES 
								(1,1,'Nguyễn Văn A','51B-006.64',1,46),
								(2,1,'Nguyễn Văn B','83B-085.85',3,46),
								(3,1,'Nguyễn Văn C','53B-085.85',2,46),
								(4,1,'Nguyễn Văn D','73B-083.83',5,46);
								
								
INSERT INTO `tblchuyendi` VALUES 
								(1,1,'2016-06-06 18:00:00','2016-06-06 22:50:57',130000,46,0),
								(2,2,'2016-06-07 07:00:57','2016-06-07 12:00:57',120000,26,20),
								(3,3,'2016-06-07 12:00:57','2016-06-07 16:50:57',150000,16,30);