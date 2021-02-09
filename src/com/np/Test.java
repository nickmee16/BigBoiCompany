package com.np;

import com.np.BigBoiCompany.BeachHotel.BeachResort;
import com.np.BigBoiCompany.BigBoiCompany;
import com.np.BigBoiCompany.Person.Customer;
import com.np.BigBoiCompany.Person.Employee;
import com.np.BigBoiCompany.Person.Guest;
import com.np.BigBoiCompany.Restaurant.Restaurant;
import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.Ski;
import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.SkiSizeTypes;
import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.SkiRossignol;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiBrands;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiRent;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.Base.SkiShoes;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.ShoeK2;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.ShoeRossignol;
import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base.Slope;
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

        Ski ski = new SkiRossignol();

        SkiShoes skiShoes = new ShoeRossignol(38);
        SkiShoes skiShoes1 = new ShoeK2(37);

        skiRent.rentPassForSlope(employee, SlopeType.EASY_1, SlopeType.EASY_2, SlopeType.MEDIUM_1, SlopeType.EASY_2,
                                SlopeType.MEDIUM_2);
        skiRent.rentPassForSlope(guest, SlopeType.EASY_1, SlopeType.EASY_2, SlopeType.MEDIUM_1, SlopeType.EASY_2,
                                SlopeType.MEDIUM_2, SlopeType.HARD_1);
        skiRent.rentPassForSlope(customer, SlopeType.EASY_1);


        skiRent.buySki(SkiSizeTypes.MEDIUM, 10);
        skiRent.buyShoes(SkiBrands.ROSSIGNOL, 38, 10);
        skiRent.buyShoes(SkiBrands.K2, 37, 20);

        skiResort.rentSki(ski, SkiSizeTypes.MEDIUM, employee);
        skiResort.rentShoes(skiShoes, 38, employee);
        skiResort.rentShoes(skiShoes1, 37, employee);


    }
}
