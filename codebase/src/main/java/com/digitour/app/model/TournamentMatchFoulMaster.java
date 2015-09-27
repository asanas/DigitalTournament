package com.digitour.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.digitour.app.db.model.TournamentParticipant;

@Entity
@Table(name = "tournament_match_foul_master")
public class TournamentMatchFoulMaster implements java.io.Serializable {

	private Long matchFoulId;
	private FoulMaster foulMaster;
	private TournamentMatchMaster tournamentMatchMaster;
	private TournamentParticipant tournamentParticipantMaster;
	private long turnNumber;

	public TournamentMatchFoulMaster() {
	}

	public TournamentMatchFoulMaster(FoulMaster foulMaster, TournamentMatchMaster tournamentMatchMaster,
			TournamentParticipant tournamentParticipantMaster, long turnNumber) {
		this.foulMaster = foulMaster;
		this.tournamentMatchMaster = tournamentMatchMaster;
		this.tournamentParticipantMaster = tournamentParticipantMaster;
		this.turnNumber = turnNumber;
	}

	@Id
    @GeneratedValue
    @Column(name = "match_foul_id", unique = true, nullable = false)
	public Long getMatchFoulId() {
		return this.matchFoulId;
	}

	public void setMatchFoulId(Long matchFoulId) {
		this.matchFoulId = matchFoulId;
	}

	@ManyToOne
	@JoinColumn(name = "foul_id")
	public FoulMaster getFoulMaster() {
		return this.foulMaster;
	}

	public void setFoulMaster(FoulMaster foulMaster) {
		this.foulMaster = foulMaster;
	}
	
	@ManyToOne
    @JoinColumn(name = "tournament_match_id")
	public TournamentMatchMaster getTournamentMatchMaster() {
		return this.tournamentMatchMaster;
	}

	public void setTournamentMatchMaster(TournamentMatchMaster tournamentMatchMaster) {
		this.tournamentMatchMaster = tournamentMatchMaster;
	}
	
	@ManyToOne
    @JoinColumn(name = "tour_participant_id")
	public TournamentParticipant getTournamentParticipantMaster() {
		return this.tournamentParticipantMaster;
	}

	public void setTournamentParticipantMaster(TournamentParticipant tournamentParticipantMaster) {
		this.tournamentParticipantMaster = tournamentParticipantMaster;
	}
	
	@Column(name = "turn_number", nullable = false)
	public long getTurnNumber() {
		return this.turnNumber;
	}

	public void setTurnNumber(long turnNumber) {
		this.turnNumber = turnNumber;
	}

}
