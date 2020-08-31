package com.np.BigBoiCompany.Restaurant.Kitchen.Equipment;

import com.np.BigBoiCompany.Restaurant.Kitchen.Equipment.Base.Equipment;

public class Fork extends Equipment {
    public Fork() {
        super("Fork", 50, true);
    }

    @Override
    public void getInfoEquip() {
        System.out.println(getTypeEquip() + " - " + getNumEquip());
    }
}
