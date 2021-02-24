package com.np;

import com.np.BigBoiCompany.BeachHotel.Beach.Beach;
import com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.Base.BeachChairEnum;
import com.np.BigBoiCompany.BeachHotel.BeachResort;
import com.np.BigBoiCompany.BigBoiCompany;
import com.np.BigBoiCompany.Person.Base.Person;
import com.np.BigBoiCompany.Person.Base.PersonType;
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

        // Angie: I don't like this for some reason, better way?
        SkiRent skiRent = new SkiRent();
        SkiResort skiResort = new SkiResort("Ski Resort", skiRent);

        Employee employee = new Employee("Angela", "1234567890", 1500);
        Guest guest = new Guest("Zele", "0987654321");
        Customer customer = new Customer("Pile", "6549871236");
        bigBoiCompany.setBeachResort(beachResort);
        bigBoiCompany.setRestaurant(restaurant);
        bigBoiCompany.setSkiResort(skiResort);

//
//        beachHotel.rentApartment(1, 3);
//        beachHotel.rentApartment(2, 3);
//        beachHotel.rentApartment(3, 3);
//        beachHotel.rentApartment(4, 3);
//        beachHotel.rentApartment(5, 3);
//
//        beachResort.getHotel().showAvailableApartments();
//
//        beachResort.rentBeachChair(BeachChairEnum.LEATHER, 4, guest);

        Ski ski1 = new SkiK2(SkiSizeTypes.LONG);
        skiRent.buySki(ski1, 3);


    }
}
