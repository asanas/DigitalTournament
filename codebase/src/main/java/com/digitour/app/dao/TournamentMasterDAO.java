package com.digitour.app.dao;

import com.digitour.app.db.model.Tournament;


public interface TournamentMasterDAO {

    public void save(Tournament transientInstance);
}
