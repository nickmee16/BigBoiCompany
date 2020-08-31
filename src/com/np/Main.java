package com.np;

import com.np.BigBoiCompany.BeachHotel.Beach.Beach;
import com.np.BigBoiCompany.BeachHotel.BeachHotel;
import com.np.BigBoiCompany.BigBoiCompany;
import com.np.BigBoiCompany.Restaurant.DinningHall.DinningHall;
import com.np.BigBoiCompany.Restaurant.Kitchen.Kitchen;
import com.np.BigBoiCompany.Restaurant.Menu.Menu;
import com.np.BigBoiCompany.Restaurant.Menu.MenuItemsEnum;
import com.np.BigBoiCompany.Restaurant.Restaurant;
import com.np.BigBoiCompany.SharedComponent.Base.Hotel;
import com.np.BigBoiCompany.SharedComponent.SkiHotel;
import com.np.BigBoiCompany.SkiResort.SkiResort;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        SkiResort ski = new SkiResort("Ski");
        ski.rentApartment(3, 4);
        ski.rentSki(180, 4);
        ski.rentShoes(45, 6);
        ski.checkProfit();

        BeachHotel beach = new BeachHotel("Bitch");
        beach.rentApartment(7, 10);
        beach.rentBeachChair("Leather", 5, true);
        beach.checkProfit();

        Restaurant restaurant = new Restaurant("Rest");
        ArrayList<MenuItemsEnum> intArrL = new ArrayList<>();
        intArrL.add(MenuItemsEnum.JUICE);
        intArrL.add(MenuItemsEnum.DESERT);
        intArrL.add(MenuItemsEnum.SALAD);
        restaurant.makeAnOrder(intArrL);
        restaurant.checkProfit();

        BigBoiCompany bigBoiCompany = new BigBoiCompany(ski, beach, restaurant);
        bigBoiCompany.companyProfit();

    }
}
