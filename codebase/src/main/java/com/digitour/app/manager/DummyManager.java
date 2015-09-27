package com.digitour.app.manager;

import java.util.List;

import com.digitour.app.db.model.City;
import com.digitour.app.model.example.Category;

public interface DummyManager {
    public List<City> getAllCities();
    public City getCityById(Long id);
    public List<Category> getAllCategories();
}
