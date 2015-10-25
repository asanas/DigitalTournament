package com.digitour.app.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "tournamentmatchresultsummary")
public class TournamentMatchResultMaster implements java.io.Serializable {

    private Long matchResultId;
    private TournamentMatchDetails tournamentMatchDetails;
    private Long wonByPoints;
    private int wonByTime;
    private String resultDetails;
    private Long matchWonByParticipant;
    private boolean draw;
    
    public TournamentMatchResultMaster() {
        
    }

    public TournamentMatchResultMaster(TournamentMatchDetails tournamentMatchMaster,
            TournamentParticipantTeam tournamentParticipantTeamMaster, long wonByPoints, int wonByTime,
            String resultDetails) {
        this.wonByPoints = wonByPoints;
        this.wonByTime = wonByTime;
        this.resultDetails = resultDetails;
    }

    public TournamentMatchResultMaster(TournamentMatchDetails tournamentMatchMaster,
            TournamentParticipant tournamentParticipantMaster,
            TournamentParticipantTeam tournamentParticipantTeamMaster, long wonByPoints, int wonByTime,
            String resultDetails) {
        this.tournamentMatchDetails = tournamentMatchMaster;
        this.wonByPoints = wonByPoints;
        this.wonByTime = wonByTime;
        this.resultDetails = resultDetails;
    }

    @Id
    @Column(name="match_result_id", unique=true, nullable=false)
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="tournamentMatchDetails"))
    public Long getMatchResultId() {
        return this.matchResultId;
    }

    public void setMatchResultId(Long matchResultId) {
        this.matchResultId = matchResultId;
    }

    @Column(name = "won_by_points", nullable = false)
    public long getWonByPoints() {
        return this.wonByPoints;
    }

    public void setWonByPoints(long wonByPoints) {
        this.wonByPoints = wonByPoints;
    }

    @Column(name = "won_by_time", nullable = false)
    public int getWonByTime() {
        return this.wonByTime;
    }

    public void setWonByTime(int wonByTime) {
        this.wonByTime = wonByTime;
    }

    @Column(name = "result_details", nullable = false)
    public String getResultDetails() {
        return this.resultDetails;
    }

    public void setResultDetails(String resultDetails) {
        this.resultDetails = resultDetails;
    }

    @Column(name = "match_won_by_participant")
    public Long getMatchWonByParticipant() {
        return matchWonByParticipant;
    }

    public void setMatchWonByParticipant(Long matchWonByParticipant) {
        this.matchWonByParticipant = matchWonByParticipant;
    }

    @Column(name="draw", columnDefinition = "CHAR")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public boolean isDraw() {
        return draw;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }

}
