package com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.Base;

public abstract class BeachChair {

    private BeachChairEnum manufacture;
    private double rentPricePerHourForHotelUsers;
    private double rentPricePerHourForNonHotelUsers;

    protected BeachChair(BeachChairEnum manufacture, double rentPricePerHourForHotelUsers, double rentPricePerHourForNonHotelUsers) {
        this.manufacture = manufacture;
        this.rentPricePerHourForHotelUsers = rentPricePerHourForHotelUsers;
        this.rentPricePerHourForNonHotelUsers = rentPricePerHourForNonHotelUsers;
    }

    public BeachChairEnum getManufacture() {
        return manufacture;
    }

    public double getRentPricePerHourForHotelUsers() {
        return rentPricePerHourForHotelUsers;
    }

    public double getRentPricePerHourForNonHotelUsers() {
        return rentPricePerHourForNonHotelUsers;
    }

    public abstract void getInfoChair();
}
