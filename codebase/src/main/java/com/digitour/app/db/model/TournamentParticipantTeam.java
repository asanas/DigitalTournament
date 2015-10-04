package com.digitour.app.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tournamentparticipantteam")
public class TournamentParticipantTeam implements java.io.Serializable {

    private Long tournamentParticipantPlayerId;
    private Long playerProfileId;
    private Long playerChaseNumber;
    private Long tournamentPartipantId;

    public TournamentParticipantTeam() {
        
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tour_p_t_id", unique = true, nullable = false)
    public Long getTournamentParticipantPlayerId() {
        return this.tournamentParticipantPlayerId;
    }

    public void setTournamentParticipantPlayerId(Long tourPTId) {
        this.tournamentParticipantPlayerId = tourPTId;
    }

    @Column(name = "player_profile_id", nullable = false)
    public Long getPlayerProfileId() {
        return this.playerProfileId;
    }

    public void setPlayerProfileId(Long playerProfileId) {
        this.playerProfileId = playerProfileId;
    }

    @Column(name = "player_chase_number", nullable = false)
    public Long getPlayerChaseNumber() {
        return this.playerChaseNumber;
    }

    public void setPlayerChaseNumber(Long playerChaseNumber) {
        this.playerChaseNumber = playerChaseNumber;
    }

    @Column(name = "tournament_participant_id", nullable = false)
    public Long getTournamentPartipantId() {
        return tournamentPartipantId;
    }

    public void setTournamentPartipantId(Long tournamentPartipantId) {
        this.tournamentPartipantId = tournamentPartipantId;
    }

}
