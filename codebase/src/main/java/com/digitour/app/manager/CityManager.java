package com.digitour.app.manager;

import java.util.List;

import com.digitour.app.db.model.City;

public interface CityManager {

	List<City> getAllCities();

	City getById(Long cityId);

}
