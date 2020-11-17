package com.np.BigBoiCompany.SkiResort.SkiRent.Ski;

import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.SkiSizeTypes;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiBrands;
import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.Ski;
import com.np.BigBoiCompany.Utility;

public class SkiLine extends Ski {
    public SkiLine() {
        super(SkiBrands.LINE, 4.75, SkiSizeTypes.SMALL);
    }

    @Override
    public void getInfoSki() {

        System.out.println(getBrand() + " ski - " + getLength() + "cm - "
                + Utility.formatNumber(getRentPricePerHour()) + "$ per hour");
    }
}
