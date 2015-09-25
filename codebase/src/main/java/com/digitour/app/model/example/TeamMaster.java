package com.digitour.app.model.example;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.digitour.app.model.City;

@Entity
@Table(name = "country_master")
public class TeamMaster implements java.io.Serializable {

	private Long teamId;
	private City cityMaster;
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

	public TeamMaster(City cityMaster, String name, String founderName, String description,
			String clubAddressLine1, String teamType, Date establishedIn) {
		this.cityMaster = cityMaster;
		this.name = name;
		this.founderName = founderName;
		this.description = description;
		this.clubAddressLine1 = clubAddressLine1;
		this.teamType = teamType;
		this.establishedIn = establishedIn;
	}

	public TeamMaster(City cityMaster, String name, String founderName, String description,
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

	@Id
    @GeneratedValue
    @Column(name = "team_id", unique = true, nullable = false)
	public Long getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

    @ManyToOne(optional=false)
    @JoinColumn(name="teamId", referencedColumnName="city_id")
    public City getCityMaster() {
		return this.cityMaster;
	}

	public void setCityMaster(City cityMaster) {
		this.cityMaster = cityMaster;
	}

	@Column(name = "name", nullable = false)
    public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "founder_name", nullable = false)
    public String getFounderName() {
		return this.founderName;
	}

	public void setFounderName(String founderName) {
		this.founderName = founderName;
	}

	@Column(name = "description", nullable = false)
    public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "club_address_line1", nullable = false)
    public String getClubAddressLine1() {
		return this.clubAddressLine1;
	}

	public void setClubAddressLine1(String clubAddressLine1) {
		this.clubAddressLine1 = clubAddressLine1;
	}
	
	@Column(name = "club_address_line2",  nullable = false)
	public String getClubAddressLine2() {
		return this.clubAddressLine2;
	}

	public void setClubAddressLine2(String clubAddressLine2) {
		this.clubAddressLine2 = clubAddressLine2;
	}

	@Column(name = "achievements",  nullable = false)
	public String getAchievements() {
		return this.achievements;
	}

	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}

    @Column( name = "photo" )
    @Lob
	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	@Column(name = "team_type",  nullable = false)
	public String getTeamType() {
		return this.teamType;
	}

	public void setTeamType(String teamType) {
		this.teamType = teamType;
	}
	
	@Column(name = "established_in",  nullable = false)
	public Date getEstablishedIn() {
		return this.establishedIn;
	}

	public void setEstablishedIn(Date establishedIn) {
		this.establishedIn = establishedIn;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "teammaster")
	public Set<PlayerProfileMaster> getPlayerProfileMasters() {
		return this.playerProfileMasters;
	}

	public void setPlayerProfileMasters(Set<PlayerProfileMaster> playerProfileMasters) {
		this.playerProfileMasters = playerProfileMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "teammaster")
	public Set<TournamentParticipantMaster> getTournamentParticipantMasters() {
		return this.tournamentParticipantMasters;
	}

	public void setTournamentParticipantMasters(Set<TournamentParticipantMaster> tournamentParticipantMasters) {
		this.tournamentParticipantMasters = tournamentParticipantMasters;
	}

}
