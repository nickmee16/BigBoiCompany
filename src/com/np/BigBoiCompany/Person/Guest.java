package com.np.BigBoiCompany.Person;

import com.np.BigBoiCompany.Person.Base.Person;
import com.np.BigBoiCompany.Person.Base.PersonType;

public class Guest extends Person {

    public Guest(String name, String EGN) {
        super(PersonType.GUEST, name, EGN, 10);
    }

}
