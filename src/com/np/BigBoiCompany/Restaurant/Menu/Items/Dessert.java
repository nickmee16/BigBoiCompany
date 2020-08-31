package com.np.BigBoiCompany.Restaurant.Menu.Items;

import com.np.BigBoiCompany.Restaurant.Menu.Items.Base.Items;

import java.text.DecimalFormat;

public class Dessert extends Items {
    public Dessert() {
        super("Fruit Cake", 0.400, 6.45, true);
    }

    @Override
    public void getInfoItem() {
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat qu = new DecimalFormat("0.000");

        System.out.println(name + " - " + qu.format(quantity) + " kg - " + df.format(price) + "$");
    }
}
