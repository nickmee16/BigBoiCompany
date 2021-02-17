package com.np;

import com.np.BigBoiCompany.BeachHotel.Beach.Beach;
import com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.Base.BeachChairEnum;
import com.np.BigBoiCompany.BeachHotel.BeachResort;
import com.np.BigBoiCompany.BigBoiCompany;
import com.np.BigBoiCompany.Person.Customer;
import com.np.BigBoiCompany.Person.Employee;
import com.np.BigBoiCompany.Person.Guest;
import com.np.BigBoiCompany.Restaurant.Menu.MenuItemsEnum;
import com.np.BigBoiCompany.Restaurant.Restaurant;
import com.np.BigBoiCompany.SharedComponent.Base.HotelTypes;
import com.np.BigBoiCompany.SharedComponent.BeachHotel;
import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.Ski;
import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.SkiSizeTypes;
import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.SkiFishcher;
import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.SkiK2;
import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.SkiRossignol;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiBrands;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiRent;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.Base.SkiShoes;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.ShoeK2;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.ShoeRossignol;

import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base.SlopeType;
import com.np.BigBoiCompany.SkiResort.SkiResort;

public class Test {
    public static void main(String[] args) {
        BigBoiCompany bigBoiCompany = new BigBoiCompany();
        BeachResort beachResort = new BeachResort("Kole");
        Restaurant restaurant = new Restaurant("Restaurant", 100);
        BeachHotel beachHotel = new BeachHotel();
        beachResort.setHotel(beachHotel);

        Ski ski1 = new SkiRossignol(SkiSizeTypes.MEDIUM);
        Ski ski2 = new SkiRossignol(SkiSizeTypes.LONG);
        SkiShoes skiShoes1 = new ShoeK2(38);
        SkiShoes skiShoes2 = new ShoeRossignol(37);

        Beach beach = new Beach(beachHotel);
        beachResort.setBeach(beach);

        // Angie: I don't like this for some reason, better way?
        SkiRent skiRent = new SkiRent();
        SkiResort skiResort = new SkiResort("Ski Resort", skiRent);

        Employee employee = new Employee("Angela", "1234567890", 1500);
        Guest guest = new Guest("Zele", "0987654321");
        Customer customer = new Customer("Pile", "6549871236");
        bigBoiCompany.setBeachResort(beachResort);
        bigBoiCompany.setRestaurant(restaurant);
        bigBoiCompany.setSkiResort(skiResort);

////        skiRent.buySki(ski1, 10);
//          skiRent.buyShoes(SkiBrands.ROSSIGNOL, 36, 5);
////        skiRent.rentSki(1, employee, 50);
////        skiRent.rentSki(2, employee, 50);
//          skiRent.rentShoes(skiShoes2, 36, employee, 5);
////        skiRent.rentPassForSlope(employee, 4, SlopeType.HARD_2);
////        skiRent.rentPassForSlope(employee, 4, SlopeType.HARD_1);
////        skiRent.rentPassForSlope(employee, 4, SlopeType.MEDIUM_2);
////        skiRent.rentPassForSlope(employee, 4, SlopeType.MEDIUM_1);
////        skiRent.rentPassForSlope(employee, 4, SlopeType.EASY_1);
//
////        restaurant.takeTable(1);
////        restaurant.makeAnOrder(1, MenuItemsEnum.DISH, 2);
////        restaurant.pay(1,employee);
//
//          beachResort.rentBeachChair(BeachChairEnum.LEATHER, 4, employee);



    }
}
