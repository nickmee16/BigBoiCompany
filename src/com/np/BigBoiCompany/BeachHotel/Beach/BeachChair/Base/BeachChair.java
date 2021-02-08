package com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.Base;

import com.np.BigBoiCompany.Utility;

public abstract class BeachChair {

    private BeachChairEnum manufacture;
    private double rentPricePerHour;

    protected BeachChair(BeachChairEnum manufacture, double rentPricePerHour) {
        this.manufacture = manufacture;
        this.rentPricePerHour = rentPricePerHour;
    }

    public BeachChairEnum getManufacture() {
        return manufacture;
    }

    public double getRentPricePerHour() {
        return rentPricePerHour;
    }

    public void getInfoChair() {

        System.out.println(getManufacture() + " beach chair" +
                "\n" + "It costs " + Utility.formatNumber(getRentPricePerHour()) + "$ per hour.");
    }

}
