package com.digitour.app.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitour.app.dao.CityMasterDAO;
import com.digitour.app.db.model.City;
import com.digitour.app.manager.CityManager;

@Service
public class CityManagerImpl implements CityManager {

	@Autowired
	CityMasterDAO cityDAO;
	
	@Override
	public List<City> getAllCities() {
		return cityDAO.getAll();
	}

	@Override
	public City getById(Long cityId) {
		return cityDAO.getById(cityId);
	}

}
