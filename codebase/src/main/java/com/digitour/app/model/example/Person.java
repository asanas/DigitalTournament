package com.digitour.app.model.example;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "society_members")
public class Person implements Serializable {

    private Long id;

    private List<Department> departmentList;

    private String fullName;

    @Id
    @GeneratedValue
    @Column(name = "person_id", unique = true, nullable = false)
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Column(name = "full_name", nullable = false)
    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    @OneToMany(mappedBy = "person")
    public List<Department> getDepartmentList()
    {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList)
    {
        this.departmentList = departmentList;
    }

}
