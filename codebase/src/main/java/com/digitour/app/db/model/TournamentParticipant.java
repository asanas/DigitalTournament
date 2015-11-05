package com.digitour.app.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tournamentparticipant")
public class TournamentParticipant implements java.io.Serializable {

    private Long tourParticipantId;
    private Long teamId;
    private Long tournamentId;
    private Long grouId;
    private Long sponsorerId;
    
    public TournamentParticipant() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tournament_participant_id", unique = true, nullable = false)
    public Long getTourParticipantId() {
        return this.tourParticipantId;
    }

    public void setTourParticipantId(Long tourParticipantId) {
        this.tourParticipantId = tourParticipantId;
    }

    @Column(name = "team_id", nullable = false)
    public Long getTeamId() {
        return teamId;
    }

    @Column(name = "tournament_id", nullable = false)
    public Long getTournamentId() {
        return tournamentId;
    }

    @Column(name = "group_id", nullable = false)
    public Long getGrouId() {
        return grouId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public void setGrouId(Long grouId) {
        this.grouId = grouId;
    }

    @Column(name = "sponsorer_id")
    public Long getSponsorerId() {
        return sponsorerId;
    }

    public void setSponsorerId(Long sponsorerId) {
        this.sponsorerId = sponsorerId;
    }

}
