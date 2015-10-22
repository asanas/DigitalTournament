package com.digitour.app.db.model.support.enums;

public enum Gender {
    MALE("Male"), FEMALE("Female");
    
    private String textGender;
    private Gender(String textGender) {
        this.textGender = textGender;
    }
    
    public String getTextGender() {
        return this.textGender;
    }
}
