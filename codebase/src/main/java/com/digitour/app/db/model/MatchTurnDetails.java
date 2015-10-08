package com.digitour.app.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.digitour.app.db.model.support.enums.TurnStatus;


@Entity
@Table(name = "matchturndetails")
public class MatchTurnDetails implements java.io.Serializable {

	private Long matchTurnId;
	private Long matchId;
	private Long inningNumber;
	private Long turnNumber;
	private TurnStatus status;
	
	
	public MatchTurnDetails() {
	}

    @Id
    @GeneratedValue
    @Column(name = "match_turn_id", unique = true, nullable = false)
	public Long getMatchTurnId() {
		return this.matchTurnId;
	}

	public void setMatchTurnId(Long matchTurnId) {
		this.matchTurnId = matchTurnId;
	}
	
	@Column(name = "inning_number", nullable = false)
    public Long getInningNumber() {
		return this.inningNumber;
	}

	public void setInningNumber(Long inningNumber) {
		this.inningNumber = inningNumber;
	}

	@Column(name = "turn_number", nullable = false)
    public Long getTurnNumber() {
		return this.turnNumber;
	}

	public void setTurnNumber(Long turnNumber) {
		this.turnNumber = turnNumber;
	}
	
	@Column(name = "match_id", nullable = false)
	public Long getMatchId() {
		return matchId;
	}

	public void setMatchId(Long matchId) {
		this.matchId = matchId;
	}

	@Enumerated(EnumType.STRING)
    @Column(name = "status")
    public TurnStatus getStatus() {
        return status;
    }

    public void setStatus(TurnStatus status) {
        this.status = status;
    }

}
