package com.digitour.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.digitour.app.dao.StateDAO;
import com.digitour.app.db.model.State;

@Repository
public class StateDAOImpl implements StateDAO{

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Override
	public List<State> getAllStates() {
		return hibernateTemplate.loadAll(State.class);
	}
	
	
}
