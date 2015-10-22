package com.digitour.app.db.model.support.enums;

public enum MajorSkill {
    DIVE("Dive"), POLEDIVE("Pole"), JUDGEMENTKHO("Judgement Kho"), RUSH("Rush"), 
    ROOT("Root"), RING("Ring"), SUDDENATTACK("SuddenAttack"), CHANGES("Changes"), DEFENCE("Defence"), ATTACK("Attack");
    
    private String textMajorSkill;
    
    private MajorSkill(String textMajorSkill) {
        this.textMajorSkill = textMajorSkill;
    }
    
    public String getTextMajorSkill() {
        return this.textMajorSkill;
    }
}
