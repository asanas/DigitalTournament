package com.digitour.app.manager.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitour.app.dao.TeamMasterDAO;
import com.digitour.app.dao.TossDetailsMasterDAO;
import com.digitour.app.dao.TournamentMasterDAO;
import com.digitour.app.dao.TournamentMatchMasterDAO;
import com.digitour.app.dao.TournamentParticipantMasterDAO;
import com.digitour.app.dao.TournamentParticipantTeamMasterDAO;
import com.digitour.app.db.model.MatchTossDetails;
import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.Tournament;
import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.db.model.TournamentParticipantTeam;
import com.digitour.app.db.model.support.enums.AgeGroup;
import com.digitour.app.manager.TournamentManager;

@Service
public class TournamentManagerImpl implements TournamentManager {

    @Autowired
    TournamentMasterDAO tournamentMasterDAO;
    
    @Autowired
    TournamentParticipantMasterDAO tournamentParticipantDAO;
    
    @Autowired
    TeamMasterDAO teamMasterDao;
    
    @Autowired
    TournamentMatchMasterDAO tournamentMatchDAO;
    
    @Autowired
    TossDetailsMasterDAO tossDetailsDAO;
    
    @Autowired
    TournamentParticipantTeamMasterDAO tourParticipantTeamDAO;
    
    @Override
    public TournamentMatchDetails startQuickMatch(Long team1Id, Long team2Id, Long tossWonTeamId, String electedTo) {
        Tournament tournament = createTestTour();
        TournamentParticipant tourparti1 = createTourPartipant(tournament, team1Id);
        TournamentParticipant tourparti2 = createTourPartipant(tournament, team2Id);
        createTournamentPartipantTeam(tourparti1, team1Id);
        createTournamentPartipantTeam(tourparti2, team2Id);
        TournamentMatchDetails tournamentMatch = createTournamentMatch(tournament, team1Id, team2Id);
        saveMatchTossDetails(tournamentMatch, tossWonTeamId, electedTo);
        return tournamentMatch;
    }

    private void saveMatchTossDetails(TournamentMatchDetails tourMatchDetails, Long tossWonTeamId, String electedTo) {
        MatchTossDetails matchToss = new MatchTossDetails();
        matchToss.setMatchId(tourMatchDetails.getTournamentMatchId());
        matchToss.setTossWonByTeamId(tossWonTeamId);
        matchToss.setElectedTo(electedTo.toUpperCase());
        tossDetailsDAO.save(matchToss);
    }

    private void createTournamentPartipantTeam(TournamentParticipant tourParticipant, Long team1Id) {
        Team team = teamMasterDao.getById(team1Id);
        Long playerChaseNumber = 1L;
        for(PlayerProfile playerProfile : team.getPlayersList()) {
            TournamentParticipantTeam tourTeam = new TournamentParticipantTeam();
            tourTeam.setPlayerProfileId(playerProfile.getPlayerProfileId());
            tourTeam.setPlayerChaseNumber(playerChaseNumber++);
            tourTeam.setTournamentPartipantId(tourParticipant.getTourParticipantId());
            tourParticipantTeamDAO.save(tourTeam);
        }
    }

    private TournamentMatchDetails createTournamentMatch(Tournament tournament, Long team1Id, Long team2Id) {
        TournamentMatchDetails tourMatchDetails = new TournamentMatchDetails();
        tourMatchDetails.setTeamParticipant1Id(team1Id);
        tourMatchDetails.setTeamParticipant2Id(team2Id);
        tourMatchDetails.setTournamentId(tournament.getTournamentId());
        tournamentMatchDAO.save(tourMatchDetails);
    	return tourMatchDetails;
    }

    private TournamentParticipant createTourPartipant(Tournament tournament, Long participatingTeamId) {
        TournamentParticipant tourParticipant = new TournamentParticipant();
        tourParticipant.setGrouId(1L);
        tourParticipant.setTournamentId(tournament.getTournamentId());
        tourParticipant.setTeamId(participatingTeamId);
        tournamentParticipantDAO.save(tourParticipant);
        return tourParticipant;
    }

    private Tournament createTestTour() {
        Tournament tournament = new Tournament();
        tournament.setTournamentName("Test Tournament");
        tournament.setDescription("Tournament description");
        tournament.setLocation("SP College");
        tournament.setTourType("ALLINDIA");
        tournament.setTourStatus("QUICKMATCH");
        tournament.setCreatedDate(new Date());
        tournament.setAgeGroup(AgeGroup.OPEN);
        tournamentMasterDAO.save(tournament);
        return tournament;
    }
}
