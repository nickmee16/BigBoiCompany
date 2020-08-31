package com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes;

import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.Base.SkiShoes;
import com.np.BigBoiCompany.Utility;

public class Shoe3 extends SkiShoes {

    public Shoe3(int size) {
        super("Line", 3.85, size);
    }

    @Override
    public void getInfoShoe() {

        System.out.println(getBrand() + " shoes - size: 36 - 45 - " + Utility.formatNumber(getRentPricePerHour()) + "$ per hour");
    }
}
