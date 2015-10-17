package com.digitour.app.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitour.app.dao.StateDAO;
import com.digitour.app.db.model.State;
import com.digitour.app.manager.StateManager;

@Service
public class StateManagerImpl implements StateManager {

	@Autowired
	StateDAO stateDAO;
	
	@Override
	public List<State> getAllStates() {
		return stateDAO.getAllStates();
	}

}
