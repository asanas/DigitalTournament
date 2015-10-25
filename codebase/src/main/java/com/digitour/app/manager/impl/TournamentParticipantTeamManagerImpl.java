package com.digitour.app.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digitour.app.dao.TournamentParticipantTeamDAO;
import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.db.model.TournamentParticipantTeam;
import com.digitour.app.manager.TournamentParticipantTeamManager;

@Repository
public class TournamentParticipantTeamManagerImpl implements TournamentParticipantTeamManager{

    @Autowired
    TournamentParticipantTeamDAO participantTeamDAO;
    
    @Override
    public TournamentParticipantTeam getById(Long participantProfileId) {
        return participantTeamDAO.getById(participantProfileId);
    }

    @Override
    public TournamentParticipantTeam getByPlayerProfileAndTournamentParticipant(PlayerProfile playerProfile,
            TournamentParticipant tournamentParticipant) {
        return participantTeamDAO.getByPlayerProfileAndTournamentParticipant(playerProfile, tournamentParticipant);
    }

    @Override
    public List<TournamentParticipantTeam> getByTournamentParticipantOrderByChaseNumber(
            TournamentParticipant tournamentParticipant) {
        return participantTeamDAO.getByTournamentParticipantOrderByChaseNumber(tournamentParticipant);
    }

}
