package com.digitour.app.model.example;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tournament_schedule_master")
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

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "tournament_schedule_id", unique = true, nullable = false)
	public Long getTournamentScheduleId() {
		return this.tournamentScheduleId;
	}

	public void setTournamentScheduleId(Long tournamentScheduleId) {
		this.tournamentScheduleId = tournamentScheduleId;
	}

    @ManyToOne(optional=false)
    @JoinColumn(name="tournamentScheduleId", referencedColumnName="tournament_match_id")
	public TournamentMatchMaster getTournamentMatchMaster() {
		return this.tournamentMatchMaster;
	}

	public void setTournamentMatchMaster(TournamentMatchMaster tournamentMatchMaster) {
		this.tournamentMatchMaster = tournamentMatchMaster;
	}

    @ManyToOne(optional=false)
    @JoinColumn(name="tournamentScheduleId", referencedColumnName="tournament_schedule_date_id")
	public TournamentScheduleDateMaster getTournamentScheduleDateMaster() {
		return this.tournamentScheduleDateMaster;
	}

	public void setTournamentScheduleDateMaster(TournamentScheduleDateMaster tournamentScheduleDateMaster) {
		this.tournamentScheduleDateMaster = tournamentScheduleDateMaster;
	}

	@OneToMany(mappedBy = "tournamentschedulemaster")
	public Set<TournamentMatchMaster> getTournamentMatchMasters() {
		return this.tournamentMatchMasters;
	}

	public void setTournamentMatchMasters(Set<TournamentMatchMaster> tournamentMatchMasters) {
		this.tournamentMatchMasters = tournamentMatchMasters;
	}

}
