package com.digitour.app.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digitour.app.dao.TournamentMatchDAO;
import com.digitour.app.db.model.TournamentMatchDetails;

@Repository
public class TournamentMatchDAOImpl implements TournamentMatchDAO{

    private static final Log log = LogFactory.getLog(TournamentMatchDAOImpl.class);

    @Autowired
    HibernateTemplate hibernateTemplate;
    
	@Override
	@Transactional
	public void save(TournamentMatchDetails tourMatchDetails) {
		this.hibernateTemplate.saveOrUpdate(tourMatchDetails);
	}

}
