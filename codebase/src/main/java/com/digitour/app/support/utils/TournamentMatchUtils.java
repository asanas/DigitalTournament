package com.digitour.app.support.utils;

import org.springframework.beans.factory.annotation.Autowired;

import com.digitour.app.dao.TournamentParticipantDAO;
import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.db.model.TournamentParticipant;

public final class TournamentMatchUtils {

    private static TournamentMatchUtils tournamentMatchUtils = new TournamentMatchUtils();

    @Autowired
    TournamentParticipantDAO tournamentParticipantDAO;
    
    public static TournamentMatchUtils getInstance() {
        return tournamentMatchUtils;
    }
    
    public TournamentParticipant fetchTournamentParticipantForMatch(TournamentMatchDetails matchDetails, String teamParti) {
        TournamentParticipant tourParticipant = null;
        if(teamParti.endsWith("Team1")) {
            tourParticipant = tournamentParticipantDAO.getById(matchDetails.getTeamParticipant1Id());
        } else {
            tourParticipant = tournamentParticipantDAO.getById(matchDetails.getTeamParticipant2Id());
        }
        return tourParticipant;
    }
}
