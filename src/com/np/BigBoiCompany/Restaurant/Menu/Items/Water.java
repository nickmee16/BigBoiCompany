package com.np.BigBoiCompany.Restaurant.Menu.Items;

import com.np.BigBoiCompany.Restaurant.Menu.Items.Base.Items;
import com.np.BigBoiCompany.Restaurant.Menu.MenuItemsEnum;

import java.text.DecimalFormat;

public class Water extends Items {
    public Water() {
        super(MenuItemsEnum.WATER, 1.500, 2.50, false, 0.90, true);
    }

    @Override
    public void getInfoItem() {
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat qu = new DecimalFormat("0.000");

        System.out.println(getName() + " - " + qu.format(getQuantityOfAProduct()) + " ml - " + df.format(getPrice()) + "$");
    }
}
