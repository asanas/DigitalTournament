package com.digitour.app.model.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tournament_participant_points_master")
public class TournamentParticipantPointsMaster implements java.io.Serializable {

	private Long tourPartipantPointId;
	private TournamentParticipantMaster tournamentParticipantMaster;
	private long matchesWon;
	private long matchesLost;
	private long matchesDrawn;
	private long totalWickets;
	private long totalPoints;

	public TournamentParticipantPointsMaster() {
	}

	public TournamentParticipantPointsMaster(TournamentParticipantMaster tournamentParticipantMaster, long matchesWon,
			long matchesLost, long matchesDrawn, long totalWickets, long totalPoints) {
		this.tournamentParticipantMaster = tournamentParticipantMaster;
		this.matchesWon = matchesWon;
		this.matchesLost = matchesLost;
		this.matchesDrawn = matchesDrawn;
		this.totalWickets = totalWickets;
		this.totalPoints = totalPoints;
	}

	@Id
    @GeneratedValue
    @Column(name = "tour_partipant_point_id", unique = true, nullable = false)
	public Long getTourPartipantPointId() {
		return this.tourPartipantPointId;
	}

	public void setTourPartipantPointId(Long tourPartipantPointId) {
		this.tourPartipantPointId = tourPartipantPointId;
	}

    @ManyToOne(optional=false)
    @JoinColumn(name="tourPartipantPointId", referencedColumnName="tour_participant_id")
	public TournamentParticipantMaster getTournamentParticipantMaster() {
		return this.tournamentParticipantMaster;
	}

	public void setTournamentParticipantMaster(TournamentParticipantMaster tournamentParticipantMaster) {
		this.tournamentParticipantMaster = tournamentParticipantMaster;
	}

	@Column(name = "matches_won", nullable = false)
	public long getMatchesWon() {
		return this.matchesWon;
	}

	public void setMatchesWon(long matchesWon) {
		this.matchesWon = matchesWon;
	}

	@Column(name = "matches_lost", nullable = false)
	public long getMatchesLost() {
		return this.matchesLost;
	}

	public void setMatchesLost(long matchesLost) {
		this.matchesLost = matchesLost;
	}

	@Column(name = "matches_drawn", nullable = false)
	public long getMatchesDrawn() {
		return this.matchesDrawn;
	}

	public void setMatchesDrawn(long matchesDrawn) {
		this.matchesDrawn = matchesDrawn;
	}

	@Column(name = "total_wickets", nullable = false)
	public long getTotalWickets() {
		return this.totalWickets;
	}

	public void setTotalWickets(long totalWickets) {
		this.totalWickets = totalWickets;
	}

	@Column(name = "total_points", nullable = false)
	public long getTotalPoints() {
		return this.totalPoints;
	}

	public void setTotalPoints(long totalPoints) {
		this.totalPoints = totalPoints;
	}

}
