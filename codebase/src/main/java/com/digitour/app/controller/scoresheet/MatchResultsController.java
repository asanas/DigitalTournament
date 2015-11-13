package com.digitour.app.controller.scoresheet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.digitour.app.client.pojo.PlayerPerformace;
import com.digitour.app.db.model.MatchPointDetails;
import com.digitour.app.db.model.MatchTurnDetails;
import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.db.model.TournamentParticipantTeam;
import com.digitour.app.db.model.support.enums.TurnStatus;
import com.digitour.app.manager.MatchPointManager;
import com.digitour.app.manager.MatchResultsManager;
import com.digitour.app.manager.MatchTurnManager;
import com.digitour.app.manager.PlayerProfileManager;
import com.digitour.app.manager.TeamManager;
import com.digitour.app.manager.TournamentMatchManager;
import com.digitour.app.manager.TournamentParticipantManager;
import com.digitour.app.manager.impl.TournamentParticipantTeamManagerImpl;

@Controller
public class MatchResultsController {

    @Autowired
    TournamentMatchManager matchManager;
    
    @Autowired
    TournamentParticipantManager participantManager;
    
    @Autowired
    MatchResultsManager matchResultsManager;
    
    @Autowired
    TeamManager teamManager;
    
    @Autowired
    MatchPointManager matchPointManager;
    
    @Autowired
    TournamentParticipantTeamManagerImpl participantTeamManager;
    
    @Autowired
    PlayerProfileManager playerProfileManager;
    
    @Autowired
    MatchTurnManager turnManager;
    
    @RequestMapping(path = "/showMatchResults", method = RequestMethod.GET)
    public ModelAndView showMatchResult(Long matchId, Long inning, Long turn, String resultType) {
        return loadMatchDetails(matchId, resultType);
    }

    private ModelAndView loadMatchDetails(Long matchId, String resultType) {
        TournamentMatchDetails matchDetails = matchManager.getById(matchId);
        ModelAndView modelAndView = new ModelAndView("result/match-result");

        TournamentParticipant tournamentParticipant1 = participantManager.getById(matchDetails.getTeamParticipant1Id());
        TournamentParticipant tournamentParticipant2 = participantManager.getById(matchDetails.getTeamParticipant2Id());

        List<TournamentParticipantTeam> participantTeam1 = participantManager.getByTournamentParticipantOrderByChaseNumber(tournamentParticipant1);
        List<TournamentParticipantTeam> participantTeam2 = participantManager.getByTournamentParticipantOrderByChaseNumber(tournamentParticipant2);

        String team1Name = teamManager.getById(tournamentParticipant1.getTeamId(), false).getDisplayName();
        String team2Name = teamManager.getById(tournamentParticipant2.getTeamId(), false).getDisplayName();

        Long team1Score = matchPointManager.getTotalMatchPointsForTheTeam(matchDetails, participantTeam2);
        Long team2Score = matchPointManager.getTotalMatchPointsForTheTeam(matchDetails, participantTeam1);

        List<MatchTurnDetails> turnList = turnManager.getTurnsByMatch(matchDetails);
        String halfTimeStatus = getHalfTimeStatus(turnList);
        List<MatchPointDetails> topDefendersTeam1 = matchPointManager.getTopDefendersListByMatch(matchDetails, participantTeam1);
        List<MatchPointDetails> topDefendersTeam2 = matchPointManager.getTopDefendersListByMatch(matchDetails, participantTeam2);

        List<PlayerPerformace> topAttackersTeam1 = matchPointManager.getTopAttackersListByMatch(matchDetails, participantTeam1);
        List<PlayerPerformace> topAttackersTeam2 = matchPointManager.getTopAttackersListByMatch(matchDetails, participantTeam2);

        List<PlayerPerformace> team1TopDefenders = fetchPlayerPerformances(topDefendersTeam1);
        List<PlayerPerformace> team2TopDefenders = fetchPlayerPerformances(topDefendersTeam2);
        
        topAttackersTeam1 = cleanUpAndFillPlayerDetails(topAttackersTeam1);
        topAttackersTeam2 = cleanUpAndFillPlayerDetails(topAttackersTeam2);

        String resultDescription = "";
        String winningTeamName = team1Name;
        Long scoreDiff = team1Score - team2Score;
        String resultTitle = "";
        String modalClass = "results";
        if(scoreDiff < 0) {
            winningTeamName = team2Name;
            scoreDiff = -1 * scoreDiff;
        }

        if("matchHightlights".equals(resultType)) {
            resultTitle = "Match Highlights";
            resultDescription = winningTeamName + " leading by " + scoreDiff + " points.";
            modalClass = "highlights";
        } else {
            resultTitle = "Final Score"; 
            if("HALFTIME-COMPLETED".equals(halfTimeStatus)) {
                Long team1HalfTimeScore = matchPointManager.getTotalMatchPointsForTheTeamByInning(1L, matchDetails, participantTeam2);
                Long team2HalfTimeScore = matchPointManager.getTotalMatchPointsForTheTeamByInning(1L, matchDetails, participantTeam1);
                modelAndView.addObject("isHalfTimeCompleted", true);
                modelAndView.addObject("team1HalfTimeScore", team1HalfTimeScore);
                modelAndView.addObject("team2HalfTimeScore", team2HalfTimeScore);
            }
            resultDescription = winningTeamName + " won by " + scoreDiff + " points.";
        }

        modelAndView.addObject("team1Name", team1Name);
        modelAndView.addObject("team2Name", team2Name);
        modelAndView.addObject("team1Score", team1Score);
        modelAndView.addObject("team2Score", team2Score);
        modelAndView.addObject("team1Defenders", team1TopDefenders);
        modelAndView.addObject("team2Defenders", team2TopDefenders);
        modelAndView.addObject("team1Attackers", topAttackersTeam1);
        modelAndView.addObject("team2Attackers", topAttackersTeam2);
        modelAndView.addObject("resultDescription", resultDescription);
        modelAndView.addObject("resultTitle", resultTitle);
        modelAndView.addObject("modalClass", modalClass);
        
        return modelAndView;
    }

    private String getHalfTimeStatus(List<MatchTurnDetails> turnList) {
        MatchTurnDetails turn2 = fetchTurn(1L, 2L, turnList);
        if(turn2.getStatus().equals(TurnStatus.COMPLETED) || turn2.getStatus().equals(TurnStatus.ABORTED)) {
            return "HALFTIME-COMPLETED";
        }
        return null;
    }

    private MatchTurnDetails fetchTurn(Long i, Long t, List<MatchTurnDetails> turnList) {
        for(MatchTurnDetails turnDetails : turnList) {
            if(turnDetails.getTurnNumber().longValue() == i && turnDetails.getInningNumber().longValue() == i) {
                return turnDetails;
            }
        }
        return null;
    }

    private List<PlayerPerformace> cleanUpAndFillPlayerDetails(List<PlayerPerformace> topAttackersTeam) {
        List<PlayerPerformace> lstPlayerPerformances = new ArrayList<>();
        for(PlayerPerformace playerPerformance : topAttackersTeam) {
            if(playerPerformance != null) {
                PlayerProfile playerProfile = playerProfileManager.getByTournamentParticipantProfileId(playerPerformance.getTournamentParticipantProfileId());
                setDisplayName(playerPerformance, playerProfile);
                lstPlayerPerformances.add(playerPerformance);
                if(lstPlayerPerformances.size() > 3) break;
            }
        }
        return lstPlayerPerformances;
    }

    private void setDisplayName(PlayerPerformace playerPerformance, PlayerProfile playerProfile) {
        playerPerformance.setPlayerName(playerProfile.getFirstName() + " " + playerProfile.getLastName().substring(0, 1) + ".");        
    }

    private List<PlayerPerformace> fetchPlayerPerformances(List<MatchPointDetails> topDefenders) {
        List<PlayerPerformace> topDefendersList = new ArrayList<>();
        int playerCount = 0;
        if(!CollectionUtils.isEmpty(topDefenders)) {
            for(MatchPointDetails pointDetails : topDefenders) {
                if(playerCount > 3) {
                    break;
                }
                PlayerProfile playerProfile = playerProfileManager.getByTournamentParticipantProfileId(pointDetails.getDefenceParticipantProfileId());
                PlayerPerformace playerPerformance = new PlayerPerformace();
                setDisplayName(playerPerformance, playerProfile);
                playerPerformance.setPerTime(pointDetails.getPerTime());
                topDefendersList.add(playerPerformance);
            }
        }
        return topDefendersList;
    }
}
