package com.digitour.app.controller.scoresheet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digitour.app.dao.TournamentParticipantDAO;
import com.digitour.app.dao.TournamentParticipantTeamDAO;
import com.digitour.app.db.model.Tournament;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.db.model.TournamentParticipantTeam;
import com.digitour.app.manager.TournamentParticipantManager;

@Repository
public class TournamentParticipantManagerImpl implements TournamentParticipantManager {

    @Autowired
    TournamentParticipantDAO participantDAO;
    @Autowired
    TournamentParticipantTeamDAO teamParticipantDAO;
    
    @Override
    public TournamentParticipant getById(Long teamParticipant1Id) {
        return participantDAO.getById(teamParticipant1Id);
    }
    
    @Override
    public List<TournamentParticipantTeam> getByTournamentParticipantOrderByChaseNumber(
            TournamentParticipant tournamentParticipant) {
        return teamParticipantDAO.getByTournamentParticipantOrderByChaseNumber(tournamentParticipant);
    }

    @Override
    public List<TournamentParticipant> getByTournament(Tournament tournament) {
        return participantDAO.getByTournament(tournament);
    }

}
