package com.np.BigBoiCompany.Restaurant.Menu.Items;

import com.np.BigBoiCompany.Restaurant.Menu.Items.Base.Items;
import com.np.BigBoiCompany.Restaurant.Menu.MenuItemsEnum;


import java.text.DecimalFormat;

public class Juice extends Items {
    public Juice() {
        super(MenuItemsEnum.JUICE, 0.330, 2.50, false, 1.09, true);
    }

    @Override
    public void getInfoItem() {
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat qu = new DecimalFormat("0.000");

        System.out.println(getName() + " - " + qu.format(getQuantityOfAProduct()) + " ml - " + df.format(getPrice()) + "$");
    }
}
