package com.np.BigBoiCompany.BeachHotel;

import com.np.BigBoiCompany.BeachHotel.Beach.Beach;
import com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.Base.BeachChairEnum;
import com.np.BigBoiCompany.IProfitable;
import com.np.BigBoiCompany.SharedComponent.Base.Hotel;
import com.np.BigBoiCompany.SharedComponent.BeachHotelComponent;
import com.np.BigBoiCompany.Utility;

public class BeachHotel implements IProfitable {

    private String name;
    private Beach beach;
    private Hotel hotel;

    public BeachHotel(String name) {
        this.name = name;
        this.beach = new Beach();
        this.hotel = new BeachHotelComponent();
    }

    @Override
    public double getProfit() {
        return hotel.getProfit() + beach.getProfit();
    }

    public void checkProfit() {
        System.out.println("The profit of Beach Hotel " + name + " is " + Utility.formatNumber(hotel.getProfit() + beach.getProfit()) + "$");
        System.out.println();
    }

    public void rentApartment(int apartmentNumber, int rentDays) {
        hotel.rentApartment(apartmentNumber, rentDays);
    }

    public void returnKeysApartment(int apartmentNumber) {
        hotel.returnKeys(apartmentNumber);
    }

    public void rentBeachChair(BeachChairEnum beachChair, int rentHours, boolean isHotelUser) {
        beach.rentChair(beachChair, rentHours, isHotelUser);
    }

    public void returnBeachChair(BeachChairEnum beachChair) {
        beach.returnBeachChair(beachChair);
    }

    public void checkAvailableBeachChairs() {
        beach.checkOffers();
    }
}
