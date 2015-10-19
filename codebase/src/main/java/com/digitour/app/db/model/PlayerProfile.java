package com.digitour.app.db.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.digitour.app.db.model.support.enums.Gender;
import com.digitour.app.db.model.support.enums.MajorSkill;
import com.digitour.app.db.model.support.enums.Role;

@Entity
@Table(name = "PLAYERPROFILE")
public class PlayerProfile implements java.io.Serializable {

    private Long playerProfileId;
    private City city;
    private MajorSkill majorSkill;
    private Role role;
    private Gender gender;
    private String firstName;
    private String lastName;
    private String middleName;
    private Date dateOfBirth;
    private byte[] photo;
    private int height;
    private Double weight;
    private Integer totalToursParticipated;
    private String achievements;
    private String contact;
    private Team team;
    private Long tournamentChaseNumber;
    private List<MatchPointDetails> matchPointDetailsList;
    private String wicketStatus;
    private String address;
    private String emailId;
    
    public PlayerProfile() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_profile_id", unique = true, nullable = false)
    public Long getPlayerProfileId() {
        return this.playerProfileId;
    }

    @ManyToOne
    @JoinColumn(name="city_id")
    public City getCity() {
        return this.city;
    }
    
    @Enumerated(EnumType.STRING)
    @Column(name = "major_skill")
    public MajorSkill getMajorSkill() {
        return this.majorSkill;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    public Role getRole() {
        return this.role;
    }

    @Column(name = "date_of_birth", nullable = false)
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    @Column( name = "photo", nullable = true )
    @Lob
    public byte[] getPhoto() {
        return this.photo;
    }

    @Column(name = "height", nullable = true)
    public int getHeight() {
        return this.height;
    }
    
    @Column(name = "weight", nullable = true)
    public Double getWeight() {
        return this.weight;
    }
    
    @Column(name = "total_tours_participated")
    public Integer getTotalToursParticipated() {
        return this.totalToursParticipated;
    }
    
    @Column(name = "achievements")
    public String getAchievements() {
        return this.achievements;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    public Gender getGender() {
        return this.gender;
    }

    @Column(name = "contact")
    public String getContact() {
        return this.contact;
    }

    public void setPlayerProfileId(Long playerProfileId) {
        this.playerProfileId = playerProfileId;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setMajorSkill(MajorSkill majorSkill) {
        this.majorSkill = majorSkill;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setTotalToursParticipated(Integer totalToursParticipated) {
        this.totalToursParticipated = totalToursParticipated;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @ManyToOne
    @JoinColumn(name = "team_id")
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Transient
    public Long getTournamentChaseNumber()
    {
        return tournamentChaseNumber;
    }

    public void setTournamentChaseNumber(Long tournamentChaseNumber)
    {
        this.tournamentChaseNumber = tournamentChaseNumber;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName()
    {
        return firstName;
    }

    @Column(name = "last_name")
    public String getLastName()
    {
        return lastName;
    }

    @Column(name = "middle_name")
    public String getMiddleName()
    {
        return middleName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    @Transient
    public List<MatchPointDetails> getMatchPointDetailsList()
    {
        return matchPointDetailsList;
    }

    public void setMatchPointDetailsList(List<MatchPointDetails> matchPointDetailsList)
    {
        this.matchPointDetailsList = matchPointDetailsList;
    }

    @Transient
    public String getWicketStatus() {
        return wicketStatus;
    }

    public void setWicketStatus(String wicketStatus) {
        this.wicketStatus = wicketStatus;
    }

    @Column(name = "address_line1", nullable = true)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "email_address", nullable = true)
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
