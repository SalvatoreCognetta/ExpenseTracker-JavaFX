CREATE DATABASE  IF NOT EXISTS `registrospese` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `registrospese`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: registrospese
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `idcategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Bollette'),(2,'Divertimento'),(3,'Bevande'),(4,'Sport'),(5,'Abbigliamento'),(6,'Autostrada'),(7,'Altro'),(8,'Carburante'),(9,'Istruzione');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spesa`
--

DROP TABLE IF EXISTS `spesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spesa` (
  `idspesa` int(11) NOT NULL AUTO_INCREMENT,
  `costo` double DEFAULT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  `data` date DEFAULT NULL,
  PRIMARY KEY (`idspesa`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spesa`
--

LOCK TABLES `spesa` WRITE;
/*!40000 ALTER TABLE `spesa` DISABLE KEYS */;
INSERT INTO `spesa` VALUES (42,21.3,'Bollette','Enel','2017-07-19'),(43,55.5,'Sport','Piscina','2017-05-01'),(44,32,'Divertimento','Kart','2017-02-01'),(45,10,'Bevande','Acqua','2017-07-25'),(46,57,'Bollette','Gas','2017-07-25'),(49,29,'Bevande','Test','2016-07-01'),(50,150,'Divertimento','MotoGP','2017-09-05'),(51,80,'Bollette','Acqua','2017-07-01'),(52,55,'Abbigliamento','Scarpe','2017-07-25'),(53,25,'Autostrada','Firenze-Roma','2017-06-06'),(54,48,'Istruzione','Libro S.O.','2017-07-11'),(55,3,'Altro','Pellicola','2017-07-25');
/*!40000 ALTER TABLE `spesa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-25  0:24:10
