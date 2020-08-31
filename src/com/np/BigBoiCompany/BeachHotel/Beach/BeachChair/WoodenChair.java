package com.np.BigBoiCompany.BeachHotel.Beach.BeachChair;

import com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.Base.BeachChair;
import com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.Base.BeachChairEnum;
import com.np.BigBoiCompany.Utility;


public class WoodenChair extends BeachChair {

    public WoodenChair() {
        super(BeachChairEnum.WOODEN, 3.50, 5.00);
    }

    @Override
    public void getInfoChair() {

        System.out.println(getManufacture() + " BeachChair" +
                "\n" + Utility.formatNumber(getRentPricePerHourForHotelUsers()) + "$ per hour - hotel guest" +
                "\n" + Utility.formatNumber(getRentPricePerHourForNonHotelUsers()) + "$ per hour");
    }
}
