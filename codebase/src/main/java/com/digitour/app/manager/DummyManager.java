package com.digitour.app.manager;

import java.util.List;

import com.digitour.app.model.City;

public interface DummyManager {
    public List<City> getAllCities();
    public City getCityById(Long id);
}
