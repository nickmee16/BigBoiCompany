package com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base;

import com.np.BigBoiCompany.SkiResort.SkiRent.SkiBrands;

public abstract class Ski {

    private SkiBrands brand;
    private double rentPricePerDay;
    private double priceOfANewPair;
    private double priceToRepair;
    private SkiSizeTypes length;

    public Ski(SkiBrands brand, double rentPricePerDay, double priceOfANewPair, double priceToRepair, SkiSizeTypes length) {
        this.brand = brand;
        this.rentPricePerDay = rentPricePerDay;
        this.priceOfANewPair = priceOfANewPair;
        this.priceToRepair = priceToRepair;
        this.length = length;
    }

    public SkiBrands getBrand() {
        return brand;
    }

    public double getRentPricePerDay() {
        return rentPricePerDay;
    }

    public SkiSizeTypes getLength() {
        return length;
    }

    public abstract void getInfoSki();
}
