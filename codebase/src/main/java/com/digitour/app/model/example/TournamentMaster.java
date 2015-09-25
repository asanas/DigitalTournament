package com.digitour.app.model.example;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tournament_master")
public class TournamentMaster implements java.io.Serializable {

	private Long tournamentId;
	private String name;
	private String description;
	private String location;
	private double prize;
	private String otherDetails;
	private String tourType;
	private String tourStatus;
	private Date tournamentStartDate;
	private Date tournamentEndDate;
	private Date createdDate;
	private String ageGroup;
	private Set<TournamentScheduleDateMaster> tournamentScheduleDateMasters = new HashSet<TournamentScheduleDateMaster>(
			0);
	private Set<TournamentParticipantMaster> tournamentParticipantMasters = new HashSet<TournamentParticipantMaster>(0);

	public TournamentMaster() {
	}

	public TournamentMaster(String name, String description, String location, double prize, String otherDetails,
			String tourType, String tourStatus, Date tournamentStartDate, Date tournamentEndDate, Date createdDate,
			String ageGroup) {
		this.name = name;
		this.description = description;
		this.location = location;
		this.prize = prize;
		this.otherDetails = otherDetails;
		this.tourType = tourType;
		this.tourStatus = tourStatus;
		this.tournamentStartDate = tournamentStartDate;
		this.tournamentEndDate = tournamentEndDate;
		this.createdDate = createdDate;
		this.ageGroup = ageGroup;
	}

	public TournamentMaster(String name, String description, String location, double prize, String otherDetails,
			String tourType, String tourStatus, Date tournamentStartDate, Date tournamentEndDate, Date createdDate,
			String ageGroup, Set<TournamentScheduleDateMaster> tournamentScheduleDateMasters,
			Set<TournamentParticipantMaster> tournamentParticipantMasters) {
		this.name = name;
		this.description = description;
		this.location = location;
		this.prize = prize;
		this.otherDetails = otherDetails;
		this.tourType = tourType;
		this.tourStatus = tourStatus;
		this.tournamentStartDate = tournamentStartDate;
		this.tournamentEndDate = tournamentEndDate;
		this.createdDate = createdDate;
		this.ageGroup = ageGroup;
		this.tournamentScheduleDateMasters = tournamentScheduleDateMasters;
		this.tournamentParticipantMasters = tournamentParticipantMasters;
	}

	@Id
    @GeneratedValue
    @Column(name = "tournament_id", unique = true, nullable = false)
	public Long getTournamentId() {
		return this.tournamentId;
	}

	public void setTournamentId(Long tournamentId) {
		this.tournamentId = tournamentId;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "location", nullable = false)
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "prize", nullable = false)
	public double getPrize() {
		return this.prize;
	}

	public void setPrize(double prize) {
		this.prize = prize;
	}

	@Column(name = "other_details", nullable = false)
	public String getOtherDetails() {
		return this.otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	@Column(name = "tour_type", nullable = false)
	public String getTourType() {
		return this.tourType;
	}

	public void setTourType(String tourType) {
		this.tourType = tourType;
	}

	@Column(name = "tour_status", nullable = false)
	public String getTourStatus() {
		return this.tourStatus;
	}

	public void setTourStatus(String tourStatus) {
		this.tourStatus = tourStatus;
	}

	@Column(name = "tournament_start_date", nullable = false)
	public Date getTournamentStartDate() {
		return this.tournamentStartDate;
	}

	public void setTournamentStartDate(Date tournamentStartDate) {
		this.tournamentStartDate = tournamentStartDate;
	}

    @Column(name = "tournament_end_date", nullable = false)
	public Date getTournamentEndDate() {
		return this.tournamentEndDate;
	}

	public void setTournamentEndDate(Date tournamentEndDate) {
		this.tournamentEndDate = tournamentEndDate;
	}

	@Column(name = "created_date", nullable = false)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "age_group", nullable = false)
	public String getAgeGroup() {
		return this.ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournamentmaster")
	public Set<TournamentScheduleDateMaster> getTournamentScheduleDateMasters() {
		return this.tournamentScheduleDateMasters;
	}

	public void setTournamentScheduleDateMasters(Set<TournamentScheduleDateMaster> tournamentScheduleDateMasters) {
		this.tournamentScheduleDateMasters = tournamentScheduleDateMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournamentmaster")
	public Set<TournamentParticipantMaster> getTournamentParticipantMasters() {
		return this.tournamentParticipantMasters;
	}

	public void setTournamentParticipantMasters(Set<TournamentParticipantMaster> tournamentParticipantMasters) {
		this.tournamentParticipantMasters = tournamentParticipantMasters;
	}

}
