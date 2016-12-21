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
-- Definition of table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Gender` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`adminId`,`Gender`,`Email`,`password`,`firstName`,`lastName`) VALUES 
 (1,'Male','admin@omss.com','admin','admin',' ');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;


--
-- Definition of table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment` (
  `appointmentId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `doctorName` varchar(45) NOT NULL,
  `appointmentType` varchar(45) NOT NULL,
  `appointmentDate` varchar(45) NOT NULL,
  `medicalReports` varchar(255) DEFAULT NULL,
  `patientId` int(10) unsigned NOT NULL,
  `doctorId` int(10) unsigned NOT NULL,
  `patientName` varchar(100) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`appointmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointment`
--

/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;


--
-- Definition of table `caseresolution`
--

DROP TABLE IF EXISTS `caseresolution`;
CREATE TABLE `caseresolution` (
  `caseresolutionId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `appointid` int(10) unsigned NOT NULL,
  `patientName` varchar(75) NOT NULL,
  `serialno` varchar(45) NOT NULL,
  `mediciname` varchar(100) NOT NULL,
  `courseDays` varchar(45) NOT NULL,
  `comments` varchar(500) DEFAULT NULL,
  `doctorName` varchar(75) NOT NULL,
  PRIMARY KEY (`caseresolutionId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `caseresolution`
--

/*!40000 ALTER TABLE `caseresolution` DISABLE KEYS */;
/*!40000 ALTER TABLE `caseresolution` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` (`doctorId`,`Gender`,`Experience`,`specializationId`,`password`,`firstName`,`lastName`,`email`,`hospitalName`) VALUES 
 (16,'male','15',1,'reddy1','shivareddy','devarapalli','reddy@gmail.com','st.vincents'),
 (17,'male','14',2,'vamsi1','vamsi','mallepalli','vamsi@gmail.com','bridgeport'),
 (18,'male','13',4,'jagadeesh','jagadeesh','kola','kola@gmail.com','appollo'),
 (19,'male','13',5,'ayyappa','ayyappa','nukavarapu','ayyappa@gmail.com','st.vincents'),
 (20,'male','12',6,'venu@1','venu','kuthala','venu@gmail.com','bridgeport');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;


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
  `doctorId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`feedbackId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` (`patientId`,`Gender`,`Email`,`password`,`firstName`,`lastName`) VALUES 
 (19,'male','pavani@gmail.com','pavani','pavani','gajjada'),
 (20,'male','devoji@gmail.com','devoji','harsha','devoji');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;


--
-- Definition of table `specialization`
--

DROP TABLE IF EXISTS `specialization`;
CREATE TABLE `specialization` (
  `specializationId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `specializationName` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`specializationId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `specialization`
--

/*!40000 ALTER TABLE `specialization` DISABLE KEYS */;
INSERT INTO `specialization` (`specializationId`,`specializationName`,`description`) VALUES 
 (1,'Cardiologist',' Treats the diseases of the heart.'),
 (2,'Dermatologist',' Treats the diseases of the Skin.'),
 (3,'Gastroenterologist','Treats the stomach disorders.'),
 (4,'Neurologist ','treats diseases of the nervous system'),
 (5,'Ophthalmologist','treats eye defects, injuries, and diseases.'),
 (6,'Urologist',' urinary tract and the'),
 (7,'Rheumatologist','treats rheumatic diseases'),
 (8,'Orthopedic','bones'),
 (9,'Neuro Surgen','about nerves'),
 (10,'Endocrinologist ','thyraid'),
 (11,'Gynecologist ','gynic problems for ladies');
/*!40000 ALTER TABLE `specialization` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
