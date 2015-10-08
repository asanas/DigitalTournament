package com.digitour.app.manager.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitour.app.dao.MatchTurnDAO;
import com.digitour.app.dao.TeamDAO;
import com.digitour.app.dao.TossDetailsDAO;
import com.digitour.app.dao.TournamentDAO;
import com.digitour.app.dao.TournamentMatchDAO;
import com.digitour.app.dao.TournamentParticipantDAO;
import com.digitour.app.dao.TournamentParticipantTeamDAO;
import com.digitour.app.db.model.MatchTurnDetails;
import com.digitour.app.db.model.MatchTossDetails;
import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.Tournament;
import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.db.model.TournamentParticipantTeam;
import com.digitour.app.db.model.support.enums.AgeGroup;
import com.digitour.app.db.model.support.enums.TurnStatus;
import com.digitour.app.manager.TournamentManager;

@Service
public class TournamentManagerImpl implements TournamentManager {

    @Autowired
    TournamentDAO tournamentDAO;
    
    @Autowired
    TournamentParticipantDAO tournamentParticipantDAO;
    
    @Autowired
    TeamDAO teamDAO;
    
    @Autowired
    TournamentMatchDAO tournamentMatchDAO;
    
    @Autowired
    TossDetailsDAO tossDetailsDAO;
    
    @Autowired
    TournamentParticipantTeamDAO tourParticipantTeamDAO;
    
    @Autowired
    MatchTurnDAO matchInningDAO;
    
    @Override
    public TournamentMatchDetails startQuickMatch(Long team1Id, Long team2Id, Long tossWonTeamId, String electedTo) {
        Tournament tournament = createTestTour();
        TournamentParticipant tourparti1 = createTourPartipant(tournament, team1Id);
        TournamentParticipant tourparti2 = createTourPartipant(tournament, team2Id);
        createTournamentPartipantTeam(tourparti1, team1Id);
        createTournamentPartipantTeam(tourparti2, team2Id);
        TournamentMatchDetails tournamentMatch = createTournamentMatch(tournament, tourparti1.getTourParticipantId(), tourparti2.getTourParticipantId());
        createTournamentTurnDetails(tournamentMatch);
        if(tossWonTeamId.equals(team1Id)) {
            tossWonTeamId = tourparti1.getTourParticipantId();
        } else {
            tossWonTeamId = tourparti2.getTourParticipantId();
        }
        saveMatchTossDetails(tournamentMatch, tossWonTeamId, electedTo);
        return tournamentMatch;
    }

    private void createTournamentTurnDetails(TournamentMatchDetails tournamentMatch) {
        for(long i=1; i<=2;i++) {
            for(long j=1;j<=2;j++) {
                MatchTurnDetails matchTurn = new MatchTurnDetails();
                matchTurn.setMatchId(tournamentMatch.getTournamentMatchId());
                matchTurn.setInningNumber(i);
                matchTurn.setTurnNumber(j);
                matchTurn.setStatus(TurnStatus.NOTSTARTED);
                matchInningDAO.save(matchTurn);
            }
        }
    }

    private void saveMatchTossDetails(TournamentMatchDetails tourMatchDetails, Long tossWonTeamId, String electedTo) {
        MatchTossDetails matchToss = new MatchTossDetails();
        matchToss.setMatchId(tourMatchDetails.getTournamentMatchId());
        matchToss.setTossWonByTeamId(tossWonTeamId);
        matchToss.setElectedTo(electedTo.toUpperCase());
        tossDetailsDAO.save(matchToss);
    }

    private void createTournamentPartipantTeam(TournamentParticipant tourParticipant, Long team1Id) {
        Team team = teamDAO.getById(team1Id);
        Long playerChaseNumber = 1L;
        for(PlayerProfile playerProfile : team.getPlayersList()) {
            TournamentParticipantTeam tourTeam = new TournamentParticipantTeam();
            tourTeam.setPlayerProfileId(playerProfile.getPlayerProfileId());
            tourTeam.setPlayerChaseNumber(playerChaseNumber++);
            tourTeam.setTournamentPartipantId(tourParticipant.getTourParticipantId());
            tourParticipantTeamDAO.save(tourTeam);
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
        tournamentDAO.save(tournament);
        return tournament;
    }
}
