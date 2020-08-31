package com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.Base;

public abstract class SkiShoes {

    private String brand;
    private double rentPricePerHour;
    private int shoeSize;

    public SkiShoes(String brand, double rentPricePerHour, int shoeSize) {
        this.brand = brand;
        this.rentPricePerHour = rentPricePerHour;
        this.shoeSize = shoeSize;
    }

    public String getBrand() {
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
