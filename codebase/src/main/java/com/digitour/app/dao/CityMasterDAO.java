package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.CityMaster;

public interface CityMasterDAO {

    public void persist(CityMaster transientInstance);

    public void attachDirty(CityMaster instance);

    public void attachClean(CityMaster instance);

    public void delete(CityMaster persistentInstance);

    public CityMaster merge(CityMaster detachedInstance);

    public CityMaster findById(java.lang.Long id);

    public List<CityMaster> findByExample(CityMaster instance);
}
