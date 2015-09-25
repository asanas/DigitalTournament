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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.digitour.app.model.City;

@Entity
@Table(name = "official_master")
public class OfficialMaster implements java.io.Serializable {

	private Long officialProfileId;
	private City cityMaster;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dateOfBirth;
	private String addressLine1;
	private String addressLine2;
	private String contact1;
	private String contact2;
	private Set<TournamentMatchMaster> tournamentMatchMastersForFkMatchRefree = new HashSet<TournamentMatchMaster>(0);
	private Set<TournamentMatchMaster> tournamentMatchMastersForFkUmpire2 = new HashSet<TournamentMatchMaster>(0);
	private Set<TournamentMatchMaster> tournamentMatchMastersForFkUmpire1 = new HashSet<TournamentMatchMaster>(0);
	private Set<TournamentMatchMaster> tournamentMatchMastersForFkScorer2 = new HashSet<TournamentMatchMaster>(0);
	private Set<TournamentMatchMaster> tournamentMatchMastersForFkScorer1 = new HashSet<TournamentMatchMaster>(0);

	public OfficialMaster() {
	}

	public OfficialMaster(City cityMaster, String firstName, String middleName, String lastName, Date dateOfBirth,
			String addressLine1, String addressLine2, String contact1, String contact2) {
		this.cityMaster = cityMaster;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.contact1 = contact1;
		this.contact2 = contact2;
	}

	public OfficialMaster(City cityMaster, String firstName, String middleName, String lastName, Date dateOfBirth,
			String addressLine1, String addressLine2, String contact1, String contact2,
			Set<TournamentMatchMaster> tournamentMatchMastersForFkMatchRefree,
			Set<TournamentMatchMaster> tournamentMatchMastersForFkUmpire2,
			Set<TournamentMatchMaster> tournamentMatchMastersForFkUmpire1,
			Set<TournamentMatchMaster> tournamentMatchMastersForFkScorer2,
			Set<TournamentMatchMaster> tournamentMatchMastersForFkScorer1) {
		this.cityMaster = cityMaster;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.contact1 = contact1;
		this.contact2 = contact2;
		this.tournamentMatchMastersForFkMatchRefree = tournamentMatchMastersForFkMatchRefree;
		this.tournamentMatchMastersForFkUmpire2 = tournamentMatchMastersForFkUmpire2;
		this.tournamentMatchMastersForFkUmpire1 = tournamentMatchMastersForFkUmpire1;
		this.tournamentMatchMastersForFkScorer2 = tournamentMatchMastersForFkScorer2;
		this.tournamentMatchMastersForFkScorer1 = tournamentMatchMastersForFkScorer1;
	}

	@Id
    @GeneratedValue
    @Column(name = "official_profile_id", unique = true, nullable = false)
	public Long getOfficialProfileId() {
		return this.officialProfileId;
	}

	public void setOfficialProfileId(Long officialProfileId) {
		this.officialProfileId = officialProfileId;
	}

    @ManyToOne(optional=false)
    @JoinColumn(name="officialProfileId", referencedColumnName="city_id")
	public City getCityMaster() {
		return this.cityMaster;
	}

	public void setCityMaster(City cityMaster) {
		this.cityMaster = cityMaster;
	}

	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "middle_name", nullable = false)
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "date_of_birth", nullable = false)
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "address_line1", nullable = false)
	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	@Column(name = "address_line2", nullable = false)
	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	@Column(name = "contact1", nullable = false)
	public String getContact1() {
		return this.contact1;
	}

	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}

	@Column(name = "contact2", nullable = false)
	public String getContact2() {
		return this.contact2;
	}

	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "officialmaster")
	public Set<TournamentMatchMaster> getTournamentMatchMastersForFkMatchRefree() {
		return this.tournamentMatchMastersForFkMatchRefree;
	}

	public void setTournamentMatchMastersForFkMatchRefree(
			Set<TournamentMatchMaster> tournamentMatchMastersForFkMatchRefree) {
		this.tournamentMatchMastersForFkMatchRefree = tournamentMatchMastersForFkMatchRefree;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "officialmaster")
	public Set<TournamentMatchMaster> getTournamentMatchMastersForFkUmpire2() {
		return this.tournamentMatchMastersForFkUmpire2;
	}

	public void setTournamentMatchMastersForFkUmpire2(Set<TournamentMatchMaster> tournamentMatchMastersForFkUmpire2) {
		this.tournamentMatchMastersForFkUmpire2 = tournamentMatchMastersForFkUmpire2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "officialmaster")
	public Set<TournamentMatchMaster> getTournamentMatchMastersForFkUmpire1() {
		return this.tournamentMatchMastersForFkUmpire1;
	}

	public void setTournamentMatchMastersForFkUmpire1(Set<TournamentMatchMaster> tournamentMatchMastersForFkUmpire1) {
		this.tournamentMatchMastersForFkUmpire1 = tournamentMatchMastersForFkUmpire1;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "officialmaster")
	public Set<TournamentMatchMaster> getTournamentMatchMastersForFkScorer2() {
		return this.tournamentMatchMastersForFkScorer2;
	}

	public void setTournamentMatchMastersForFkScorer2(Set<TournamentMatchMaster> tournamentMatchMastersForFkScorer2) {
		this.tournamentMatchMastersForFkScorer2 = tournamentMatchMastersForFkScorer2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "officialmaster")
	public Set<TournamentMatchMaster> getTournamentMatchMastersForFkScorer1() {
		return this.tournamentMatchMastersForFkScorer1;
	}

	public void setTournamentMatchMastersForFkScorer1(Set<TournamentMatchMaster> tournamentMatchMastersForFkScorer1) {
		this.tournamentMatchMastersForFkScorer1 = tournamentMatchMastersForFkScorer1;
	}

}
