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
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import com.digitour.app.model.City;

@Entity
@Table(name = "player_profile_master")
public class PlayerProfileMaster implements java.io.Serializable {

    private Long playerProfileId;
    private City cityMaster;
    private MajorSkill majorSkill;
    private RoleMaster roleMaster;
    private TeamMaster teamMaster;
    private String name;
    private Date dateOfBirth;
    private byte[] photo;
    private String height;
    private Double weight;
    private Integer totalToursParticipated;
    private String achievements;
    private String gender;
    private String contact;
    private Set<TournamentParticipantTeamMaster> tournamentParticipantTeamMasters = new HashSet<TournamentParticipantTeamMaster>(
            0);

    public PlayerProfileMaster() {
    }

    public PlayerProfileMaster(City cityMaster, TeamMaster teamMaster, String name, Date dateOfBirth,
            String gender, String contact) {
        this.cityMaster = cityMaster;
        this.teamMaster = teamMaster;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contact = contact;
    }

    public PlayerProfileMaster(City cityMaster, MajorSkill majorSkill, RoleMaster roleMaster,
            TeamMaster teamMaster, String name, Date dateOfBirth, byte[] photo, String height, Double weight,
            Integer totalToursParticipated, String achievements, String gender, String contact,
            Set<TournamentParticipantTeamMaster> tournamentParticipantTeamMasters) {
        this.cityMaster = cityMaster;
        this.majorSkill = majorSkill;
        this.roleMaster = roleMaster;
        this.teamMaster = teamMaster;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.photo = photo;
        this.height = height;
        this.weight = weight;
        this.totalToursParticipated = totalToursParticipated;
        this.achievements = achievements;
        this.gender = gender;
        this.contact = contact;
        this.tournamentParticipantTeamMasters = tournamentParticipantTeamMasters;
    }

    @Id
    @GeneratedValue
    @Column(name = "player_profile_id", unique = true, nullable = false)
    public Long getPlayerProfileId() {
        return this.playerProfileId;
    }

    public void setPlayerProfileId(Long playerProfileId) {
        this.playerProfileId = playerProfileId;
    }

    @ManyToOne(optional=false)
    @JoinColumn(name="playerProfileId", referencedColumnName="city_id")
    public City getCityMaster() {
        return this.cityMaster;
    }

    public void setCityMaster(City cityMaster) {
        this.cityMaster = cityMaster;
    }

    @ManyToOne(optional=false)
    @JoinColumn(name="playerProfileId", referencedColumnName="major_skill_id")
    public MajorSkill getMajorSkill() {
        return this.majorSkill;
    }

    public void setMajorSkill(MajorSkill majorSkill) {
        this.majorSkill = majorSkill;
    }

    @ManyToOne(optional=false)
    @JoinColumn(name="playerProfileId", referencedColumnName="role_id")
    public RoleMaster getRoleMaster() {
        return this.roleMaster;
    }

    public void setRoleMaster(RoleMaster roleMaster) {
        this.roleMaster = roleMaster;
    }

    @ManyToOne(optional=false)
    @JoinColumn(name="playerProfileId", referencedColumnName="team_id")
    public TeamMaster getTeamMaster() {
        return this.teamMaster;
    }

    public void setTeamMaster(TeamMaster teamMaster) {
        this.teamMaster = teamMaster;
    }
    
    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "date_of_birth", nullable = false)
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column( name = "photo" )
    @Lob
    public byte[] getPhoto() {
        return this.photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Column(name = "height", nullable = false)
    public String getHeight() {
        return this.height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Column(name = "weight", nullable = false)
    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Column(name = "total_tours_participated")
    public Integer getTotalToursParticipated() {
        return this.totalToursParticipated;
    }

    public void setTotalToursParticipated(Integer totalToursParticipated) {
        this.totalToursParticipated = totalToursParticipated;
    }

    @Column(name = "achievements")
    public String getAchievements() {
        return this.achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    @Column(name = "gender")
    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "contact")
    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "playerprofilemaster")
    public Set<TournamentParticipantTeamMaster> getTournamentParticipantTeamMasters() {
        return this.tournamentParticipantTeamMasters;
    }

    public void setTournamentParticipantTeamMasters(
            Set<TournamentParticipantTeamMaster> tournamentParticipantTeamMasters) {
        this.tournamentParticipantTeamMasters = tournamentParticipantTeamMasters;
    }

}
