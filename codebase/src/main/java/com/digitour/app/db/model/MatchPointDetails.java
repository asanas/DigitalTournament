package com.digitour.app.db.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "matchpointdetails")
public class MatchPointDetails implements java.io.Serializable {

	private Long matchPointId;
	private Long symbolId;
	private Long matchId;
	private Long defenceParticipantProfileId;
	private Long attackParticipantProfileId;
	private Long assistParticipantProfileId;
	private long inningNumber;
	private long turnNumber;
	private Date runTime;
	private Date perTime;
	private boolean isOut;
	private boolean turnClosure;
	
	public MatchPointDetails() {
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
	
	@Column(name="symbol_id", nullable = false)
	public Long getSymbolId() {
		return this.symbolId;
	}

	public void setSymbolId(Long symbolId) {
		this.symbolId = symbolId;
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

	@Column(name = "per_time", nullable = false)
	public Date getPerTime() {
		return this.perTime;
	}

	public void setPerTime(Date perTime) {
		this.perTime = perTime;
	}

	@Column(name = "tournament_match_id", nullable = false)
	public Long getMatchId() {
		return matchId;
	}

	@Column(name = "defence_id")
	public Long getDefenceParticipantProfileId() {
		return defenceParticipantProfileId;
	}

	@Column(name = "attack_id")
	public Long getAttackParticipantProfileId() {
		return attackParticipantProfileId;
	}

	@Column(name = "assist_id")
	public Long getAssistParticipantProfileId() {
		return assistParticipantProfileId;
	}

	@Column(name = "out")
	public boolean isOut() {
		return isOut;
	}

	@Column(name = "turn_closure")
	public boolean isTurnClosure() {
		return turnClosure;
	}

	public void setMatchId(Long matchId) {
		this.matchId = matchId;
	}

	public void setDefenceParticipantProfileId(Long defenceParticipantProfileId) {
		this.defenceParticipantProfileId = defenceParticipantProfileId;
	}

	public void setAttackParticipantProfileId(Long attackParticipantProfileId) {
		this.attackParticipantProfileId = attackParticipantProfileId;
	}

	public void setAssistParticipantProfileId(Long assistParticipantProfileId) {
		this.assistParticipantProfileId = assistParticipantProfileId;
	}

	public void setOut(boolean isOut) {
		this.isOut = isOut;
	}

	public void setTurnClosure(boolean turnClosure) {
		this.turnClosure = turnClosure;
	}

}
