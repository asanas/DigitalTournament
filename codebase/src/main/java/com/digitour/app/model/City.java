package com.digitour.app.model;

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
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "city_master")
public class City implements java.io.Serializable {

    private Long cityId;

    private StateMaster stateMaster;

    private String cityName;

    private Set<PlayerProfileMaster> playerProfileMasters = new HashSet<PlayerProfileMaster>(0);

    private Set<OfficialMaster> officialMasters = new HashSet<OfficialMaster>(0);

    private Set<TeamMaster> teamMasters = new HashSet<TeamMaster>(0);

    public City() {
        
    }

    public City(StateMaster stateMaster, String cityName) {
        this.stateMaster = stateMaster;
        this.cityName = cityName;
    }

    public City(StateMaster stateMaster, String cityName, Set<PlayerProfileMaster> playerProfileMasters,
            Set<OfficialMaster> officialMasters, Set<TeamMaster> teamMasters) {
        this.stateMaster = stateMaster;
        this.cityName = cityName;
        this.playerProfileMasters = playerProfileMasters;
        this.officialMasters = officialMasters;
        this.teamMasters = teamMasters;
    }

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    public Long getCityId() {
        return this.cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @ManyToOne
    @JoinColumn(name="state_id", nullable=false)
    public StateMaster getStateMaster() {
        return this.stateMaster;
    }

    public void setStateMaster(StateMaster stateMaster) {
        this.stateMaster = stateMaster;
    }

    @Column(name = "city_name", nullable = false)
    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    public Set<PlayerProfileMaster> getPlayerProfileMasters() {
        return this.playerProfileMasters;
    }

    public void setPlayerProfileMasters(Set<PlayerProfileMaster> playerProfileMasters) {
        this.playerProfileMasters = playerProfileMasters;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    public Set<OfficialMaster> getOfficialMasters() {
        return this.officialMasters;
    }

    public void setOfficialMasters(Set<OfficialMaster> officialMasters) {
        this.officialMasters = officialMasters;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    public Set<TeamMaster> getTeamMasters() {
        return this.teamMasters;
    }

    public void setTeamMasters(Set<TeamMaster> teamMasters) {
        this.teamMasters = teamMasters;
    }

}
