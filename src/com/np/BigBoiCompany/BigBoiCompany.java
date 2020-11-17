package com.np.BigBoiCompany;

import com.np.BigBoiCompany.BeachHotel.BeachResort;
import com.np.BigBoiCompany.Restaurant.Restaurant;
import com.np.BigBoiCompany.SharedComponent.Base.Hotel;
import com.np.BigBoiCompany.SharedComponent.Base.HotelTypes;
import com.np.BigBoiCompany.SkiResort.SkiResort;

import java.util.ArrayList;
import java.util.HashMap;

public class BigBoiCompany {
    private ArrayList<IProfitable> assets = new ArrayList<>();
    private HashMap<HotelTypes, Hotel> availableHotels = new HashMap<>();
    private SkiResort skiResort;
    private BeachResort beachResort;
    private Restaurant restaurant;

    public BigBoiCompany() {
        this.skiResort = new SkiResort("Ski");
        this.beachResort = new BeachResort("Bitch");
        this.restaurant = new Restaurant("Rest");


        populateAvailableHotels();
        populateAssets();

    }

    private void populateAssets() {
        assets.add(skiResort);
        assets.add(beachResort);
        assets.add(restaurant);
    }

    public void companyProfit() {
        double profit = 0;

        for (IProfitable asset : assets) {
            profit += asset.getProfit();
        }

        System.out.println("Big Boi Company Profit: " + Utility.formatNumber(profit) + "$");
    }


    public void populateAvailableHotels() {
        this.availableHotels.put(skiResort.getHotel().getType(), skiResort.getHotel());
        this.availableHotels.put(beachResort.getHotel().getType(), beachResort.getHotel());
    }

    public void showAvailableHotels() {
        for (Hotel hotel: availableHotels.values()) {
            hotel.info();
        }
    }

    public void showAvailableApartments(HotelTypes hotel) {
        availableHotels.get(hotel).showAvailableApartments();
    }

    public void rentApartment(HotelTypes hotel, int numApartment, int days) {
        availableHotels.get(hotel).rentApartment(numApartment, days);
    }

    public void returnKeysApartment(HotelTypes hotel, int apartmentNumber) {
        availableHotels.get(hotel).returnKeys(apartmentNumber);
    }
}
