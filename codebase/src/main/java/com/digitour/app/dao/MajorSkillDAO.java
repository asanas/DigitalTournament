package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.MajorSkill;

public interface MajorSkillDAO {

    public void persist(MajorSkill transientInstance);

    public void attachDirty(MajorSkill instance);

    public void attachClean(MajorSkill instance);

    public void delete(MajorSkill persistentInstance);

    public MajorSkill merge(MajorSkill detachedInstance);

    public MajorSkill findById(java.lang.Long id);

    public List<MajorSkill> findByExample(MajorSkill instance);
}
