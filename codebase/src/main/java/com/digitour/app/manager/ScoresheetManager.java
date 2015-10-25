package com.digitour.app.manager;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.digitour.app.db.model.MatchTossDetails;
import com.digitour.app.db.model.MatchTurnDetails;
import com.digitour.app.db.model.Symbol;
import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.db.model.TournamentParticipant;

public interface ScoresheetManager {

    String createTossWonMessage(TournamentParticipant tournamentParticipant1,
            TournamentParticipant tournamentParticipant2, MatchTossDetails tossDetails);

	List<Symbol> populateSymbols(ModelAndView modelAndView);

	List<MatchTurnDetails> populateTurns(ModelAndView modelAndView, TournamentMatchDetails tournamentMatchDetails);

}
