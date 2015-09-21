package com.digitour.app.model;
// Generated 19 Sep, 2015 10:42:06 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TeamMaster generated by hbm2java
 */
public class TeamMaster implements java.io.Serializable {

	private Long teamId;
	private CityMaster cityMaster;
	private String name;
	private String founderName;
	private String description;
	private String clubAddressLine1;
	private String clubAddressLine2;
	private String achievements;
	private byte[] photo;
	private String teamType;
	private Date establishedIn;
	private Set<PlayerProfileMaster> playerProfileMasters = new HashSet<PlayerProfileMaster>(0);
	private Set<TournamentParticipantMaster> tournamentParticipantMasters = new HashSet<TournamentParticipantMaster>(0);

	public TeamMaster() {
	}

	public TeamMaster(CityMaster cityMaster, String name, String founderName, String description,
			String clubAddressLine1, String teamType, Date establishedIn) {
		this.cityMaster = cityMaster;
		this.name = name;
		this.founderName = founderName;
		this.description = description;
		this.clubAddressLine1 = clubAddressLine1;
		this.teamType = teamType;
		this.establishedIn = establishedIn;
	}

	public TeamMaster(CityMaster cityMaster, String name, String founderName, String description,
			String clubAddressLine1, String clubAddressLine2, String achievements, byte[] photo, String teamType,
			Date establishedIn, Set<PlayerProfileMaster> playerProfileMasters,
			Set<TournamentParticipantMaster> tournamentParticipantMasters) {
		this.cityMaster = cityMaster;
		this.name = name;
		this.founderName = founderName;
		this.description = description;
		this.clubAddressLine1 = clubAddressLine1;
		this.clubAddressLine2 = clubAddressLine2;
		this.achievements = achievements;
		this.photo = photo;
		this.teamType = teamType;
		this.establishedIn = establishedIn;
		this.playerProfileMasters = playerProfileMasters;
		this.tournamentParticipantMasters = tournamentParticipantMasters;
	}

	public Long getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public CityMaster getCityMaster() {
		return this.cityMaster;
	}

	public void setCityMaster(CityMaster cityMaster) {
		this.cityMaster = cityMaster;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFounderName() {
		return this.founderName;
	}

	public void setFounderName(String founderName) {
		this.founderName = founderName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClubAddressLine1() {
		return this.clubAddressLine1;
	}

	public void setClubAddressLine1(String clubAddressLine1) {
		this.clubAddressLine1 = clubAddressLine1;
	}

	public String getClubAddressLine2() {
		return this.clubAddressLine2;
	}

	public void setClubAddressLine2(String clubAddressLine2) {
		this.clubAddressLine2 = clubAddressLine2;
	}

	public String getAchievements() {
		return this.achievements;
	}

	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}

	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getTeamType() {
		return this.teamType;
	}

	public void setTeamType(String teamType) {
		this.teamType = teamType;
	}

	public Date getEstablishedIn() {
		return this.establishedIn;
	}

	public void setEstablishedIn(Date establishedIn) {
		this.establishedIn = establishedIn;
	}

	public Set<PlayerProfileMaster> getPlayerProfileMasters() {
		return this.playerProfileMasters;
	}

	public void setPlayerProfileMasters(Set<PlayerProfileMaster> playerProfileMasters) {
		this.playerProfileMasters = playerProfileMasters;
	}

	public Set<TournamentParticipantMaster> getTournamentParticipantMasters() {
		return this.tournamentParticipantMasters;
	}

	public void setTournamentParticipantMasters(Set<TournamentParticipantMaster> tournamentParticipantMasters) {
		this.tournamentParticipantMasters = tournamentParticipantMasters;
	}

}
