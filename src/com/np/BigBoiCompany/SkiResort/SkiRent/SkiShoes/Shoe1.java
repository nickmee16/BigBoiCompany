package com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes;

import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.Base.SkiShoes;
import com.np.BigBoiCompany.Utility;


public class Shoe1 extends SkiShoes {

    public Shoe1(int size) {
        super("K2", 4.20, size);
    }

    @Override
    public void getInfoShoe() {

        System.out.println(getBrand() + " shoes - size: 36 - 45 - " + Utility.formatNumber(getRentPricePerHour()) + "$ per hour");
    }
}
