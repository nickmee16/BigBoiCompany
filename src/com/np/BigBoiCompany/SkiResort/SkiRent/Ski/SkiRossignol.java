package com.np.BigBoiCompany.SkiResort.SkiRent.Ski;

import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.SkiSizeTypes;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiBrands;
import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.Ski;
import com.np.BigBoiCompany.Utility;

public class SkiRossignol extends Ski {
    public SkiRossignol(SkiSizeTypes size) {
        super(SkiBrands.ROSSIGNOL, 5.00, 235, 35, size);
    }

    @Override
    public void getInfoSki() {

        System.out.println(getBrand() + " ski - " + getLength() + "cm - "
                + Utility.formatNumber(getRentPricePerDay()) + "$ per hour");
    }
}