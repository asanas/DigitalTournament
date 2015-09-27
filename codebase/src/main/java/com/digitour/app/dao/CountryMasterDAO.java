package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.Country;

public interface CountryMasterDAO {

    public void persist(Country transientInstance);
    public void attachDirty(Country instance);
    public void attachClean(Country instance);

    public void delete(Country persistentInstance);

    public Country merge(Country detachedInstance);

    public Country findById(java.lang.Long id);

    public List<Country> findByExample(Country instance);
}