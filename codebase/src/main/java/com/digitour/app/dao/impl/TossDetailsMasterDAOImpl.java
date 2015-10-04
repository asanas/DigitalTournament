package com.digitour.app.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digitour.app.dao.TossDetailsMasterDAO;
import com.digitour.app.db.model.MatchTossDetails;

@Repository
public class TossDetailsMasterDAOImpl implements TossDetailsMasterDAO {

    private static final Log log = LogFactory.getLog(TossDetailsMasterDAOImpl.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;

	@Override
	@Transactional
	public void save(MatchTossDetails matchToss) {
		this.hibernateTemplate.saveOrUpdate(matchToss);
	}
    
    
}
