package com.np.BigBoiCompany.Person;

import com.np.BigBoiCompany.Person.Base.Person;
import com.np.BigBoiCompany.Person.Base.PersonType;

public class Customer extends Person {

    public Customer(String name, String EGN) {
        super(PersonType.CUSTOMER, name, EGN, 0);
    }
}
