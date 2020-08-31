package com.np.BigBoiCompany.SkiResort.SkiRent;

import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.Base.SkiShoes;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.Shoe1;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.Shoe2;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.Shoe3;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiType.*;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiType.Base.SkiType;
import com.np.BigBoiCompany.Utility;

import java.util.ArrayList;

public class SkiRent {

    private double profit = 0;
    private ArrayList<SkiType> skis = new ArrayList<>();;
    private ArrayList<SkiShoes> shoes = new ArrayList<>();;
    private ArrayList<SkiShoes> availableShoes = new ArrayList<>();;
    private ArrayList<SkiShoes> takenShoes = new ArrayList<>();;


    public SkiRent() {
        populateSki();
        populateSkiShoes();
    }

    private void populateSkiShoes() {
        for (int i = 36; i < 46; i++) {
            SkiShoes shoe1 = new Shoe1(i);
            SkiShoes shoe2 = new Shoe2(i);
            SkiShoes shoe3 = new Shoe3(i);
            for (int y = 0; y < 2; y++) {
                this.availableShoes.add(shoe1);
                this.availableShoes.add(shoe2);
                this.availableShoes.add(shoe3);
            }
        }
    }

    private void populateSki() {
        SkiType ski1 = new SkiType1();
        SkiType ski2 = new SkiType2();
        SkiType ski3 = new SkiType3();
        SkiType ski4 = new SkiType4();
        SkiType ski5 = new SkiType5();
        skis.add(ski1);
        skis.add(ski2);
        skis.add(ski3);
        skis.add(ski4);
        skis.add(ski5);

    }

    public double getProfit() {
        return profit;
    }

    public void checkProfit() {
        System.out.println("The profit of the Ski is " + Utility.formatNumber(profit));
        System.out.println();
    }

    public void rentSki(int skiLength, int rentHours) {
        int countSki = 0;
        double skiProfit = 0;

        for(int i = 0; i < skis.size(); i++) {
            if(skis.get(i).getLength() == skiLength) {
                System.out.println("You rented:");
                skis.get(i).getInfoSki();
                skiProfit = skis.get(i).getRentPricePerHour();
                countSki++;
            }
        }

        if (countSki == 0) {
            System.out.println("There are no ski with length " + skiLength +
                    "\n" + "Please insert correct ski length");
        } else {
            System.out.println("Price: " + Utility.formatNumber(skiProfit * rentHours) + "$");
            profit = profit + (skiProfit * rentHours);
            System.out.println();
        }
    }

    public void rentShoes(int shoeSize, int rentHours) {
        int countShoe = 0;
        double shoeProfit = 0;

        for (int i = 0; i < availableShoes.size(); i++) {
            if (availableShoes.get(i).getShoeSize() == shoeSize) {
                availableShoes.get(i).getInfoShoe();
                shoeProfit = availableShoes.get(i).getRentPricePerHour();
                takenShoes.add(availableShoes.get(i));
                availableShoes.remove(i);
                countShoe++;
                break;
            }
        }

        if (countShoe == 0) {
            System.out.println("There are no shoes " + shoeSize + " size" +
                    "\n" + "Please insert correct size");
            System.out.println();
        } else {
            System.out.println("Price: " + Utility.formatNumber(shoeProfit * rentHours) + "$");
            profit = profit + (shoeProfit * rentHours);
            System.out.println();
        }
    }

    public void rentSkiAndShoes(int skiLength, int shoeSize, int rentHours) {
        rentSki(skiLength, rentHours);
        rentShoes(shoeSize, rentHours);
    }

    public void returnSki(int skiLength) {
        int countSki = 0;

        for(int i = 0; i < skis.size(); i++) {
            if(skis.get(i).getLength() == skiLength) {
                skis.get(i).getInfoSki();
                countSki++;
            }
        }

        if(countSki == 0) {
            System.out.println("Wrong ski length");
        } else {
            System.out.println("You returned the ski");
        }
    }

    public void returnShoes(int shoeSize) {
        int countShoes = 0;

        for (int i = 0; i < takenShoes.size(); i++) {
            if (takenShoes.get(i).getShoeSize() == shoeSize) {
                availableShoes.add(takenShoes.get(i));
                takenShoes.remove(i);
                countShoes++;
                break;
            }
        }

        if(countShoes == 0) {
            System.out.println("Wrong shoe size");
        } else {
            System.out.println("You returned the shoes");
        }
    }

    public void returnSkiAndShoes(int skiLength,  int shoeSize) {
        returnSki(skiLength);
        returnShoes(shoeSize);
    }
}
