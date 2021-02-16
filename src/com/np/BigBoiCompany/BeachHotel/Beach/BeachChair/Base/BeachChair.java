package com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.Base;

import com.np.BigBoiCompany.Utility;

public abstract class BeachChair {

    private BeachChairEnum manufacture;
    private double rentPricePerHour;
    private double quantity;

    protected BeachChair(BeachChairEnum manufacture, double rentPricePerHour, double quantity) {
        this.manufacture = manufacture;
        this.rentPricePerHour = rentPricePerHour;
        this.quantity = quantity;
    }

    public BeachChairEnum getManufacture() {
        return manufacture;
    }

    public double getRentPricePerHour() {
        return rentPricePerHour;
    }

    public double getQuantity() {
        return quantity;
    }

    public void getInfoChair() {

        System.out.println(getManufacture() + " beach chair" +
                "\n" + "It costs " + Utility.formatNumber(getRentPricePerHour()) + "$ per hour.");
    }

}
