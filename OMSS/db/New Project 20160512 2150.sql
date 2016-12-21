-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.19


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema omss
--

CREATE DATABASE IF NOT EXISTS omss;
USE omss;

--
-- Definition of table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment` (
  `appointmentId` int(10) unsigned NOT NULL,
  `doctorName` varchar(45) NOT NULL,
  `appointmentType` varchar(45) NOT NULL,
  `appointmentDate` varchar(45) NOT NULL,
  `appointmentTime` varchar(45) NOT NULL,
  `medicalReports` varchar(45) NOT NULL,
  `treatmentType` varchar(45) NOT NULL,
  `finalReport` varchar(45) NOT NULL,
  `patientId` int(10) unsigned NOT NULL,
  `doctorId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`appointmentId`),
  KEY `FK_appointment_1` (`patientId`),
  KEY `FK_appointment_2` (`doctorId`),
  CONSTRAINT `FK_appointment_1` FOREIGN KEY (`patientId`) REFERENCES `patient` (`patientId`),
  CONSTRAINT `FK_appointment_2` FOREIGN KEY (`doctorId`) REFERENCES `doctor` (`doctorId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointment`
--

/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;


--
-- Definition of table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `doctorId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Gender` varchar(45) NOT NULL,
  `Experience` varchar(45) NOT NULL,
  `specializationId` int(10) unsigned DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `hospitalName` varchar(45) NOT NULL,
  PRIMARY KEY (`doctorId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--


--
-- Definition of table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `feedbackId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `patientName` varchar(45) NOT NULL,
  `doctorName` varchar(45) NOT NULL,
  `rating` varchar(45) NOT NULL,
  `review` varchar(255) NOT NULL,
  `status` varchar(45) NOT NULL,
  `specializationId` int(10) unsigned NOT NULL,
  `doctorId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`feedbackId`),
  KEY `FK_feedback_1` (`specializationId`),
  KEY `FK_feedback_2` (`doctorId`),
  CONSTRAINT `FK_feedback_1` FOREIGN KEY (`specializationId`) REFERENCES `specialization` (`specializationId`),
  CONSTRAINT `FK_feedback_2` FOREIGN KEY (`doctorId`) REFERENCES `doctor` (`doctorId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedback`
--

/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;


--
-- Definition of table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `patientId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Gender` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  PRIMARY KEY (`patientId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--



--
-- Definition of table `specialization`
--

DROP TABLE IF EXISTS `specialization`;
CREATE TABLE `specialization` (
  `specializationId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `specializationName` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`specializationId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `specialization`
--

/*!40000 ALTER TABLE `specialization` DISABLE KEYS */;
/*!40000 ALTER TABLE `specialization` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
