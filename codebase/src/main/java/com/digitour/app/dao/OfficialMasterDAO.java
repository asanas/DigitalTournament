package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.OfficialMaster;

public interface OfficialMasterDAO {

    public void persist(OfficialMaster transientInstance);

    public void attachDirty(OfficialMaster instance);

    public void attachClean(OfficialMaster instance);

    public void delete(OfficialMaster persistentInstance);
    public OfficialMaster merge(OfficialMaster detachedInstance);
    public OfficialMaster findById(java.lang.Long id);
    public List<OfficialMaster> findByExample(OfficialMaster instance);
}
