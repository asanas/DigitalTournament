package com.digitour.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.digitour.app.db.model.TournamentParticipant;

@Entity
@Table(name = "tournamentparticipantpoints")
public class TournamentParticipantPoints implements java.io.Serializable {

    private Long tourPartipantPointId;
    private TournamentParticipant tournamentParticipantMaster;
    private long matchesWon;
    private long matchesLost;
    private long matchesDrawn;
    private long totalWickets;
    private long totalPoints;

    public TournamentParticipantPoints() {
    }

    public TournamentParticipantPoints(TournamentParticipant tournamentParticipantMaster, long matchesWon,
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tournament_participant_id")
    public TournamentParticipant getTournamentParticipantMaster() {
        return this.tournamentParticipantMaster;
    }

    public void setTournamentParticipantMaster(TournamentParticipant tournamentParticipantMaster) {
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
