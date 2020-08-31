package com.np.BigBoiCompany.Restaurant.Kitchen.Equipment;

import com.np.BigBoiCompany.Restaurant.Kitchen.Equipment.Base.Equipment;

public class Knife extends Equipment {
    public Knife() {
        super("Knife", 4, false);
    }

    @Override
    public void getInfoEquip() {
        System.out.println(getTypeEquip() + " - " + getNumEquip());
    }
}
