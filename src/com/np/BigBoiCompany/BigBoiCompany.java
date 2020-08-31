package com.np.BigBoiCompany;

import com.np.BigBoiCompany.BeachHotel.BeachHotel;
import com.np.BigBoiCompany.Restaurant.Restaurant;
import com.np.BigBoiCompany.SharedComponent.Base.Hotel;
import com.np.BigBoiCompany.SkiResort.SkiResort;

import java.util.ArrayList;

public class BigBoiCompany {
    private ArrayList<IProfitable> assets;
    private SkiResort skiResort;
    private BeachHotel beachHotel;
    private Restaurant restaurant;

    public BigBoiCompany(SkiResort skiResort, BeachHotel beachHotel, Restaurant restaurant) {
        this.skiResort = skiResort;
        this.beachHotel = beachHotel;
        this.restaurant = restaurant;

        addAssets();
    }

//    public void companyProfit() {
//        double profit = 0;
//
//        for (IProfitable asset: assets) {
//            profit += asset.getProfit();
//        }
//
//        System.out.println("Big Boi Company Profit: " + Utility.formatNumber(profit) + "$");
//    }

    public void companyProfit() {
        System.out.println("Big Boi Company Profit: " + Utility.formatNumber(skiResort.getProfit() + beachHotel.getProfit() + restaurant.getProfit()) + "$");
    }

    private void addAssets() {

    }
}
