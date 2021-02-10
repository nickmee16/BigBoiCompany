package com.np.BigBoiCompany.SkiResort.SkiRent;

import com.np.BigBoiCompany.Person.Base.Person;
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

    /*
    come back when you add budget
    */

    public void buySki(SkiSizeTypes skiLength, int numberOfPairs) {
        SkiInfo ski;

        for (int i = 0; i < numberOfPairs; i++) {

            int id = skiNew.size() + 1;

            for (int y = 0; y < skiNew.size() - 1; y++) {
                if (skiNew.get(y).getId() + 1 != skiNew.get(y + 1).getId()) {
                    id = skiNew.get(y).getId() + 1;
                }
            }

            if (skiLength.equals(SkiSizeTypes.VERY_SMALL)) {
                ski = new SkiInfo(id, new SkiFishcher(), 100, 0);

            } else if (skiLength.equals(SkiSizeTypes.SMALL)) {
                ski = new SkiInfo(id, new SkiLine(), 100, 0);

            } else if (skiLength.equals(SkiSizeTypes.MEDIUM)) {
                ski = new SkiInfo(id, new SkiRossignol(), 100, 0);

            } else if (skiLength.equals(SkiSizeTypes.LONG)) {
                ski = new SkiInfo(id, new SkiK2(), 100, 0);

            } else {
                ski = new SkiInfo(id, new SkiVolkl(), 100, 0);
            }


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

    public void rentSki(Ski ski, SkiSizeTypes skiLength, Person person) {
        SkiInfo skiInfo = null;

        double skiPrice = ski.getRentPricePerDay();
        skiPrice -= skiPrice * person.getDiscount() /100;

        for(int i = 0; i < skiNew.size(); i++) {

            if(skiNew.get(i).getSki().getLength() == skiLength) {
                skiInfo = skiNew.get(i);
                skiNew.remove(i);
                skiNewTaken.add(skiInfo);
                break;
            }
        }

        if(skiInfo == null) {
            System.out.println("We do not have this size at the moment!");

        } else {
            System.out.println("Rented Ski info" + "\n"
                                + "ski: " + skiInfo.getSki().getBrand() + "\n"
                                + "length: " + skiInfo.getSki().getLength() + "\n"
                                + "price: " + Utility.formatNumber(skiPrice) + "$");
        }
    }


    public void rentShoes(SkiShoes skiShoes, int shoeSize, Person person) {
        double shoePrice = skiShoes.getRentPricePerDay();

        shoePrice -= shoePrice * person.getDiscount() /100;

        for (int i = 0; i < availableShoes.size(); i++) {
            if (availableShoes.get(i).getShoeSize() == shoeSize) {
                SkiShoes localShoes = availableShoes.get(i);

                localShoes.getInfoShoe();
                shoePrice = localShoes.getRentPricePerDay();
                takenShoes.add(localShoes);
                availableShoes.remove(i);
                break;
            }
        }

        if (shoePrice == 0) {
            System.out.println("There are no shoes " + shoeSize + " size" +
                    "\n" + "Please insert correct size");
        } else {
            System.out.println("Price for " + person + " is " + Utility.formatNumber(shoePrice) + "$");
            profit += (shoePrice);
        }
        System.out.println();
    }

    public void rentSkiAndShoes(Ski ski, SkiSizeTypes skiLength, SkiShoes skiShoes, int shoeSize, Person person) {
        rentSki(ski, skiLength, person);
        rentShoes(skiShoes, shoeSize, person);
    }


    public void rentPassForSlope(Person person, SlopeType... slope) {
        ArrayList<SlopeType> slopeAL = new ArrayList<>(Arrays.asList(slope));

        for(int i = 0; i < slopeAL.size() - 1; i++) {

            for(int y = i + 1; y < slopeAL.size(); y++) {

                if(slopeAL.get(i) == slopeAL.get(y)) {
                    slopeAL.remove(y);
                    y--;
                }
            }
        }

        int discount = 0;

        if(slopeAL.size() > 1) {
            discount = 5 * slopeAL.size();
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
        System.out.println(discount);
        price = price *  ((double) (100 - discount) / 100);
        price -= price * person.getDiscount() / 100;

        if(discount == 0) {
            System.out.println("Total price for " + person + " is " + Utility.formatNumber(price) + "$");
        } else {
            System.out.println("Total with discount for package of " + slopeAL.size() + " slopes: " + Utility.formatNumber(price) + "$");
        }
    }

    /*
    Need to be changed by person ID
     */
    public void returnSki(Person person, SkiSizeTypes skiLength) {
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
    public void returnShoes(Person person, int shoeSize) {
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
    public void returnSkiAndShoes(Person person, SkiSizeTypes skiLength,  int shoeSize) {
        returnSki(person, skiLength);
        returnShoes(person, shoeSize);
    }
}
