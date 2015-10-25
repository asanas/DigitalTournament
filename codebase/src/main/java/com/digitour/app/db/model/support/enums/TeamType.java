package com.digitour.app.db.model.support.enums;

public enum TeamType {
    MEN("Men"), WOMEN("Women"), BOYS("Boys"), GIRLS("Girls");
    private String textTeamType;
    private TeamType(String teamtype) {
        this.textTeamType = teamtype;
    }

    public String getTextTeamType() {
        return this.textTeamType;
    }
}
