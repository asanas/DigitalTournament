package com.digitour.app.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matchtossdetails")
public class MatchTossDetails implements java.io.Serializable {

	private Long tossDetailsId;
	private Long matchId;
	private Long tossWonByTeamId;
	private String electedTo;

	public MatchTossDetails() {
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

	@Column(name = "elected_to", nullable = false)
	public String getElectedTo() {
		return this.electedTo;
	}

	public void setElectedTo(String electedTo) {
		this.electedTo = electedTo;
	}
	@Column(name = "tournament_match_id", nullable = false)
	public Long getMatchId() {
		return matchId;
	}

	@Column(name = "toss_won_by", nullable = false)
	public Long getTossWonByTeamId() {
		return tossWonByTeamId;
	}

	public void setMatchId(Long matchId) {
		this.matchId = matchId;
	}

	public void setTossWonByTeamId(Long tossWonByTeamId) {
		this.tossWonByTeamId = tossWonByTeamId;
	}

}
