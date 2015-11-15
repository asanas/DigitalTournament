package com.digitour.app.manager.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitour.app.dao.MatchTurnDAO;
import com.digitour.app.dao.TossDetailsDAO;
import com.digitour.app.dao.TournamentDAO;
import com.digitour.app.dao.TournamentMatchDAO;
import com.digitour.app.dao.TournamentParticipantTeamDAO;
import com.digitour.app.db.model.MatchTossDetails;
import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.Tournament;
import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.db.model.TournamentParticipantTeam;
import com.digitour.app.db.model.support.enums.AgeGroup;
import com.digitour.app.db.model.support.enums.Role;
import com.digitour.app.manager.MatchTurnManager;
import com.digitour.app.manager.TeamManager;
import com.digitour.app.manager.TournamentManager;
import com.digitour.app.manager.TournamentParticipantManager;

@Service
public class TournamentManagerImpl implements TournamentManager {

    @Autowired
    TournamentDAO tournamentDAO;
    
    @Autowired
    TournamentParticipantManager tournamentParticipantManager;
    
    @Autowired
    TeamManager teamManager;
    
    @Autowired
    TournamentMatchDAO tournamentMatchDAO;

    @Autowired
    TossDetailsDAO tossDetailsDAO;
    
    @Autowired
    TournamentParticipantTeamDAO tourParticipantTeamDAO;
    
    @Autowired
    MatchTurnDAO matchInningDAO;
    
    @Autowired
    MatchTurnManager turnManager;
    
    @Override
    public TournamentMatchDetails startQuickMatch(Long team1Id, Long team2Id, Long tossWonTeamId, String electedTo, Long tournamentId) {
        Tournament tournament = createTestTour();
        TournamentParticipant tourParti1 = null;
        TournamentParticipant tourParti2 = null;
        TournamentMatchDetails tournamentMatch = null;
        if(tournamentId.longValue() != 0) {
            tournament = tournamentDAO.getById(tournamentId);
            Team team1 = teamManager.getById(team1Id, false);
            Team team2 = teamManager.getById(team2Id, false);
            tourParti1 = tournamentParticipantManager.getByTeamAndTournament(team1, tournament);
            tourParti2 = tournamentParticipantManager.getByTeamAndTournament(team2, tournament);
        } else {
            tourParti1 = createTourPartipant(tournament, team1Id);
            tourParti2 = createTourPartipant(tournament, team2Id);
            createTournamentPartipantTeam(tourParti1, team1Id);
            createTournamentPartipantTeam(tourParti2, team2Id);
        }
        tournamentMatch = createTournamentMatch(tournament, tourParti1.getTourParticipantId(), tourParti2.getTourParticipantId());
        turnManager.createMatchTurns(tournamentMatch);
        if(tossWonTeamId.equals(team1Id)) {
            tossWonTeamId = tourParti1.getTourParticipantId();
        } else {
            tossWonTeamId = tourParti2.getTourParticipantId();
        }
        saveMatchTossDetails(tournamentMatch, tossWonTeamId, electedTo);
        return tournamentMatch;
    }

    private void saveMatchTossDetails(TournamentMatchDetails tourMatchDetails, Long tossWonTeamId, String electedTo) {
        MatchTossDetails matchToss = new MatchTossDetails();
        matchToss.setTournamentMatchDetails(tourMatchDetails);
        matchToss.setTossWonByTeamId(tossWonTeamId);
        matchToss.setElectedTo(electedTo.toUpperCase());
        tossDetailsDAO.save(matchToss);
    }

    private void createTournamentPartipantTeam(TournamentParticipant tourParticipant, Long team1Id) {
        Team team = teamManager.getById(team1Id, true);
        Long playerChaseNumber = 1L;
        for(PlayerProfile playerProfile : team.getPlayersList()) {
            if(!Role.COACH.equals(playerProfile.getRole()) && !Role.MANAGER.equals(playerProfile.getRole())) {
                TournamentParticipantTeam tourTeam = new TournamentParticipantTeam();
                tourTeam.setPlayerProfileId(playerProfile.getPlayerProfileId());
                tourTeam.setPlayerChaseNumber(playerChaseNumber++);
                tourTeam.setTournamentPartipantId(tourParticipant.getTourParticipantId());
                tourParticipantTeamDAO.save(tourTeam);
            }
        }
    }

    private TournamentMatchDetails createTournamentMatch(Tournament tournament, Long team1ParticipantId, Long team2ParticipantId) {
        TournamentMatchDetails tourMatchDetails = new TournamentMatchDetails();
        tourMatchDetails.setTeamParticipant1Id(team1ParticipantId);
        tourMatchDetails.setTeamParticipant2Id(team2ParticipantId);
        tourMatchDetails.setTournamentId(tournament.getTournamentId());
        tournamentMatchDAO.save(tourMatchDetails);
        return tourMatchDetails;
    }

    @Override
    public TournamentParticipant createTourPartipant(Tournament tournament, Long teamId) {
        TournamentParticipant tourParticipant = new TournamentParticipant();
        tourParticipant.setGrouId(1L);
        tourParticipant.setTournamentId(tournament.getTournamentId());
        tourParticipant.setTeamId(teamId);
        tournamentParticipantManager.save(tourParticipant);
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
        tournamentDAO.save(tournament);
        return tournament;
    }

    @Override
    public void save(Tournament tournament) {
        tournamentDAO.save(tournament);
    }

    @Override
    public Tournament getById(Long tournamentId) {
        return tournamentDAO.getById(tournamentId);
    }
}
