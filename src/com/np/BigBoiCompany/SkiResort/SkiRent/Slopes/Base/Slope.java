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

    public SlopeType getSlopeType() {
        return slopeType;
    }

    public void setSlopeType(SlopeType slopeType) {
        this.slopeType = slopeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }
}
