package com.np.BigBoiCompany.BeachHotel.Beach;

import com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.Base.BeachChair;
import com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.Chair1;
import com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.Chair2;
import com.np.BigBoiCompany.Utility;

import java.util.ArrayList;

public class Beach {


    private double profit;
    private ArrayList<BeachChair> beachChairs;
    private ArrayList<BeachChair> availableChairs;
    private ArrayList<BeachChair> takenChairs;

    public Beach() {
        this.profit = 0;
        this.beachChairs = new ArrayList<>();
        this.availableChairs = new ArrayList<>();
        this.takenChairs = new ArrayList<>();
        populateChair();

    }

    public double getProfit() {
        return profit;
    }

    public void checkProfit() {
        System.out.println("The profit of the Beach Part is " + Utility.formatNumber(profit));
        System.out.println();
    }

    private void populateChair() {
        BeachChair chair1 = new Chair1();
        BeachChair chair2 = new Chair2();

        for (int y = 0; y < 15; y++) {
            availableChairs.add(chair1);
            availableChairs.add(chair2);
        }
    }

    public void checkOffers() {
        String leather = "Leather";
        String wooden = "Wooden";
        int countL = 0;
        int countW = 0;

        for(int i = 0; i < availableChairs.size(); i++) {
            if(availableChairs.get(i).getManufacture().equals(leather)) {
                countL++;
            } else if(availableChairs.get(i).getManufacture().equals(wooden)) {
                countW++;
            }
        }

        System.out.println(leather + " - " + countL);
        System.out.println(wooden + " - " + countW);
    }



    public void rentChair(String beachChair, int rentHours, boolean isHotelUser) {
        double chairProfit = 0;
        int count = 0;

        for (int i = 0; i < availableChairs.size(); i++) {
            if(availableChairs.get(i).getManufacture().equals(beachChair)) {
                if(isHotelUser) {
                    System.out.println("You rented:");
                    availableChairs.get(i).getInfoChair();
                    System.out.println("Price: " + Utility.formatNumber(availableChairs.get(i).getRentPricePerHourForHotelUsers() * rentHours) + "$");
                    System.out.println();
                    chairProfit = availableChairs.get(i).getRentPricePerHourForHotelUsers() * rentHours;
                    takenChairs.add(availableChairs.get(i));
                    availableChairs.remove(i);
                    count++;
                    break;
                } else if(!isHotelUser) {
                    System.out.println("You rented:");
                    availableChairs.get(i).getInfoChair();
                    System.out.println("Price: " + Utility.formatNumber(availableChairs.get(i).getRentPricePerHourForNonHotelUsers() * rentHours) + "$");
                    System.out.println();
                    chairProfit = availableChairs.get(i).getRentPricePerHourForNonHotelUsers() * rentHours;
                    takenChairs.add(availableChairs.get(i));
                    availableChairs.remove(i);
                    count++;
                    break;
                }
            }
        }

        if(count == 0) {
            System.out.println("There are no " + beachChair + " beach chairs. You will have to lay on the beach with a towel");
            System.out.println();
        } else {
            profit += chairProfit;
        }
    }

    public void returnBeachChair(String beachChair) {
        int count = 0;

        for(int i = 0; i < takenChairs.size(); i++) {
            if(takenChairs.get(i).getManufacture().equals(beachChair)) {
                System.out.println("You returned " + beachChair + " beach chair");
                System.out.println();
                availableChairs.add(takenChairs.get(i));
                takenChairs.remove(i);
                count++;
                break;
            }
        }

        if (count == 0) {
            System.out.println("Wrong beach chair!");
            System.out.println();
        }
    }


}
