package com.np.BigBoiCompany.Restaurant.Menu.Items;

import com.np.BigBoiCompany.Restaurant.Menu.Items.Base.Items;
import com.np.BigBoiCompany.Restaurant.Menu.MenuItemsEnum;
import com.np.BigBoiCompany.Utility;


import java.text.DecimalFormat;

public class Alcoholic extends Items {
    public Alcoholic() {
        super(MenuItemsEnum.ALCOHOL, 0.050, 7.50 , false);
    }

    @Override
    public void getInfoItem() {
        DecimalFormat qu = new DecimalFormat("0.000");

        System.out.println(name + " - " + qu.format(quantity) + " ml - " + Utility.formatNumber(price) + "$");
    }
}