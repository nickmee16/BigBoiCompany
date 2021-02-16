package com.np.BigBoiCompany.SharedComponent.Base;

import com.np.BigBoiCompany.Person.Base.Person;
import com.np.BigBoiCompany.Utility;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Hotel {

    private int floors;
    private int apartments;
    private int limitFloors;
    private int limitApartment;
    private double apartmentRent;
    private ArrayList<Integer> availableApartments;
    private ArrayList<Integer> takenApartments;
    private double profit;
    private HotelTypes type;


    protected Hotel(int floors, int apartments, HotelTypes type) {
        this.floors = floors;
        this.apartments = apartments;
        this.limitFloors = 2;
        this.limitApartment = 6;
        this.apartmentRent = 45;
        this.availableApartments = new ArrayList<>();
        this.takenApartments = new ArrayList<>();
        this.profit = 0;
        this.type = type;

        setApartments(apartments);
        setFloors(floors);
        populateAvailableApartments();
    }

    public double getProfit() {
        return profit;
    }

    public int getApartments() {
        return apartments;
    }

    public int getLimitApartment() {
        return limitApartment;
    }

    public ArrayList<Integer> getAvailableApartments() {
        return availableApartments;
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

    public void populateAvailableApartments() {
        for(int i = 0; i < apartments; i++) {
            availableApartments.add(i + 1);
        }
    }

    public void showAvailableApartments() {
        Collections.sort(availableApartments);

        for(int i = 0; i < availableApartments.size(); i++) {

            if(i == availableApartments.size() - 1) {
                System.out.println(availableApartments.get(i));
            } else {
                System.out.print(availableApartments.get(i) + ", ");
            }
        }
    }

    public void rentApartment(int apartmentNumber, int days) {
        if (availableApartments.contains(apartmentNumber)) {
            System.out.println("You rented apartment №"
                    + apartmentNumber + " for " + days + " days" +
                    "\n" + "Price: " + Utility.formatNumber(apartmentRent * days) + "$");
            System.out.println();
            profit = profit + (apartmentRent * days);
            takenApartments.add(apartmentNumber);
            availableApartments.remove((Integer) apartmentNumber);
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
            availableApartments.add(apartmentNumber);
        } else {
            System.out.println("Wrong number or the apartment is free.");
            System.out.println();
        }
    }

    public HotelTypes getType() {
        return type;
    }

    public abstract void info();
}

