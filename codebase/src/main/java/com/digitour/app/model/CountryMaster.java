package com.digitour.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "country_master")
public class CountryMaster implements java.io.Serializable {

	private Long countryId;
	private String countryName;
	private Set<StateMaster> stateMasters = new HashSet<StateMaster>(0);

	public CountryMaster() {
	}

	public CountryMaster(String countryName) {
		this.countryName = countryName;
	}

	public CountryMaster(String countryName, Set<StateMaster> stateMasters) {
		this.countryName = countryName;
		this.stateMasters = stateMasters;
	}

	@Id
    @GeneratedValue
    @Column(name = "county_id", unique = true, nullable = false)
	public Long getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	@Column(name = "country_name", unique = true, nullable = false)
	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country_master")
	public Set<StateMaster> getStateMasters() {
		return this.stateMasters;
	}

	public void setStateMasters(Set<StateMaster> stateMasters) {
		this.stateMasters = stateMasters;
	}

}
