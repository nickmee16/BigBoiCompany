package com.np.BigBoiCompany.SkiResort.SkiRent.Ski;

import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.SkiSizeTypes;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiBrands;
import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.Ski;
import com.np.BigBoiCompany.Utility;

public class SkiVolkl extends Ski {
    public SkiVolkl() {
        super(SkiBrands.VOLKL, 4.30, SkiSizeTypes.VERY_LONG);
    }

    @Override
    public void getInfoSki() {

        System.out.println(getBrand() + " ski - " + getLength() + "cm - "
                + Utility.formatNumber(getRentPricePerHour()) + "$ per hour");
    }
}
