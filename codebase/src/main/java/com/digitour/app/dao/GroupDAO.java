package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.Group;

public interface GroupDAO {

    public void persist(Group transientInstance);

    public void attachDirty(Group instance);

    public void attachClean(Group instance);

    public void delete(Group persistentInstance);

    public Group merge(Group detachedInstance);
    public Group findById(java.lang.Long id);

    public List<Group> findByExample(Group instance);
}
