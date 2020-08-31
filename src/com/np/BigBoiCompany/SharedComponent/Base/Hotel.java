package com.np.BigBoiCompany.SharedComponent.Base;

import com.np.BigBoiCompany.Utility;

import java.util.ArrayList;

public abstract class Hotel {

    private int floors;
    private int apartments;
    private int limitFloors;
    private int limitApartment;
    private double apartmentRent;
    private ArrayList<Integer> takenApartments;
    private double profit;

    protected Hotel(int floors, int apartments) {
        this.floors = floors;
        this.apartments = apartments;
        this.limitFloors = 2;
        this.limitApartment = 6;
        this.apartmentRent = 45;
        this.takenApartments = new ArrayList<>();
        this.profit = 0;
    }

    public double getProfit() {
        return profit;
    }

    public void checkProfit() {

        System.out.println("The profit of the hotel is " + Utility.formatNumber(profit));
        System.out.println();
    }

    public void setFloors(int floors) {
        if (floors > limitFloors) {
            this.floors = limitFloors;
        }else if(floors > 1) {
            this.floors = 1;
        } else {
            this.floors = floors;
        }
    }

    public void setApartments(int apartments) {
        if (apartments > limitApartment) {
            this.apartments = limitApartment;
        } else if(apartments < 1) {
            this.apartmentRent = 1;
        } else {
            this.apartments = apartments;
        }
    }

    private boolean checkApartment(int number) {
        int[] apartmentArray = new int[apartments * 2];
        for (int i = 0; i < apartments * 2; i++) {
            apartmentArray[i] = i + 1;
            if (apartmentArray[i] == number) {
                return true;
            }
        }
        return false;
    }

    public void rentApartment(int apartmentNumber, int days) {
        if (checkApartment(apartmentNumber) && !takenApartments.contains(apartmentNumber)) {
            System.out.println("You rented apartment №"
                    + apartmentNumber + " for " + days + " days" +
                    "\n" + "Price: " + Utility.formatNumber(apartmentRent * days) + "$");
            System.out.println();
            profit = profit + (apartmentRent * days);
            takenApartments.add(apartmentNumber);
        } else {
            System.out.println("Wrong number or the apartment is already taken.");
            System.out.println();
        }
    }

    public void returnKeys(int apartmentNumber) {
        int ind = takenApartments.indexOf(apartmentNumber);
        if (takenApartments.contains(apartmentNumber)) {
            System.out.println("You returned the keys for apartment №" + apartmentNumber);
            System.out.println();
            takenApartments.remove(ind);
        } else {
            System.out.println("Wrong number or the apartment is free.");
            System.out.println();
        }
    }
}

