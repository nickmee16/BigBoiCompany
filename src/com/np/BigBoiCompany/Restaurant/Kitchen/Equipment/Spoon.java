package com.np.BigBoiCompany.Restaurant.Kitchen.Equipment;

import com.np.BigBoiCompany.Restaurant.Kitchen.Equipment.Base.Equipment;

public class Spoon extends Equipment {
    public Spoon() {
        super("Spoon", 50, false);
    }

    @Override
    public void getInfoEquip() {
        System.out.println(getTypeEquip() + " - " + getNumEquip());
    }
}
