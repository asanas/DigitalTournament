package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.TournamentParticipant;

public interface TournamentParticipantMasterDAO {

    public void persist(TournamentParticipant transientInstance);

    public void attachDirty(TournamentParticipant instance);

    public void attachClean(TournamentParticipant instance);

    public void delete(TournamentParticipant persistentInstance);

    public TournamentParticipant merge(TournamentParticipant detachedInstance);

    public TournamentParticipant findById(java.lang.Long id);
    public List<TournamentParticipant> findByExample(TournamentParticipant instance);
}
