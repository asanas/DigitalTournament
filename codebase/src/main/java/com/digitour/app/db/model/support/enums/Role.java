package com.digitour.app.db.model.support.enums;

public enum Role {
    ATTACKER("Attacker"), DEFENDER("Defender"), ALLROUNDER("All Rounder"), COACH("Coach"), MANAGER("Manager");
    
    private String textRole;
    
    private Role(String roleText) {
        this.textRole = roleText;
    }
    
    public String getTextRole() {
        return this.textRole;
    }
}
