ALTER TABLE `player_profile_master` DROP FOREIGN KEY `player_profile_master_fk0`;

ALTER TABLE `player_profile_master` DROP FOREIGN KEY `player_profile_master_fk1`;

ALTER TABLE `player_profile_master` DROP FOREIGN KEY `player_profile_master_fk2`;

ALTER TABLE `player_profile_master` DROP FOREIGN KEY `player_profile_master_fk3`;

ALTER TABLE `team_master` DROP FOREIGN KEY `team_master_fk0`;

ALTER TABLE `city_master` DROP FOREIGN KEY `city_master_fk0`;

ALTER TABLE `state_master` DROP FOREIGN KEY `state_master_fk0`;

ALTER TABLE `tournament_participant_master` DROP FOREIGN KEY `tournament_participant_master_fk0`;

ALTER TABLE `tournament_participant_master` DROP FOREIGN KEY `tournament_participant_master_fk1`;

ALTER TABLE `tournament_group_details_master` DROP FOREIGN KEY `tournament_group_details_master_fk0`;

ALTER TABLE `tournament_group_details_master` DROP FOREIGN KEY `tournament_group_details_master_fk1`;

ALTER TABLE `tournament_schedule_date_master` DROP FOREIGN KEY `tournament_schedule_date_master_fk0`;

ALTER TABLE `tournament_match_master` DROP FOREIGN KEY `tournament_match_master_fk0`;

ALTER TABLE `tournament_match_master` DROP FOREIGN KEY `tournament_match_master_fk1`;

ALTER TABLE `tournament_match_master` DROP FOREIGN KEY `tournament_match_master_fk2`;

ALTER TABLE `tournament_match_master` DROP FOREIGN KEY `tournament_match_master_fk3`;

ALTER TABLE `tournament_match_master` DROP FOREIGN KEY `tournament_match_master_fk4`;

ALTER TABLE `tournament_match_master` DROP FOREIGN KEY `tournament_match_master_fk5`;

ALTER TABLE `tournament_match_master` DROP FOREIGN KEY `tournament_match_master_fk6`;

ALTER TABLE `tournament_match_master` DROP FOREIGN KEY `tournament_match_master_fk7`;

ALTER TABLE `tournament_schedule_master` DROP FOREIGN KEY `tournament_schedule_master_fk0`;

ALTER TABLE `tournament_schedule_master` DROP FOREIGN KEY `tournament_schedule_master_fk1`;

ALTER TABLE `toss_details_master` DROP FOREIGN KEY `toss_details_master_fk0`;

ALTER TABLE `toss_details_master` DROP FOREIGN KEY `toss_details_master_fk1`;

ALTER TABLE `match_point_master` DROP FOREIGN KEY `match_point_master_fk0`;

ALTER TABLE `match_point_master` DROP FOREIGN KEY `match_point_master_fk1`;

ALTER TABLE `match_point_master` DROP FOREIGN KEY `match_point_master_fk2`;

ALTER TABLE `match_point_master` DROP FOREIGN KEY `match_point_master_fk3`;

ALTER TABLE `match_point_master` DROP FOREIGN KEY `match_point_master_fk4`;

ALTER TABLE `tournament_match_result_master` DROP FOREIGN KEY `tournament_match_result_master_fk0`;

ALTER TABLE `tournament_match_result_master` DROP FOREIGN KEY `tournament_match_result_master_fk1`;

ALTER TABLE `tournament_match_result_master` DROP FOREIGN KEY `tournament_match_result_master_fk2`;

ALTER TABLE `tournament_match_foul_master` DROP FOREIGN KEY `tournament_match_foul_master_fk0`;

ALTER TABLE `tournament_match_foul_master` DROP FOREIGN KEY `tournament_match_foul_master_fk1`;

ALTER TABLE `tournament_match_foul_master` DROP FOREIGN KEY `tournament_match_foul_master_fk2`;

ALTER TABLE `official_master` DROP FOREIGN KEY `official_master_fk0`;

ALTER TABLE `tournament_participant_points_master` DROP FOREIGN KEY `tournament_participant_points_master_fk0`;

ALTER TABLE `tournament_participant_team_master` DROP FOREIGN KEY `tournament_participant_team_master_fk0`;

ALTER TABLE `tournament_participant_team_master` DROP FOREIGN KEY `tournament_participant_team_master_fk1`;

DROP TABLE IF EXISTS `player_profile_master`;

DROP TABLE IF EXISTS `team_master`;

DROP TABLE IF EXISTS `city_master`;

DROP TABLE IF EXISTS `state_master`;

DROP TABLE IF EXISTS `country_master`;

DROP TABLE IF EXISTS `major_skill`;

DROP TABLE IF EXISTS `role_master`;

DROP TABLE IF EXISTS `tournament_master`;

DROP TABLE IF EXISTS `tournament_participant_master`;

DROP TABLE IF EXISTS `tournament_group_details_master`;

DROP TABLE IF EXISTS `group_master`;

DROP TABLE IF EXISTS `tournament_schedule_date_master`;

DROP TABLE IF EXISTS `tournament_match_master`;

DROP TABLE IF EXISTS `tournament_schedule_master`;

DROP TABLE IF EXISTS `symbol_master`;

DROP TABLE IF EXISTS `toss_details_master`;

DROP TABLE IF EXISTS `match_point_master`;

DROP TABLE IF EXISTS `tournament_match_result_master`;

DROP TABLE IF EXISTS `foul_master`;

DROP TABLE IF EXISTS `tournament_match_foul_master`;

DROP TABLE IF EXISTS `official_master`;

DROP TABLE IF EXISTS `tournament_participant_points_master`;

DROP TABLE IF EXISTS `tournament_participant_team_master`;

