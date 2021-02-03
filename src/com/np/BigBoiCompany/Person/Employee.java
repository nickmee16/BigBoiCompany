package com.np.BigBoiCompany.Person;

import com.np.BigBoiCompany.Person.Base.Person;
import com.np.BigBoiCompany.Person.Base.PersonType;

public class Employee extends Person {

    public Employee(String name, String EGN, double salary) {
        super(PersonType.EMPLOYEE, name, EGN, 20, salary, 0);
    }

}
