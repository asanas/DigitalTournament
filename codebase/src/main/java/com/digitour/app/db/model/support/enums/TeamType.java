package com.digitour.app.db.model.support.enums;

public enum TeamType {
	MEN("Men"), WOMEN("Women"), BOYS("Boys"), GIRLS("Girls");
	private String teamType;
	private TeamType(String teamtype) {
	    this.teamType = teamtype;
	}

	public String getTeamType() {
	    return this.teamType;
	}
}
