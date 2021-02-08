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
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.ShoeRossignol;
import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base.SlopeType;
import com.np.BigBoiCompany.SkiResort.SkiResort;

public class Test {
    public static void main(String[] args) {
        BigBoiCompany bigBoiCompany = new BigBoiCompany();
        BeachResort beachResort = new BeachResort("Kole");
        Restaurant restaurant = new Restaurant("Restaurant", 100);
        SkiResort skiResort = new SkiResort("Ski Resort");
        Employee employee = new Employee("Angela", "1234567890", 1500);
        Guest guest = new Guest("Zele", "0987654321");
        Customer customer = new Customer("Pile", "6549871236");
        bigBoiCompany.setBeachResort(beachResort);
        bigBoiCompany.setRestaurant(restaurant);
        bigBoiCompany.setSkiResort(skiResort);
        Ski ski = new SkiRossignol();
        SkiRent skiRent = new SkiRent();
        SkiShoes skiShoes = new ShoeRossignol(38);

        skiRent.rentPassForSlope(SlopeType.EASY_1, SlopeType.EASY_2, SlopeType.MEDIUM_1, SlopeType.EASY_2, SlopeType.MEDIUM_2);
        skiRent.rentPassForSlope(SlopeType.EASY_1, SlopeType.EASY_2, SlopeType.MEDIUM_1, SlopeType.EASY_2, SlopeType.MEDIUM_2, SlopeType.HARD_1);
        skiRent.rentPassForSlope(SlopeType.EASY_1);

//        beachResort.rentBeachChair(BeachChairEnum.LEATHER, 2, employee);
//        beachResort.rentBeachChair(BeachChairEnum.LEATHER, 2, guest);
//        beachResort.rentBeachChair(BeachChairEnum.LEATHER, 2, customer);
//
//        beachResort.rentBeachChair(BeachChairEnum.WOODEN, 1, employee);
//        beachResort.rentBeachChair(BeachChairEnum.WOODEN, 1, guest);
//        beachResort.rentBeachChair(BeachChairEnum.WOODEN, 1, customer);

        skiRent.buySki(SkiSizeTypes.MEDIUM, 10);
        skiRent.buyShoes(SkiBrands.ROSSIGNOL, 38, 10);

        skiResort.rentSki(ski, SkiSizeTypes.MEDIUM, employee);
        skiResort.rentShoes(skiShoes, 38, employee);


    }
}

//    public static void main(String[] args) {
//        Stack<Integer> nums = new Stack<>();
//        nums.add(213);
//        nums.add(0, 123);
//        System.out.println(nums.pop());
//        nums.add(0, 2134);
//        nums.add(0, 111);
//        nums.add(0, 222);
//
//        System.out.println(nums.pop());
//        System.out.println(nums.pop());
//
//        ArrayList<Integer> nums2 = new ArrayList<>();
////        nums2.
//    }