package com.np.BigBoiCompany.BeachHotel;

import com.np.BigBoiCompany.BeachHotel.Beach.Beach;
import com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.Base.BeachChairEnum;
import com.np.BigBoiCompany.IProfitable;
import com.np.BigBoiCompany.Person.Base.Person;
import com.np.BigBoiCompany.SharedComponent.Base.Hotel;
import com.np.BigBoiCompany.SharedComponent.BeachHotel;
import com.np.BigBoiCompany.Utility;

public class BeachResort implements IProfitable {

    private String name;
    private Beach beach;
    private Hotel hotel;

    public BeachResort(String name) {
        this.name = name;
        this.beach = new Beach();
        this.hotel = new BeachHotel();
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setBeach(Beach beach) {
        this.beach = beach;
    }

    @Override
    public double getProfit() {
        return hotel.getProfit() + beach.getProfit();
    }

    public void checkProfit() {
        System.out.println("The profit of Beach Hotel " + name + " is " + Utility.formatNumber(hotel.getProfit() + beach.getProfit()) + "$");
        System.out.println();
    }

    public void rentBeachChair(BeachChairEnum beachChair, int rentHours, Person person) {
        beach.rentChair(beachChair, rentHours, person);
    }

    public void returnBeachChair(BeachChairEnum beachChair) {
        beach.returnBeachChair(beachChair);
    }

    public void checkAvailableBeachChairs() {
        beach.checkOffers();
    }

    public Hotel getHotel() {
        return hotel;
    }


}
