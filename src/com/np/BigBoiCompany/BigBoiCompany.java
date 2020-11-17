package com.np.BigBoiCompany;

import com.np.BigBoiCompany.BeachHotel.BeachHotel;
import com.np.BigBoiCompany.Restaurant.Restaurant;
import com.np.BigBoiCompany.SkiResort.SkiResort;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;

public class BigBoiCompany {
    private ArrayList<IProfitable> assets = new ArrayList<>();
    private ArrayList<IShowHotelIngo> infos = new ArrayList<>();
    private ArrayList<HotelsEnum> hotelsEnums = new ArrayList<>(EnumSet.allOf(HotelsEnum.class));
    private HashMap<HotelsEnum, IShowHotelIngo> availableHotels = new HashMap<>();
    private SkiResort skiResort;
    private BeachHotel beachHotel;
    private Restaurant restaurant;

    public BigBoiCompany(SkiResort skiResort, BeachHotel beachHotel, Restaurant restaurant) {
        this.skiResort = skiResort;
        this.beachHotel = beachHotel;
        this.restaurant = restaurant;

        populateInfos();
        populateAvailableHotels();
        populateAssets();

    }

    private void populateAssets() {
        assets.add(skiResort);
        assets.add(beachHotel);
        assets.add(restaurant);
    }

    public void companyProfit() {
        double profit = 0;

        for (IProfitable asset : assets) {
            profit += asset.getProfit();
        }

        System.out.println("Big Boi Company Profit: " + Utility.formatNumber(profit) + "$");
    }

    private void populateInfos() {
        infos.add(skiResort);
        infos.add(beachHotel);
    }

    public void populateAvailableHotels() {
        for(int i = 0; i < infos.size(); i++) {
            availableHotels.put(hotelsEnums.get(i), infos.get(i));
        }
    }

    public void showAvailableHotels() {
        for (int i = 0; i < infos.size(); i++) {
            infos.get(i).info();
        }
    }

    public void showAvailableApartments(HotelsEnum hotel) {
        availableHotels.get(hotel).showAvailableApartments();
    }

    public void rentApartment(HotelsEnum hotel, int numApartment, int days) {
        availableHotels.get(hotel).rentApartment(numApartment, days);
    }

    public void returnKeysApartment(HotelsEnum hotel, int apartmentNumber) {
        availableHotels.get(hotel).returnKeysApartment(apartmentNumber);
    }
}
