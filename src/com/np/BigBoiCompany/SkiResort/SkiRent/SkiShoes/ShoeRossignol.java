package com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes;

import com.np.BigBoiCompany.SkiResort.SkiRent.SkiBrands;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.Base.SkiShoes;
import com.np.BigBoiCompany.Utility;


public class ShoeRossignol extends SkiShoes {

    public ShoeRossignol(int size) {
        super(SkiBrands.ROSSIGNOL, 4.00, size);
    }

    @Override
    public void getInfoShoe() {

        System.out.println(getBrand() + " shoes - size: 36 - 45 - " + Utility.formatNumber(getRentPricePerDay()) + "$ per hour");
    }
}
