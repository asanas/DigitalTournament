package com.digitour.app.model.example;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "major_skill")
public class MajorSkill implements java.io.Serializable {

    private Long majorSkillId;
    private String skillName;
    private Set<PlayerProfileMaster> playerProfileMasters = new HashSet<PlayerProfileMaster>(0);

    public MajorSkill() {
    }

    public MajorSkill(String skillName) {
        this.skillName = skillName;
    }

    public MajorSkill(String skillName, Set<PlayerProfileMaster> playerProfileMasters) {
        this.skillName = skillName;
        this.playerProfileMasters = playerProfileMasters;
    }

    @Id
    @GeneratedValue
    @Column(name = "major_skill_id", unique = true, nullable = false)
    public Long getMajorSkillId() {
        return this.majorSkillId;
    }

    public void setMajorSkillId(Long majorSkillId) {
        this.majorSkillId = majorSkillId;
    }

    @Column(name = "skill_name", nullable = false)
    public String getSkillName() {
        return this.skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "majorskill")
    public Set<PlayerProfileMaster> getPlayerProfileMasters() {
        return this.playerProfileMasters;
    }

    public void setPlayerProfileMasters(Set<PlayerProfileMaster> playerProfileMasters) {
        this.playerProfileMasters = playerProfileMasters;
    }

}
