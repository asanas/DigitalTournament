package com.digitour.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.digitour.app.dao.SymbolMasterDAO;
import com.digitour.app.db.model.Symbol;

@Repository
public class SymbolMasterDAOImpl implements SymbolMasterDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Override
	public Symbol getById(Long symbolId) {
		return this.hibernateTemplate.load(Symbol.class, symbolId);
	}

	@Override
	public List<Symbol> getAllSymbols() {
		return this.hibernateTemplate.loadAll(Symbol.class);
	}

}
