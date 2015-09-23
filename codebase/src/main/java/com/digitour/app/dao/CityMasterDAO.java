package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.City;

public interface CityMasterDAO {

    public void save(City cityMaster);

    public City getById(Long id);

    /*public void attachDirty(CityMaster instance);

    public void attachClean(CityMaster instance);

    public void delete(CityMaster persistentInstance);

    public CityMaster merge(CityMaster detachedInstance);

    public CityMaster findById(java.lang.Long id);

    public List<CityMaster> findByExample(CityMaster instance);*/
    
    public List<City> getAll();
}
