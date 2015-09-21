package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.TournamentParticipantMaster;

public interface TournamentParticipantMasterDAO {

    public void persist(TournamentParticipantMaster transientInstance);

    public void attachDirty(TournamentParticipantMaster instance);

    public void attachClean(TournamentParticipantMaster instance);

    public void delete(TournamentParticipantMaster persistentInstance);

    public TournamentParticipantMaster merge(TournamentParticipantMaster detachedInstance);

    public TournamentParticipantMaster findById(java.lang.Long id);
    public List<TournamentParticipantMaster> findByExample(TournamentParticipantMaster instance);
}
