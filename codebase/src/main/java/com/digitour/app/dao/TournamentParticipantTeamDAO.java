package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.db.model.TournamentParticipantTeam;

public interface TournamentParticipantTeamDAO {
	public void save(TournamentParticipantTeam tourTeam);

    public List<TournamentParticipantTeam> getByTournamentParticipantOrderByChaseNumber(TournamentParticipant tournamentParticipant1);

    public TournamentParticipantTeam getById(Long attackParticipantProfileId);

	public TournamentParticipantTeam getByPlayerProfileAndTournamentParticipant(PlayerProfile defenderPlayerProfile,
			TournamentParticipant defenderParticipant);
}
