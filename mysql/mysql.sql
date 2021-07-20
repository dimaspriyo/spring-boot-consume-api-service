-- MySQL dump 10.13  Distrib 8.0.25, for Linux (x86_64)
--
-- Host: localhost    Database: mysqlDB
-- ------------------------------------------------------
-- Server version	8.0.25-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `production_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES ('89b62607-be19-4c4b-8c8e-3208256e3243','Corvette C8','3920-03-01'),('ff07a978-041e-4b1c-b8db-9b97de216893','Ford GT Mustang','3920-02-01');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `driver` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `car_id` varchar(255) DEFAULT NULL,
  `driver` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8wacexawfwmswuet3651bhd28` (`car_id`),
  KEY `FKf2hft4b5jubbk958h93tphpsc` (`driver`),
  CONSTRAINT `FK8wacexawfwmswuet3651bhd28` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`),
  CONSTRAINT `FKf2hft4b5jubbk958h93tphpsc` FOREIGN KEY (`driver`) REFERENCES `car` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
INSERT INTO `driver` VALUES ('4ec3767d-9559-4f44-8a07-6b809c7761e9','Doe','ff07a978-041e-4b1c-b8db-9b97de216893',NULL),('51d5758e-61c8-40cd-ad9b-6ea4f2360f79','John','ff07a978-041e-4b1c-b8db-9b97de216893',NULL),('9ea913aa-49a6-46dc-9223-c3469ade1462','Tommy','89b62607-be19-4c4b-8c8e-3208256e3243',NULL),('a8d67522-6589-4359-a4fe-acb8b417b344','Blake','89b62607-be19-4c4b-8c8e-3208256e3243',NULL);
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mysql_table`
--

DROP TABLE IF EXISTS `mysql_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mysql_table` (
  `id` varchar(255) NOT NULL,
  `birth_date` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mysql_table`
--

LOCK TABLES `mysql_table` WRITE;
/*!40000 ALTER TABLE `mysql_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `mysql_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'mysqlDB'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-13 18:25:03
