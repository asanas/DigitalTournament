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
import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.db.model.TournamentParticipantTeam;
import com.digitour.app.manager.MatchPointManager;
import com.digitour.app.manager.MatchResultsManager;
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
    
    @RequestMapping(path = "/showMatchResults", method = RequestMethod.GET)
    public ModelAndView showMatchResult(Long matchId, Long inning, Long turn) {
        return loadMatchDetails(matchId);    
    }

    private ModelAndView loadMatchDetails(Long matchId) {
        TournamentMatchDetails matchDetails = matchManager.getById(matchId);
        ModelAndView modelAndView = new ModelAndView("result/match-result");

        TournamentParticipant tournamentParticipant1 = participantManager.getById(matchDetails.getTeamParticipant1Id());
        TournamentParticipant tournamentParticipant2 = participantManager.getById(matchDetails.getTeamParticipant2Id());

        List<TournamentParticipantTeam> participantTeam1 = participantManager.getByTournamentParticipantOrderByChaseNumber(tournamentParticipant1);
        List<TournamentParticipantTeam> participantTeam2 = participantManager.getByTournamentParticipantOrderByChaseNumber(tournamentParticipant2);

        String team1Name = teamManager.getById(tournamentParticipant1.getTeamId(), false).getDisplayName();
        String team2Name = teamManager.getById(tournamentParticipant2.getTeamId(), false).getDisplayName();

        Long team1Score = matchPointManager.getTotalMatchPointsForTheTeam(matchDetails, participantTeam1);
        Long team2Score = matchPointManager.getTotalMatchPointsForTheTeam(matchDetails, participantTeam2);
        

        List<MatchPointDetails> topDefendersTeam1 = matchPointManager.getTopDefendersList(matchDetails, participantTeam1);
        List<MatchPointDetails> topDefendersTeam2 = matchPointManager.getTopDefendersList(matchDetails, participantTeam2);
        
        List<PlayerPerformace> team1TopDefenders = fetchPlayerPerformances(topDefendersTeam1);
        List<PlayerPerformace> team2TopDefenders = fetchPlayerPerformances(topDefendersTeam2);
        
        String resultDescription = "";
        String winningTeamName = team1Name;
        Long scoreDiff = team1Score - team2Score;
        
        if(scoreDiff < 0) {
            winningTeamName = team2Name;
            scoreDiff = -1 * scoreDiff;
        }
        
        resultDescription = winningTeamName + " won by " + scoreDiff + " points.";
        modelAndView.addObject("team1Name", team1Name);
        modelAndView.addObject("team2Name", team2Name);
        modelAndView.addObject("team1Score", team1Score);
        modelAndView.addObject("team2Score", team2Score);
        modelAndView.addObject("team1Defenders", team1TopDefenders);
        modelAndView.addObject("team2Defenders", team2TopDefenders);
        modelAndView.addObject("resultDescription", resultDescription);
        return modelAndView;
    }

    private List<PlayerPerformace> fetchPlayerPerformances(List<MatchPointDetails> topDefenders) {
        List<PlayerPerformace> topDefendersList = new ArrayList<>();
        int playerCount = 0;
        if(!CollectionUtils.isEmpty(topDefenders)) {
            for(MatchPointDetails pointDetails : topDefenders) {
                if(playerCount > 3) {
                    break;
                }
                TournamentParticipantTeam participantProfile = participantTeamManager.getById(pointDetails.getDefenceParticipantProfileId());
                PlayerProfile playerProfile = playerProfileManager.getById(participantProfile.getPlayerProfileId());
                PlayerPerformace playerPerformance = new PlayerPerformace();
                playerPerformance.setPlayerName(playerProfile.getFirstName() + " " + playerProfile.getLastName().substring(0, 1) + ".");
                playerPerformance.setPerTime(pointDetails.getPerTime());
                topDefendersList.add(playerPerformance);
            }
        }
        return topDefendersList;
    }
}
