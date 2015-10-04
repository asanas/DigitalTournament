package com.digitour.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.db.model.TournamentParticipantTeam;

// TODO: Update this according to table
@Entity
@Table(name = "tournament_match_result_master")
public class TournamentMatchResultMaster implements java.io.Serializable {

	private Long matchResultId;
	private TournamentMatchDetails tournamentMatchMaster;
	private TournamentParticipant tournamentParticipantMaster;
	private TournamentParticipantTeam tournamentParticipantTeamMaster;
	private long wonByPoints;
	private Date wonByTime;
	private String resultDetails;

	public TournamentMatchResultMaster() {
	}

	public TournamentMatchResultMaster(TournamentMatchDetails tournamentMatchMaster,
			TournamentParticipantTeam tournamentParticipantTeamMaster, long wonByPoints, Date wonByTime,
			String resultDetails) {
		this.tournamentMatchMaster = tournamentMatchMaster;
		this.tournamentParticipantTeamMaster = tournamentParticipantTeamMaster;
		this.wonByPoints = wonByPoints;
		this.wonByTime = wonByTime;
		this.resultDetails = resultDetails;
	}

	public TournamentMatchResultMaster(TournamentMatchDetails tournamentMatchMaster,
			TournamentParticipant tournamentParticipantMaster,
			TournamentParticipantTeam tournamentParticipantTeamMaster, long wonByPoints, Date wonByTime,
			String resultDetails) {
		this.tournamentMatchMaster = tournamentMatchMaster;
		this.tournamentParticipantMaster = tournamentParticipantMaster;
		this.tournamentParticipantTeamMaster = tournamentParticipantTeamMaster;
		this.wonByPoints = wonByPoints;
		this.wonByTime = wonByTime;
		this.resultDetails = resultDetails;
	}

	@Id
    @GeneratedValue
    @Column(name = "match_result_id", unique = true, nullable = false)
	public Long getMatchResultId() {
		return this.matchResultId;
	}

	public void setMatchResultId(Long matchResultId) {
		this.matchResultId = matchResultId;
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
    @JoinColumn(name = "tour_participant_id")
	public TournamentParticipant getTournamentParticipantMaster() {
		return this.tournamentParticipantMaster;
	}

	public void setTournamentParticipantMaster(TournamentParticipant tournamentParticipantMaster) {
		this.tournamentParticipantMaster = tournamentParticipantMaster;
	}

	@ManyToOne
    @JoinColumn(name = "tour_p_t_id")
	public TournamentParticipantTeam getTournamentParticipantTeamMaster() {
		return this.tournamentParticipantTeamMaster;
	}

	public void setTournamentParticipantTeamMaster(TournamentParticipantTeam tournamentParticipantTeamMaster) {
		this.tournamentParticipantTeamMaster = tournamentParticipantTeamMaster;
	}

	@Column(name = "won_by_points", nullable = false)
	public long getWonByPoints() {
		return this.wonByPoints;
	}

	public void setWonByPoints(long wonByPoints) {
		this.wonByPoints = wonByPoints;
	}

	@Column(name = "won_by_time", nullable = false)
	public Date getWonByTime() {
		return this.wonByTime;
	}

	public void setWonByTime(Date wonByTime) {
		this.wonByTime = wonByTime;
	}

	@Column(name = "result_details", nullable = false)
	public String getResultDetails() {
		return this.resultDetails;
	}

	public void setResultDetails(String resultDetails) {
		this.resultDetails = resultDetails;
	}

}
