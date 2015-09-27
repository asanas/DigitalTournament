package com.digitour.app.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.digitour.app.db.model.City;

public class CityMasterDAOImplTests {

    private static final Log log = LogFactory.getLog(CityMasterDAOImplTests.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<City> getAll() {
        log.debug("Loading all city names");
        return hibernateTemplate.loadAll(City.class);
    }
    
}
