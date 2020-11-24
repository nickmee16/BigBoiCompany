package com.np.BigBoiCompany.Restaurant.Menu.Items;

import com.np.BigBoiCompany.Restaurant.Menu.Items.Base.Items;
import com.np.BigBoiCompany.Restaurant.Menu.MenuItemsEnum;

import java.text.DecimalFormat;

public class Dish extends Items {
    public Dish() {
        super(MenuItemsEnum.DISH, 0.550, 10.30, true, 6.50, false);
    }

    @Override
    public void getInfoItem() {
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat qu = new DecimalFormat("0.000");

        System.out.println(getName() + " - " + qu.format(getQuantityOfAProduct()) + " kg - " + df.format(getPrice()) + "$");
    }
}
