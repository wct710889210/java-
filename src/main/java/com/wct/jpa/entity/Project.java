package com.wct.jpa.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Project {
    private int id;
    private String name;
    private Collection employees;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(
            targetEntity = Employee.class,
            mappedBy = "projects"
    )
    public Collection getEmployees() {
        return employees;
    }

    public void setEmployees(Collection employees) {
        this.employees = employees;
    }
}
