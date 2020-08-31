package com.np.BigBoiCompany.Restaurant.Menu.Items;

import com.np.BigBoiCompany.Restaurant.Menu.Items.Base.Items;

import java.text.DecimalFormat;

public class Dish extends Items {
    public Dish() {
        super("Chicken", 0.550, 10.30, true);
    }

    @Override
    public void getInfoItem() {
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat qu = new DecimalFormat("0.000");

        System.out.println(name + " - " + qu.format(quantity) + " kg - " + df.format(price) + "$");
    }
}
