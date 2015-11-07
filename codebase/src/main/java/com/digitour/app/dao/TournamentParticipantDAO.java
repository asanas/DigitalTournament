package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.Tournament;
import com.digitour.app.db.model.TournamentParticipant;

public interface TournamentParticipantDAO {

    public void save(TournamentParticipant tourPartipant);

    public TournamentParticipant getById(Long teamParticipant1Id);

    public TournamentParticipant getTournamentParticipantByTeamAndTournament(Team team, Long tournamentId);

	public List<TournamentParticipant> getByTournament(Tournament tournament);
}
