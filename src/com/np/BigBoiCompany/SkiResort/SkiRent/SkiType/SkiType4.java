package com.np.BigBoiCompany.SkiResort.SkiRent.SkiType;

import com.np.BigBoiCompany.SkiResort.SkiRent.SkiType.Base.SkiType;
import com.np.BigBoiCompany.Utility;

public class SkiType4 extends SkiType {
    public SkiType4() {
        super("Fischer", 4.60, 150);
    }

    @Override
    public void getInfoSki() {

        System.out.println(getBrand() + " ski - " + getLength() + "cm - "
                + Utility.formatNumber(getRentPricePerHour()) + "$ per hour");
    }
}
