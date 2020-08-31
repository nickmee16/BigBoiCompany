package com.np.BigBoiCompany.SkiResort.SkiRent.SkiType;

import com.np.BigBoiCompany.SkiResort.SkiRent.SkiType.Base.SkiType;
import com.np.BigBoiCompany.Utility;

public class SkiType1 extends SkiType {
    public SkiType1() {
        super("K2", 5.50, 180);
    }

    @Override
    public void getInfoSki() {

        System.out.println(getBrand() + " ski - " + getLength() + "cm - "
                + Utility.formatNumber(getRentPricePerHour()) + "$ per hour");
    }
}
