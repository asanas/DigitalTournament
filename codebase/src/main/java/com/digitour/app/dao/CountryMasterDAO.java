package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.CountryMaster;

public interface CountryMasterDAO {

    public void persist(CountryMaster transientInstance);
    public void attachDirty(CountryMaster instance);
    public void attachClean(CountryMaster instance);

    public void delete(CountryMaster persistentInstance);

    public CountryMaster merge(CountryMaster detachedInstance);

    public CountryMaster findById(java.lang.Long id);

    public List<CountryMaster> findByExample(CountryMaster instance);
}