package com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.Base;

import com.np.BigBoiCompany.SkiResort.SkiRent.SkiBrands;

public abstract class SkiShoes {

    private SkiBrands brand;
    private double rentPricePerDay;
    private int shoeSize;

    public SkiShoes(SkiBrands brand, double rentPricePerDay, int shoeSize) {
        this.brand = brand;
        this.rentPricePerDay = rentPricePerDay;
        this.shoeSize = shoeSize;
    }

    public SkiBrands getBrand() {
        return brand;
    }

    public double getRentPricePerDay() {
        return rentPricePerDay;
    }

    public int getShoeSize() {
        return shoeSize;
    }

    public abstract void getInfoShoe();
}
