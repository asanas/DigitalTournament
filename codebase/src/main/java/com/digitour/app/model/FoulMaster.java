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
@Table(name = "foul_master")
public class FoulMaster implements java.io.Serializable {

	private Long foulId;
	private String foulName;
	private String foulDescription;
	private Set<TournamentMatchFoulMaster> tournamentMatchFoulMasters = new HashSet<TournamentMatchFoulMaster>(0);

	public FoulMaster() {
	}

	public FoulMaster(String foulName, String foulDescription) {
		this.foulName = foulName;
		this.foulDescription = foulDescription;
	}

	public FoulMaster(String foulName, String foulDescription,
			Set<TournamentMatchFoulMaster> tournamentMatchFoulMasters) {
		this.foulName = foulName;
		this.foulDescription = foulDescription;
		this.tournamentMatchFoulMasters = tournamentMatchFoulMasters;
	}

	@Id
    @GeneratedValue
    @Column(name = "foul_id", unique = true, nullable = false)
	public Long getFoulId() {
		return this.foulId;
	}

	public void setFoulId(Long foulId) {
		this.foulId = foulId;
	}

	@Column(name = "foul_name", nullable = false)
	public String getFoulName() {
		return this.foulName;
	}

	public void setFoulName(String foulName) {
		this.foulName = foulName;
	}

	@Column(name = "foul_description", nullable = false)
	public String getFoulDescription() {
		return this.foulDescription;
	}

	public void setFoulDescription(String foulDescription) {
		this.foulDescription = foulDescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "foul_master")
	public Set<TournamentMatchFoulMaster> getTournamentMatchFoulMasters() {
		return this.tournamentMatchFoulMasters;
	}

	public void setTournamentMatchFoulMasters(Set<TournamentMatchFoulMaster> tournamentMatchFoulMasters) {
		this.tournamentMatchFoulMasters = tournamentMatchFoulMasters;
	}

}
