package com.digitour.app.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tournamentmatchdetails")
public class TournamentMatchDetails implements java.io.Serializable {

    private Long tournamentMatchId;
    private Long teamParticipant1Id;
    private Long teamParticipant2Id;
    private Long tournamentId;
    private Long timeLapsed;

    public TournamentMatchDetails() {
        
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tournament_match_id", unique = true, nullable = false)
    public Long getTournamentMatchId() {
        return this.tournamentMatchId;
    }

    @Column(name = "team_participant1_id", nullable = false)
    public Long getTeamParticipant1Id() {
        return teamParticipant1Id;
    }
    
    @Column(name = "team_participant2_id", nullable = false)
    public Long getTeamParticipant2Id() {
        return teamParticipant2Id;
    }

    @Column(name = "tournament_id", nullable = false)
    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentMatchId(Long tournamentMatchId) {
        this.tournamentMatchId = tournamentMatchId;
    }

    public void setTeamParticipant1Id(Long team1Id) {
        this.teamParticipant1Id = team1Id;
    }

    public void setTeamParticipant2Id(Long team2Id) {
        this.teamParticipant2Id = team2Id;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }

    @Transient
    public Long getTimeLapsed() {
        return timeLapsed;
    }

    public void setTimeLapsed(Long timeLapsed)
    {
        this.timeLapsed = timeLapsed;
    }

}
