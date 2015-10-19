package com.digitour.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.digitour.app.dao.FoulDetailsDAO;
import com.digitour.app.db.model.FoulDetails;

@Repository
public class FoulDetailsDAOImpl implements FoulDetailsDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Override
	public List<FoulDetails> getAll() {
		return this.hibernateTemplate.loadAll(FoulDetails.class);
	}

	@Override
	public FoulDetails getById(Long foulId) {
		return this.hibernateTemplate.load(FoulDetails.class, foulId);
	}

}
