package com.digitour.app.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitour.app.dao.CityMasterDAO;
import com.digitour.app.manager.DummyManager;
import com.digitour.app.model.CityMaster;

@Service
public class DummyManagerImpl implements DummyManager
{

    @Autowired
    CityMasterDAO cityMasterDAO;
    
    @Override
    public List<CityMaster> getAllCities() {
        return cityMasterDAO.getAll();
    }

}
