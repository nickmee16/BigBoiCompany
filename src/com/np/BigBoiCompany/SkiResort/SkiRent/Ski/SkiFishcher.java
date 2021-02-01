package com.np.BigBoiCompany.SkiResort.SkiRent.Ski;

import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.SkiSizeTypes;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiBrands;
import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.Ski;
import com.np.BigBoiCompany.Utility;

public class SkiFishcher extends Ski {
    public SkiFishcher() {
        super(SkiBrands.FISCHER, 4.60, 250, 50, SkiSizeTypes.VERY_SMALL);
    }

    @Override
    public void getInfoSki() {

        System.out.println(getBrand() + " ski - " + getLength() + "cm - "
                + Utility.formatNumber(getRentPricePerDay()) + "$ per hour");
    }
}
