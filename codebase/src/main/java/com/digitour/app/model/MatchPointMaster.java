package com.digitour.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "match_point_master")
public class MatchPointMaster implements java.io.Serializable {

	private Long matchPointId;
	private SymbolMaster symbolMaster;
	private TournamentMatchMaster tournamentMatchMaster;
	private TournamentParticipantTeamMaster tournamentParticipantTeamMasterByFkDefenceId;
	private TournamentParticipantTeamMaster tournamentParticipantTeamMasterByFkAttackerId;
	private TournamentParticipantTeamMaster tournamentParticipantTeamMasterByFkAssistId;
	private long inningNumber;
	private long turnNumber;
	private Date runTime;
	private Date perTime;

	public MatchPointMaster() {
	}

	public MatchPointMaster(SymbolMaster symbolMaster, TournamentMatchMaster tournamentMatchMaster,
			TournamentParticipantTeamMaster tournamentParticipantTeamMasterByFkDefenceId,
			TournamentParticipantTeamMaster tournamentParticipantTeamMasterByFkAttackerId,
			TournamentParticipantTeamMaster tournamentParticipantTeamMasterByFkAssistId, long inningNumber,
			long turnNumber, Date runTime, Date perTime) {
		this.symbolMaster = symbolMaster;
		this.tournamentMatchMaster = tournamentMatchMaster;
		this.tournamentParticipantTeamMasterByFkDefenceId = tournamentParticipantTeamMasterByFkDefenceId;
		this.tournamentParticipantTeamMasterByFkAttackerId = tournamentParticipantTeamMasterByFkAttackerId;
		this.tournamentParticipantTeamMasterByFkAssistId = tournamentParticipantTeamMasterByFkAssistId;
		this.inningNumber = inningNumber;
		this.turnNumber = turnNumber;
		this.runTime = runTime;
		this.perTime = perTime;
	}

    @Id
    @GeneratedValue
    @Column(name = "match_point_id", unique = true, nullable = false)
	public Long getMatchPointId() {
		return this.matchPointId;
	}

	public void setMatchPointId(Long matchPointId) {
		this.matchPointId = matchPointId;
	}

	@ManyToOne
	@JoinColumn(name="symbol_id")
	public SymbolMaster getSymbolMaster() {
		return this.symbolMaster;
	}

	public void setSymbolMaster(SymbolMaster symbolMaster) {
		this.symbolMaster = symbolMaster;
	}

	@ManyToOne
    @JoinColumn(name="tournament_match_id")
	public TournamentMatchMaster getTournamentMatchMaster() {
		return this.tournamentMatchMaster;
	}

	public void setTournamentMatchMaster(TournamentMatchMaster tournamentMatchMaster) {
		this.tournamentMatchMaster = tournamentMatchMaster;
	}

    @ManyToOne
    @JoinColumn(name="tour_p_t_id")
	public TournamentParticipantTeamMaster getTournamentParticipantTeamMasterByFkDefenceId() {
		return this.tournamentParticipantTeamMasterByFkDefenceId;
	}

	public void setTournamentParticipantTeamMasterByFkDefenceId(
			TournamentParticipantTeamMaster tournamentParticipantTeamMasterByFkDefenceId) {
		this.tournamentParticipantTeamMasterByFkDefenceId = tournamentParticipantTeamMasterByFkDefenceId;
	}

    @ManyToOne
    @JoinColumn(name="tour_p_t_id")
	public TournamentParticipantTeamMaster getTournamentParticipantTeamMasterByFkAttackerId() {
		return this.tournamentParticipantTeamMasterByFkAttackerId;
	}

	public void setTournamentParticipantTeamMasterByFkAttackerId(
			TournamentParticipantTeamMaster tournamentParticipantTeamMasterByFkAttackerId) {
		this.tournamentParticipantTeamMasterByFkAttackerId = tournamentParticipantTeamMasterByFkAttackerId;
	}

    @ManyToOne
    @JoinColumn(name="tour_p_t_id")
	public TournamentParticipantTeamMaster getTournamentParticipantTeamMasterByFkAssistId() {
		return this.tournamentParticipantTeamMasterByFkAssistId;
	}

	public void setTournamentParticipantTeamMasterByFkAssistId(
			TournamentParticipantTeamMaster tournamentParticipantTeamMasterByFkAssistId) {
		this.tournamentParticipantTeamMasterByFkAssistId = tournamentParticipantTeamMasterByFkAssistId;
	}

	@Column(name = "inning_number", nullable = false)
    public long getInningNumber() {
		return this.inningNumber;
	}

	public void setInningNumber(long inningNumber) {
		this.inningNumber = inningNumber;
	}

	@Column(name = "turn_number", nullable = false)
    public long getTurnNumber() {
		return this.turnNumber;
	}

	public void setTurnNumber(long turnNumber) {
		this.turnNumber = turnNumber;
	}
	
	@Column(name = "run_time", nullable = false)
    public Date getRunTime() {
		return this.runTime;
	}

	public void setRunTime(Date runTime) {
		this.runTime = runTime;
	}

	@Column(name = "run_time", nullable = false)
	public Date getPerTime() {
		return this.perTime;
	}

	public void setPerTime(Date perTime) {
		this.perTime = perTime;
	}

}
