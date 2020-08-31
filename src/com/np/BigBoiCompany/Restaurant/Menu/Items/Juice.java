package com.np.BigBoiCompany.Restaurant.Menu.Items;

import com.np.BigBoiCompany.Restaurant.Menu.Items.Base.Items;


import java.text.DecimalFormat;

public class Juice extends Items {
    public Juice() {
        super("Orange Juice", 0.330, 2.50, false);
    }

    @Override
    public void getInfoItem() {
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat qu = new DecimalFormat("0.000");

        System.out.println(name + " - " + qu.format(quantity) + " ml - " + df.format(price) + "$");
    }
}