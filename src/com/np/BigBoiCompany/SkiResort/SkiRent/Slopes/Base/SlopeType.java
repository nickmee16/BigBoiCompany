package com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base;

public enum SlopeType {

    EASY_1(20, 2),
    EASY_2(20, 2),
    MEDIUM_1(30, 5),
    MEDIUM_2(30, 5),
    HARD_1(40, 10),
    HARD_2(40, 10);

    private final double price;
    private final int dmg;

    SlopeType(double price, int dmg) {
        this.price = price;
        this.dmg = dmg;
    }

    public double getPrice() {
        return price;
    }

    public int getDmg() {
        return dmg;
    }
}
