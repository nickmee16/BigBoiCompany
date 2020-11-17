package com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base;

import com.np.BigBoiCompany.SkiResort.SkiRent.SkiBrands;

public abstract class Ski {

    private SkiBrands brand;
    private double rentPricePerHour;
    private SkiSizeTypes length;

    public Ski(SkiBrands brand, double rentPricePerHour, SkiSizeTypes length) {
        this.brand = brand;
        this.rentPricePerHour = rentPricePerHour;
        this.length = length;
    }

    public SkiBrands getBrand() {
        return brand;
    }

    public SkiSizeTypes getLength() {
        return length;
    }

    public double getRentPricePerHour() {
        return rentPricePerHour;
    }

    public abstract void getInfoSki();
}
