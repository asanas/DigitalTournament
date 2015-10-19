package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.FoulDetails;

public interface FoulDetailsDAO {

	public List<FoulDetails> getAll();

	public FoulDetails getById(Long foulId);

}
