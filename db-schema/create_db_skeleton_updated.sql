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
  `defence_id` bigint(20) NOT NULL,
  `attacker_id` bigint(20) NOT NULL,
  `assist_id` bigint(20) NOT NULL,
  `run_time` time NOT NULL,
  `per_time` time NOT NULL,
  `symbol_id` bigint(20) NOT NULL,
  PRIMARY KEY (`match_point_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.matchpointdetails: ~0 rows (approximately)
/*!40000 ALTER TABLE `matchpointdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `matchpointdetails` ENABLE KEYS */;


-- Dumping structure for table digitourapp.matchtossdetails
CREATE TABLE IF NOT EXISTS `matchtossdetails` (
  `toss_details_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tournament_match_id` bigint(20) NOT NULL,
  `toss_won_by` bigint(20) NOT NULL,
  `elected_to` varchar(10) NOT NULL,
  PRIMARY KEY (`toss_details_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.matchtossdetails: ~2 rows (approximately)
/*!40000 ALTER TABLE `matchtossdetails` DISABLE KEYS */;
INSERT IGNORE INTO `matchtossdetails` (`toss_details_id`, `tournament_match_id`, `toss_won_by`, `elected_to`) VALUES
	(1, 1, 1, 'DEFENCE'),
	(2, 2, 1, 'DEFENCE');
/*!40000 ALTER TABLE `matchtossdetails` ENABLE KEYS */;


-- Dumping structure for table digitourapp.playerprofile
CREATE TABLE IF NOT EXISTS `playerprofile` (
  `player_profile_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
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
  CONSTRAINT `fk_pp_team` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_city` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table digitourapp.playerprofile: ~17 rows (approximately)
/*!40000 ALTER TABLE `playerprofile` DISABLE KEYS */;
INSERT IGNORE INTO `playerprofile` (`player_profile_id`, `full_name`, `date_of_birth`, `photo`, `height`, `weight`, `total_tours_participated`, `achievements`, `city_id`, `major_skill`, `role`, `gender`, `contact`, `team_id`) VALUES
	(1, 'Aditya S', '2015-10-01', NULL, 190, 65, 5, '5 times Bp', 1, 'DIVE', 'ALLROUNDER', 'MALE', '8087547907', 1),
	(2, 'Shantanu I', '2015-10-01', NULL, 150, 52, 25, '9 times BP', 1, 'DIVE', 'ALLROUNDER', 'MALE', '80875777', 1),
	(3, 'Tushar C', '2007-10-01', NULL, 160, 66, 65, '15 Times BP', 1, 'DIVE', 'ALLROUNDER', 'MALE', '50544414', 1),
	(4, 'Kunal W', '2004-10-01', NULL, 190, 55, 66, '66 Times Bp', 1, 'DIVE', 'ALLROUNDER', 'MALE', '665541', 1),
	(5, 'ABC', '2010-10-01', NULL, 200, 55, 55, '10 Times BP', 1, 'DIVE', 'ALLROUNDER', 'MALE', '666655', 2),
	(6, 'Player Test1', '2015-10-02', NULL, 150, 60, 55, 'Test achievements1', 1, 'DIVE', 'ALLROUNDER', 'MALE', '808855471', 3),
	(7, 'Player Test2', '2015-10-02', NULL, 150, 60, 55, 'Test achievements2', 1, 'DIVE', 'ALLROUNDER', 'MALE', '808855472', 3),
	(8, 'Player Test3', '2015-10-02', NULL, 150, 60, 55, 'Test achievements3', 1, 'DIVE', 'ALLROUNDER', 'MALE', '808855473', 3),
	(9, 'Player Test4', '2015-10-02', NULL, 150, 60, 55, 'Test achievements4', 1, 'DIVE', 'ALLROUNDER', 'MALE', '808855474', 3),
	(10, 'Player Test5', '2015-10-02', NULL, 150, 60, 55, 'Test achievements5', 1, 'DIVE', 'ALLROUNDER', 'MALE', '808855475', 3),
	(11, 'Player Test6', '2015-10-02', NULL, 150, 60, 55, 'Test achievements6', 1, 'DIVE', 'ALLROUNDER', 'MALE', '808855476', 3),
	(12, 'Player Test7', '2015-10-02', NULL, 150, 60, 55, 'Test achievements7', 1, 'DIVE', 'ALLROUNDER', 'MALE', '808855477', 3),
	(13, 'Player Test8', '2015-10-02', NULL, 150, 60, 55, 'Test achievements8', 1, 'DIVE', 'ALLROUNDER', 'MALE', '808855478', 3),
	(14, 'Player Test9', '2015-10-02', NULL, 150, 60, 55, 'Test achievements9', 1, 'DIVE', 'ALLROUNDER', 'MALE', '808855479', 3),
	(15, 'Player Test10', '2015-10-02', NULL, 150, 60, 55, 'Test achievements10', 1, 'DIVE', 'ALLROUNDER', 'MALE', '8088554710', 3),
	(16, 'Player Test11', '2015-10-02', NULL, 150, 60, 55, 'Test achievements11', 1, 'DIVE', 'ALLROUNDER', 'MALE', '8088554711', 3),
	(17, 'Player Test12', '2015-10-02', NULL, 150, 60, 55, 'Test achievements12', 1, 'DIVE', 'ALLROUNDER', 'MALE', '8088554712', 3);
/*!40000 ALTER TABLE `playerprofile` ENABLE KEYS */;


-- Dumping structure for table digitourapp.statecountry
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.team: ~3 rows (approximately)
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT IGNORE INTO `team` (`team_id`, `team_name`, `founder_name`, `description`, `club_address_line1`, `club_address_line2`, `achievements`, `city_id`, `photo`, `team_type`, `established_in`) VALUES
	(1, 'Nav Maharahtra Sangh', 'PATANKAR SIR', 'XYZ', 'SP College Ground', NULL, 'Achievements', 1, NULL, 'CLUB', '1960-10-01'),
	(2, 'Sanmitra Sangh', 'Haribhau Sane', 'XYZ', 'Karishma Society', NULL, 'Achievements', 2, NULL, 'CLUB', '1968-10-01'),
	(3, 'Test team1', 'Test Founder', 'Test description1', 'Test address line - test1', NULL, 'Test achievements1', 1, NULL, 'CLUB', '2015-10-02');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.tournament: ~3 rows (approximately)
/*!40000 ALTER TABLE `tournament` DISABLE KEYS */;
INSERT IGNORE INTO `tournament` (`tournament_id`, `tournament_name`, `description`, `location`, `prize`, `other_details`, `tour_type`, `tour_status`, `tournament_start_date`, `tournament_end_date`, `created_date`, `age_group`) VALUES
	(1, 'Test Tournament', 'Tournament description', 'SP College', 0, NULL, 'ALLINDIA', 'QUICKMATCH', NULL, NULL, '2015-10-04 00:58:00', 'OPEN'),
	(2, 'Test Tournament', 'Tournament description', 'SP College', 0, NULL, 'ALLINDIA', 'QUICKMATCH', NULL, NULL, '2015-10-04 01:11:17', 'OPEN'),
	(3, 'Test Tournament', 'Tournament description', 'SP College', 0, NULL, 'ALLINDIA', 'QUICKMATCH', NULL, NULL, '2015-10-04 01:20:04', 'OPEN');
/*!40000 ALTER TABLE `tournament` ENABLE KEYS */;


-- Dumping structure for table digitourapp.tournamentmatchdetails
CREATE TABLE IF NOT EXISTS `tournamentmatchdetails` (
  `tournament_match_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `team_participant1_id` bigint(20) NOT NULL,
  `team_participant2_id` bigint(20) NOT NULL,
  `tournament_id` bigint(20) NOT NULL,
  PRIMARY KEY (`tournament_match_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.tournamentmatchdetails: ~2 rows (approximately)
/*!40000 ALTER TABLE `tournamentmatchdetails` DISABLE KEYS */;
INSERT IGNORE INTO `tournamentmatchdetails` (`tournament_match_id`, `team_participant1_id`, `team_participant2_id`, `tournament_id`) VALUES
	(1, 1, 2, 2),
	(2, 1, 2, 3);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.tournamentparticipant: ~4 rows (approximately)
/*!40000 ALTER TABLE `tournamentparticipant` DISABLE KEYS */;
INSERT IGNORE INTO `tournamentparticipant` (`tournament_participant_id`, `tournament_id`, `team_id`, `group_id`) VALUES
	(1, 2, 1, 1),
	(2, 2, 1, 1),
	(3, 3, 1, 1),
	(4, 3, 2, 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table digitourapp.tournamentparticipantteam: ~5 rows (approximately)
/*!40000 ALTER TABLE `tournamentparticipantteam` DISABLE KEYS */;
INSERT IGNORE INTO `tournamentparticipantteam` (`tour_p_t_id`, `tournament_participant_id`, `player_profile_id`, `player_chase_number`) VALUES
	(1, 3, 1, 1),
	(2, 3, 2, 2),
	(3, 3, 3, 3),
	(4, 3, 4, 4),
	(5, 4, 5, 1);
/*!40000 ALTER TABLE `tournamentparticipantteam` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
