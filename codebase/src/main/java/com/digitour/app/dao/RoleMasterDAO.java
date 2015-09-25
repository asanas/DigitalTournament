package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.example.RoleMaster;

public interface RoleMasterDAO {

    public void persist(RoleMaster transientInstance);
    public void attachDirty(RoleMaster instance);

    public void attachClean(RoleMaster instance);

    public void delete(RoleMaster persistentInstance);

    public RoleMaster merge(RoleMaster detachedInstance);

    public RoleMaster findById(java.lang.Long id);

    public List<RoleMaster> findByExample(RoleMaster instance);
}
