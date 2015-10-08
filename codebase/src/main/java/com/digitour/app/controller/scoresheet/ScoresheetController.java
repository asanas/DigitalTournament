package com.digitour.app.controller.scoresheet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.digitour.app.dao.MatchTurnDAO;
import com.digitour.app.dao.MatchPointMasterDAO;
import com.digitour.app.dao.PlayerProfileDAO;
import com.digitour.app.dao.SymbolMasterDAO;
import com.digitour.app.dao.TeamDAO;
import com.digitour.app.dao.TossDetailsDAO;
import com.digitour.app.dao.TournamentMatchDAO;
import com.digitour.app.dao.TournamentParticipantDAO;
import com.digitour.app.dao.TournamentParticipantTeamDAO;
import com.digitour.app.db.model.MatchTurnDetails;
import com.digitour.app.db.model.MatchPointDetails;
import com.digitour.app.db.model.MatchTossDetails;
import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.Symbol;
import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.db.model.TournamentParticipantTeam;
import com.digitour.app.db.model.support.enums.TurnStatus;

@Controller
public class ScoresheetController {
    
    @Autowired
    TournamentMatchDAO tournamentDAO;
    
    @Autowired
    TeamDAO teamDAO;
    
    @Autowired
    TossDetailsDAO tossDetailsDAO;
    
    @Autowired
    TournamentParticipantDAO tournamentParticipantDAO;
    
    @Autowired
    TournamentParticipantTeamDAO tournamentParticipantTeamDAO;
    
    @Autowired
    PlayerProfileDAO playerProfileDAO;
    
    @Autowired
    MatchPointMasterDAO matchPointDAO;
    
    @Autowired
    TournamentMatchDAO tournamentMatchDAO;
    
    @Autowired
    SymbolMasterDAO symbolDAO;
    
    @Autowired
    MatchTurnDAO matchInningDAO;
    
    @RequestMapping(path ="/loadScoresheet/match/{matchId}/inning/{inning}/turn/{turn}", method=RequestMethod.GET)
    public ModelAndView showHomepage(@PathVariable Long matchId, @PathVariable Long inning, @PathVariable Long turn) {
        ModelAndView modelAndView = new ModelAndView("scoresheet/scoresheethome");
        TournamentMatchDetails tourMatchDetails = tournamentDAO.getMatchDetailsById(matchId);
        if(tourMatchDetails != null) {
            populateScoresheetData(modelAndView, tourMatchDetails, inning, turn);
        }
        return modelAndView;
    }

    @RequestMapping(value="/addMatchPoint", method=RequestMethod.POST)
    @ResponseBody
    public String addMatchPoint(@RequestParam Long matchId, @RequestParam  Long defenderProfileId, @RequestParam Long chaserProfileId,
            @RequestParam Long symbolId, @RequestParam String formattedTimePlayed, @RequestParam Long inning, @RequestParam Long turn,
            @RequestParam Long runTime ) {
    	TournamentMatchDetails matchDetails = tournamentMatchDAO.getMatchDetailsById(matchId);
    	PlayerProfile defenderPlayerProfile = playerProfileDAO.getById(defenderProfileId);
    	PlayerProfile chaserPlayerProfile = playerProfileDAO.getById(chaserProfileId);
    	TournamentParticipant defenderParticipant = tournamentParticipantDAO.getTournamentParticipantByTeamAndTournament(defenderPlayerProfile.getTeam(), 
    			matchDetails.getTournamentId());
    	TournamentParticipant chaserParticipant = tournamentParticipantDAO.getTournamentParticipantByTeamAndTournament(chaserPlayerProfile.getTeam(), 
    			matchDetails.getTournamentId());
    	TournamentParticipantTeam defenderProfileTourTeam = tournamentParticipantTeamDAO.getByPlayerProfileAndTournamentParticipant(defenderPlayerProfile, defenderParticipant);
    	TournamentParticipantTeam chaserProfileTourTeam = tournamentParticipantTeamDAO.getByPlayerProfileAndTournamentParticipant(chaserPlayerProfile, chaserParticipant);
    	String[] perTimeSplit = formattedTimePlayed.split(" ");
    	Long minutes = Long.parseLong(perTimeSplit[0].substring(0, 1));
    	Long seconds = Long.parseLong(perTimeSplit[1].substring(0, perTimeSplit[1].length()-1));
    	Long perTime = minutes * 60 + seconds;
    	Symbol symbol = symbolDAO.getById(symbolId);
    	MatchPointDetails matchPoint = new MatchPointDetails();
    	matchPoint.setDefenceParticipantProfileId(defenderProfileTourTeam.getTournamentParticipantPlayerId());
    	matchPoint.setAttackParticipantProfileId(chaserProfileTourTeam.getTournamentParticipantPlayerId());
    	matchPoint.setAssistParticipantProfileId(chaserProfileTourTeam.getTournamentParticipantPlayerId());
    	matchPoint.setMatchId(matchDetails.getTournamentMatchId());
    	matchPoint.setSymbol(symbol);
    	matchPoint.setOut(true);
    	matchPoint.setTurnClosure(false);
    	matchPoint.setPerTime(perTime);
    	matchPoint.setRunTime(runTime);
    	matchPoint.setTurnNumber(turn);
    	matchPoint.setInningNumber(inning);
        matchPointDAO.save(matchPoint);
    	return "success";
    }
    
    private void populateScoresheetData(ModelAndView modelAndView, TournamentMatchDetails tournamentMatchDetails, Long inning, Long turn) {
        TournamentParticipant tournamentParticipant1 = tournamentParticipantDAO.getById(tournamentMatchDetails.getTeamParticipant1Id());
        TournamentParticipant tournamentParticipant2 = tournamentParticipantDAO.getById(tournamentMatchDetails.getTeamParticipant2Id());
        MatchTossDetails tossDetails = tossDetailsDAO.getTossDetailsByMatchId(tournamentMatchDetails.getTournamentMatchId());
        String tossWonMsg = createTossWonMessage(tournamentParticipant1, tournamentParticipant2, tossDetails);
        modelAndView.addObject("tossWonMessage", tossWonMsg);
        modelAndView.addObject("matchId", tournamentMatchDetails.getTournamentMatchId());
        populateSymbols(modelAndView);
        populateParticipatingTeams(tournamentMatchDetails, tournamentParticipant1, tournamentParticipant2, tossDetails, modelAndView, inning, turn);
    }

    private void populateSymbols(ModelAndView modelAndView) {
    	List<Symbol> symbolList = symbolDAO.getAllSymbols();
    	modelAndView.addObject("symbolList", symbolList);
	}

	private void populateMatchPointDetails(TournamentMatchDetails tournamentMatchDetails, Long inning, Long turn, List<TournamentParticipantTeam> defendingParticipatingTeam,
            List<PlayerProfile> defendingTeamList) {
	    for(TournamentParticipantTeam defendingPlayer: defendingParticipatingTeam) {
            List<MatchPointDetails> matchPointList = matchPointDAO.getMatchPointsByInningTurnAndDefender(tournamentMatchDetails, defendingPlayer.getTournamentParticipantPlayerId(), inning, turn);
            if(matchPointList != null && matchPointList.size() > 0) {
                PlayerProfile playerProfile = playerProfileDAO.getById(defendingPlayer.getPlayerProfileId());
                for(MatchPointDetails matchPoint: matchPointList) {
                    matchPoint.setDefenderName(playerProfile.getFirstName() + " " + playerProfile.getLastName());
                    TournamentParticipantTeam chaserParticipatingProfile = tournamentParticipantTeamDAO.getById(matchPoint.getAttackParticipantProfileId());
                    PlayerProfile chaserPlayerProfile = playerProfileDAO.getById(chaserParticipatingProfile.getPlayerProfileId());
                    matchPoint.setChaserName(chaserPlayerProfile.getFirstName() + " " + chaserPlayerProfile.getLastName());
                }
                attachMatchPointListToPlayerProfile(defendingTeamList, matchPointList, playerProfile);
            }
        }
    }

    private void attachMatchPointListToPlayerProfile(List<PlayerProfile> defendingTeamList, List<MatchPointDetails> matchPointList, PlayerProfile playerProfileToCompare) {
        for(PlayerProfile playerProfile : defendingTeamList) {
            if(playerProfile.getPlayerProfileId().equals(playerProfileToCompare.getPlayerProfileId())) {
                playerProfile.setMatchPointDetailsList(matchPointList);
                break;
            }
        }
    }

    private void populateParticipatingTeams(TournamentMatchDetails tournamentMatchDetails, TournamentParticipant tournamentParticipant1,
            TournamentParticipant tournamentParticipant2, MatchTossDetails tossDetails, ModelAndView modelAndView, Long inning, Long turn) {
    	List<TournamentParticipantTeam> tournamentParticipantTeam1 = tournamentParticipantTeamDAO.getByTournamentParticipantOrderByChaseNumber(tournamentParticipant1);
        List<TournamentParticipantTeam> tournamentParticipantTeam2 = tournamentParticipantTeamDAO.getByTournamentParticipantOrderByChaseNumber(tournamentParticipant2);
        
        List<PlayerProfile> participatingTeam1 = getTeamPlayers(tournamentParticipantTeam1);
        List<PlayerProfile> participatingTeam2 = getTeamPlayers(tournamentParticipantTeam2);

        List<PlayerProfile> defendingTeam = findTeamForCurrentInningAndTurn(tossDetails, tournamentParticipant1, tournamentParticipant2, participatingTeam1, participatingTeam2, "DEFENCE", turn);
        List<PlayerProfile> chasingTeam = findTeamForCurrentInningAndTurn(tossDetails, tournamentParticipant1, tournamentParticipant2, participatingTeam1, participatingTeam2, "CHASE", turn);
        
        modelAndView.addObject("defendingTeam", defendingTeam);
        modelAndView.addObject("chasingTeam", chasingTeam);
        
        modelAndView.addObject("defendingTeamName", defendingTeam.get(0).getTeam().getName());
        modelAndView.addObject("chasingTeamName", chasingTeam.get(0).getTeam().getName());

        modelAndView.addObject("defendingTeamName", defendingTeam.get(0).getTeam().getName());
        
        MatchTurnDetails turnDetails = matchInningDAO.getInningDetailsByMatchInningAndTurnNumber(tournamentMatchDetails.getTournamentMatchId(), inning, turn);
        if(turnDetails != null && !TurnStatus.NOTSTARTED.equals(turnDetails.getStatus())) {
        	if(defendingTeam.get(0).getTeam().getTeamId().equals(tournamentParticipant1.getTeamId())) {
                populateMatchPointDetails(tournamentMatchDetails, inning, turn, tournamentParticipantTeam1, defendingTeam);
                addMatchTotalScoreForBothTeams(modelAndView, tournamentMatchDetails, tournamentParticipantTeam1, tournamentParticipantTeam2);
        	} else {
                populateMatchPointDetails(tournamentMatchDetails, inning, turn, tournamentParticipantTeam2, defendingTeam);
                addMatchTotalScoreForBothTeams(modelAndView, tournamentMatchDetails, tournamentParticipantTeam2, tournamentParticipantTeam1);
        	}
            addLapsedTimeTillNow(modelAndView, tournamentMatchDetails, inning, turn);
        }
    }

    private void addMatchTotalScoreForBothTeams(ModelAndView modelAndView,
			TournamentMatchDetails tournamentMatchDetails, List<TournamentParticipantTeam> chasingParticipantTeam,
			List<TournamentParticipantTeam> defendingParticipatingTeam) {
        Long defendingParticipantTeamScore = 0L;
        Long chasingParticipantTeamScore = 0L;
        
        defendingParticipantTeamScore = matchPointDAO.getTotalMatchPointsForTheTeam(tournamentMatchDetails, chasingParticipantTeam);
        chasingParticipantTeamScore = matchPointDAO.getTotalMatchPointsForTheTeam(tournamentMatchDetails, defendingParticipatingTeam);
	
        modelAndView.addObject("defendingTeamScore", defendingParticipantTeamScore);
        modelAndView.addObject("chasingTeamScore", chasingParticipantTeamScore);
    }

	private void addLapsedTimeTillNow(ModelAndView modelAndView, TournamentMatchDetails tournamentMatchDetails, Long inning, Long turn) {
        Long timeLapsed = matchPointDAO.getMaxRunTimeByMatchInningAndTurn(tournamentMatchDetails, inning, turn);
        modelAndView.addObject("timeLapsed", timeLapsed);
    }

    private List<PlayerProfile> findTeamForCurrentInningAndTurn(MatchTossDetails tossDetails, TournamentParticipant tournamentParticipant1,
            TournamentParticipant tournamentParticipant2, List<PlayerProfile> participatingTeam1, List<PlayerProfile> participatingTeam2, String teamSelection, Long turn) {
        List<PlayerProfile> returnPlayersList = participatingTeam1;
        if(teamSelection.equalsIgnoreCase(tossDetails.getElectedTo())) {
            if(tossDetails.getTossWonByTeamId().equals(tournamentParticipant2.getTourParticipantId()) && turn == 1) {
                returnPlayersList = participatingTeam2;
            }
        } else {
            if(tossDetails.getTossWonByTeamId().equals(tournamentParticipant1.getTourParticipantId()) && turn == 1) {
                returnPlayersList = participatingTeam2;
            }
        }
        return returnPlayersList;
    }

    private List<PlayerProfile> getTeamPlayers(List<TournamentParticipantTeam> tournamentParticipantTeam1) {
        List<PlayerProfile> listPlayers = new ArrayList<PlayerProfile>();
        for(TournamentParticipantTeam tournamentParticipant: tournamentParticipantTeam1) {
            PlayerProfile playerProfile = playerProfileDAO.getById(tournamentParticipant.getPlayerProfileId());
            playerProfile.setTournamentChaseNumber(tournamentParticipant.getPlayerChaseNumber());
            listPlayers.add(playerProfile);
        }
        return listPlayers;
    }

    private String createTossWonMessage(TournamentParticipant tournamentParticipant1, TournamentParticipant tournamentParticipant2, MatchTossDetails tossDetails) {
        String tossWonMsg = "Toss won by ";
        Team team = null;
        if(tossDetails.getTossWonByTeamId().equals(tournamentParticipant1.getTourParticipantId())) {
            team = teamDAO.getById(tournamentParticipant1.getTeamId());
        } else {
            team = teamDAO.getById(tournamentParticipant2.getTeamId());
        }
        tossWonMsg = tossWonMsg + team.getName() + " And elected to " + tossDetails.getElectedTo();
        return tossWonMsg;
    }
}
