package com.masglobal.consulting.employees.domain.model;

import java.math.BigDecimal;

public abstract class Person {

    protected Long id;
    protected String name;
    protected Role role;
    protected double hourlySalary;
    protected double monthlySalary;

    public Person(Long id, String name, Role role, double hourlySalary, double monthlySalary) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.hourlySalary = hourlySalary;
        this.monthlySalary = monthlySalary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    abstract BigDecimal calculateAnnualSalary();
}
