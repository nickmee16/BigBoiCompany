package com.np;

import com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.Base.BeachChairEnum;
import com.np.BigBoiCompany.BeachHotel.BeachHotel;
import com.np.BigBoiCompany.BigBoiCompany;
import com.np.BigBoiCompany.HotelsEnum;
import com.np.BigBoiCompany.Restaurant.Menu.MenuItemsEnum;
import com.np.BigBoiCompany.Restaurant.Restaurant;
import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.SkiSizeTypes;
import com.np.BigBoiCompany.SkiResort.SkiResort;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        SkiResort ski = new SkiResort("Ski");
//        ski.rentApartment(3, 4);
//        ski.rentSki(SkiSizeTypes.MEDIUM, 4);
//        ski.rentShoes(45, 6);
//        ski.checkProfit();

        BeachHotel beach = new BeachHotel("Bitch");
//        beach.rentApartment(7, 10);
//        beach.rentBeachChair(BeachChairEnum.LEATHER, 5, true);
//        beach.checkProfit();

        Restaurant restaurant = new Restaurant("Rest");
//        ArrayList<MenuItemsEnum> intArrL = new ArrayList<>();
//        intArrL.add(MenuItemsEnum.JUICE);
//        intArrL.add(MenuItemsEnum.DESERT);
//        intArrL.add(MenuItemsEnum.SALAD);
//        restaurant.makeAnOrder(intArrL);
//        restaurant.checkProfit();

        BigBoiCompany bigBoiCompany = new BigBoiCompany(ski, beach, restaurant);
        bigBoiCompany.companyProfit();
        bigBoiCompany.showAvailableHotels();
        bigBoiCompany.showAvailableApartments(HotelsEnum.SKI_HOTEL);
        bigBoiCompany.rentApartment(HotelsEnum.SKI_HOTEL, 12, 8);
        bigBoiCompany.rentApartment(HotelsEnum.SKI_HOTEL, 3, 8);
        bigBoiCompany.rentApartment(HotelsEnum.SKI_HOTEL, 4, 8);
        bigBoiCompany.showAvailableApartments(HotelsEnum.SKI_HOTEL);
        bigBoiCompany.companyProfit();


    }
}
