package com.np.BigBoiCompany.Restaurant.Kitchen.Equipment;

import com.np.BigBoiCompany.Restaurant.Kitchen.Equipment.Base.Equipment;

public class Plate extends Equipment {
    public Plate() {
        super("Plate", 50, true);
    }

    @Override
    public void getInfoEquip() {
        System.out.println(getTypeEquip() + " - " + getNumEquip());
    }
}
