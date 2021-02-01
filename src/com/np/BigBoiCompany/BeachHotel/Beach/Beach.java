package com.np.BigBoiCompany.BeachHotel.Beach;

import com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.Base.BeachChair;
import com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.Base.BeachChairEnum;
import com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.LeatherChair;
import com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.WoodenChair;
import com.np.BigBoiCompany.Utility;

public class Beach {

    private int countL = 0;
    private int countW = 0;
    private double profit = 0;
//    private final ArrayList<BeachChair> availableChairs = new ArrayList<>();
//    private final ArrayList<BeachChair> takenChairs = new ArrayList<>();

    public Beach() {
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
        for (int y = 0; y < 15; y++) {
            countL++;
            countW++;
        }
    }

    public void checkOffers() {
        System.out.println(BeachChairEnum.LEATHER + " - " + countL);
        System.out.println(BeachChairEnum.WOODEN + " - " + countW);
    }

    public void rentChair(BeachChairEnum beachChair, int rentHours, boolean isHotelUser) {
        BeachChair chair;

        switch (beachChair) {
            case WOODEN:
                if(countW > 0) {
                    countW--;
                    chair = new WoodenChair();
                } else {
                    if(countL > 0) {
                        System.out.println("Take a leather chair");
                    } else {
                        System.out.println("Lay on the beach");
                    }
                    return;
                }
                break;
            case LEATHER:
                if(countL > 0) {
                    countL--;
                    chair = new LeatherChair();
                } else {
                    if(countW > 0) {
                        System.out.println("Take a wooden chair");
                    } else {
                        System.out.println("Lay on the beach");
                    }
                    return;
                }
                break;
            default:
                chair = new LeatherChair();
                break;
        }

        double price = isHotelUser ?
                chair.getRentPricePerHourForHotelUsers() :
                chair.getRentPricePerHourForNonHotelUsers();

        System.out.println("You rented:");
        chair.getInfoChair();
        System.out.println("Price: " + Utility.formatNumber(price * rentHours) + "$");
        System.out.println();
        profit += price * rentHours;
    }

    public void returnBeachChair(BeachChairEnum beachChair) {

        switch (beachChair) {
            case WOODEN:
                if(countW < 16) {
                    countW++;
                    System.out.println("You returned wooden chair");
                } else {
                    System.out.println("No such type to be returned");
                }
                break;
            case LEATHER:
                if(countL < 16) {
                    countL++;
                    System.out.println("You returned leather chair");
                } else {
                    System.out.println("No such type to be returned");
                }
                break;
            default:
                break;
        }
    }
}
