package com.wct.jpa.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Employee {
    private int id;
    private String name;
    private int salary;
    private Department department;
    private Collection<Phone> phones = new ArrayList<Phone>();
    private Collection projects;
    private Employee manager;
    private Collection directs = new ArrayList();
    private Address address;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "salary")
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @ManyToOne
    @JoinColumn(name = "dept_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @OneToMany(mappedBy = "employee",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    public Collection<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Collection<Phone> phones) {
        this.phones = phones;
    }

    @ManyToMany(targetEntity = Project.class)
    @JoinTable(
            name = "EMP_PRO",
            joinColumns = @JoinColumn(name = "EMP_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRO_ID")
    )
    public Collection getProjects() {
        return projects;
    }

    public void setProjects(Collection projects) {
        this.projects = projects;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MANAGER_ID")
    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @OneToMany(
            targetEntity = Employee.class,
            mappedBy = "manager",
            cascade = CascadeType.PERSIST
    )
    public Collection getDirects() {
        return directs;
    }

    public void setDirects(Collection directs) {
        this.directs = directs;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ADDR_ID")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee() {
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}
