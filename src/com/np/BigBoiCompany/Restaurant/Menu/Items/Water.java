package com.np.BigBoiCompany.Restaurant.Menu.Items;

import com.np.BigBoiCompany.Restaurant.Menu.Items.Base.Items;

import java.text.DecimalFormat;

public class Water extends Items {
    public Water() {
        super("Bankq", 1.500, 2.50, false);
    }

    @Override
    public void getInfoItem() {
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat qu = new DecimalFormat("0.000");

        System.out.println(name + " - " + qu.format(quantity) + " ml - " + df.format(price) + "$");
    }
}
