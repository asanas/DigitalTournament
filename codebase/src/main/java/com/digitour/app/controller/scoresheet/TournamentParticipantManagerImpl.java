package com.digitour.app.controller.scoresheet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digitour.app.dao.TournamentParticipantDAO;
import com.digitour.app.dao.TournamentParticipantTeamDAO;
import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.Tournament;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.db.model.TournamentParticipantTeam;
import com.digitour.app.manager.PlayerProfileManager;
import com.digitour.app.manager.TournamentParticipantManager;

@Repository
public class TournamentParticipantManagerImpl implements TournamentParticipantManager {

    @Autowired
    TournamentParticipantDAO participantDAO;
    @Autowired
    TournamentParticipantTeamDAO teamParticipantDAO;
    @Autowired
    PlayerProfileManager playerProfileManager;
    
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

    @Override
    public TournamentParticipant getByTeamAndTournament(Team team, Tournament tournament) {
        return participantDAO.getTournamentParticipantByTeamAndTournament(team, tournament.getTournamentId());
    }

    @Override
    public void createTournamentParticipantTeamByChaseNumber(Tournament tournament, Team team,
            String playerProfileChaseNumberMap) {
        String[] playersChaseArray = playerProfileChaseNumberMap.split(",");
        TournamentParticipant tournamentPartipant = this.getByTeamAndTournament(team, tournament);
        for(int i =0; i < playersChaseArray.length; i++) {
            Long playerProfileId = Long.parseLong(playersChaseArray[i].split("-")[0]);
            Long selectedChaseNumber = Long.parseLong(playersChaseArray[i].split("-")[1]);
            PlayerProfile playerProfile = playerProfileManager.getById(playerProfileId);
            TournamentParticipantTeam tourTeamPlayerProfile = teamParticipantDAO.getByPlayerProfileAndTournamentParticipant(playerProfile, tournamentPartipant);
            if(tourTeamPlayerProfile == null) {
                tourTeamPlayerProfile = new TournamentParticipantTeam();
            }
            tourTeamPlayerProfile.setPlayerChaseNumber(selectedChaseNumber);
            tourTeamPlayerProfile.setPlayerProfileId(playerProfileId);
            tourTeamPlayerProfile.setTournamentPartipantId(tournamentPartipant.getTourParticipantId());
            teamParticipantDAO.save(tourTeamPlayerProfile);
        }
    }
}
