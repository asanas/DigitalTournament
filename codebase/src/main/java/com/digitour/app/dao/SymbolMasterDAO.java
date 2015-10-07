package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.Symbol;

public interface SymbolMasterDAO {
	public Symbol getById(Long symbolId);

	public List<Symbol> getAllSymbols();
}
