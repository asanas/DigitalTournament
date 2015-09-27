-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.1.73-community - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.3.0.4991
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for digitourapp
DROP DATABASE IF EXISTS `digitourapp`;
CREATE DATABASE IF NOT EXISTS `digitourapp` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `digitourapp`;


-- Dumping structure for table digitourapp.city
DROP TABLE IF EXISTS `city`;
CREATE TABLE IF NOT EXISTS `city` (
  `city_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(100) NOT NULL,
  `fk_state_id` bigint(20) NOT NULL,
  PRIMARY KEY (`city_id`),
  KEY `fk_state` (`fk_state_id`),
  CONSTRAINT `fk_state` FOREIGN KEY (`fk_state_id`) REFERENCES `statecountry` (`state_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.city: ~4 rows (approximately)
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT IGNORE INTO `city` (`city_id`, `city_name`, `fk_state_id`) VALUES
	(1, 'Pune', 1),
	(2, 'Mumbai', 1),
	(3, 'Sangli', 1),
	(4, 'Kolapur', 1);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;


-- Dumping structure for table digitourapp.group
DROP TABLE IF EXISTS `group`;
CREATE TABLE IF NOT EXISTS `group` (
  `group_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(100) NOT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.group: ~0 rows (approximately)
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
/*!40000 ALTER TABLE `group` ENABLE KEYS */;


-- Dumping structure for table digitourapp.playerprofile
DROP TABLE IF EXISTS `playerprofile`;
CREATE TABLE IF NOT EXISTS `playerprofile` (
  `player_profile_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `date_of_birth` date NOT NULL,
  `photo` blob,
  `height` int(3) DEFAULT NULL,
  `weight` int(3) DEFAULT NULL,
  `total_tours_participated` int(11) DEFAULT NULL,
  `achievements` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fk_city_id` bigint(20) NOT NULL,
  `major_skill` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `contact` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fk_team_id` bigint(20) NOT NULL,
  PRIMARY KEY (`player_profile_id`),
  KEY `fk_city` (`fk_city_id`),
  KEY `fk_pp_team` (`fk_team_id`),
  CONSTRAINT `fk_city` FOREIGN KEY (`fk_city_id`) REFERENCES `city` (`city_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pp_team` FOREIGN KEY (`fk_team_id`) REFERENCES `team` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table digitourapp.playerprofile: ~0 rows (approximately)
/*!40000 ALTER TABLE `playerprofile` DISABLE KEYS */;
/*!40000 ALTER TABLE `playerprofile` ENABLE KEYS */;


-- Dumping structure for table digitourapp.statecountry
DROP TABLE IF EXISTS `statecountry`;
CREATE TABLE IF NOT EXISTS `statecountry` (
  `state_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `state_name` varchar(100) NOT NULL,
  `country_name` varchar(50) NOT NULL,
  PRIMARY KEY (`state_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.statecountry: ~1 rows (approximately)
/*!40000 ALTER TABLE `statecountry` DISABLE KEYS */;
INSERT IGNORE INTO `statecountry` (`state_id`, `state_name`, `country_name`) VALUES
	(1, 'Maharashtra', 'India');
/*!40000 ALTER TABLE `statecountry` ENABLE KEYS */;


-- Dumping structure for table digitourapp.team
DROP TABLE IF EXISTS `team`;
CREATE TABLE IF NOT EXISTS `team` (
  `team_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `team_name` varchar(500) NOT NULL,
  `founder_name` varchar(500) NOT NULL,
  `description` varchar(500) NOT NULL,
  `club_address_line1` varchar(500) NOT NULL,
  `club_address_line2` varchar(500) DEFAULT NULL,
  `achievements` varchar(500) DEFAULT NULL,
  `fk_city_id` bigint(20) NOT NULL,
  `photo` blob,
  `team_type` varchar(10) NOT NULL,
  `established_in` date NOT NULL,
  PRIMARY KEY (`team_id`),
  KEY `fk_team_city` (`fk_city_id`),
  CONSTRAINT `fk_team_city` FOREIGN KEY (`fk_city_id`) REFERENCES `city` (`city_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.team: ~0 rows (approximately)
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
/*!40000 ALTER TABLE `team` ENABLE KEYS */;


-- Dumping structure for table digitourapp.tournament
DROP TABLE IF EXISTS `tournament`;
CREATE TABLE IF NOT EXISTS `tournament` (
  `tournament_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tournament_name` varchar(500) NOT NULL,
  `description` varchar(500) NOT NULL,
  `location` varchar(500) NOT NULL,
  `prize` double NOT NULL,
  `other_details` varchar(500) NOT NULL,
  `tour_type` varchar(500) NOT NULL,
  `tour_status` varchar(10) NOT NULL,
  `tournament_start_date` date NOT NULL,
  `tournament_end_date` date NOT NULL,
  `created_date` datetime NOT NULL,
  `age_group` varchar(10) NOT NULL,
  PRIMARY KEY (`tournament_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.tournament: ~0 rows (approximately)
/*!40000 ALTER TABLE `tournament` DISABLE KEYS */;
/*!40000 ALTER TABLE `tournament` ENABLE KEYS */;


-- Dumping structure for table digitourapp.tournamentofficial
DROP TABLE IF EXISTS `tournamentofficial`;
CREATE TABLE IF NOT EXISTS `tournamentofficial` (
  `official_profile_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(100) NOT NULL,
  `date_of_birth` date NOT NULL,
  `address_line1` varchar(500) NOT NULL,
  `address_line2` varchar(500) DEFAULT NULL,
  `contact1` varchar(20) NOT NULL,
  `contact2` varchar(20) DEFAULT NULL,
  `fk_city_id` bigint(20) NOT NULL,
  PRIMARY KEY (`official_profile_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.tournamentofficial: ~0 rows (approximately)
/*!40000 ALTER TABLE `tournamentofficial` DISABLE KEYS */;
/*!40000 ALTER TABLE `tournamentofficial` ENABLE KEYS */;


-- Dumping structure for table digitourapp.tournamentparticipant
DROP TABLE IF EXISTS `tournamentparticipant`;
CREATE TABLE IF NOT EXISTS `tournamentparticipant` (
  `tournament_participant_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fk_tournament_id` bigint(20) NOT NULL,
  `fk_team_id` bigint(20) NOT NULL,
  `fk_group_id` bigint(20) NOT NULL,
  PRIMARY KEY (`tournament_participant_id`),
  KEY `tp_tournament` (`fk_tournament_id`),
  KEY `tp_team` (`fk_team_id`),
  KEY `tp_group` (`fk_group_id`),
  CONSTRAINT `tp_group` FOREIGN KEY (`fk_group_id`) REFERENCES `group` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tp_team` FOREIGN KEY (`fk_team_id`) REFERENCES `team` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tp_tournament` FOREIGN KEY (`fk_tournament_id`) REFERENCES `tournament` (`tournament_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.tournamentparticipant: ~0 rows (approximately)
/*!40000 ALTER TABLE `tournamentparticipant` DISABLE KEYS */;
/*!40000 ALTER TABLE `tournamentparticipant` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
