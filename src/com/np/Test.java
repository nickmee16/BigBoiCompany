package com.np;

import com.np.BigBoiCompany.BeachHotel.BeachResort;
import com.np.BigBoiCompany.BigBoiCompany;
import com.np.BigBoiCompany.Person.Employee;
import com.np.BigBoiCompany.Person.Guest;
import com.np.BigBoiCompany.Restaurant.Menu.Items.Salad;
import com.np.BigBoiCompany.Restaurant.Menu.Items.Water;
import com.np.BigBoiCompany.Restaurant.Menu.MenuItemsEnum;
import com.np.BigBoiCompany.Restaurant.Restaurant;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiRent;
import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base.SlopeType;

import java.util.ArrayList;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
//        BigBoiCompany bigBoiCompany = new BigBoiCompany();
//        BeachResort beachResort = new BeachResort("Kole");
//        Restaurant restaurant = new Restaurant("Restaurant", 100);
//        Employee employee = new Employee("Angela", "1234567890", 1500);
//        Guest guest = new Guest("Zele", "0987654321");
//        bigBoiCompany.setBeachResort(beachResort);
//        bigBoiCompany.setRestaurant(restaurant);
//
//
//        bigBoiCompany.hireEmployee(employee);
//        restaurant.takeTable(1);
//        restaurant.makeAnOrder(1, MenuItemsEnum.SALAD, 1);
//        restaurant.makeAnOrder(1, MenuItemsEnum.WATER, 1);
//        restaurant.checkBill(1);
//        restaurant.pay(1, employee);
//
//        restaurant.takeTable(2);
//        restaurant.makeAnOrder(2, MenuItemsEnum.ALCOHOL, 2);
//        restaurant.pay(2, guest);
//
//        System.out.println(restaurant.getProfit()
//        );

        SkiRent skiRent = new SkiRent();
        skiRent.rentPassForSlope(SlopeType.EASY_1, SlopeType.EASY_2, SlopeType.MEDIUM_1, SlopeType.EASY_2, SlopeType.MEDIUM_2);
        skiRent.rentPassForSlope(SlopeType.EASY_1, SlopeType.EASY_2, SlopeType.MEDIUM_1, SlopeType.EASY_2, SlopeType.MEDIUM_2, SlopeType.HARD_1);
        skiRent.rentPassForSlope(SlopeType.EASY_1);

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