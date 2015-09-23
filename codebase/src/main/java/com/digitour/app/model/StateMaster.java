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
@Table(name = "state_master")
public class StateMaster implements java.io.Serializable {

    private Long stateId;
    private CountryMaster countryMaster;
    private String stateName;
    private Set<City> cityMasters = new HashSet<City>(0);

    public StateMaster() {
    }

    public StateMaster(CountryMaster countryMaster, String stateName) {
        this.countryMaster = countryMaster;
        this.stateName = stateName;
    }

    public StateMaster(CountryMaster countryMaster, String stateName, Set<City> cityMasters) {
        this.countryMaster = countryMaster;
        this.stateName = stateName;
        this.cityMasters = cityMasters;
    }

    @Id
    @GeneratedValue
    @Column(name = "state_id", unique = true, nullable = false)
    public Long getStateId() {
        return this.stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    public CountryMaster getCountryMaster() {
        return this.countryMaster;
    }

    public void setCountryMaster(CountryMaster countryMaster) {
        this.countryMaster = countryMaster;
    }

    @Column(name = "state_name", nullable = false)
    public String getStateName() {
        return this.stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "state_master")
    public Set<City> getCityMasters() {
        return this.cityMasters;
    }

    public void setCityMasters(Set<City> cityMasters) {
        this.cityMasters = cityMasters;
    }

}
