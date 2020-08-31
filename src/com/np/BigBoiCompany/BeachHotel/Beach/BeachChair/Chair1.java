package com.np.BigBoiCompany.BeachHotel.Beach.BeachChair;

import com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.Base.BeachChair;
import com.np.BigBoiCompany.Utility;


public class Chair1 extends BeachChair {

    public Chair1() {
        super("Leather", 5.45, 7.55);
    }

    @Override
    public void getInfoChair() {

        System.out.println(getManufacture() + " BeachChair" +
                "\n" + Utility.formatNumber(getRentPricePerHourForHotelUsers()) + "$ per hour - hotel guest" +
                "\n" + Utility.formatNumber(getRentPricePerHourForNonHotelUsers()) + "$ per hour");
    }
}
