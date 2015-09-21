package com.digitour.app.model;

import java.util.HashSet;
import java.util.Set;

/**
 * CityMaster generated by hbm2java
 */
public class CityMaster implements java.io.Serializable {

	private Long cityId;
	private StateMaster stateMaster;
	private String cityName;
	private Set<PlayerProfileMaster> playerProfileMasters = new HashSet<PlayerProfileMaster>(0);
	private Set<OfficialMaster> officialMasters = new HashSet<OfficialMaster>(0);
	private Set<TeamMaster> teamMasters = new HashSet<TeamMaster>(0);

	public CityMaster() {
	}

	public CityMaster(StateMaster stateMaster, String cityName) {
		this.stateMaster = stateMaster;
		this.cityName = cityName;
	}

	public CityMaster(StateMaster stateMaster, String cityName, Set<PlayerProfileMaster> playerProfileMasters,
			Set<OfficialMaster> officialMasters, Set<TeamMaster> teamMasters) {
		this.stateMaster = stateMaster;
		this.cityName = cityName;
		this.playerProfileMasters = playerProfileMasters;
		this.officialMasters = officialMasters;
		this.teamMasters = teamMasters;
	}

	public Long getCityId() {
		return this.cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public StateMaster getStateMaster() {
		return this.stateMaster;
	}

	public void setStateMaster(StateMaster stateMaster) {
		this.stateMaster = stateMaster;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Set<PlayerProfileMaster> getPlayerProfileMasters() {
		return this.playerProfileMasters;
	}

	public void setPlayerProfileMasters(Set<PlayerProfileMaster> playerProfileMasters) {
		this.playerProfileMasters = playerProfileMasters;
	}

	public Set<OfficialMaster> getOfficialMasters() {
		return this.officialMasters;
	}

	public void setOfficialMasters(Set<OfficialMaster> officialMasters) {
		this.officialMasters = officialMasters;
	}

	public Set<TeamMaster> getTeamMasters() {
		return this.teamMasters;
	}

	public void setTeamMasters(Set<TeamMaster> teamMasters) {
		this.teamMasters = teamMasters;
	}

}