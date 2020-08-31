package com.np.BigBoiCompany.Restaurant.Menu.Items;

import com.np.BigBoiCompany.Restaurant.Menu.Items.Base.Items;

import java.text.DecimalFormat;

public class NonAlcoholic  extends Items {
    public NonAlcoholic() {
        super("Pepsi Cola", 0.500, 2.00, false);
    }

    @Override
    public void getInfoItem() {
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat qu = new DecimalFormat("0.000");

        System.out.println(name + " - " + qu.format(quantity) + " ml - " + df.format(price) + "$");
    }
}
