-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `grades`
--

DROP TABLE IF EXISTS `grades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grades` (
  `studentid` bigint NOT NULL,
  `grade` bigint DEFAULT NULL,
  `module` varchar(255) DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`studentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grades`
--

LOCK TABLES `grades` WRITE;
/*!40000 ALTER TABLE `grades` DISABLE KEYS */;
INSERT INTO `grades` VALUES (3,80,'Data Structures and Algorithms','StudentA Doe'),(4,98,'Advanced Digital Forensics','StudentB Doe'),(5,98,'Secure Software Engineering','StudentC Doe');
/*!40000 ALTER TABLE `grades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modules`
--

DROP TABLE IF EXISTS `modules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modules` (
  `module_id` bigint NOT NULL AUTO_INCREMENT,
  `closed` bit(1) NOT NULL,
  `coordinator` varchar(255) DEFAULT NULL,
  `module_name` varchar(255) DEFAULT NULL,
  `module_topic` varchar(255) DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modules`
--

LOCK TABLES `modules` WRITE;
/*!40000 ALTER TABLE `modules` DISABLE KEYS */;
INSERT INTO `modules` VALUES (1,_binary '\0','StaffA Doe','Intro to Java Programming','Java','School of Computer Science'),(2,_binary '\0','StaffA Doe','Data Structures and Algorithms','Data Structures','School of Computer Science'),(3,_binary '\0','StaffB Doe','Advanced Digital Forensics','Digital Forensics','School of Computer Science'),(4,_binary '\0','StaffB Doe','Secure Software Engineering','Cyber security','School of Computer Science');
/*!40000 ALTER TABLE `modules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modules_users`
--

DROP TABLE IF EXISTS `modules_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modules_users` (
  `module_module_id` bigint NOT NULL,
  `users_user_id` bigint NOT NULL,
  PRIMARY KEY (`module_module_id`,`users_user_id`),
  KEY `FK1ryigtobov1hj1lk5g485qipq` (`users_user_id`),
  CONSTRAINT `FK1ryigtobov1hj1lk5g485qipq` FOREIGN KEY (`users_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKilmwdyfr3uwwchnxqhu7ykgtf` FOREIGN KEY (`module_module_id`) REFERENCES `modules` (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modules_users`
--

LOCK TABLES `modules_users` WRITE;
/*!40000 ALTER TABLE `modules_users` DISABLE KEYS */;
INSERT INTO `modules_users` VALUES (2,3),(3,3),(4,3),(1,4),(3,4),(4,5);
/*!40000 ALTER TABLE `modules_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_fees`
--

DROP TABLE IF EXISTS `pay_fees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pay_fees` (
  `fees_id` bigint NOT NULL AUTO_INCREMENT,
  `card_name` varchar(255) DEFAULT NULL,
  `card_number` varchar(255) DEFAULT NULL,
  `expire_date` varchar(255) DEFAULT NULL,
  `security_code` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`fees_id`),
  KEY `FKrlue6etyh4v1f8rg9bwvx31yt` (`user_id`),
  CONSTRAINT `FKrlue6etyh4v1f8rg9bwvx31yt` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_fees`
--

LOCK TABLES `pay_fees` WRITE;
/*!40000 ALTER TABLE `pay_fees` DISABLE KEYS */;
INSERT INTO `pay_fees` VALUES (1,'Student Doe','4319350560608080','10/22','718',3),(2,'StudentB Doe','4505938280809797','12/23','231',4),(3,'StudentC Doe','4319505071728385','09/20','081',5);
/*!40000 ALTER TABLE `pay_fees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_STAFF'),(3,'ROLE_STUDENT');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `home_num` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile_num` varchar(255) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `student_number` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'D12W3W9','janedoe@edu.com','Jane','F','01574739','Doe','08978584737','Ireland','$2a$10$rFGgx287CjP14yRvpr/tUuQiCrZ/fuoHThxbSzZWbjzmJ/ap63igm','001','janedoe'),(3,'D4W9W2','studentdoe@edu.com','StudentA','M','01444658392','Doe','08974758893','Italy','$2a$10$319GHgCjuHRaQXJW9yr1UuPCI503PogMWMJFVdk5G8In0o4QHSW.u','002','studentdoe'),(4,'D12W3W9','studentbdoe@edu.com','StudentB','F','0145063838','Doe','0897367467','Ireland','$2a$10$VkysJMy2IItV7vfxzWwaf.t5IKUH1O94x/JsbM9wJ5pjfP.9HGKPS','003','studentdoeB'),(5,'A91RX20','studentbdoe@edu.com','StudentC','M','013993489','Doe','0895293849','Ireland','$2a$10$D02xFi04evjYvyCoHWpOR.Cev3wN.gerhv5SKBpipaL6j3Vhxj65y','004','studentdoeC'),(7,'D08FC62','staffa@edu.com','StaffA','M','01444658392','Doe','08974758893','Lebanon','$2a$10$459OLq8K9U5dIDwkIJGOS.z.qDqm8EYWq7MEsv7iEEsxgavJ4lpPm','','staffdoeA'),(8,'D3P2P4','staffb@edu.com','StaffB','F','01934884','Doe','089834823','Lebanon','$2a$10$FfAMbxttYwajDSyuOOL7b.Dh7QZ6BlHgXwUktQMzaBasPA9o7C9Gi','','staffdoeB');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_modules`
--

DROP TABLE IF EXISTS `user_modules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_modules` (
  `user_user_id` bigint NOT NULL,
  `modules_module_id` bigint NOT NULL,
  PRIMARY KEY (`user_user_id`,`modules_module_id`),
  KEY `FK4gpfefxnumtgrastodtgy1kkx` (`modules_module_id`),
  CONSTRAINT `FK4gpfefxnumtgrastodtgy1kkx` FOREIGN KEY (`modules_module_id`) REFERENCES `modules` (`module_id`),
  CONSTRAINT `FKllx1j28bsrvo3y49kep6i9a9o` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_modules`
--

LOCK TABLES `user_modules` WRITE;
/*!40000 ALTER TABLE `user_modules` DISABLE KEYS */;
INSERT INTO `user_modules` VALUES (4,1),(3,2),(3,3),(4,3),(3,4),(5,4);
/*!40000 ALTER TABLE `user_modules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `users_user_id` bigint NOT NULL,
  `roles_id` bigint NOT NULL,
  PRIMARY KEY (`users_user_id`,`roles_id`),
  KEY `FKj9553ass9uctjrmh0gkqsmv0d` (`roles_id`),
  CONSTRAINT `FKj9553ass9uctjrmh0gkqsmv0d` FOREIGN KEY (`roles_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKpxg673cbwoh40u7meqqap00t3` FOREIGN KEY (`users_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1),(7,2),(8,2),(3,3),(4,3),(5,3);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wrong_attempt_audit`
--

DROP TABLE IF EXISTS `wrong_attempt_audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wrong_attempt_audit` (
  `attempt_id` bigint NOT NULL AUTO_INCREMENT,
  `attempt_date` date DEFAULT NULL,
  `attempt_date_time` datetime(6) DEFAULT NULL,
  `attempt_msg` varchar(255) DEFAULT NULL,
  `remote_id` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`attempt_id`),
  KEY `FK80tqbxh48cjt4pqsocmp6srbw` (`user_id`),
  CONSTRAINT `FK80tqbxh48cjt4pqsocmp6srbw` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wrong_attempt_audit`
--

LOCK TABLES `wrong_attempt_audit` WRITE;
/*!40000 ALTER TABLE `wrong_attempt_audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `wrong_attempt_audit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-28 20:04:49
