package com.np.BigBoiCompany.SkiResort;

import com.np.BigBoiCompany.IProfitable;
import com.np.BigBoiCompany.SharedComponent.Base.Hotel;
import com.np.BigBoiCompany.SharedComponent.SkiHotel;
import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.SkiSizeTypes;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiRent;
import com.np.BigBoiCompany.Utility;


public class SkiResort implements IProfitable {

    private final String name;
    private final SkiRent skiRent;
    private final Hotel hotel;

    public SkiResort(String name) {
        this.name = name;
        this.skiRent = new SkiRent();
        this.hotel = new SkiHotel();
    }

    @Override
    public double getProfit() {
        return hotel.getProfit() + skiRent.getProfit();
    }


    public void getInfo() {
        System.out.println(name);
    }

    public void checkProfit() {
        System.out.println("The profit of Ski Resort " + name + " is " + Utility.formatNumber(hotel.getProfit() + skiRent.getProfit()) + "$");
        System.out.println();
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void rentSki(SkiSizeTypes skiLength, int rentHours) {
        skiRent.rentSki(skiLength, rentHours);
    }

    public void rentShoes(int shoeSize, int rentHours) {
        skiRent.rentShoes(shoeSize, rentHours);
    }

    public void rentSkiAndShoes(SkiSizeTypes skiLength, int shoeSize, int rentHours) {
        skiRent.rentSkiAndShoes(skiLength, shoeSize, rentHours);
    }

    public void returnSki(SkiSizeTypes skiLength) {
        skiRent.returnSki(skiLength);
    }

    public void returnShoes(int shoeSize) {
        skiRent.returnShoes(shoeSize);
    }
    public void returnSkiAndShoes(SkiSizeTypes skiLength,  int shoeSize) {
        skiRent.returnSkiAndShoes(skiLength, shoeSize);
    }

}
