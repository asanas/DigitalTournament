package com.digitour.app.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matchfouldetails")
public class MatchFoulDetails implements java.io.Serializable {

    private Long matchFoulId;
    private Long inningNumber;
    private Long tournamentMatchId;
    private FoulDetails foulDetails;
    private Long tournamentParticipantId;
    
    public MatchFoulDetails() {
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

    @Column(name = "inning_number", nullable = false)
    public long getInningNumber() {
        return this.inningNumber;
    }

    public void setInningNumber(long inningNumber) {
        this.inningNumber = inningNumber;
    }

    @Column(name = "tournament_match_id", nullable = false)
	public Long getTournamentMatchId() {
		return tournamentMatchId;
	}

	public void setTournamentMatchId(Long tournamentMatchId) {
		this.tournamentMatchId = tournamentMatchId;
	}

    @ManyToOne
    @JoinColumn(name="foul_id", nullable=false)
	public FoulDetails getFoulDetails() {
		return foulDetails;
	}

	public void setFoulDetails(FoulDetails foulDetails) {
		this.foulDetails = foulDetails;
	}
	@Column(name = "participating_team_id", nullable = false)
	public Long getTournamentParticipantId() {
		return tournamentParticipantId;
	}

	public void setTournamentParticipantId(Long tournamentParticipantId) {
		this.tournamentParticipantId = tournamentParticipantId;
	}

}
