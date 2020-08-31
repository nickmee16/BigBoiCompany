package com.np.BigBoiCompany.SkiResort.SkiRent.SkiType;

import com.np.BigBoiCompany.SkiResort.SkiRent.SkiType.Base.SkiType;
import com.np.BigBoiCompany.Utility;

public class SkiType2 extends SkiType {
    public SkiType2() {
        super("Rossignol", 5.00, 170);
    }

    @Override
    public void getInfoSki() {

        System.out.println(getBrand() + " ski - " + getLength() + "cm - "
                + Utility.formatNumber(getRentPricePerHour()) + "$ per hour");
    }
}