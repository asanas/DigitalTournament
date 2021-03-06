package com.digitour.app.manager;

import java.util.List;

import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.Tournament;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.db.model.TournamentParticipantTeam;

public interface TournamentParticipantManager {

    TournamentParticipant getById(Long teamParticipant1Id);

    public List<TournamentParticipantTeam> getByTournamentParticipantOrderByChaseNumber(TournamentParticipant tournamentParticipant1);

    List<TournamentParticipant> getByTournament(Tournament tournament);

    TournamentParticipant getByTeamAndTournament(Team team, Tournament tournament);

    void createTournamentParticipantTeamByChaseNumber(Tournament tournament, Team team,
            String playerProfileChaseNumberMap);
    
    void save(TournamentParticipant tournamentParticipant);

}
