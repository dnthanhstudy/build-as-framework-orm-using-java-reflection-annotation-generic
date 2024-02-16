-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.35 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for estatebasic
CREATE DATABASE IF NOT EXISTS `estatebasic` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `estatebasic`;

-- Dumping structure for table estatebasic.assignmentbuilding
CREATE TABLE IF NOT EXISTS `assignmentbuilding` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `staffid` bigint NOT NULL,
  `buildingid` bigint NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_building` (`staffid`),
  KEY `fk_building_user` (`buildingid`),
  CONSTRAINT `fk_building_user` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`),
  CONSTRAINT `fk_user_building` FOREIGN KEY (`staffid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table estatebasic.assignmentbuilding: ~4 rows (approximately)
INSERT INTO `assignmentbuilding` (`id`, `staffid`, `buildingid`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
	(1, 2, 1, NULL, NULL, NULL, NULL),
	(2, 2, 3, NULL, NULL, NULL, NULL),
	(3, 3, 1, NULL, NULL, NULL, NULL),
	(4, 3, 4, NULL, NULL, NULL, NULL);

-- Dumping structure for table estatebasic.assignmentcustomer
CREATE TABLE IF NOT EXISTS `assignmentcustomer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `staffid` bigint NOT NULL,
  `customerid` bigint NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_customer` (`staffid`),
  KEY `fk_customer_user` (`customerid`),
  CONSTRAINT `fk_customer_user` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`),
  CONSTRAINT `fk_user_customer` FOREIGN KEY (`staffid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table estatebasic.assignmentcustomer: ~0 rows (approximately)

-- Dumping structure for table estatebasic.building
CREATE TABLE IF NOT EXISTS `building` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `street` varchar(255) DEFAULT NULL,
  `ward` varchar(255) DEFAULT NULL,
  `districtid` bigint NOT NULL,
  `structure` varchar(255) DEFAULT NULL,
  `numberofbasement` int DEFAULT NULL,
  `floorarea` int DEFAULT NULL,
  `direction` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `rentprice` int NOT NULL,
  `rentpricedescription` text,
  `servicefee` varchar(255) DEFAULT NULL,
  `carfee` varchar(255) DEFAULT NULL,
  `motorbikefee` varchar(255) DEFAULT NULL,
  `overtimefee` varchar(255) DEFAULT NULL,
  `waterfee` varchar(255) DEFAULT NULL,
  `electricityfee` varchar(255) DEFAULT NULL,
  `deposit` varchar(255) DEFAULT NULL,
  `payment` varchar(255) DEFAULT NULL,
  `renttime` varchar(255) DEFAULT NULL,
  `decorationtime` varchar(255) DEFAULT NULL,
  `brokeragefee` decimal(13,2) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `linkofbuilding` varchar(255) DEFAULT NULL,
  `map` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `motofee` varchar(255) DEFAULT NULL,
  `namemanager` varchar(255) DEFAULT NULL,
  `phonemanager` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_building_district` (`districtid`),
  CONSTRAINT `fk_building_district` FOREIGN KEY (`districtid`) REFERENCES `district` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table estatebasic.building: ~4 rows (approximately)
INSERT INTO `building` (`id`, `name`, `street`, `ward`, `districtid`, `structure`, `numberofbasement`, `floorarea`, `direction`, `level`, `rentprice`, `rentpricedescription`, `servicefee`, `carfee`, `motorbikefee`, `overtimefee`, `waterfee`, `electricityfee`, `deposit`, `payment`, `renttime`, `decorationtime`, `brokeragefee`, `note`, `linkofbuilding`, `map`, `image`, `createddate`, `modifieddate`, `createdby`, `modifiedby`, `status`, `avatar`, `motofee`, `namemanager`, `phonemanager`) VALUES
	(1, 'Nam Giao Building Tower', '59 phan xích long', 'Phường 2', 1, NULL, 2, 500, NULL, NULL, 15, '15 triệu/m2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2024-01-11 13:08:20', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, 'ACM Tower', '96 cao thắng', 'Phường 4', 2, NULL, 2, 650, NULL, NULL, 18, '18 triệu/m2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2024-01-11 13:08:21', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(3, 'Alpha 2 Building Tower', '153 nguyễn đình chiểu', 'Phường 6', 1, NULL, 1, 200, NULL, NULL, 20, '20 triệu/m2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2024-01-11 13:08:22', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(4, 'IDD 1 Building', '111 Lý Chính Thắng', 'Phường 7', 3, NULL, 1, 200, NULL, NULL, 12, '12 triệu/m2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2024-01-11 13:08:22', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- Dumping structure for table estatebasic.buildingrenttype
CREATE TABLE IF NOT EXISTS `buildingrenttype` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `buildingid` bigint NOT NULL,
  `renttypeid` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_buildingtype_building` (`buildingid`),
  KEY `fk_buildingtype_renttype` (`renttypeid`),
  CONSTRAINT `fk_buildingtype_building` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`),
  CONSTRAINT `fk_buildingtype_renttype` FOREIGN KEY (`renttypeid`) REFERENCES `renttype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table estatebasic.buildingrenttype: ~7 rows (approximately)
INSERT INTO `buildingrenttype` (`id`, `buildingid`, `renttypeid`) VALUES
	(1, 1, 1),
	(2, 1, 2),
	(3, 2, 2),
	(4, 3, 3),
	(5, 4, 1),
	(6, 4, 2),
	(7, 4, 3);

-- Dumping structure for table estatebasic.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fullname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table estatebasic.customer: ~0 rows (approximately)

-- Dumping structure for table estatebasic.district
CREATE TABLE IF NOT EXISTS `district` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` timestamp NULL DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table estatebasic.district: ~3 rows (approximately)
INSERT INTO `district` (`id`, `code`, `name`, `createdby`, `createddate`, `modifiedby`, `modifieddate`, `status`) VALUES
	(1, 'Q1', 'Quận 1', NULL, NULL, NULL, NULL, NULL),
	(2, 'Q2', 'Quận 2', NULL, NULL, NULL, NULL, NULL),
	(3, 'Q4', 'Quận 4', NULL, NULL, NULL, NULL, NULL);

-- Dumping structure for table estatebasic.rentarea
CREATE TABLE IF NOT EXISTS `rentarea` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `value` int DEFAULT NULL,
  `buildingid` bigint NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rentarea_building` (`buildingid`),
  CONSTRAINT `rentarea_building` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table estatebasic.rentarea: ~11 rows (approximately)
INSERT INTO `rentarea` (`id`, `value`, `buildingid`, `createddate`, `modifieddate`, `createdby`, `modifiedby`, `status`) VALUES
	(1, 100, 1, NULL, NULL, NULL, NULL, NULL),
	(2, 200, 1, NULL, NULL, NULL, NULL, NULL),
	(3, 200, 2, NULL, NULL, NULL, NULL, NULL),
	(4, 300, 2, NULL, NULL, NULL, NULL, NULL),
	(5, 400, 2, NULL, NULL, NULL, NULL, NULL),
	(6, 300, 3, NULL, NULL, NULL, NULL, NULL),
	(7, 400, 3, NULL, NULL, NULL, NULL, NULL),
	(8, 500, 3, NULL, NULL, NULL, NULL, NULL),
	(9, 100, 4, NULL, NULL, NULL, NULL, NULL),
	(10, 400, 4, NULL, NULL, NULL, NULL, NULL),
	(11, 250, 4, NULL, NULL, NULL, NULL, NULL);

-- Dumping structure for table estatebasic.renttype
CREATE TABLE IF NOT EXISTS `renttype` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table estatebasic.renttype: ~3 rows (approximately)
INSERT INTO `renttype` (`id`, `code`, `name`) VALUES
	(1, 'tang-tret', 'Tầng trệt'),
	(2, 'nguyen-can', 'Nguyên căn'),
	(3, 'noi-that', 'Nội thất');

-- Dumping structure for table estatebasic.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table estatebasic.role: ~2 rows (approximately)
INSERT INTO `role` (`id`, `name`, `code`, `createddate`, `modifieddate`, `createdby`, `modifiedby`, `status`) VALUES
	(1, 'Quản lý', 'manager', NULL, NULL, NULL, NULL, NULL),
	(2, 'Nhân viên', 'staff', NULL, NULL, NULL, NULL, NULL);

-- Dumping structure for table estatebasic.transaction
CREATE TABLE IF NOT EXISTS `transaction` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `note` varchar(255) DEFAULT NULL,
  `customerid` bigint NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `type` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customer_transaction` (`customerid`),
  KEY `fk_transactiontype_transaction_idx` (`type`),
  CONSTRAINT `fk_customer_transaction` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`),
  CONSTRAINT `fk_transactiontype_transaction` FOREIGN KEY (`type`) REFERENCES `transactiontype` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table estatebasic.transaction: ~0 rows (approximately)

-- Dumping structure for table estatebasic.transactiontype
CREATE TABLE IF NOT EXISTS `transactiontype` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `modifieddate` timestamp NULL DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Dumping data for table estatebasic.transactiontype: ~0 rows (approximately)

-- Dumping structure for table estatebasic.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `status` int NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table estatebasic.user: ~4 rows (approximately)
INSERT INTO `user` (`id`, `username`, `password`, `fullname`, `phone`, `email`, `status`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
	(1, 'nguyenvana', '123456', 'nguyen van a', NULL, NULL, 1, NULL, NULL, NULL, NULL),
	(2, 'nguyenvanb', '123456', 'nguyen van b', NULL, NULL, 1, NULL, NULL, NULL, NULL),
	(3, 'nguyenvanc', '123456', 'nguyen van c', NULL, NULL, 1, NULL, NULL, NULL, NULL),
	(4, 'nguyenvand', '123456', 'nguyen van d', NULL, NULL, 1, NULL, NULL, NULL, NULL);

-- Dumping structure for table estatebasic.user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `roleid` bigint NOT NULL,
  `userid` bigint NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_role` (`userid`),
  KEY `fk_role_user` (`roleid`),
  CONSTRAINT `fk_role_user` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- Dumping data for table estatebasic.user_role: ~4 rows (approximately)
INSERT INTO `user_role` (`id`, `roleid`, `userid`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
	(1, 1, 1, NULL, NULL, NULL, NULL),
	(2, 2, 2, NULL, NULL, NULL, NULL),
	(3, 2, 3, NULL, NULL, NULL, NULL),
	(4, 2, 4, NULL, NULL, NULL, NULL);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
