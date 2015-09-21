package com.digitour.app.model;
// Generated 19 Sep, 2015 10:42:06 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * TournamentScheduleMaster generated by hbm2java
 */
public class TournamentScheduleMaster implements java.io.Serializable {

	private Long tournamentScheduleId;
	private TournamentMatchMaster tournamentMatchMaster;
	private TournamentScheduleDateMaster tournamentScheduleDateMaster;
	private Set<TournamentMatchMaster> tournamentMatchMasters = new HashSet<TournamentMatchMaster>(0);

	public TournamentScheduleMaster() {
	}

	public TournamentScheduleMaster(TournamentMatchMaster tournamentMatchMaster,
			TournamentScheduleDateMaster tournamentScheduleDateMaster) {
		this.tournamentMatchMaster = tournamentMatchMaster;
		this.tournamentScheduleDateMaster = tournamentScheduleDateMaster;
	}

	public TournamentScheduleMaster(TournamentMatchMaster tournamentMatchMaster,
			TournamentScheduleDateMaster tournamentScheduleDateMaster,
			Set<TournamentMatchMaster> tournamentMatchMasters) {
		this.tournamentMatchMaster = tournamentMatchMaster;
		this.tournamentScheduleDateMaster = tournamentScheduleDateMaster;
		this.tournamentMatchMasters = tournamentMatchMasters;
	}

	public Long getTournamentScheduleId() {
		return this.tournamentScheduleId;
	}

	public void setTournamentScheduleId(Long tournamentScheduleId) {
		this.tournamentScheduleId = tournamentScheduleId;
	}

	public TournamentMatchMaster getTournamentMatchMaster() {
		return this.tournamentMatchMaster;
	}

	public void setTournamentMatchMaster(TournamentMatchMaster tournamentMatchMaster) {
		this.tournamentMatchMaster = tournamentMatchMaster;
	}

	public TournamentScheduleDateMaster getTournamentScheduleDateMaster() {
		return this.tournamentScheduleDateMaster;
	}

	public void setTournamentScheduleDateMaster(TournamentScheduleDateMaster tournamentScheduleDateMaster) {
		this.tournamentScheduleDateMaster = tournamentScheduleDateMaster;
	}

	public Set<TournamentMatchMaster> getTournamentMatchMasters() {
		return this.tournamentMatchMasters;
	}

	public void setTournamentMatchMasters(Set<TournamentMatchMaster> tournamentMatchMasters) {
		this.tournamentMatchMasters = tournamentMatchMasters;
	}

}