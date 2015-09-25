package com.digitour.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.digitour.app.dao.PersonDAO;
import com.digitour.app.model.example.Person;

// @Repository
public class PersonDAOImpl implements PersonDAO
{

    // @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Person> getAll() {
        return hibernateTemplate.loadAll(Person.class);
    }

}
