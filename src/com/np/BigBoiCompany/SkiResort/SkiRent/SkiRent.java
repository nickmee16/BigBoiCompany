package com.np.BigBoiCompany.SkiResort.SkiRent;

import com.np.BigBoiCompany.Person.Base.Person;
import com.np.BigBoiCompany.Person.Base.PersonType;
import com.np.BigBoiCompany.SkiResort.SkiConsts;
import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.SkiInfo;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.Base.SkiShoes;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.ShoeK2;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.ShoeRossignol;
import com.np.BigBoiCompany.SkiResort.SkiRent.SkiShoes.ShoeLine;
import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.Ski;
import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.*;
import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base.Slope;
import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base.SlopeType;
import com.np.BigBoiCompany.Utility;

import java.util.*;

public class SkiRent {

    private double profit = 0;
    private final ArrayList<SkiInfo> availableSkis = new ArrayList<>();
    private final HashMap<Person, SkiInfo> takenSki = new HashMap<>();
    private final ArrayList<SkiShoes> availableShoes = new ArrayList<>();
    private final HashMap<Person, SkiShoes> takenShoes = new HashMap<>();
    private final ArrayList<Slope> slopes = new ArrayList<>();
    private final HashMap<Person, ArrayList<SlopeType>> allowedSLopes = new HashMap<>();
    private final Queue<Integer> availableIds = new LinkedList<>();

    public SkiRent() {
        populateSlopes();
    }

    public void buySki(Ski ski, int numberOfPairs) {
        SkiInfo skiInfo;

        for (int i = 0; i < numberOfPairs; i++) {
            int id = availableSkis.size() + 1;

            if(!availableIds.isEmpty()) {
                id = availableIds.poll();
            }

            skiInfo = new SkiInfo(id, ski, 100, 0);

            availableSkis.add(skiInfo);
        }
    }

    private SkiShoes createSki(SkiBrands brand, int size) {
        switch (brand) {
            case K2: return new ShoeK2(size);
            case LINE: return new ShoeLine(size);
            case ROSSIGNOL: return new ShoeRossignol(size);
            default: return null;
        }
    }

    public void buyShoes(SkiBrands brand, int size, int numberOfPairs) {
        SkiShoes shoe = createSki(brand,size);
        if (shoe == null) {
            System.out.println("Not supported brand provided");
            return;
        }

        for (int i = 0; i < numberOfPairs; i++) {
            availableShoes.add(shoe);
        }

    }

    private void populateSlopes() {
        slopes.add(new E1());
        slopes.add(new E2());
        slopes.add(new M1());
        slopes.add(new M2());
        slopes.add(new H1());
        slopes.add(new H2());
    }

    public double getProfit() {
        return profit;
    }

    public void checkProfit() {
        System.out.println("The profit of the Ski is " + Utility.formatNumber(profit));
        System.out.println();
    }

    public void rentSki(int skiID, Person person, int days) {
        SkiInfo ski = null;

        if (skiID > availableSkis.size() + takenSki.size()) {
            System.out.println("Wrong ID");
            return;
        }


        for (int i = 0; i < availableSkis.size(); i++) {

            if (availableSkis.get(i).getId() == skiID) {
                ski = availableSkis.get(i);
                availableSkis.remove(i);
                takenSki.put(person, ski);
                break;
            }
        }


        if (ski == null) {
            System.out.println("Those ski are taken");

        } else  {

            double skiPrice = ski.getSki().getRentPricePerDay() * days;
            skiPrice -= skiPrice * person.getDiscount() / 100;
            if (ski.getCondition() <= 40) {
                skiPrice -= skiPrice * 60 / 100;
                System.out.println("You get extra 60% discount");
            }

            System.out.println("Rented ski info" + "\n"
                    + "Brand: " + ski.getSki().getBrand() + "\n"
                    + "Length: " + ski.getSki().getLength() + "\n"
                    + "Condition: " + ski.getCondition() + "%" + "\n"
                    + "Price: " + Utility.formatNumber(skiPrice) + "$");
            //TODO: fix this refactor later (profit and tab part)
            if(person.getPersonType().equals(PersonType.EMPLOYEE)) {
                profit += Utility.putItOnTab(person, skiPrice);
            } else {
                profit += skiPrice;
            }
        }
    }

    public void rentShoes(SkiShoes skiShoes, int shoeSize, Person person, int days) {
        double shoePrice = skiShoes.getRentPricePerDay();

        shoePrice -= shoePrice * person.getDiscount() / 100;

        for (int i = 0; i < availableShoes.size(); i++) {
            if (availableShoes.get(i).getShoeSize() == shoeSize) {
                SkiShoes localShoes = availableShoes.get(i);

                localShoes.getInfoShoe();
                shoePrice = localShoes.getRentPricePerDay() * days;
                takenShoes.put(person, localShoes);
                availableShoes.remove(i);
                break;
            }
        }

        if (shoePrice == 0) {
            System.out.println("There are no shoes " + shoeSize + " size" +
                    "\n" + "Please insert correct size");
        } else {
            System.out.println("Price for " + person + " is " + Utility.formatNumber(shoePrice) + "$");
            //TODO: fix this
            if(person.getPersonType().equals(PersonType.EMPLOYEE)) {
                profit += Utility.putItOnTab(person, shoePrice);
            } else {
                profit += (shoePrice);
            }
        }
        System.out.println();

    }

    public void rentSkiAndShoes(int skiID, SkiShoes skiShoes, int shoeSize, Person person, int days) {
        rentSki(skiID, person, days);
        rentShoes(skiShoes, shoeSize, person, days);
    }

    private void removeRepetitiveSlopes(ArrayList<SlopeType> slopeAL) {
        for (int i = 0; i < slopeAL.size() - 1; i++) {

            for (int y = i + 1; y < slopeAL.size(); y++) {

                if (slopeAL.get(i) == slopeAL.get(y)) {
                    slopeAL.remove(y);
                    y--;
                }
            }
        }
    }

    public void rentPassForSlope(Person person, int days, SlopeType... slope) {
        ArrayList<SlopeType> slopeAL = new ArrayList<>(Arrays.asList(slope));

        removeRepetitiveSlopes(slopeAL);

        int discount = 0;

        if (slopeAL.size() > 1) {
            discount = 5 * slopeAL.size();
        }

        double price = 0;

        ArrayList<SlopeType> slopeTypes = new ArrayList<>(slopeAL);

        for (int i = 0; i < slopeAL.size(); i++) {
            price += slopeAL.get(i).getPrice();
            slopeTypes.add(slopeAL.get(i));

            for (int y = 0; y < slopes.size(); y++) {//TODO: no comment
                if (slopes.get(y).getSlopeType() == slopeAL.get(i)) {
                    System.out.println(slopeAL.get(i) + " price:" + Utility.formatNumber(slopeAL.get(i).getPrice()) + "$");
                }
            }
        }

        if(person.getPersonType().equals(PersonType.EMPLOYEE)) {
            profit +=  Utility.putItOnTab(person, price);
        }

        allowedSLopes.put(person, slopeTypes);

        price = price * ((double) (100 - discount) / 100) * days;
        price -= price * person.getDiscount() / 100;

        //TODO:: FIX
        if(person.getPersonType().equals(PersonType.EMPLOYEE)) {
            profit += Utility.putItOnTab(person, price);
        } else {
            profit += price;
        }


        if (discount == 0) {
            System.out.println("Total price for " + person.getName() + " is " + Utility.formatNumber(price) + "$");
        } else {
            System.out.println("Total price with discount for package of " + slopeAL.size() + " slopes: " + Utility.formatNumber(price) + "$");
        }
    }

    public void goDownTheSlope(Person person, SlopeType slope) {
        if(!allowedSLopes.containsKey(person)) {
            System.out.println("This person does not have a pass for slopes.");
            return;
        }

        SkiInfo rentedSkiInfo = takenSki.get(person);

        if (rentedSkiInfo.getCondition() <= 40 && !(slope.equals(SlopeType.EASY_1) || slope.equals(SlopeType.EASY_2))) {
            System.out.println("The condition of the ski(" + rentedSkiInfo.getCondition() + "%) is too dangerous for skiing on slopes different than "
                    + SlopeType.EASY_1 + " and " + SlopeType.EASY_2);
            return;
        } else {
            rentedSkiInfo.damage(slope.getDmg());
            System.out.println(person.getName() + " went down on slope " + slope + ". Ski info and state: " + rentedSkiInfo.getSki().getBrand()
                    + ", id:" + rentedSkiInfo.getId() + ", condition:" + rentedSkiInfo.getCondition() + "%.");
        }


        boolean canPersonGoOnSelectedSlope = allowedSLopes.get(person).contains(slope);

        if (!canPersonGoOnSelectedSlope) {
            System.out.println("This person has no valid pass for slope " + slope);
        }
    }

    public void repairSki(int skiID) {

        if (skiID > availableSkis.size() + takenSki.size()) {
            System.out.println("Wrong ID");
            return;
        }

        boolean taken = true;

        for (int i = 0; i < availableSkis.size(); i++) {

            if (skiID == availableSkis.get(i).getId()) {

                if (100 - availableSkis.get(i).getTimesRepaired() * SkiConsts.MINIMUM_DURABILITY == SkiConsts.DURABILITY_LOSS_ON_REPAIR) {
                    System.out.println("Those ski can not be repaired anymore");

                } else if (availableSkis.get(i).getCondition() > SkiConsts.MINIMUM_DURABILITY) {
                    System.out.println("These ski do not required repairing");

                } else {
                    availableSkis.get(i).wasRepaired();
                    availableSkis.get(i).repair();

                    System.out.println("Ski " + availableSkis.get(i).getSki().getBrand() + " (" + availableSkis.get(i).getId() + ")" + "\n"
                            + "have been repaired (times repaired: " + availableSkis.get(i).getTimesRepaired() + ")" + "\n"
                            + "new condition: " + availableSkis.get(i).getCondition() + "%");
                }
                taken = false;
                break;
            }
        }

        if(taken) {
            System.out.println("This ski are in use");
        }
    }

    public void destroySki(int skiID) {

        if (skiID > availableSkis.size() + takenSki.size()) {
            System.out.println("Wrong ID");
            return;
        }

        for (int i = 0; i < availableSkis.size(); i++) {
            if (skiID == availableSkis.get(i).getId()) {
                System.out.println("Ski " + availableSkis.get(i).getSki().getBrand() + " (id:" + availableSkis.get(i).getId() + ") were destroyed");
                availableIds.add(skiID);
                availableSkis.remove(availableSkis.get(i));
                break;
            }
        }
    }

    public void returnSki(Person person) {

        if (takenSki.containsKey(person)) {
            availableSkis.add(takenSki.get(person));
            takenSki.remove(person);
            System.out.println(person.getName() + "(" + person.getPersonType() + ")" + " returned the ski");

        } else {
            System.out.println(person.getName() + "(" + person.getPersonType() + ")" + " have not rent ski");
        }
    }

    public void returnShoes(Person person) {
        if (takenShoes.containsKey(person)) {
            availableShoes.add(takenShoes.get(person));
            takenShoes.remove(person);
            System.out.println(person.getName() + "(" + person.getPersonType() + ")" + " returned the shoes");

        } else {
            System.out.println(person.getName() + "(" + person.getPersonType() + ")" + " have not rent shoes");
        }
    }

    public void returnSkiAndShoes(Person person) {
        returnSki(person);
        returnShoes(person);
    }
}
