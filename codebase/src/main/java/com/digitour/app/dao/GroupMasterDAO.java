package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.GroupMaster;

public interface GroupMasterDAO {

    public void persist(GroupMaster transientInstance);

    public void attachDirty(GroupMaster instance);

    public void attachClean(GroupMaster instance);

    public void delete(GroupMaster persistentInstance);

    public GroupMaster merge(GroupMaster detachedInstance);
    public GroupMaster findById(java.lang.Long id);

    public List<GroupMaster> findByExample(GroupMaster instance);
}
