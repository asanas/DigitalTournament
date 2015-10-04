package com.digitour.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.digitour.app.db.model.TournamentMatchDetails;

@Entity
@Table(name = "tournament_schedule_master")
public class TournamentScheduleMaster implements java.io.Serializable {

	private Long tournamentScheduleId;
	private TournamentMatchDetails tournamentMatchMaster;
	private TournamentScheduleDateMaster tournamentScheduleDateMaster;
	private Set<TournamentMatchDetails> tournamentMatchMasters = new HashSet<TournamentMatchDetails>(0);

	public TournamentScheduleMaster() {
	}

	public TournamentScheduleMaster(TournamentMatchDetails tournamentMatchMaster,
			TournamentScheduleDateMaster tournamentScheduleDateMaster) {
		this.tournamentMatchMaster = tournamentMatchMaster;
		this.tournamentScheduleDateMaster = tournamentScheduleDateMaster;
	}

	public TournamentScheduleMaster(TournamentMatchDetails tournamentMatchMaster,
			TournamentScheduleDateMaster tournamentScheduleDateMaster,
			Set<TournamentMatchDetails> tournamentMatchMasters) {
		this.tournamentMatchMaster = tournamentMatchMaster;
		this.tournamentScheduleDateMaster = tournamentScheduleDateMaster;
		this.tournamentMatchMasters = tournamentMatchMasters;
	}

	@Id
    @GeneratedValue
    @Column(name = "tournament_schedule_id", unique = true, nullable = false)
	public Long getTournamentScheduleId() {
		return this.tournamentScheduleId;
	}

	public void setTournamentScheduleId(Long tournamentScheduleId) {
		this.tournamentScheduleId = tournamentScheduleId;
	}

	@ManyToOne
	@JoinColumn(name = "tournament_match_id")
	public TournamentMatchDetails getTournamentMatchMaster() {
		return this.tournamentMatchMaster;
	}

	public void setTournamentMatchMaster(TournamentMatchDetails tournamentMatchMaster) {
		this.tournamentMatchMaster = tournamentMatchMaster;
	}

	@ManyToOne
    @JoinColumn(name = "tournament_schedule_id")
	public TournamentScheduleDateMaster getTournamentScheduleDateMaster() {
		return this.tournamentScheduleDateMaster;
	}

	public void setTournamentScheduleDateMaster(TournamentScheduleDateMaster tournamentScheduleDateMaster) {
		this.tournamentScheduleDateMaster = tournamentScheduleDateMaster;
	}

	@ManyToOne
    @JoinColumn(name = "tournament_match_id")
	public Set<TournamentMatchDetails> getTournamentMatchMasters() {
		return this.tournamentMatchMasters;
	}

	public void setTournamentMatchMasters(Set<TournamentMatchDetails> tournamentMatchMasters) {
		this.tournamentMatchMasters = tournamentMatchMasters;
	}

}
