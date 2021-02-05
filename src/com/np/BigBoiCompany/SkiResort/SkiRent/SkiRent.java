package com.np.BigBoiCompany.SkiResort.SkiRent;

import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.SkiInfo;
import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.SkiSizeTypes;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.Base.SkiShoes;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.ShoeK2;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.ShoeRossignol;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.ShoeLine;
import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.*;
import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.Ski;
import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.*;
import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base.Slope;
import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base.SlopeType;
import com.np.BigBoiCompany.Utility;

import java.util.ArrayList;
import java.util.Arrays;

public class SkiRent {

    private double profit = 0;
    private ArrayList<Ski> availableSkis = new ArrayList<>();
    private ArrayList<SkiShoes> availableShoes = new ArrayList<>();
    private ArrayList<SkiShoes> takenShoes = new ArrayList<>();
    private ArrayList<SkiInfo> skiNew = new ArrayList<>();
    private ArrayList<SkiInfo> skiNewTaken = new ArrayList<>();
    private ArrayList<Slope> slopes = new ArrayList<>();


    public SkiRent() {
//        populateSki();
//        populateSkiShoes();
        populateSlopes();
    }

//    private void populateSkiShoes() {
//        for (int i = 36; i < 46; i++) {
//            SkiShoes shoe1 = new ShoeK2(i);
//            SkiShoes shoe2 = new ShoeRossignol(i);
//            SkiShoes shoe3 = new ShoeLine(i);
//            for (int y = 0; y < 2; y++) {
//                this.availableShoes.add(shoe1);
//                this.availableShoes.add(shoe2);
//                this.availableShoes.add(shoe3);
//            }
//        }
//    }

//    private void populateSki() {
//        Ski ski1 = new SkiK2();
//        Ski ski2 = new SkiRossignol();
//        Ski ski3 = new SkiLine();
//        Ski ski4 = new SkiFishcher();
//        Ski ski5 = new SkiVolkl();
//        availableSkis.add(ski1);
//        availableSkis.add(ski2);
//        availableSkis.add(ski3);
//        availableSkis.add(ski4);
//        availableSkis.add(ski5);
//
//    }


    /*
    come back when you add budget
    */

    public void buySki(SkiSizeTypes skiLength, int numberOfPairs) {
        SkiInfo ski;
        int id = skiNew.size() + 1;

        for(int i = 0; i < skiNew.size() - 1; i++) {
            if(skiNew.get(i).getId() + 1 != skiNew.get(i + 1).getId()) {
                id = skiNew.get(i).getId() + 1;
            }
        }

        if(skiLength.equals(SkiSizeTypes.VERY_SMALL)) {
            ski = new SkiInfo(id, new SkiFishcher(), 100, 0);

        } else if(skiLength.equals(SkiSizeTypes.SMALL)) {
            ski = new SkiInfo(id, new SkiLine(), 100, 0);

        } else if(skiLength.equals(SkiSizeTypes.MEDIUM)) {
            ski = new SkiInfo(id, new SkiRossignol(), 100, 0);

        } else if(skiLength.equals(SkiSizeTypes.LONG)) {
            ski = new SkiInfo(id, new SkiK2(), 100, 0);

        } else {
            ski = new SkiInfo(id, new SkiVolkl(), 100, 0);
        }

        for (int i = 0; i < numberOfPairs; i++) {
            skiNew.add(ski);
        }
    }

    public void buyShoes(SkiBrands brand, int size, int numberOfPairs) {
        SkiShoes shoe;

        if(brand.equals(SkiBrands.K2)) {
            shoe = new ShoeK2(size);

        } else if(brand.equals(SkiBrands.LINE)) {
            shoe = new ShoeLine(size);

        } else if(brand.equals(SkiBrands.ROSSIGNOL)) {
            shoe = new ShoeRossignol(size);

        } else {
            System.out.println("No shoes of this brand");
            return;
        }

        for(int i = 0; i < numberOfPairs; i++) {
            availableShoes.add(shoe);
        }

    }

    public void populateSlopes() {
        Slope e1 = new E1();
        Slope e2 = new E2();
        Slope m1 = new M1();
        Slope m2 = new M2();
        Slope h1 = new H1();
        Slope h2 = new H2();
        slopes.add(e1);
        slopes.add(e2);
        slopes.add(m1);
        slopes.add(m2);
        slopes.add(h1);
        slopes.add(h2);
    }

    public double getProfit() {
        return profit;
    }

    public void checkProfit() {
        System.out.println("The profit of the Ski is " + Utility.formatNumber(profit));
        System.out.println();
    }


    /*
    Add person here
     */
    public void rentSki(SkiSizeTypes skiLength) {
        SkiInfo ski = null;

        for(int i = 0; i < skiNew.size(); i++) {

            if(skiNew.get(i).getSki().getLength() == skiLength) {
                ski = skiNew.get(i);
                skiNew.remove(i);
                skiNewTaken.add(ski);
                break;
            }
        }

        if(ski == null) {
            System.out.println("We do not have this size at the moment!");

        } else {
            System.out.println("Rented Ski info" + "\n"
                                + "ski: " + ski.getSki().getBrand() + "\n"
                                + "length: " + ski.getSki().getLength() + "\n"
                                + "price: " + Utility.formatNumber(ski.getSki().getRentPricePerDay()) + "$");
        }
    }

//    public void rentSki(SkiSizeTypes skiLength) {
//        SkiSizeTypes localType = SkiSizeTypes.NONE;
//        double skiProfit = 0;
//
//        for(int i = 0; i < availableSkis.size(); i++) {
//            if(availableSkis.get(i).getLength() == skiLength) {
//                Ski localSki = availableSkis.get(i);
//
//                System.out.println("You rented:");
//                localSki.getInfoSki();
//                skiProfit = localSki.getRentPricePerDay();
//                localType = localSki.getLength();
//                break;
//            }
//        }
//
//        if (localType == SkiSizeTypes.NONE) {
//            System.out.println("There are no ski with length " + skiLength.getValue() +
//                    "\n" + "Please insert correct ski length");
//        } else {
//            System.out.println("Price: " + Utility.formatNumber(skiProfit) + "$");
//            profit = profit + (skiProfit);
//            System.out.println();
//        }
//    }

    /*
    Add person here
     */
    public void rentShoes(int shoeSize) {
        double shoeProfit = 0;

        for (int i = 0; i < availableShoes.size(); i++) {
            if (availableShoes.get(i).getShoeSize() == shoeSize) {
                SkiShoes localShoes = availableShoes.get(i);

                localShoes.getInfoShoe();
                shoeProfit = localShoes.getRentPricePerDay();
                takenShoes.add(localShoes);
                availableShoes.remove(i);
                break;
            }
        }

        if (shoeProfit == 0) {
            System.out.println("There are no shoes " + shoeSize + " size" +
                    "\n" + "Please insert correct size");
        } else {
            System.out.println("Price: " + Utility.formatNumber(shoeProfit) + "$");
            profit = profit + (shoeProfit);
        }
        System.out.println();
    }

    /*
    Add person here
     */
    public void rentSkiAndShoes(SkiSizeTypes skiLength, int shoeSize) {
        rentSki(skiLength);
        rentShoes(shoeSize);
    }

    /*
      Add person here
      add discount for more slopes
      */


    public void rentPassForSlope1(SlopeType... slope) {
        ArrayList<SlopeType> slopeAL = new ArrayList<>(Arrays.asList(slope));

        for(int i = 0; i < slopeAL.size() - 1; i++) {

            for(int y = i + 1; y < slopeAL.size(); y++) {

                if(slopeAL.get(i) == slopeAL.get(y)) {
                    slopeAL.remove(y);
                    y--;
                }
            }
        }

        double price = 0;
        for(int i = 0; i < slopeAL.size(); i++) {
            price += slopeAL.get(i).getPrice();

            for(int y = 0; y < slopes.size(); y++) {
                if(slopes.get(y).getSlopeType() == slopeAL.get(i)) {
                    System.out.println(slopeAL.get(i) + " price:" + Utility.formatNumber(slopeAL.get(i).getPrice()) + "$");
                }
            }
        }

        System.out.println(Utility.formatNumber(price) + "$");
    }

    /*
    Need to be changed by person ID
     */
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

    /*
  Need to be changed by person ID
   */
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

    /*
  Need to be changed by person ID
   */
    public void returnSkiAndShoes(SkiSizeTypes skiLength,  int shoeSize) {
        returnSki(skiLength);
        returnShoes(shoeSize);
    }
}
