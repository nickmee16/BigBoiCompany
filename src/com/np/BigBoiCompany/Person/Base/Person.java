package com.np.BigBoiCompany.Person.Base;

public class Person {

    private PersonType personType;
    private String name;
    private String EGN;
    private double discount;
    private double salary;
    private double tab;

    public Person(PersonType personType, String name, String EGN, double discount, double salary, double tab) {
        this.personType = personType;
        this.name = name;
        this.EGN = EGN;
        this.discount = discount;
        this.salary = salary;
        this.tab = tab;
    }

    public Person(PersonType personType, String name, String EGN, double discount) {
        this.personType = personType;
        this.name = name;
        this.EGN = EGN;
        this.discount = discount;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEGN() {
        return EGN;
    }

    public void setEGN(String EGN) {
        this.EGN = EGN;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getTab() {
        return tab;
    }

    public void setTab(double tab) {
        this.tab = tab;
    }

    @Override
    public String toString() {
        return "{" +
                "personType=" + personType +
                ", name='" + name + '\'' +
                ", EGN='" + EGN + '\'' +
                ", discount=" + discount +
                ", salary=" + salary +
                ", tab=" + tab +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return Objects.equals(name, person.name) && Objects.equals(EGN, person.EGN);
//    }
}
