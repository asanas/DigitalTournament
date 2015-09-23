package com.digitour.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "toss_details_master")
public class TossDetailsMaster implements java.io.Serializable {

	private Long tossDetailsId;
	private TournamentMatchMaster tournamentMatchMaster;
	private TournamentParticipantMaster tournamentParticipantMaster;
	private String electedTo;

	public TossDetailsMaster() {
	}

	public TossDetailsMaster(TournamentMatchMaster tournamentMatchMaster,
			TournamentParticipantMaster tournamentParticipantMaster, String electedTo) {
		this.tournamentMatchMaster = tournamentMatchMaster;
		this.tournamentParticipantMaster = tournamentParticipantMaster;
		this.electedTo = electedTo;
	}

	@Id
    @GeneratedValue
    @Column(name = "toss_details_id", unique = true, nullable = false)
	public Long getTossDetailsId() {
		return this.tossDetailsId;
	}

	public void setTossDetailsId(Long tossDetailsId) {
		this.tossDetailsId = tossDetailsId;
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
	public TournamentParticipantMaster getTournamentParticipantMaster() {
		return this.tournamentParticipantMaster;
	}

	public void setTournamentParticipantMaster(TournamentParticipantMaster tournamentParticipantMaster) {
		this.tournamentParticipantMaster = tournamentParticipantMaster;
	}

	@Column(name = "elected_to", nullable = false)
	public String getElectedTo() {
		return this.electedTo;
	}

	public void setElectedTo(String electedTo) {
		this.electedTo = electedTo;
	}

}
