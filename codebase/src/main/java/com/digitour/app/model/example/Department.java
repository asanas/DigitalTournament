package com.digitour.app.model.example;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "working_department")
public class Department implements Serializable {


    private Long id;

    private Person person;

    private String departmentName;

    @Id
    @GeneratedValue
    @Column(name = "department_id", unique = true, nullable = false)
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Column(name = "department_name", nullable = false)
    public String getDepartmentName()
    {
        return departmentName;
    }

    public void setDepartmentName(String deptName)
    {
        this.departmentName = deptName;
    }

    @ManyToOne(optional=false)
    @JoinColumn(name="id", referencedColumnName="person_id")
    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }


}
