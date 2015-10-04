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

import com.digitour.app.db.model.MatchPointDetails;

@Entity
@Table(name = "country_master")
public class SymbolMaster implements java.io.Serializable {

	private Long symbolId;
	private String description;
	private Set<MatchPointDetails> matchPointMasters = new HashSet<MatchPointDetails>(0);

	public SymbolMaster() {
	}

	public SymbolMaster(String description) {
		this.description = description;
	}

	public SymbolMaster(String description, Set<MatchPointDetails> matchPointMasters) {
		this.description = description;
		this.matchPointMasters = matchPointMasters;
	}

	@Id
    @GeneratedValue
    @Column(name = "symbol_id", unique = true, nullable = false)
	public Long getSymbolId() {
		return this.symbolId;
	}

	public void setSymbolId(Long symbolId) {
		this.symbolId = symbolId;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "symbol_master")
	public Set<MatchPointDetails> getMatchPointMasters() {
		return this.matchPointMasters;
	}

	public void setMatchPointMasters(Set<MatchPointDetails> matchPointMasters) {
		this.matchPointMasters = matchPointMasters;
	}

}
