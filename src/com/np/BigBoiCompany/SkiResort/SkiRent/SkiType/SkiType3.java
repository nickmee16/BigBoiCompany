package com.np.BigBoiCompany.SkiResort.SkiRent.SkiType;

import com.np.BigBoiCompany.SkiResort.SkiRent.SkiType.Base.SkiType;
import com.np.BigBoiCompany.Utility;

public class SkiType3 extends SkiType {
    public SkiType3() {
        super("Line", 4.75, 160);
    }

    @Override
    public void getInfoSki() {

        System.out.println(getBrand() + " ski - " + getLength() + "cm - "
                + Utility.formatNumber(getRentPricePerHour()) + "$ per hour");
    }
}
