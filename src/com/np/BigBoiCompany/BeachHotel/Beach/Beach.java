package com.np.BigBoiCompany.BeachHotel.Beach;

import com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.Base.BeachChair;
import com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.Base.BeachChairEnum;
import com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.LeatherChair;
import com.np.BigBoiCompany.BeachHotel.Beach.BeachChair.WoodenChair;
import com.np.BigBoiCompany.Person.Base.PersonType;
import com.np.BigBoiCompany.Person.Customer;
import com.np.BigBoiCompany.SharedComponent.Base.Hotel;
import com.np.BigBoiCompany.SharedComponent.BeachHotel;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiRent;
import com.np.BigBoiCompany.Utility;
import com.np.BigBoiCompany.Person.Base.Person;


public class Beach {

    private int countL = 0;
    private int countW = 0;
    private double profit = 0;
    private BeachHotel beachHotel;

    public Beach (BeachHotel beachHotel) {
        this.beachHotel = beachHotel;
        populateChair();
    }

    SkiRent skiRent = new SkiRent();

    public void setSkiRent(SkiRent skiRent) {
        this.skiRent = skiRent;
    }

    public void setBeachHotel(BeachHotel beachHotel) {
        this.beachHotel = beachHotel;
    }

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

    public void rentChair(BeachChairEnum beachChair, int rentHours, Person person) {

        BeachChair chair;

        if (!person.getPersonType().equals(PersonType.GUEST) && beachHotel.getAvailableApartments().size() == 0){
            System.out.println("Sorry, there are no free places today!");
        } else {
            switch (beachChair) {
                case WOODEN:
                    if (countW > 0) {
                        countW--;
                        chair = new WoodenChair();
                    } else {
                        if (countL > 0) {
                            System.out.println("Take a leather chair");
                        } else {
                            System.out.println("Lay on the beach");
                        }
                        return;
                    }
                    break;
                case LEATHER:
                    if (countL > 0) {
                        countL--;
                        chair = new LeatherChair();
                    } else {
                        if (countW > 0) {
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

            double price = chair.getRentPricePerHour();
            price -= price * person.getDiscount() / 100;


            System.out.println("You have rented a");
            chair.getInfoChair();
            System.out.println("Price for " + person + " is " + Utility.formatNumber(price * rentHours) + "$");
            System.out.println();

            if(person.getPersonType().equals(PersonType.EMPLOYEE)) {
                profit += skiRent.putItOnTab(person, price);
            } else if (person.getPersonType().equals(PersonType.EMPLOYEE) && person.getTab() > person.getSalary() * 30 /100) {
                System.out.println("Sorry can't put the bill on your tab. You have reached your limit.");
            }

            profit += price * rentHours;
        }
    }

    public void returnBeachChair(BeachChairEnum beachChair) {

        switch (beachChair) {
            case WOODEN:
                if (countW < 16) {
                    countW++;
                    System.out.println("You returned wooden chair");
                } else {
                    System.out.println("No such type to be returned");
                }
                break;
            case LEATHER:
                if (countL < 16) {
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

