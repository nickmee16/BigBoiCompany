package com.np.BigBoiCompany.Restaurant.Menu.Items;

import com.np.BigBoiCompany.Restaurant.Menu.Items.Base.Items;
import com.np.BigBoiCompany.Restaurant.Menu.MenuItemsEnum;

import java.text.DecimalFormat;

public class NonAlcoholic  extends Items {
    public NonAlcoholic() {
        super(MenuItemsEnum.NON_ALCOHOLIC, 0.500, 2.00, false, 0.75, false);
    }

    @Override
    public void getInfoItem() {
        DecimalFormat df = new DecimalFormat("0.00");
        DecimalFormat qu = new DecimalFormat("0.000");

        System.out.println(getName() + " - " + qu.format(getQuantityOfAProduct()) + " ml - " + df.format(getPrice()) + "$");
    }
}
