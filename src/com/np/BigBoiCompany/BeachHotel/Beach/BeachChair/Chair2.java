package com.np.BigBoiCompany.BeachHotel.Beach.BeachChair;

import com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.Base.BeachChair;
import com.np.BigBoiCompany.Utility;


public class Chair2 extends BeachChair {

    public Chair2() {
        super("Wooden", 3.50, 5.00);
    }

    @Override
    public void getInfoChair() {

        System.out.println(getManufacture() + " BeachChair" +
                "\n" + Utility.formatNumber(getRentPricePerHourForHotelUsers()) + "$ per hour - hotel guest" +
                "\n" + Utility.formatNumber(getRentPricePerHourForNonHotelUsers()) + "$ per hour");
    }
}
