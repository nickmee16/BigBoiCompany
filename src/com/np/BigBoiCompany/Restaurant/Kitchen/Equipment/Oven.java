package com.np.BigBoiCompany.Restaurant.Kitchen.Equipment;

import com.np.BigBoiCompany.Restaurant.Kitchen.Equipment.Base.Equipment;

public class Oven extends Equipment {
    public Oven() {
        super("Oven", 3, false);
    }

    @Override
    public void getInfoEquip() {
        System.out.println(getTypeEquip() + " - " + getNumEquip());
    }
}
