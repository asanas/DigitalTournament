package com.digitour.app.db.model.support.enums;

public enum AgeGroup {
    
    U14("Under-14"), U18("Under-18"), OPEN("Open");
    private String textAgeGroup;
    
    private AgeGroup(String textAgeGroup) {
        this.textAgeGroup = textAgeGroup;
    }
    
    public String getTextAgeGroup() {
        return this.textAgeGroup;
    }

}
