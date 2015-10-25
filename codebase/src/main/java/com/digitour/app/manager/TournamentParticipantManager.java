package com.digitour.app.manager;

import java.util.List;

import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.db.model.TournamentParticipantTeam;

public interface TournamentParticipantManager {

    TournamentParticipant getById(Long teamParticipant1Id);

    public List<TournamentParticipantTeam> getByTournamentParticipantOrderByChaseNumber(TournamentParticipant tournamentParticipant1);

}
