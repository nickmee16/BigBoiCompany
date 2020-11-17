package com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes;

import com.np.BigBoiCompany.SkiResort.SkiRent.SkiBrands;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.Base.SkiShoes;
import com.np.BigBoiCompany.Utility;

public class ShoeLine extends SkiShoes {

    public ShoeLine(int size) {
        super(SkiBrands.LINE, 3.85, size);
    }

    @Override
    public void getInfoShoe() {

        System.out.println(getBrand() + " shoes - size: 36 - 45 - " + Utility.formatNumber(getRentPricePerHour()) + "$ per hour");
    }
}
