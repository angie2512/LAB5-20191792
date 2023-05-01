package com.example.lab5.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Departments {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "department_id")
    private int departmentId;
    @Basic
    @Column(name = "department_name")
    private String departmentName;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Departments manager;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Locations location;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Departments getManager() {
        return manager;
    }

    public void setManager(Departments manager) {
        this.manager = manager;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }
}
