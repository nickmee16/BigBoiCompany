package com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes;

import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.Base.SkiShoes;
import com.np.BigBoiCompany.Utility;


public class Shoe2 extends SkiShoes {

    public Shoe2(int size) {
        super("Rossignol", 4.00, size);
    }

    @Override
    public void getInfoShoe() {

        System.out.println(getBrand() + " shoes - size: 36 - 45 - " + Utility.formatNumber(getRentPricePerHour()) + "$ per hour");
    }
}
