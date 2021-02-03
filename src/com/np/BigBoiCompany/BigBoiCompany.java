package com.np.BigBoiCompany;

import com.np.BigBoiCompany.BeachHotel.BeachResort;
import com.np.BigBoiCompany.Person.Base.Person;
import com.np.BigBoiCompany.Person.Guest;
import com.np.BigBoiCompany.Restaurant.Restaurant;
import com.np.BigBoiCompany.SharedComponent.Base.Hotel;
import com.np.BigBoiCompany.SharedComponent.Base.HotelTypes;
import com.np.BigBoiCompany.SkiResort.SkiResort;
import com.np.BigBoiCompany.Person.Employee;

import java.util.ArrayList;
import java.util.HashMap;

public class BigBoiCompany {
    private ArrayList<IProfitable> assets = new ArrayList<>();
    private HashMap<HotelTypes, Hotel> availableHotels = new HashMap<>();
    private SkiResort skiResort;
    private BeachResort beachResort;
    private Restaurant restaurant;
    private ArrayList<Person> employees = new ArrayList<>();
    private ArrayList<Person> guests = new ArrayList<>();


    public BigBoiCompany() {
        this.skiResort = new SkiResort("Ski");
        this.beachResort = new BeachResort("Bitch");
        this.restaurant = new Restaurant("Rest", 100);

        populateAvailableHotels();
        populateAssets();

    }

    private void populateAssets() {
        assets.add(skiResort);
        assets.add(beachResort);
        assets.add(restaurant);
    }

    public void companyProfit() {
        double profit = 0;

        for (IProfitable asset : assets) {
            profit += asset.getProfit();
        }

        System.out.println("Big Boi Company Profit: " + Utility.formatNumber(profit) + "$");
    }


    public void populateAvailableHotels() {
        this.availableHotels.put(skiResort.getHotel().getType(), skiResort.getHotel());
        this.availableHotels.put(beachResort.getHotel().getType(), beachResort.getHotel());
    }

    public void showAvailableHotels() {
        for (Hotel hotel: availableHotels.values()) {
            hotel.info();
        }
    }

    public void showAvailableApartments(HotelTypes hotel) {
        availableHotels.get(hotel).showAvailableApartments();
    }

    public void rentApartment(HotelTypes hotel, int numApartment, int days) {
        availableHotels.get(hotel).rentApartment(numApartment, days);
    }

    public void returnKeysApartment(HotelTypes hotel, int apartmentNumber) {
        availableHotels.get(hotel).returnKeys(apartmentNumber);
    }

    public void hireEmployee(String name, String EGN, double salary) {
        boolean notExist = true;
        for(int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getEGN().equals(EGN)) {
                notExist = false;
                break;
            }
        }

        if(!notExist) {
            System.out.println("This EGN is already in the system");

        } else if(!checkNameEGN(name, EGN)) {

        } else {
            Person emp = new Employee(name, EGN, salary);
            employees.add(emp);
            System.out.println("New employee" + "\n"
                    + "name: " + emp.getName() + "\n"
                    + "EGN: " + emp.getEGN() + "\n"
                    + "salary: " + emp.getSalary() + "\n");
        }
    }

    public void addGuest(String  name, String EGN) {
        boolean notExist = true;
        for(int i = 0; i < guests.size(); i++) {
            if(guests.get(i).getEGN().equals(EGN)) {
                notExist = false;
                break;
            }
        }

        if(!notExist) {
            System.out.println("This EGN is already in the system");

        } else if(!checkNameEGN(name, EGN)) {

        } else {
            Person guest = new Guest(name, EGN);
            guests.add(guest);
            System.out.println("New employee" + "\n"
                    + "name: " + guest.getName() + "\n"
                    + "EGN: " + guest.getEGN() + "\n");
        }
    }

    public void showEmployeeInfo() {
        for (Person employee : employees) {
            System.out.println("name: " + employee.getName() + "\n"
                    + "EGN: " + employee.getEGN() + "\n"
                    + "salary: " + employee.getSalary() + "\n"
                    + "tab: " + employee.getTab() + "\n");
        }
    }

    public void showGuestInfo() {
        for (Person guest : guests) {
            System.out.println("name: " + guest.getName() + "\n"
                    + "EGN: " + guest.getEGN() + "\n");
        }
    }

    public boolean checkNameEGN(String name, String EGN) {
        if(!name.matches("^[ A-Za-z]+$")) {

            System.out.println("Name should contain only letters");
            return false;

        } else if(EGN.matches(".*[a-zA-Z]+.*") || EGN.length() != 10) {

            System.out.println("EGN should be exactly 10 symbols and should contain only digits");
            return false;
        }

        return true;
    }
}
