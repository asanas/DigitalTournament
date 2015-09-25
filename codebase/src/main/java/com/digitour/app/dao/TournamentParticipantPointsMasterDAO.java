package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.example.TournamentParticipantPointsMaster;

public interface TournamentParticipantPointsMasterDAO {

    public void persist(TournamentParticipantPointsMaster transientInstance);

    public void attachDirty(TournamentParticipantPointsMaster instance);

    public void attachClean(TournamentParticipantPointsMaster instance);

    public void delete(TournamentParticipantPointsMaster persistentInstance);

    public TournamentParticipantPointsMaster merge(TournamentParticipantPointsMaster detachedInstance);

    public TournamentParticipantPointsMaster findById(java.lang.Long id);

    public List<TournamentParticipantPointsMaster> findByExample(TournamentParticipantPointsMaster instance);
}
