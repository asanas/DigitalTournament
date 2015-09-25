package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.example.TournamentParticipantTeamMaster;

public interface TournamentParticipantTeamMasterDAO {

    public void persist(TournamentParticipantTeamMaster transientInstance);
    public void attachDirty(TournamentParticipantTeamMaster instance);

    public void attachClean(TournamentParticipantTeamMaster instance);

    public void delete(TournamentParticipantTeamMaster persistentInstance);
    public TournamentParticipantTeamMaster merge(TournamentParticipantTeamMaster detachedInstance);

    public TournamentParticipantTeamMaster findById(java.lang.Long id);
    public List<TournamentParticipantTeamMaster> findByExample(TournamentParticipantTeamMaster instance);
}
