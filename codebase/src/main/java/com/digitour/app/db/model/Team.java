package com.digitour.app.db.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.digitour.app.db.model.support.enums.Gender;
import com.digitour.app.db.model.support.enums.TeamType;

@Entity
@Table(name = "team")
public class Team implements java.io.Serializable {

    private Long teamId;
    private City city;
    private String teamName;
    private String founderName;
    private String description;
    private String clubAddressLine1;
    private String clubAddressLine2;
    private String achievements;
    private byte[] photo;
    private TeamType teamType;
    private Date establishedIn;
    private List<PlayerProfile> playersList;
    private Gender gender;
    private String displayName;

    public Team() {
        
    }

    public Team(String teamName, String founderName, String description, String address, String achievements,
            City teamCity, Date establishedIn, Gender gender) {
        this.teamName = teamName;
        this.founderName = founderName;
        this.description = description;
        this.clubAddressLine1 = address;
        this.clubAddressLine1 = address;
        this.achievements = achievements;
        this.city = teamCity;
        this.teamType = TeamType.CLUB;
        this.establishedIn = establishedIn;
        this.gender = gender;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_id", unique = true, nullable = false)
    public Long getTeamId() {
        return this.teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    @ManyToOne
    @JoinColumn(name = "city_id")
    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Column(name = "team_name", nullable = false)
    public String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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
    
    @Column(name = "club_address_line2")
    public String getClubAddressLine2() {
        return this.clubAddressLine2;
    }

    public void setClubAddressLine2(String clubAddressLine2) {
        this.clubAddressLine2 = clubAddressLine2;
    }

    @Column(name = "achievements")
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
    
    @Enumerated(EnumType.STRING)
    @Column(name = "team_type",  nullable = false)
    public TeamType getTeamType() {
        return this.teamType;
    }

    public void setTeamType(TeamType teamType) {
        this.teamType = teamType;
    }
    
    @Column(name = "established_in",  nullable = false)
    public Date getEstablishedIn() {
        return this.establishedIn;
    }

    public void setEstablishedIn(Date establishedIn) {
        this.establishedIn = establishedIn;
    }

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    public List<PlayerProfile> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(List<PlayerProfile> playersList) {
        this.playersList = playersList;
    }
    
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Column(name = "display_name",  nullable = false)
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

}
