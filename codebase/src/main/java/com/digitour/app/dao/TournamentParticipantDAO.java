package com.digitour.app.dao;

import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.TournamentParticipant;

public interface TournamentParticipantDAO {

	public void save(TournamentParticipant tourPartipant);

    public TournamentParticipant getById(Long teamParticipant1Id);

	public TournamentParticipant getTournamentParticipantByTeamAndTournament(Team team, Long tournamentId);
}
