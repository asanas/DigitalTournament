CREATE TABLE IF NOT EXISTS `player_profile_master` (
	`player_profile_id` bigint NOT NULL AUTO_INCREMENT,
	`name` varchar(500) NOT NULL,
	`date_of_birth` DATE NOT NULL,
	`photo` blob,
	`height` varchar(10),
	`weight` double,
	`total_tours_participated` int,
	`achievements` varchar(500),
	`fk_team_id` bigint NOT NULL,
	`fk_city_id` bigint NOT NULL,
	`fk_major_skill_id` bigint,
	`fk_role_id` bigint,
	`gender` varchar(1) NOT NULL,
	`contact` varchar(20) NOT NULL,
	PRIMARY KEY (`player_profile_id`)
);

CREATE TABLE IF NOT EXISTS `team_master` (
	`team_id` bigint NOT NULL AUTO_INCREMENT,
	`name` varchar(500) NOT NULL,
	`founder_name` varchar(500) NOT NULL,
	`description` varchar(500) NOT NULL,
	`club_address_line1` varchar(500) NOT NULL,
	`club_address_line2` varchar(500),
	`achievements` varchar(500),
	`fk_city_id` bigint NOT NULL,
	`photo` blob,
	`team_type` varchar(10) NOT NULL,
	`established_in` DATE NOT NULL,
	PRIMARY KEY (`team_id`)
);

CREATE TABLE IF NOT EXISTS `city_master` (
	`city_id` bigint NOT NULL AUTO_INCREMENT,
	`city_name` varchar(500) NOT NULL,
	`fk_state_id` bigint NOT NULL,
	PRIMARY KEY (`city_id`)
);

CREATE TABLE IF NOT EXISTS `state_master` (
	`state_id` bigint NOT NULL AUTO_INCREMENT,
	`state_name` varchar(50) NOT NULL,
	`fk_country_id` bigint NOT NULL,
	PRIMARY KEY (`state_id`)
);

CREATE TABLE IF NOT EXISTS `country_master` (
	`country_id` bigint NOT NULL AUTO_INCREMENT,
	`country_name` varchar(500) NOT NULL DEFAULT 'India',
	PRIMARY KEY (`country_id`)
);

CREATE TABLE IF NOT EXISTS `major_skill` (
	`major_skill_id` bigint NOT NULL AUTO_INCREMENT,
	`skill_name` varchar(500) NOT NULL,
	PRIMARY KEY (`major_skill_id`)
);

CREATE TABLE IF NOT EXISTS `role_master` (
	`role_id` bigint NOT NULL AUTO_INCREMENT,
	`role_name` varchar(500) NOT NULL,
	PRIMARY KEY (`role_id`)
);

CREATE TABLE IF NOT EXISTS `tournament_master` (
	`tournament_id` bigint NOT NULL AUTO_INCREMENT,
	`name` varchar(500) NOT NULL,
	`description` varchar(500) NOT NULL,
	`location` varchar(500) NOT NULL,
	`prize` double NOT NULL,
	`other_details` varchar(500) NOT NULL,
	`tour_type` varchar(500) NOT NULL,
	`tour_status` varchar(10) NOT NULL,
	`tournament_start_date` DATE NOT NULL,
	`tournament_end_date` DATE NOT NULL,
	`created_date` DATETIME NOT NULL,
	`age_group` varchar(10) NOT NULL,
	PRIMARY KEY (`tournament_id`)
);

CREATE TABLE IF NOT EXISTS `tournament_participant_master` (
	`tour_participant_id` bigint NOT NULL AUTO_INCREMENT,
	`fk_tournament_id` bigint NOT NULL,
	`fk_team_id` bigint NOT NULL,
	PRIMARY KEY (`tour_participant_id`)
);

CREATE TABLE IF NOT EXISTS `tournament_group_details_master` (
	`tour_group_id` bigint NOT NULL AUTO_INCREMENT,
	`fk_tour_participant_id` bigint NOT NULL,
	`fk_tour_grp_id` bigint NOT NULL,
	`group_type` varchar(50) NOT NULL,
	PRIMARY KEY (`tour_group_id`)
);

CREATE TABLE IF NOT EXISTS `group_master` (
	`group_id` bigint NOT NULL AUTO_INCREMENT,
	`group_name` varchar(100) NOT NULL,
	PRIMARY KEY (`group_id`)
);

CREATE TABLE IF NOT EXISTS `tournament_schedule_date_master` (
	`tournament_schedule_id` bigint NOT NULL AUTO_INCREMENT,
	`tournament_day_date` DATE NOT NULL,
	`fk_tournament_id` bigint NOT NULL,
	`session_time` varchar(10) NOT NULL,
	`day_number` int NOT NULL,
	PRIMARY KEY (`tournament_schedule_id`)
);

CREATE TABLE IF NOT EXISTS `tournament_match_master` (
	`tournament_match_id` bigint NOT NULL AUTO_INCREMENT,
	`fk_team1_id` bigint NOT NULL,
	`fk_team2_id` bigint NOT NULL,
	`fk_tournament_schedule_id` bigint NOT NULL,
	`match_number` bigint NOT NULL,
	`match_details` varchar(500) NOT NULL,
	`fk_scorer1` bigint NOT NULL,
	`fk_scorer2` bigint NOT NULL,
	`fk_umpire1` bigint NOT NULL,
	`fk_umpire2` bigint NOT NULL,
	`fk_match_refree` bigint NOT NULL,
	PRIMARY KEY (`tournament_match_id`)
);

CREATE TABLE IF NOT EXISTS `tournament_schedule_master` (
	`tournament_schedule_id` bigint NOT NULL AUTO_INCREMENT,
	`fk_tournament_schedule_date_id` bigint NOT NULL,
	`fk_tournament_match_id` bigint NOT NULL,
	PRIMARY KEY (`tournament_schedule_id`)
);

CREATE TABLE IF NOT EXISTS `symbol_master` (
	`symbol_id` bigint NOT NULL AUTO_INCREMENT,
	`Description` varchar(500) NOT NULL,
	PRIMARY KEY (`symbol_id`)
);

CREATE TABLE IF NOT EXISTS `toss_details_master` (
	`toss_details_id` bigint NOT NULL AUTO_INCREMENT,
	`fk_tournament_match_id` bigint NOT NULL,
	`fk_toss_won_by` bigint NOT NULL,
	`elected_to` varchar(10) NOT NULL,
	PRIMARY KEY (`toss_details_id`)
);

CREATE TABLE IF NOT EXISTS `match_point_master` (
	`match_point_id` bigint NOT NULL AUTO_INCREMENT,
	`fk_tournament_match_id` bigint NOT NULL,
	`inning_number` bigint NOT NULL,
	`turn_number` bigint NOT NULL,
	`fk_defence_id` bigint NOT NULL,
	`fk_attacker_id` bigint NOT NULL,
	`fk_assist_id` bigint NOT NULL,
	`run_time` TIME NOT NULL,
	`per_time` TIME NOT NULL,
	`symbol` bigint NOT NULL,
	PRIMARY KEY (`match_point_id`)
);

CREATE TABLE IF NOT EXISTS `tournament_match_result_master` (
	`match_result_id` bigint NOT NULL,
	`match_won_by` bigint,
	`won_by_points` bigint NOT NULL,
	`won_by_time` int,
	`result_details` varchar(500),
	`fk_player_of_the_match` bigint NOT NULL,
	PRIMARY KEY (`match_result_id`)
);

CREATE TABLE IF NOT EXISTS `foul_master` (
	`foul_id` bigint NOT NULL AUTO_INCREMENT,
	`foul_name` varchar(50) NOT NULL,
	`foul_description` varchar(500) NOT NULL,
	PRIMARY KEY (`foul_id`)
);

CREATE TABLE IF NOT EXISTS `tournament_match_foul_master` (
	`match_foul_id` bigint NOT NULL AUTO_INCREMENT,
	`fk_tournament_match_id` bigint NOT NULL,
	`fk_foul_id` bigint NOT NULL,
	`fk_team_id` bigint NOT NULL,
	`turn_number` bigint NOT NULL,
	PRIMARY KEY (`match_foul_id`)
);

CREATE TABLE IF NOT EXISTS `official_master` (
	`official_profile_id` bigint NOT NULL AUTO_INCREMENT,
	`first_name` varchar(100) NOT NULL,
	`middle_name` varchar(100) NOT NULL,
	`last_name` varchar(100) NOT NULL,
	`date_of_birth` DATE NOT NULL,
	`address_line1` varchar(500) NOT NULL,
	`address_line2` varchar(500) NOT NULL,
	`contact1` varchar(20) NOT NULL,
	`contact2` varchar(20) NOT NULL,
	`fk_city_id` bigint NOT NULL,
	PRIMARY KEY (`official_profile_id`)
);

CREATE TABLE IF NOT EXISTS `tournament_participant_points_master` (
	`tour_partipant_point_id` bigint NOT NULL AUTO_INCREMENT,
	`fk_tournament_partipant_id` bigint NOT NULL,
	`matches_won` bigint NOT NULL,
	`matches_lost` bigint NOT NULL,
	`matches_drawn` bigint NOT NULL,
	`total_wickets` bigint NOT NULL,
	`total_points` bigint NOT NULL,
	PRIMARY KEY (`tour_partipant_point_id`)
);

CREATE TABLE IF NOT EXISTS `tournament_participant_team_master` (
	`tour_p_t_id` bigint NOT NULL AUTO_INCREMENT,
	`fk_tournament_participant_id` bigint NOT NULL,
	`fk_player_profile_id` bigint NOT NULL,
	`player_chase_number` bigint NOT NULL,
	PRIMARY KEY (`tour_p_t_id`)
);

ALTER TABLE `player_profile_master` ADD CONSTRAINT `player_profile_master_fk0` FOREIGN KEY (`fk_team_id`) REFERENCES `team_master`(`team_id`);

ALTER TABLE `player_profile_master` ADD CONSTRAINT `player_profile_master_fk1` FOREIGN KEY (`fk_city_id`) REFERENCES `city_master`(`city_id`);

ALTER TABLE `player_profile_master` ADD CONSTRAINT `player_profile_master_fk2` FOREIGN KEY (`fk_major_skill_id`) REFERENCES `major_skill`(`major_skill_id`);

ALTER TABLE `player_profile_master` ADD CONSTRAINT `player_profile_master_fk3` FOREIGN KEY (`fk_role_id`) REFERENCES `role_master`(`role_id`);

ALTER TABLE `team_master` ADD CONSTRAINT `team_master_fk0` FOREIGN KEY (`fk_city_id`) REFERENCES `city_master`(`city_id`);

ALTER TABLE `city_master` ADD CONSTRAINT `city_master_fk0` FOREIGN KEY (`fk_state_id`) REFERENCES `state_master`(`state_id`);

ALTER TABLE `state_master` ADD CONSTRAINT `state_master_fk0` FOREIGN KEY (`fk_country_id`) REFERENCES `country_master`(`country_id`);

ALTER TABLE `tournament_participant_master` ADD CONSTRAINT `tournament_participant_master_fk0` FOREIGN KEY (`fk_tournament_id`) REFERENCES `tournament_master`(`tournament_id`);

ALTER TABLE `tournament_participant_master` ADD CONSTRAINT `tournament_participant_master_fk1` FOREIGN KEY (`fk_team_id`) REFERENCES `team_master`(`team_id`);

ALTER TABLE `tournament_group_details_master` ADD CONSTRAINT `tournament_group_details_master_fk0` FOREIGN KEY (`fk_tour_participant_id`) REFERENCES `tournament_participant_master`(`tour_participant_id`);

ALTER TABLE `tournament_group_details_master` ADD CONSTRAINT `tournament_group_details_master_fk1` FOREIGN KEY (`fk_tour_grp_id`) REFERENCES `group_master`(`group_id`);

ALTER TABLE `tournament_schedule_date_master` ADD CONSTRAINT `tournament_schedule_date_master_fk0` FOREIGN KEY (`fk_tournament_id`) REFERENCES `tournament_master`(`tournament_id`);

ALTER TABLE `tournament_match_master` ADD CONSTRAINT `tournament_match_master_fk0` FOREIGN KEY (`fk_team1_id`) REFERENCES `tournament_participant_master`(`tour_participant_id`);

ALTER TABLE `tournament_match_master` ADD CONSTRAINT `tournament_match_master_fk1` FOREIGN KEY (`fk_team2_id`) REFERENCES `tournament_participant_master`(`tour_participant_id`);

ALTER TABLE `tournament_match_master` ADD CONSTRAINT `tournament_match_master_fk2` FOREIGN KEY (`fk_tournament_schedule_id`) REFERENCES `tournament_schedule_master`(`tournament_schedule_id`);

ALTER TABLE `tournament_match_master` ADD CONSTRAINT `tournament_match_master_fk3` FOREIGN KEY (`fk_scorer1`) REFERENCES `official_master`(`official_profile_id`);

ALTER TABLE `tournament_match_master` ADD CONSTRAINT `tournament_match_master_fk4` FOREIGN KEY (`fk_scorer2`) REFERENCES `official_master`(`official_profile_id`);

ALTER TABLE `tournament_match_master` ADD CONSTRAINT `tournament_match_master_fk5` FOREIGN KEY (`fk_umpire1`) REFERENCES `official_master`(`official_profile_id`);

ALTER TABLE `tournament_match_master` ADD CONSTRAINT `tournament_match_master_fk6` FOREIGN KEY (`fk_umpire2`) REFERENCES `official_master`(`official_profile_id`);

ALTER TABLE `tournament_match_master` ADD CONSTRAINT `tournament_match_master_fk7` FOREIGN KEY (`fk_match_refree`) REFERENCES `official_master`(`official_profile_id`);

ALTER TABLE `tournament_schedule_master` ADD CONSTRAINT `tournament_schedule_master_fk0` FOREIGN KEY (`fk_tournament_schedule_date_id`) REFERENCES `tournament_schedule_date_master`(`tournament_schedule_id`);

ALTER TABLE `tournament_schedule_master` ADD CONSTRAINT `tournament_schedule_master_fk1` FOREIGN KEY (`fk_tournament_match_id`) REFERENCES `tournament_match_master`(`tournament_match_id`);

ALTER TABLE `toss_details_master` ADD CONSTRAINT `toss_details_master_fk0` FOREIGN KEY (`fk_tournament_match_id`) REFERENCES `tournament_match_master`(`tournament_match_id`);

ALTER TABLE `toss_details_master` ADD CONSTRAINT `toss_details_master_fk1` FOREIGN KEY (`fk_toss_won_by`) REFERENCES `tournament_participant_master`(`tour_participant_id`);

ALTER TABLE `match_point_master` ADD CONSTRAINT `match_point_master_fk0` FOREIGN KEY (`fk_tournament_match_id`) REFERENCES `tournament_match_master`(`tournament_match_id`);

ALTER TABLE `match_point_master` ADD CONSTRAINT `match_point_master_fk1` FOREIGN KEY (`fk_defence_id`) REFERENCES `tournament_participant_team_master`(`tour_p_t_id`);

ALTER TABLE `match_point_master` ADD CONSTRAINT `match_point_master_fk2` FOREIGN KEY (`fk_attacker_id`) REFERENCES `tournament_participant_team_master`(`tour_p_t_id`);

ALTER TABLE `match_point_master` ADD CONSTRAINT `match_point_master_fk3` FOREIGN KEY (`fk_assist_id`) REFERENCES `tournament_participant_team_master`(`tour_p_t_id`);

ALTER TABLE `match_point_master` ADD CONSTRAINT `match_point_master_fk4` FOREIGN KEY (`symbol`) REFERENCES `symbol_master`(`symbol_id`);

ALTER TABLE `tournament_match_result_master` ADD CONSTRAINT `tournament_match_result_master_fk0` FOREIGN KEY (`fk_tournament_match_id`) REFERENCES `tournament_match_master`(`tournament_match_id`);

ALTER TABLE `tournament_match_result_master` ADD CONSTRAINT `tournament_match_result_master_fk1` FOREIGN KEY (`match_won_by`) REFERENCES `tournament_participant_master`(`tour_participant_id`);

ALTER TABLE `tournament_match_result_master` ADD CONSTRAINT `tournament_match_result_master_fk2` FOREIGN KEY (`fk_player_of_the_match`) REFERENCES `tournament_participant_team_master`(`tour_p_t_id`);

ALTER TABLE `tournament_match_foul_master` ADD CONSTRAINT `tournament_match_foul_master_fk0` FOREIGN KEY (`fk_tournament_match_id`) REFERENCES `tournament_match_master`(`tournament_match_id`);

ALTER TABLE `tournament_match_foul_master` ADD CONSTRAINT `tournament_match_foul_master_fk1` FOREIGN KEY (`fk_foul_id`) REFERENCES `foul_master`(`foul_id`);

ALTER TABLE `tournament_match_foul_master` ADD CONSTRAINT `tournament_match_foul_master_fk2` FOREIGN KEY (`fk_team_id`) REFERENCES `tournament_participant_master`(`tour_participant_id`);

ALTER TABLE `official_master` ADD CONSTRAINT `official_master_fk0` FOREIGN KEY (`fk_city_id`) REFERENCES `city_master`(`city_id`);

ALTER TABLE `tournament_participant_points_master` ADD CONSTRAINT `tournament_participant_points_master_fk0` FOREIGN KEY (`fk_tournament_partipant_id`) REFERENCES `tournament_participant_master`(`tour_participant_id`);

ALTER TABLE `tournament_participant_team_master` ADD CONSTRAINT `tournament_participant_team_master_fk0` FOREIGN KEY (`fk_tournament_participant_id`) REFERENCES `tournament_participant_master`(`tour_participant_id`);

ALTER TABLE `tournament_participant_team_master` ADD CONSTRAINT `tournament_participant_team_master_fk1` FOREIGN KEY (`fk_player_profile_id`) REFERENCES `player_profile_master`(`player_profile_id`);

