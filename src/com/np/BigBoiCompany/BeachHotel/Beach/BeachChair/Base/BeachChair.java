package com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.Base;

public abstract class BeachChair {

    private String manufacture;
    private double rentPricePerHourForHotelUsers;
    private double rentPricePerHourForNonHotelUsers;

    public BeachChair(String manufacture, double rentPricePerHourForHotelUsers, double rentPricePerHourForNonHotelUsers) {
        this.manufacture = manufacture;
        this.rentPricePerHourForHotelUsers = rentPricePerHourForHotelUsers;
        this.rentPricePerHourForNonHotelUsers = rentPricePerHourForNonHotelUsers;
    }

    public String getManufacture() {
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
