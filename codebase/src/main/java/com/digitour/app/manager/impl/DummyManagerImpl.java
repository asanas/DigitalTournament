package com.digitour.app.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitour.app.dao.CityMasterDAO;
import com.digitour.app.manager.DummyManager;
import com.digitour.app.model.City;

@Service
public class DummyManagerImpl implements DummyManager
{

    @Autowired
    CityMasterDAO cityMasterDAO;
    
    @Override
    public List<City> getAllCities() {
        return cityMasterDAO.getAll();
    }

    @Override
    public City getCityById(Long id) {
        return cityMasterDAO.getById(id);
    }
}
