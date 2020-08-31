package com.np.BigBoiCompany.SkiResort.SkiRent.SkiType;

import com.np.BigBoiCompany.SkiResort.SkiRent.SkiType.Base.SkiType;
import com.np.BigBoiCompany.Utility;

public class SkiType5 extends SkiType {
    public SkiType5() {
        super("Volkl", 4.30, 140);
    }

    @Override
    public void getInfoSki() {

        System.out.println(getBrand() + " ski - " + getLength() + "cm - "
                + Utility.formatNumber(getRentPricePerHour()) + "$ per hour");
    }
}
