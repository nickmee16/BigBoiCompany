package com.np.BigBoiCompany.SkiResort.SkiRent;

import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.SkiSizeTypes;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.Base.SkiShoes;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.ShoeK2;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.ShoeRossignol;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.ShoeLine;
import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.*;
import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.Ski;
import com.np.BigBoiCompany.Utility;

import java.util.ArrayList;

public class SkiRent {

    private double profit = 0;
    private ArrayList<Ski> availableSkis = new ArrayList<>();;
    private ArrayList<SkiShoes> shoes = new ArrayList<>();;
    private ArrayList<SkiShoes> availableShoes = new ArrayList<>();;
    private ArrayList<SkiShoes> takenShoes = new ArrayList<>();;


    public SkiRent() {
        populateSki();
        populateSkiShoes();
    }

    private void populateSkiShoes() {
        for (int i = 36; i < 46; i++) {
            SkiShoes shoe1 = new ShoeK2(i);
            SkiShoes shoe2 = new ShoeRossignol(i);
            SkiShoes shoe3 = new ShoeLine(i);
            for (int y = 0; y < 2; y++) {
                this.availableShoes.add(shoe1);
                this.availableShoes.add(shoe2);
                this.availableShoes.add(shoe3);
            }
        }
    }

    private void populateSki() {
        Ski ski1 = new SkiK2();
        Ski ski2 = new SkiRossignol();
        Ski ski3 = new SkiLine();
        Ski ski4 = new SkiFishcher();
        Ski ski5 = new SkiVolkl();
        availableSkis.add(ski1);
        availableSkis.add(ski2);
        availableSkis.add(ski3);
        availableSkis.add(ski4);
        availableSkis.add(ski5);

    }

    public double getProfit() {
        return profit;
    }

    public void checkProfit() {
        System.out.println("The profit of the Ski is " + Utility.formatNumber(profit));
        System.out.println();
    }

//    refactor to boolean
    public void rentSki(SkiSizeTypes skiLength, int rentHours) {
        SkiSizeTypes localType = SkiSizeTypes.NONE;
        double skiProfit = 0;

        for(int i = 0; i < availableSkis.size(); i++) {
            if(availableSkis.get(i).getLength() == skiLength) {
                Ski localSki = availableSkis.get(i);

                System.out.println("You rented:");
                localSki.getInfoSki();
                skiProfit = localSki.getRentPricePerHour();
                localType = localSki.getLength();
                break;
            }
        }

        if (localType == SkiSizeTypes.NONE) {
            System.out.println("There are no ski with length " + skiLength.getValue() +
                    "\n" + "Please insert correct ski length");
        } else {
            System.out.println("Price: " + Utility.formatNumber(skiProfit * rentHours) + "$");
            profit = profit + (skiProfit * rentHours);
            System.out.println();
        }
    }

    //    refactor to boolean

    public void rentShoes(int shoeSize, int rentHours) {
        double shoeProfit = 0;

        for (int i = 0; i < availableShoes.size(); i++) {
            if (availableShoes.get(i).getShoeSize() == shoeSize) {
                SkiShoes localShoes = availableShoes.get(i);

                localShoes.getInfoShoe();
                shoeProfit = localShoes.getRentPricePerHour();
                takenShoes.add(localShoes);
                availableShoes.remove(i);
                break;
            }
        }

        if (shoeProfit == 0) {
            System.out.println("There are no shoes " + shoeSize + " size" +
                    "\n" + "Please insert correct size");
        } else {
            System.out.println("Price: " + Utility.formatNumber(shoeProfit * rentHours) + "$");
            profit = profit + (shoeProfit * rentHours);
        }
        System.out.println();
    }

    public void rentSkiAndShoes(SkiSizeTypes skiLength, int shoeSize, int rentHours) {
        rentSki(skiLength, rentHours);
        rentShoes(shoeSize, rentHours);
    }

    public void returnSki(SkiSizeTypes skiLength) {
        int countSki = 0;

        for(int i = 0; i < availableSkis.size(); i++) {
            if(availableSkis.get(i).getLength() == skiLength) {
                availableSkis.get(i).getInfoSki();
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

    public void returnSkiAndShoes(SkiSizeTypes skiLength,  int shoeSize) {
        returnSki(skiLength);
        returnShoes(shoeSize);
    }
}
