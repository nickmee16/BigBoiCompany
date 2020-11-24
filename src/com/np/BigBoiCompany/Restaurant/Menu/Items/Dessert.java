package com.np.BigBoiCompany.Restaurant.Menu.Items;

import com.np.BigBoiCompany.Restaurant.Menu.Items.Base.Items;
import com.np.BigBoiCompany.Restaurant.Menu.MenuItemsEnum;

import java.text.DecimalFormat;

public class Dessert extends Items {
    public Dessert() {
        super(MenuItemsEnum.DESERT, 0.400, 6.45, true, 3.29, false);
    }

    @Override
    public void getInfoItem() {
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat qu = new DecimalFormat("0.000");

        System.out.println(getName() + " - " + qu.format(getQuantityOfAProduct()) + " kg - " + df.format(getPrice()) + "$");
    }
}
