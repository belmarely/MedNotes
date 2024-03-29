-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: registro_medico
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.13-MariaDB

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
-- Table structure for table `antecedentes_personales`
--

DROP TABLE IF EXISTS `antecedentes_personales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `antecedentes_personales` (
  `id_antecedentes_personales` int(11) NOT NULL AUTO_INCREMENT,
  `tabaquismo` varchar(45) NOT NULL,
  `alcoholismo` varchar(45) NOT NULL,
  `otras_drogas_especifique` varchar(200) NOT NULL,
  `creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_antecedentes_personales`),
  UNIQUE KEY `id_antecedentes_personales_UNIQUE` (`id_antecedentes_personales`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `antecedentes_personales`
--

LOCK TABLES `antecedentes_personales` WRITE;
/*!40000 ALTER TABLE `antecedentes_personales` DISABLE KEYS */;
/*!40000 ALTER TABLE `antecedentes_personales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `citas`
--

DROP TABLE IF EXISTS `citas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `citas` (
  `id_cita` int(11) NOT NULL AUTO_INCREMENT,
  `id_expediente` int(11) NOT NULL,
  `dia` datetime NOT NULL,
  `creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_cita`),
  KEY `fk_expediente_idx` (`id_expediente`),
  CONSTRAINT `fk_expediente` FOREIGN KEY (`id_expediente`) REFERENCES `expedientes` (`id_expediente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citas`
--

LOCK TABLES `citas` WRITE;
/*!40000 ALTER TABLE `citas` DISABLE KEYS */;
/*!40000 ALTER TABLE `citas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diagnosticos`
--

DROP TABLE IF EXISTS `diagnosticos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diagnosticos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_paciente` int(11) NOT NULL,
  `diagnostico` varchar(250) NOT NULL,
  `creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id_pac_idx` (`id_paciente`),
  CONSTRAINT `id_pac` FOREIGN KEY (`id_paciente`) REFERENCES `expedientes` (`id_expediente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnosticos`
--

LOCK TABLES `diagnosticos` WRITE;
/*!40000 ALTER TABLE `diagnosticos` DISABLE KEYS */;
/*!40000 ALTER TABLE `diagnosticos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examenes_fisicos`
--

DROP TABLE IF EXISTS `examenes_fisicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examenes_fisicos` (
  `id_examen_fisico` int(11) NOT NULL AUTO_INCREMENT,
  `id_paciente` int(11) NOT NULL,
  `sintoma_principal` varchar(250) NOT NULL,
  `motivo_consulta` varchar(250) NOT NULL,
  `apariencia_general` varchar(250) NOT NULL,
  `presion_arterial` decimal(10,0) NOT NULL COMMENT 'mm/hg',
  `frecuencia_cardiaca` double NOT NULL COMMENT 'Por minuto',
  `frecuencia_respiratoria` double NOT NULL COMMENT 'Por minuto',
  `temperatura` decimal(10,0) NOT NULL COMMENT '(°C)',
  `apetito` enum('1','2','3') NOT NULL,
  `sed` enum('1','2','3') NOT NULL,
  `sueño` enum('1','2','3') NOT NULL,
  `miccion` enum('1','2','3') NOT NULL,
  `defecacion` enum('1','2','3') NOT NULL,
  `snc` varchar(45) NOT NULL,
  `cabeza` varchar(45) NOT NULL,
  `ojos` varchar(45) NOT NULL,
  `nariz_paranasales` varchar(45) NOT NULL,
  `boca_faringe` varchar(45) NOT NULL,
  `cuello` varchar(45) NOT NULL,
  `respiratorio` varchar(45) NOT NULL,
  `cardiovascular` varchar(45) NOT NULL,
  `digestivo` varchar(45) NOT NULL,
  `osteomuscular` varchar(45) NOT NULL,
  `hematologico` varchar(45) NOT NULL,
  `genitoutario` varchar(45) NOT NULL,
  `infatico` varchar(45) NOT NULL,
  `endocrino` varchar(45) NOT NULL,
  `piel_faneras` varchar(45) NOT NULL,
  `creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_examen_fisico`),
  KEY `id_pacient_idx` (`id_paciente`),
  CONSTRAINT `id_pacient` FOREIGN KEY (`id_paciente`) REFERENCES `expedientes` (`id_expediente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examenes_fisicos`
--

LOCK TABLES `examenes_fisicos` WRITE;
/*!40000 ALTER TABLE `examenes_fisicos` DISABLE KEYS */;
/*!40000 ALTER TABLE `examenes_fisicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expedientes`
--

DROP TABLE IF EXISTS `expedientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expedientes` (
  `id_expediente` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `telefono` varchar(13) NOT NULL,
  `identidad` varchar(13) NOT NULL,
  `sexo` int(1) NOT NULL,
  `edad` int(3) NOT NULL,
  `lugar_de_nacimiento` varchar(30) NOT NULL,
  `fecha_de_nacimiento` date NOT NULL,
  `direccion` varchar(250) NOT NULL,
  `seguridad_social` varchar(20) NOT NULL,
  `nacionalidad` int(11) NOT NULL,
  `tipo_de_sangre` enum('0+','A+','B+','A-','O-','B-') NOT NULL,
  `antecedentes_familiares` int(11) NOT NULL,
  `creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_expediente`),
  UNIQUE KEY `identidad_UNIQUE` (`identidad`),
  UNIQUE KEY `idpacientes_UNIQUE` (`id_expediente`),
  KEY `pf_paises_idx` (`nacionalidad`),
  KEY `fk_ante_idx` (`antecedentes_familiares`),
  CONSTRAINT `fk_ante` FOREIGN KEY (`antecedentes_familiares`) REFERENCES `antecedentes_personales` (`id_antecedentes_personales`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pf_paises` FOREIGN KEY (`nacionalidad`) REFERENCES `paises` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expedientes`
--

LOCK TABLES `expedientes` WRITE;
/*!40000 ALTER TABLE `expedientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `expedientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paises`
--

DROP TABLE IF EXISTS `paises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paises` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country_code` varchar(2) NOT NULL,
  `country_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paises`
--

LOCK TABLES `paises` WRITE;
/*!40000 ALTER TABLE `paises` DISABLE KEYS */;
INSERT INTO `paises` VALUES (1,'AF','Afghanistan'),(2,'AL','Albania'),(3,'DZ','Algeria'),(4,'DS','American Samoa'),(5,'AD','Andorra'),(6,'AO','Angola'),(7,'AI','Anguilla'),(8,'AQ','Antarctica'),(9,'AG','Antigua and Barbuda'),(10,'AR','Argentina'),(11,'AM','Armenia'),(12,'AW','Aruba'),(13,'AU','Australia'),(14,'AT','Austria'),(15,'AZ','Azerbaijan'),(16,'BS','Bahamas'),(17,'BH','Bahrain'),(18,'BD','Bangladesh'),(19,'BB','Barbados'),(20,'BY','Belarus'),(21,'BE','Belgium'),(22,'BZ','Belize'),(23,'BJ','Benin'),(24,'BM','Bermuda'),(25,'BT','Bhutan'),(26,'BO','Bolivia'),(27,'BA','Bosnia and Herzegovina'),(28,'BW','Botswana'),(29,'BV','Bouvet Island'),(30,'BR','Brazil'),(31,'IO','British Indian Ocean Territory'),(32,'BN','Brunei Darussalam'),(33,'BG','Bulgaria'),(34,'BF','Burkina Faso'),(35,'BI','Burundi'),(36,'KH','Cambodia'),(37,'CM','Cameroon'),(38,'CA','Canada'),(39,'CV','Cape Verde'),(40,'KY','Cayman Islands'),(41,'CF','Central African Republic'),(42,'TD','Chad'),(43,'CL','Chile'),(44,'CN','China'),(45,'CX','Christmas Island'),(46,'CC','Cocos (Keeling) Islands'),(47,'CO','Colombia'),(48,'KM','Comoros'),(49,'CD','Democratic Republic of the Congo'),(50,'CG','Republic of Congo'),(51,'CK','Cook Islands'),(52,'CR','Costa Rica'),(53,'HR','Croatia (Hrvatska)'),(54,'CU','Cuba'),(55,'CY','Cyprus'),(56,'CZ','Czech Republic'),(57,'DK','Denmark'),(58,'DJ','Djibouti'),(59,'DM','Dominica'),(60,'DO','Dominican Republic'),(61,'TP','East Timor'),(62,'EC','Ecuador'),(63,'EG','Egypt'),(64,'SV','El Salvador'),(65,'GQ','Equatorial Guinea'),(66,'ER','Eritrea'),(67,'EE','Estonia'),(68,'ET','Ethiopia'),(69,'FK','Falkland Islands (Malvinas)'),(70,'FO','Faroe Islands'),(71,'FJ','Fiji'),(72,'FI','Finland'),(73,'FR','France'),(74,'FX','France, Metropolitan'),(75,'GF','French Guiana'),(76,'PF','French Polynesia'),(77,'TF','French Southern Territories'),(78,'GA','Gabon'),(79,'GM','Gambia'),(80,'GE','Georgia'),(81,'DE','Germany'),(82,'GH','Ghana'),(83,'GI','Gibraltar'),(84,'GK','Guernsey'),(85,'GR','Greece'),(86,'GL','Greenland'),(87,'GD','Grenada'),(88,'GP','Guadeloupe'),(89,'GU','Guam'),(90,'GT','Guatemala'),(91,'GN','Guinea'),(92,'GW','Guinea-Bissau'),(93,'GY','Guyana'),(94,'HT','Haiti'),(95,'HM','Heard and Mc Donald Islands'),(96,'HN','Honduras'),(97,'HK','Hong Kong'),(98,'HU','Hungary'),(99,'IS','Iceland'),(100,'IN','India'),(101,'IM','Isle of Man'),(102,'ID','Indonesia'),(103,'IR','Iran (Islamic Republic of)'),(104,'IQ','Iraq'),(105,'IE','Ireland'),(106,'IL','Israel'),(107,'IT','Italy'),(108,'CI','Ivory Coast'),(109,'JE','Jersey'),(110,'JM','Jamaica'),(111,'JP','Japan'),(112,'JO','Jordan'),(113,'KZ','Kazakhstan'),(114,'KE','Kenya'),(115,'KI','Kiribati'),(116,'KP','Korea, Democratic People\'s Republic of'),(117,'KR','Korea, Republic of'),(118,'XK','Kosovo'),(119,'KW','Kuwait'),(120,'KG','Kyrgyzstan'),(121,'LA','Lao People\'s Democratic Republic'),(122,'LV','Latvia'),(123,'LB','Lebanon'),(124,'LS','Lesotho'),(125,'LR','Liberia'),(126,'LY','Libyan Arab Jamahiriya'),(127,'LI','Liechtenstein'),(128,'LT','Lithuania'),(129,'LU','Luxembourg'),(130,'MO','Macau'),(131,'MK','North Macedonia'),(132,'MG','Madagascar'),(133,'MW','Malawi'),(134,'MY','Malaysia'),(135,'MV','Maldives'),(136,'ML','Mali'),(137,'MT','Malta'),(138,'MH','Marshall Islands'),(139,'MQ','Martinique'),(140,'MR','Mauritania'),(141,'MU','Mauritius'),(142,'TY','Mayotte'),(143,'MX','Mexico'),(144,'FM','Micronesia, Federated States of'),(145,'MD','Moldova, Republic of'),(146,'MC','Monaco'),(147,'MN','Mongolia'),(148,'ME','Montenegro'),(149,'MS','Montserrat'),(150,'MA','Morocco'),(151,'MZ','Mozambique'),(152,'MM','Myanmar'),(153,'NA','Namibia'),(154,'NR','Nauru'),(155,'NP','Nepal'),(156,'NL','Netherlands'),(157,'AN','Netherlands Antilles'),(158,'NC','New Caledonia'),(159,'NZ','New Zealand'),(160,'NI','Nicaragua'),(161,'NE','Niger'),(162,'NG','Nigeria'),(163,'NU','Niue'),(164,'NF','Norfolk Island'),(165,'MP','Northern Mariana Islands'),(166,'NO','Norway'),(167,'OM','Oman'),(168,'PK','Pakistan'),(169,'PW','Palau'),(170,'PS','Palestine'),(171,'PA','Panama'),(172,'PG','Papua New Guinea'),(173,'PY','Paraguay'),(174,'PE','Peru'),(175,'PH','Philippines'),(176,'PN','Pitcairn'),(177,'PL','Poland'),(178,'PT','Portugal'),(179,'PR','Puerto Rico'),(180,'QA','Qatar'),(181,'RE','Reunion'),(182,'RO','Romania'),(183,'RU','Russian Federation'),(184,'RW','Rwanda'),(185,'KN','Saint Kitts and Nevis'),(186,'LC','Saint Lucia'),(187,'VC','Saint Vincent and the Grenadines'),(188,'WS','Samoa'),(189,'SM','San Marino'),(190,'ST','Sao Tome and Principe'),(191,'SA','Saudi Arabia'),(192,'SN','Senegal'),(193,'RS','Serbia'),(194,'SC','Seychelles'),(195,'SL','Sierra Leone'),(196,'SG','Singapore'),(197,'SK','Slovakia'),(198,'SI','Slovenia'),(199,'SB','Solomon Islands'),(200,'SO','Somalia'),(201,'ZA','South Africa'),(202,'GS','South Georgia South Sandwich Islands'),(203,'SS','South Sudan'),(204,'ES','Spain'),(205,'LK','Sri Lanka'),(206,'SH','St. Helena'),(207,'PM','St. Pierre and Miquelon'),(208,'SD','Sudan'),(209,'SR','Suriname'),(210,'SJ','Svalbard and Jan Mayen Islands'),(211,'SZ','Swaziland'),(212,'SE','Sweden'),(213,'CH','Switzerland'),(214,'SY','Syrian Arab Republic'),(215,'TW','Taiwan'),(216,'TJ','Tajikistan'),(217,'TZ','Tanzania, United Republic of'),(218,'TH','Thailand'),(219,'TG','Togo'),(220,'TK','Tokelau'),(221,'TO','Tonga'),(222,'TT','Trinidad and Tobago'),(223,'TN','Tunisia'),(224,'TR','Turkey'),(225,'TM','Turkmenistan'),(226,'TC','Turks and Caicos Islands'),(227,'TV','Tuvalu'),(228,'UG','Uganda'),(229,'UA','Ukraine'),(230,'AE','United Arab Emirates'),(231,'GB','United Kingdom'),(232,'US','United States'),(233,'UM','United States minor outlying islands'),(234,'UY','Uruguay'),(235,'UZ','Uzbekistan'),(236,'VU','Vanuatu'),(237,'VA','Vatican City State'),(238,'VE','Venezuela'),(239,'VN','Vietnam'),(240,'VG','Virgin Islands (British)'),(241,'VI','Virgin Islands (U.S.)'),(242,'WF','Wallis and Futuna Islands'),(243,'EH','Western Sahara'),(244,'YE','Yemen'),(245,'ZM','Zambia'),(246,'ZW','Zimbabwe');
/*!40000 ALTER TABLE `paises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patologicos`
--

DROP TABLE IF EXISTS `patologicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patologicos` (
  `id_patologicos` int(11) NOT NULL,
  `id_paciente` int(11) NOT NULL,
  `antecedentes_hospitalarios` varchar(250) NOT NULL,
  `antecedentes_alergicos` varchar(250) NOT NULL,
  `antecedentes_traumaticos` varchar(250) NOT NULL,
  `creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_patologicos`),
  KEY `id_paci_idx` (`id_paciente`),
  CONSTRAINT `id_pacie` FOREIGN KEY (`id_paciente`) REFERENCES `expedientes` (`id_expediente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patologicos`
--

LOCK TABLES `patologicos` WRITE;
/*!40000 ALTER TABLE `patologicos` DISABLE KEYS */;
/*!40000 ALTER TABLE `patologicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(45) NOT NULL,
  `palabra_clave` varchar(45) NOT NULL,
  `creacionl` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'registro_medico'
--

--
-- Dumping routines for database 'registro_medico'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-05 18:15:38
