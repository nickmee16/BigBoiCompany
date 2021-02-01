package com.np.BigBoiCompany.Employee;

public class Employee {

    private String name;
    private String EGN;
    private double salary;
    private double tab;

    public Employee(String name, String EGN, double salary, double tab) {
        this.name = name;
        this.EGN = EGN;
        this.salary = salary;
        this.tab = tab;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEGN(String EGN) {
        this.EGN = EGN;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setTab(double tab) {
        this.tab = tab;
    }

    public String getName() {
        return name;
    }

    public String getEGN() {
        return EGN;
    }

    public double getSalary() {
        return salary;
    }

    public double getTab() {
        return tab;
    }
}
