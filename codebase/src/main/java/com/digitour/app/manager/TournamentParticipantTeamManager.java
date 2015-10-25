package com.digitour.app.manager;

import java.util.List;

import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.db.model.TournamentParticipantTeam;

public interface TournamentParticipantTeamManager {

    TournamentParticipantTeam getById(Long defenceParticipantProfileId);

    TournamentParticipantTeam getByPlayerProfileAndTournamentParticipant(PlayerProfile playerProfile,
            TournamentParticipant tournamentParticipant);

    List<TournamentParticipantTeam> getByTournamentParticipantOrderByChaseNumber(
            TournamentParticipant tournamentParticipant1);

}
