package com.digitour.app.db.model;

import java.util.Date;

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
    private String name;
    private Date dateOfBirth;
    private byte[] photo;
    private int height;
    private Double weight;
    private Integer totalToursParticipated;
    private String achievements;
    private String contact;
    private Team team;
    
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

    @Column(name = "full_name", nullable = false)
    public String getName() {
    	return this.name;
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


    public void setName(String name) {
        this.name = name;
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
}
