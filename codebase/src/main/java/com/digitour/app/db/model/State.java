package com.digitour.app.db.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STATECOUNTRY")
public class State implements java.io.Serializable {

    private Long stateId;
    String countryName;
    private String stateName;
    private List<City> cityList;

    public State() {
        
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STATE_ID", unique = true, nullable = false)
    public Long getStateId() {
        return this.stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    @Column(name = "COUNTRY_NAME", nullable = false)
    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Column(name = "STATE_NAME", nullable = false)
    public String getStateName() {
        return this.stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "state", cascade = CascadeType.ALL)
    public List<City> getCityList() {
        return this.cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

}
