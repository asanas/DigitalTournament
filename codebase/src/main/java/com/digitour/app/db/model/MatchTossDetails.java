package com.digitour.app.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "matchtossdetails")
public class MatchTossDetails implements java.io.Serializable {

	private Long tossDetailsId;
	private Long tossWonByTeamId;
	private String electedTo;
	private TournamentMatchDetails tournamentMatchDetails;
	
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

	@Column(name = "toss_won_by", nullable = false)
	public Long getTossWonByTeamId() {
		return tossWonByTeamId;
	}

	public void setTossWonByTeamId(Long tossWonByTeamId) {
		this.tossWonByTeamId = tossWonByTeamId;
	}

	@OneToOne
    @PrimaryKeyJoinColumn
	public TournamentMatchDetails getTournamentMatchDetails() {
		return tournamentMatchDetails;
	}

	public void setTournamentMatchDetails(TournamentMatchDetails tournamentMatchDetails) {
		this.tournamentMatchDetails = tournamentMatchDetails;
	}

}
