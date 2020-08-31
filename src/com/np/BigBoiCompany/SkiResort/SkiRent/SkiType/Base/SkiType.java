package com.np.BigBoiCompany.SkiResort.SkiRent.SkiType.Base;

import java.text.DecimalFormat;

public abstract class SkiType {

    private String brand;
    private double rentPricePerHour;
    private double length;

    public SkiType(String brand, double rentPricePerHour, double length) {
        this.brand = brand;
        this.rentPricePerHour = rentPricePerHour;
        this.length = length;
    }

    public String getBrand() {
        return brand;
    }

    public double getLength() {
        return length;
    }

    public double getRentPricePerHour() {
        return rentPricePerHour;
    }

    public abstract void getInfoSki();
}
