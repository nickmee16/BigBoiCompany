package com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base;

public class Slope {

    private SlopeType slopeType;
    private String name;
    private double price;
    private int dmg;

    public Slope(SlopeType slopeType, String name, double price, int dmg) {
        this.slopeType = slopeType;
        this.name = name;
        this.price = price;
        this.dmg = dmg;
    }
}
