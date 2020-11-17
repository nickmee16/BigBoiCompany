package com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.Base;

import com.np.BigBoiCompany.SkiResort.SkiRent.SkiBrands;

public abstract class SkiShoes {

    private SkiBrands brand;
    private double rentPricePerHour;
    private int shoeSize;

    public SkiShoes(SkiBrands brand, double rentPricePerHour, int shoeSize) {
        this.brand = brand;
        this.rentPricePerHour = rentPricePerHour;
        this.shoeSize = shoeSize;
    }

    public SkiBrands getBrand() {
        return brand;
    }

    public double getRentPricePerHour() {
        return rentPricePerHour;
    }

    public int getShoeSize() {
        return shoeSize;
    }

    public abstract void getInfoShoe();
}
