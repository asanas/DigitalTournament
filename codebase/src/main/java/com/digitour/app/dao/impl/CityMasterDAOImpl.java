package com.digitour.app.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.digitour.app.dao.CityMasterDAO;
import com.digitour.app.db.model.City;
import com.digitour.app.model.example.Category;

@Repository
public class CityMasterDAOImpl implements CityMasterDAO{

    private static final Log log = LogFactory.getLog(CityMasterDAOImpl.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<City> getAll() {
        log.debug("Loading all city names");
        return hibernateTemplate.loadAll(City.class);
    }

    @Override
    public void save(City cityMaster) {
        
    }

    @Override
    public City getById(Long id) {
        City cityMaster = hibernateTemplate.load(City.class, id);
        return cityMaster;
    }

	@Override
	public List<Category> getAllCategories() {
		return hibernateTemplate.loadAll(Category.class);
	}
}
