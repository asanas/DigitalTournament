-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.20 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for digitourapp
CREATE DATABASE IF NOT EXISTS `digitourapp` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `digitourapp`;


-- Dumping structure for table digitourapp.city
CREATE TABLE IF NOT EXISTS `city` (
  `city_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(100) NOT NULL,
  `state_id` bigint(20) NOT NULL,
  PRIMARY KEY (`city_id`),
  KEY `fk_state` (`state_id`),
  CONSTRAINT `fk_state` FOREIGN KEY (`state_id`) REFERENCES `statecountry` (`state_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.city: ~4 rows (approximately)
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT IGNORE INTO `city` (`city_id`, `city_name`, `state_id`) VALUES
	(1, 'Pune', 1),
	(2, 'Mumbai', 1),
	(3, 'Sangli', 1),
	(4, 'Kolapur', 1);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;


-- Dumping structure for table digitourapp.group
CREATE TABLE IF NOT EXISTS `group` (
  `group_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(100) NOT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.group: ~2 rows (approximately)
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
INSERT IGNORE INTO `group` (`group_id`, `group_name`) VALUES
	(1, 'A'),
	(2, 'B');
/*!40000 ALTER TABLE `group` ENABLE KEYS */;


-- Dumping structure for table digitourapp.matchpointdetails
CREATE TABLE IF NOT EXISTS `matchpointdetails` (
  `match_point_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tournament_match_id` bigint(20) NOT NULL,
  `inning_number` bigint(20) NOT NULL,
  `turn_number` bigint(20) NOT NULL,
  `defender_id` bigint(20) NOT NULL,
  `attacker_id` bigint(20) NOT NULL,
  `assist_id` bigint(20) DEFAULT NULL,
  `wicket_status` char(1) DEFAULT NULL,
  `turn_closure` char(1) DEFAULT NULL,
  `run_time` bigint(20) NOT NULL,
  `per_time` bigint(20) NOT NULL,
  `symbol_id` bigint(20) NOT NULL,
  PRIMARY KEY (`match_point_id`),
  KEY `fk_mpd_assist` (`assist_id`),
  KEY `fk_mpd_attack` (`attacker_id`),
  KEY `fk_mpd_defence` (`defender_id`),
  KEY `fk_mpd_symbol` (`symbol_id`),
  CONSTRAINT `fk_mpd_assist` FOREIGN KEY (`assist_id`) REFERENCES `tournamentparticipantteam` (`tour_p_t_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_mpd_attack` FOREIGN KEY (`attacker_id`) REFERENCES `tournamentparticipantteam` (`tour_p_t_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_mpd_defence` FOREIGN KEY (`defender_id`) REFERENCES `tournamentparticipantteam` (`tour_p_t_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_mpd_symbol` FOREIGN KEY (`symbol_id`) REFERENCES `symbol` (`symbol_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.matchpointdetails: ~1 rows (approximately)
/*!40000 ALTER TABLE `matchpointdetails` DISABLE KEYS */;
INSERT IGNORE INTO `matchpointdetails` (`match_point_id`, `tournament_match_id`, `inning_number`, `turn_number`, `defender_id`, `attacker_id`, `assist_id`, `wicket_status`, `turn_closure`, `run_time`, `per_time`, `symbol_id`) VALUES
	(2, 6, 1, 1, 82, 76, 76, '1', '0', 130, 130, 5),
	(12, 9, 1, 1, 142, 159, 159, '1', '0', 203, 203, 2),
	(13, 9, 1, 1, 143, 163, 163, '1', '0', 456, 456, 1),
	(14, 9, 1, 1, 144, 156, 156, '1', '0', 464, 8, 1),
	(15, 9, 1, 1, 145, 164, 164, '1', '0', 481, 25, 1);
/*!40000 ALTER TABLE `matchpointdetails` ENABLE KEYS */;


-- Dumping structure for table digitourapp.matchtossdetails
CREATE TABLE IF NOT EXISTS `matchtossdetails` (
  `tournament_match_id` bigint(20) NOT NULL,
  `toss_won_by` bigint(20) NOT NULL,
  `elected_to` varchar(10) NOT NULL,
  PRIMARY KEY (`tournament_match_id`),
  KEY `fk_mtd_toss_won` (`toss_won_by`),
  CONSTRAINT `fk_mtd_toss_won` FOREIGN KEY (`toss_won_by`) REFERENCES `tournamentparticipant` (`tournament_participant_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_mtd_tour_mtch` FOREIGN KEY (`tournament_match_id`) REFERENCES `tournamentmatchdetails` (`tournament_match_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.matchtossdetails: ~7 rows (approximately)
/*!40000 ALTER TABLE `matchtossdetails` DISABLE KEYS */;
INSERT IGNORE INTO `matchtossdetails` (`tournament_match_id`, `toss_won_by`, `elected_to`) VALUES
	(9, 18, 'CHASE'),
	(10, 20, 'CHASE');
/*!40000 ALTER TABLE `matchtossdetails` ENABLE KEYS */;


-- Dumping structure for table digitourapp.matchturndetails
CREATE TABLE IF NOT EXISTS `matchturndetails` (
  `match_turn_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `inning_number` bigint(20) NOT NULL,
  `turn_number` bigint(20) NOT NULL,
  `status` varchar(10) NOT NULL,
  `match_id` bigint(20) NOT NULL,
  PRIMARY KEY (`match_turn_id`),
  KEY `fk_mid_mtch_id` (`match_id`),
  CONSTRAINT `fk_mid_mtch_id` FOREIGN KEY (`match_id`) REFERENCES `tournamentmatchdetails` (`tournament_match_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.matchturndetails: ~8 rows (approximately)
/*!40000 ALTER TABLE `matchturndetails` DISABLE KEYS */;
INSERT IGNORE INTO `matchturndetails` (`match_turn_id`, `inning_number`, `turn_number`, `status`, `match_id`) VALUES
	(13, 1, 1, 'COMPLETED', 9),
	(14, 1, 2, 'NOTSTARTED', 9),
	(15, 2, 1, 'NOTSTARTED', 9),
	(16, 2, 2, 'NOTSTARTED', 9),
	(17, 1, 1, 'NOTSTARTED', 10),
	(18, 1, 2, 'NOTSTARTED', 10),
	(19, 2, 1, 'NOTSTARTED', 10),
	(20, 2, 2, 'NOTSTARTED', 10);
/*!40000 ALTER TABLE `matchturndetails` ENABLE KEYS */;


-- Dumping structure for table digitourapp.playerprofile
CREATE TABLE IF NOT EXISTS `playerprofile` (
  `player_profile_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `middle_name` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_of_birth` date NOT NULL,
  `photo` blob,
  `height` int(3) DEFAULT NULL,
  `weight` int(3) DEFAULT NULL,
  `total_tours_participated` int(11) DEFAULT NULL,
  `achievements` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `city_id` bigint(20) NOT NULL,
  `major_skill` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `contact` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `team_id` bigint(20) NOT NULL,
  PRIMARY KEY (`player_profile_id`),
  KEY `fk_city` (`city_id`),
  KEY `fk_pp_team` (`team_id`),
  CONSTRAINT `fk_city` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pp_team` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table digitourapp.playerprofile: ~29 rows (approximately)
/*!40000 ALTER TABLE `playerprofile` DISABLE KEYS */;
INSERT IGNORE INTO `playerprofile` (`player_profile_id`, `first_name`, `middle_name`, `last_name`, `date_of_birth`, `photo`, `height`, `weight`, `total_tours_participated`, `achievements`, `city_id`, `major_skill`, `role`, `gender`, `contact`, `team_id`) VALUES
	(1, 'Aditya S', NULL, NULL, '2015-10-01', NULL, 190, 65, 5, '5 times Bp', 1, 'DIVE', 'ALLROUNDER', 'MALE', '8087547907', 1),
	(2, 'Shantanu I', NULL, NULL, '2015-10-01', NULL, 150, 52, 25, '9 times BP', 1, 'DIVE', 'ALLROUNDER', 'MALE', '80875777', 1),
	(3, 'Tushar C', NULL, NULL, '2007-10-01', NULL, 160, 66, 65, '15 Times BP', 1, 'DIVE', 'ALLROUNDER', 'MALE', '50544414', 1),
	(4, 'Kunal W', NULL, NULL, '2004-10-01', NULL, 190, 55, 66, '66 Times Bp', 1, 'DIVE', 'ALLROUNDER', 'MALE', '665541', 1),
	(5, 'ABC', NULL, NULL, '2010-10-01', NULL, 200, 55, 55, '10 Times BP', 1, 'DIVE', 'ALLROUNDER', 'MALE', '666655', 2),
	(6, 'fname1', NULL, 'lname1', '2015-10-02', NULL, 150, 60, 55, 'Test achievements1', 1, 'DIVE', 'ALLROUNDER', 'MALE', '808855471', 3),
	(7, 'fname2', NULL, 'lname2', '2015-10-02', NULL, 150, 60, 55, 'Test achievements2', 1, 'DIVE', 'ALLROUNDER', 'MALE', '808855472', 3),
	(8, 'fname3', NULL, 'lname3', '2015-10-02', NULL, 150, 60, 55, 'Test achievements3', 1, 'DIVE', 'ALLROUNDER', 'MALE', '808855473', 3),
	(9, 'fname4', NULL, 'lname4', '2015-10-02', NULL, 150, 60, 55, 'Test achievements4', 1, 'DIVE', 'ALLROUNDER', 'MALE', '808855474', 3),
	(10, 'fname5', NULL, 'lname5', '2015-10-02', NULL, 150, 60, 55, 'Test achievements5', 1, 'DIVE', 'ALLROUNDER', 'MALE', '808855475', 3),
	(11, 'fname6', NULL, 'lname6', '2015-10-02', NULL, 150, 60, 55, 'Test achievements6', 1, 'DIVE', 'ALLROUNDER', 'MALE', '808855476', 3),
	(12, 'fname7', NULL, 'lname7', '2015-10-02', NULL, 150, 60, 55, 'Test achievements7', 1, 'DIVE', 'ALLROUNDER', 'MALE', '808855477', 3),
	(13, 'fname8', NULL, 'lname8', '2015-10-02', NULL, 150, 60, 55, 'Test achievements8', 1, 'DIVE', 'ALLROUNDER', 'MALE', '808855478', 3),
	(14, 'fname9', NULL, 'lname9', '2015-10-02', NULL, 150, 60, 55, 'Test achievements9', 1, 'DIVE', 'ALLROUNDER', 'MALE', '808855479', 3),
	(15, 'fname10', NULL, 'lname10', '2015-10-02', NULL, 150, 60, 55, 'Test achievements10', 1, 'DIVE', 'ALLROUNDER', 'MALE', '8088554710', 3),
	(16, 'fname11', NULL, 'lname11', '2015-10-02', NULL, 150, 60, 55, 'Test achievements11', 1, 'DIVE', 'ALLROUNDER', 'MALE', '8088554711', 3),
	(17, 'fname12', NULL, 'lname12', '2015-10-02', NULL, 150, 60, 55, 'Test achievements12', 1, 'DIVE', 'ALLROUNDER', 'MALE', '8088554712', 3),
	(18, 'dfname1', NULL, 'dlname1', '2015-10-06', NULL, 150, 60, 55, 'Dream Test achievements1', 2, 'DIVE', 'ALLROUNDER', 'MALE', 'DREAM-NUMBER-1', 4),
	(19, 'dfname2', NULL, 'dlname2', '2015-10-06', NULL, 150, 60, 55, 'Dream Test achievements2', 2, 'DIVE', 'ALLROUNDER', 'MALE', 'DREAM-NUMBER-2', 4),
	(20, 'dfname3', NULL, 'dlname3', '2015-10-06', NULL, 150, 60, 55, 'Dream Test achievements3', 2, 'DIVE', 'ALLROUNDER', 'MALE', 'DREAM-NUMBER-3', 4),
	(21, 'dfname4', NULL, 'dlname4', '2015-10-06', NULL, 150, 60, 55, 'Dream Test achievements4', 2, 'DIVE', 'ALLROUNDER', 'MALE', 'DREAM-NUMBER-4', 4),
	(22, 'dfname5', NULL, 'dlname5', '2015-10-06', NULL, 150, 60, 55, 'Dream Test achievements5', 2, 'DIVE', 'ALLROUNDER', 'MALE', 'DREAM-NUMBER-5', 4),
	(23, 'dfname6', NULL, 'dlname6', '2015-10-06', NULL, 150, 60, 55, 'Dream Test achievements6', 2, 'DIVE', 'ALLROUNDER', 'MALE', 'DREAM-NUMBER-6', 4),
	(24, 'dfname7', NULL, 'dlname7', '2015-10-06', NULL, 150, 60, 55, 'Dream Test achievements7', 2, 'DIVE', 'ALLROUNDER', 'MALE', 'DREAM-NUMBER-7', 4),
	(25, 'dfname8', NULL, 'dlname8', '2015-10-06', NULL, 150, 60, 55, 'Dream Test achievements8', 2, 'DIVE', 'ALLROUNDER', 'MALE', 'DREAM-NUMBER-8', 4),
	(26, 'dfname9', NULL, 'dlname9', '2015-10-06', NULL, 150, 60, 55, 'Dream Test achievements9', 2, 'DIVE', 'ALLROUNDER', 'MALE', 'DREAM-NUMBER-9', 4),
	(27, 'dfname10', NULL, 'dlname10', '2015-10-06', NULL, 150, 60, 55, 'Dream Test achievements10', 2, 'DIVE', 'ALLROUNDER', 'MALE', 'DREAM-NUMBER-10', 4),
	(28, 'dfname11', NULL, 'dlname11', '2015-10-06', NULL, 150, 60, 55, 'Dream Test achievements11', 2, 'DIVE', 'ALLROUNDER', 'MALE', 'DREAM-NUMBER-11', 4),
	(29, 'dfname12', NULL, 'dlname12', '2015-10-06', NULL, 150, 60, 55, 'Dream Test achievements12', 2, 'DIVE', 'ALLROUNDER', 'MALE', 'DREAM-NUMBER-12', 4);
/*!40000 ALTER TABLE `playerprofile` ENABLE KEYS */;


-- Dumping structure for table digitourapp.statecountry
CREATE TABLE IF NOT EXISTS `statecountry` (
  `state_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `state_name` varchar(100) NOT NULL,
  `country_name` varchar(50) NOT NULL,
  PRIMARY KEY (`state_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.statecountry: ~0 rows (approximately)
/*!40000 ALTER TABLE `statecountry` DISABLE KEYS */;
INSERT IGNORE INTO `statecountry` (`state_id`, `state_name`, `country_name`) VALUES
	(1, 'Maharashtra', 'India');
/*!40000 ALTER TABLE `statecountry` ENABLE KEYS */;


-- Dumping structure for table digitourapp.symbol
CREATE TABLE IF NOT EXISTS `symbol` (
  `symbol_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Description` varchar(500) NOT NULL,
  PRIMARY KEY (`symbol_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.symbol: ~4 rows (approximately)
/*!40000 ALTER TABLE `symbol` DISABLE KEYS */;
INSERT IGNORE INTO `symbol` (`symbol_id`, `Description`) VALUES
	(1, 'Pole'),
	(2, 'Dive'),
	(3, 'Out Of Field'),
	(4, 'Late Entry'),
	(5, 'Simple Touch');
/*!40000 ALTER TABLE `symbol` ENABLE KEYS */;


-- Dumping structure for table digitourapp.team
CREATE TABLE IF NOT EXISTS `team` (
  `team_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `team_name` varchar(500) NOT NULL,
  `founder_name` varchar(500) NOT NULL,
  `description` varchar(500) NOT NULL,
  `club_address_line1` varchar(500) NOT NULL,
  `club_address_line2` varchar(500) DEFAULT NULL,
  `achievements` varchar(500) DEFAULT NULL,
  `city_id` bigint(20) NOT NULL,
  `photo` blob,
  `team_type` varchar(10) NOT NULL,
  `established_in` date NOT NULL,
  PRIMARY KEY (`team_id`),
  KEY `fk_team_city` (`city_id`),
  CONSTRAINT `fk_team_city` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.team: ~3 rows (approximately)
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT IGNORE INTO `team` (`team_id`, `team_name`, `founder_name`, `description`, `club_address_line1`, `club_address_line2`, `achievements`, `city_id`, `photo`, `team_type`, `established_in`) VALUES
	(1, 'Nav Maharahtra Sangh', 'PATANKAR SIR', 'XYZ', 'SP College Ground', NULL, 'Achievements', 1, NULL, 'CLUB', '1960-10-01'),
	(2, 'Sanmitra Sangh', 'Haribhau Sane', 'XYZ', 'Karishma Society', NULL, 'Achievements', 2, NULL, 'CLUB', '1968-10-01'),
	(3, 'Test team1', 'Test Founder', 'Test description1', 'Test address line - test1', NULL, 'Test achievements1', 1, NULL, 'CLUB', '2015-10-02'),
	(4, 'Dream Test team1', 'Dream Test Founder', 'Dream Test description1', 'Dream Test address line - test1', NULL, 'Dream Test achievements1', 2, NULL, 'CLUB', '2015-10-06');
/*!40000 ALTER TABLE `team` ENABLE KEYS */;


-- Dumping structure for table digitourapp.tournament
CREATE TABLE IF NOT EXISTS `tournament` (
  `tournament_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tournament_name` varchar(500) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `location` varchar(500) NOT NULL,
  `prize` double DEFAULT NULL,
  `other_details` varchar(500) DEFAULT NULL,
  `tour_type` varchar(500) NOT NULL,
  `tour_status` varchar(10) NOT NULL,
  `tournament_start_date` date DEFAULT NULL,
  `tournament_end_date` date DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `age_group` varchar(10) NOT NULL,
  PRIMARY KEY (`tournament_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.tournament: ~8 rows (approximately)
/*!40000 ALTER TABLE `tournament` DISABLE KEYS */;
INSERT IGNORE INTO `tournament` (`tournament_id`, `tournament_name`, `description`, `location`, `prize`, `other_details`, `tour_type`, `tour_status`, `tournament_start_date`, `tournament_end_date`, `created_date`, `age_group`) VALUES
	(1, 'Test Tournament', 'Tournament description', 'SP College', 0, NULL, 'ALLINDIA', 'QUICKMATCH', NULL, NULL, '2015-10-04 00:58:00', 'OPEN'),
	(2, 'Test Tournament', 'Tournament description', 'SP College', 0, NULL, 'ALLINDIA', 'QUICKMATCH', NULL, NULL, '2015-10-04 01:11:17', 'OPEN'),
	(3, 'Test Tournament', 'Tournament description', 'SP College', 0, NULL, 'ALLINDIA', 'QUICKMATCH', NULL, NULL, '2015-10-04 01:20:04', 'OPEN'),
	(4, 'Test Tournament', 'Tournament description', 'SP College', 0, NULL, 'ALLINDIA', 'QUICKMATCH', NULL, NULL, '2015-10-05 14:45:12', 'OPEN'),
	(5, 'Test Tournament', 'Tournament description', 'SP College', 0, NULL, 'ALLINDIA', 'QUICKMATCH', NULL, NULL, '2015-10-06 13:56:34', 'OPEN'),
	(6, 'Test Tournament', 'Tournament description', 'SP College', 0, NULL, 'ALLINDIA', 'QUICKMATCH', NULL, NULL, '2015-10-06 16:32:43', 'OPEN'),
	(10, 'Test Tournament', 'Tournament description', 'SP College', 0, NULL, 'ALLINDIA', 'QUICKMATCH', NULL, NULL, '2015-10-12 16:50:53', 'OPEN'),
	(11, 'Test Tournament', 'Tournament description', 'SP College', 0, NULL, 'ALLINDIA', 'QUICKMATCH', NULL, NULL, '2015-10-12 16:56:05', 'OPEN');
/*!40000 ALTER TABLE `tournament` ENABLE KEYS */;


-- Dumping structure for table digitourapp.tournamentmatchdetails
CREATE TABLE IF NOT EXISTS `tournamentmatchdetails` (
  `tournament_match_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `team_participant1_id` bigint(20) NOT NULL,
  `team_participant2_id` bigint(20) NOT NULL,
  `tournament_id` bigint(20) NOT NULL,
  PRIMARY KEY (`tournament_match_id`),
  KEY `fk_tmd_parti1` (`team_participant1_id`),
  KEY `fk_tmd_parti2` (`team_participant2_id`),
  CONSTRAINT `fk_tmd_parti1` FOREIGN KEY (`team_participant1_id`) REFERENCES `tournamentparticipant` (`tournament_participant_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tmd_parti2` FOREIGN KEY (`team_participant2_id`) REFERENCES `tournamentparticipant` (`tournament_participant_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.tournamentmatchdetails: ~7 rows (approximately)
/*!40000 ALTER TABLE `tournamentmatchdetails` DISABLE KEYS */;
INSERT IGNORE INTO `tournamentmatchdetails` (`tournament_match_id`, `team_participant1_id`, `team_participant2_id`, `tournament_id`) VALUES
	(9, 17, 18, 10),
	(10, 19, 20, 11);
/*!40000 ALTER TABLE `tournamentmatchdetails` ENABLE KEYS */;


-- Dumping structure for table digitourapp.tournamentofficial
CREATE TABLE IF NOT EXISTS `tournamentofficial` (
  `official_profile_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(100) NOT NULL,
  `date_of_birth` date NOT NULL,
  `address_line1` varchar(500) NOT NULL,
  `address_line2` varchar(500) DEFAULT NULL,
  `contact1` varchar(20) NOT NULL,
  `contact2` varchar(20) DEFAULT NULL,
  `city_id` bigint(20) NOT NULL,
  PRIMARY KEY (`official_profile_id`),
  KEY `fk_ofp_city` (`city_id`),
  CONSTRAINT `fk_ofp_city` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.tournamentofficial: ~0 rows (approximately)
/*!40000 ALTER TABLE `tournamentofficial` DISABLE KEYS */;
/*!40000 ALTER TABLE `tournamentofficial` ENABLE KEYS */;


-- Dumping structure for table digitourapp.tournamentparticipant
CREATE TABLE IF NOT EXISTS `tournamentparticipant` (
  `tournament_participant_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tournament_id` bigint(20) NOT NULL,
  `team_id` bigint(20) NOT NULL,
  `group_id` bigint(20) NOT NULL,
  PRIMARY KEY (`tournament_participant_id`),
  KEY `tp_group` (`group_id`),
  KEY `tp_team` (`team_id`),
  KEY `tp_tournament` (`tournament_id`),
  CONSTRAINT `tp_group` FOREIGN KEY (`group_id`) REFERENCES `group` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tp_team` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tp_tournament` FOREIGN KEY (`tournament_id`) REFERENCES `tournament` (`tournament_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.tournamentparticipant: ~14 rows (approximately)
/*!40000 ALTER TABLE `tournamentparticipant` DISABLE KEYS */;
INSERT IGNORE INTO `tournamentparticipant` (`tournament_participant_id`, `tournament_id`, `team_id`, `group_id`) VALUES
	(17, 10, 3, 1),
	(18, 10, 4, 1),
	(19, 11, 3, 1),
	(20, 11, 4, 1);
/*!40000 ALTER TABLE `tournamentparticipant` ENABLE KEYS */;


-- Dumping structure for table digitourapp.tournamentparticipantpoints
CREATE TABLE IF NOT EXISTS `tournamentparticipantpoints` (
  `tour_partipant_point_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fk_tournament_partipant_id` bigint(20) NOT NULL,
  `matches_won` bigint(20) NOT NULL,
  `matches_lost` bigint(20) NOT NULL,
  `matches_drawn` bigint(20) NOT NULL,
  `total_wickets` bigint(20) NOT NULL,
  `total_points` bigint(20) NOT NULL,
  PRIMARY KEY (`tour_partipant_point_id`),
  UNIQUE KEY `fk_tournament_partipant_id` (`fk_tournament_partipant_id`),
  CONSTRAINT `fk_tour_parti_id` FOREIGN KEY (`fk_tournament_partipant_id`) REFERENCES `tournamentparticipant` (`tournament_participant_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.tournamentparticipantpoints: ~0 rows (approximately)
/*!40000 ALTER TABLE `tournamentparticipantpoints` DISABLE KEYS */;
/*!40000 ALTER TABLE `tournamentparticipantpoints` ENABLE KEYS */;


-- Dumping structure for table digitourapp.tournamentparticipantteam
CREATE TABLE IF NOT EXISTS `tournamentparticipantteam` (
  `tour_p_t_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tournament_participant_id` bigint(20) NOT NULL,
  `player_profile_id` bigint(20) NOT NULL,
  `player_chase_number` bigint(20) NOT NULL,
  PRIMARY KEY (`tour_p_t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=190 DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.tournamentparticipantteam: ~189 rows (approximately)
/*!40000 ALTER TABLE `tournamentparticipantteam` DISABLE KEYS */;
INSERT IGNORE INTO `tournamentparticipantteam` (`tour_p_t_id`, `tournament_participant_id`, `player_profile_id`, `player_chase_number`) VALUES
	(1, 3, 1, 1),
	(2, 3, 2, 2),
	(3, 3, 3, 3),
	(4, 3, 4, 4),
	(5, 4, 5, 1),
	(6, 5, 1, 1),
	(7, 5, 2, 2),
	(8, 5, 3, 3),
	(9, 5, 4, 4),
	(10, 6, 6, 1),
	(11, 6, 7, 2),
	(12, 6, 8, 3),
	(13, 6, 9, 4),
	(14, 6, 10, 5),
	(15, 6, 11, 6),
	(16, 6, 12, 7),
	(17, 6, 13, 8),
	(18, 6, 14, 9),
	(19, 6, 15, 10),
	(20, 6, 16, 11),
	(21, 6, 17, 12),
	(22, 7, 6, 1),
	(23, 7, 7, 2),
	(24, 7, 8, 3),
	(25, 7, 9, 4),
	(26, 7, 10, 5),
	(27, 7, 11, 6),
	(28, 7, 12, 7),
	(29, 7, 13, 8),
	(30, 7, 14, 9),
	(31, 7, 15, 10),
	(32, 7, 16, 11),
	(33, 7, 17, 12),
	(34, 8, 18, 1),
	(35, 8, 19, 2),
	(36, 8, 20, 3),
	(37, 8, 21, 4),
	(38, 8, 22, 5),
	(39, 8, 23, 6),
	(40, 8, 24, 7),
	(41, 8, 25, 8),
	(42, 8, 26, 9),
	(43, 8, 27, 10),
	(44, 8, 28, 11),
	(45, 8, 29, 12),
	(46, 9, 6, 1),
	(47, 9, 7, 2),
	(48, 9, 8, 3),
	(49, 9, 9, 4),
	(50, 9, 10, 5),
	(51, 9, 11, 6),
	(52, 9, 12, 7),
	(53, 9, 13, 8),
	(54, 9, 14, 9),
	(55, 9, 15, 10),
	(56, 9, 16, 11),
	(57, 9, 17, 12),
	(58, 10, 18, 1),
	(59, 10, 19, 2),
	(60, 10, 20, 3),
	(61, 10, 21, 4),
	(62, 10, 22, 5),
	(63, 10, 23, 6),
	(64, 10, 24, 7),
	(65, 10, 25, 8),
	(66, 10, 26, 9),
	(67, 10, 27, 10),
	(68, 10, 28, 11),
	(69, 10, 29, 12),
	(70, 11, 6, 1),
	(71, 11, 7, 2),
	(72, 11, 8, 3),
	(73, 11, 9, 4),
	(74, 11, 10, 5),
	(75, 11, 11, 6),
	(76, 11, 12, 7),
	(77, 11, 13, 8),
	(78, 11, 14, 9),
	(79, 11, 15, 10),
	(80, 11, 16, 11),
	(81, 11, 17, 12),
	(82, 12, 18, 1),
	(83, 12, 19, 2),
	(84, 12, 20, 3),
	(85, 12, 21, 4),
	(86, 12, 22, 5),
	(87, 12, 23, 6),
	(88, 12, 24, 7),
	(89, 12, 25, 8),
	(90, 12, 26, 9),
	(91, 12, 27, 10),
	(92, 12, 28, 11),
	(93, 12, 29, 12),
	(94, 13, 6, 1),
	(95, 13, 7, 2),
	(96, 13, 8, 3),
	(97, 13, 9, 4),
	(98, 13, 10, 5),
	(99, 13, 11, 6),
	(100, 13, 12, 7),
	(101, 13, 13, 8),
	(102, 13, 14, 9),
	(103, 13, 15, 10),
	(104, 13, 16, 11),
	(105, 13, 17, 12),
	(106, 14, 18, 1),
	(107, 14, 19, 2),
	(108, 14, 20, 3),
	(109, 14, 21, 4),
	(110, 14, 22, 5),
	(111, 14, 23, 6),
	(112, 14, 24, 7),
	(113, 14, 25, 8),
	(114, 14, 26, 9),
	(115, 14, 27, 10),
	(116, 14, 28, 11),
	(117, 14, 29, 12),
	(118, 15, 6, 1),
	(119, 15, 7, 2),
	(120, 15, 8, 3),
	(121, 15, 9, 4),
	(122, 15, 10, 5),
	(123, 15, 11, 6),
	(124, 15, 12, 7),
	(125, 15, 13, 8),
	(126, 15, 14, 9),
	(127, 15, 15, 10),
	(128, 15, 16, 11),
	(129, 15, 17, 12),
	(130, 16, 18, 1),
	(131, 16, 19, 2),
	(132, 16, 20, 3),
	(133, 16, 21, 4),
	(134, 16, 22, 5),
	(135, 16, 23, 6),
	(136, 16, 24, 7),
	(137, 16, 25, 8),
	(138, 16, 26, 9),
	(139, 16, 27, 10),
	(140, 16, 28, 11),
	(141, 16, 29, 12),
	(142, 17, 6, 1),
	(143, 17, 7, 2),
	(144, 17, 8, 3),
	(145, 17, 9, 4),
	(146, 17, 10, 5),
	(147, 17, 11, 6),
	(148, 17, 12, 7),
	(149, 17, 13, 8),
	(150, 17, 14, 9),
	(151, 17, 15, 10),
	(152, 17, 16, 11),
	(153, 17, 17, 12),
	(154, 18, 18, 1),
	(155, 18, 19, 2),
	(156, 18, 20, 3),
	(157, 18, 21, 4),
	(158, 18, 22, 5),
	(159, 18, 23, 6),
	(160, 18, 24, 7),
	(161, 18, 25, 8),
	(162, 18, 26, 9),
	(163, 18, 27, 10),
	(164, 18, 28, 11),
	(165, 18, 29, 12),
	(166, 19, 6, 1),
	(167, 19, 7, 2),
	(168, 19, 8, 3),
	(169, 19, 9, 4),
	(170, 19, 10, 5),
	(171, 19, 11, 6),
	(172, 19, 12, 7),
	(173, 19, 13, 8),
	(174, 19, 14, 9),
	(175, 19, 15, 10),
	(176, 19, 16, 11),
	(177, 19, 17, 12),
	(178, 20, 18, 1),
	(179, 20, 19, 2),
	(180, 20, 20, 3),
	(181, 20, 21, 4),
	(182, 20, 22, 5),
	(183, 20, 23, 6),
	(184, 20, 24, 7),
	(185, 20, 25, 8),
	(186, 20, 26, 9),
	(187, 20, 27, 10),
	(188, 20, 28, 11),
	(189, 20, 29, 12);
/*!40000 ALTER TABLE `tournamentparticipantteam` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
