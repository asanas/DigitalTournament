package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.TossDetailsMaster;

public interface TossDetailsMasterDAO {


    public void persist(TossDetailsMaster transientInstance);
    public void attachDirty(TossDetailsMaster instance);

    public void attachClean(TossDetailsMaster instance);

    public void delete(TossDetailsMaster persistentInstance);

    public TossDetailsMaster merge(TossDetailsMaster detachedInstance);
    public TossDetailsMaster findById(java.lang.Long id);
    public List<TossDetailsMaster> findByExample(TossDetailsMaster instance);
}
