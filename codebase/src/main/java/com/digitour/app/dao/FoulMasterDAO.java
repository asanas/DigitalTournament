package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.example.FoulMaster;

public interface FoulMasterDAO {

    public void persist(FoulMaster transientInstance);
    public void attachDirty(FoulMaster instance);

    public void attachClean(FoulMaster instance);
    public void delete(FoulMaster persistentInstance);

    public FoulMaster merge(FoulMaster detachedInstance);

    public FoulMaster findById(java.lang.Long id);

    public List<FoulMaster> findByExample(FoulMaster instance);
}
