package com.np.BigBoiCompany.SkiResort.SkiRent;

import com.np.BigBoiCompany.Person.Base.Person;
import com.np.BigBoiCompany.Person.Base.PersonType;
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
    private ArrayList<SkiInfo> availableSkis = new ArrayList<>();
    private HashMap<Person, SkiInfo> takenSki = new HashMap<>();
    private ArrayList<SkiShoes> availableShoes = new ArrayList<>();
    private HashMap<Person, SkiShoes> takenShoes = new HashMap<>();
    private ArrayList<Slope> slopes = new ArrayList<>();
    private HashMap<Person, SlopeType> allowedSLopes = new HashMap<>();


    public SkiRent() {
        populateSlopes();
    }

    public void buySki(Ski ski, int numberOfPairs) {
        SkiInfo skiInfo;

        for (int i = 0; i < numberOfPairs; i++) {

            int id = availableSkis.size() + 1;

            for (int y = 0; y < availableSkis.size() - 1; y++) {
                if (availableSkis.get(y).getId() + 1 != availableSkis.get(y + 1).getId()) {
                    id = availableSkis.get(y).getId() + 1;
                }
            }

            skiInfo = new SkiInfo(id, ski, 100, 0);

            availableSkis.add(skiInfo);
        }
    }

    public void buyShoes(SkiBrands brand, int size, int numberOfPairs) {
        SkiShoes shoe;

        if (brand.equals(SkiBrands.K2)) {
            shoe = new ShoeK2(size);

        } else if (brand.equals(SkiBrands.LINE)) {
            shoe = new ShoeLine(size);

        } else if (brand.equals(SkiBrands.ROSSIGNOL)) {
            shoe = new ShoeRossignol(size);

        } else {
            System.out.println("No shoes of this brand");
            return;
        }

        for (int i = 0; i < numberOfPairs; i++) {
            availableShoes.add(shoe);
        }

    }

    private void populateSlopes() {
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

        } else if (ski.getCondition() <= 40) {

            double skiPrice = ski.getSki().getRentPricePerDay() * days;
            skiPrice -= skiPrice * person.getDiscount() / 100;
            skiPrice -= skiPrice * 60 / 100;

            System.out.println("You get extra 60% discount");
            System.out.println("Rented ski info" + "\n"
                    + "Brand: " + ski.getSki().getBrand() + "\n"
                    + "Length: " + ski.getSki().getLength() + "\n"
                    + "Condition: " + ski.getCondition() + "%" + "\n"
                    + "Price: " + Utility.formatNumber(skiPrice) + "$");

            if(person.getPersonType().equals(PersonType.EMPLOYEE)) {
              profit +=  putItOnTab(person, skiPrice);
            } else if (person.getPersonType().equals(PersonType.EMPLOYEE) && person.getTab() > person.getSalary() * 30 /100) {
                System.out.println("Sorry can't put the bill on your tab. You have reached your limit.");
            }

            profit += skiPrice;

        } else {

            double skiPrice = ski.getSki().getRentPricePerDay() * days;
            System.out.println(skiPrice + " sadasd");
            skiPrice -= skiPrice * person.getDiscount() / 100;
            System.out.println(skiPrice + " asdsd");

            System.out.println("Rented ski info" + "\n"
                    + "Brand: " + ski.getSki().getBrand() + "\n"
                    + "Length: " + ski.getSki().getLength() + "\n"
                    + "Condition: " + ski.getCondition() + "%" + "\n"
                    + "Price: " + Utility.formatNumber(skiPrice) + "$");

            if(person.getPersonType().equals(PersonType.EMPLOYEE)) {
                profit +=  putItOnTab(person, skiPrice);
            }

            profit += skiPrice;
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
                if(person.getPersonType().equals(PersonType.EMPLOYEE)) {
                profit += putItOnTab(person, shoePrice);
            } else if (person.getPersonType().equals(PersonType.EMPLOYEE) && person.getTab() > person.getSalary() * 30 /100) {
                System.out.println("Sorry can't put the bill on your tab. You have reached your limit.");
            }
            profit += (shoePrice);
        }
        System.out.println();

    }

    public void rentSkiAndShoes(int skiID, SkiShoes skiShoes, int shoeSize, Person person, int days) {
        rentSki(skiID, person, days);
        rentShoes(skiShoes, shoeSize, person, days);
            }

    public void rentPassForSlope(Person person, int days, SlopeType... slope) {
        ArrayList<SlopeType> slopeAL = new ArrayList<>(Arrays.asList(slope));

        for (int i = 0; i < slopeAL.size() - 1; i++) {

            for (int y = i + 1; y < slopeAL.size(); y++) {

                if (slopeAL.get(i) == slopeAL.get(y)) {
                    slopeAL.remove(y);
                    y--;
                }
            }
        }

        int discount = 0;

        if (slopeAL.size() > 1) {
            discount = 5 * slopeAL.size();
        }

        double price = 0;
        for (int i = 0; i < slopeAL.size(); i++) {
            price += slopeAL.get(i).getPrice();
            allowedSLopes.put(person, slopeAL.get(i));

            for (int y = 0; y < slopes.size(); y++) {
                if (slopes.get(y).getSlopeType() == slopeAL.get(i)) {
                    System.out.println(slopeAL.get(i) + " price:" + Utility.formatNumber(slopeAL.get(i).getPrice()) + "$");
                }
            }
        }

        if(person.getPersonType().equals(PersonType.EMPLOYEE)) {
            profit +=  putItOnTab(person, price);
        } else if (person.getPersonType().equals(PersonType.EMPLOYEE) && person.getTab() > person.getSalary() * 30 /100) {
            System.out.println("Sorry can't put the bill on your tab. You have reached your limit.");
        }

        System.out.println(discount);
        price = price * ((double) (100 - discount) / 100) * days;
        price -= price * person.getDiscount() / 100;

        if (discount == 0) {
            System.out.println("Total price for " + person + " is " + Utility.formatNumber(price) + "$");
        } else {
            System.out.println("Total with discount for package of " + slopeAL.size() + " slopes: " + Utility.formatNumber(price) + "$");
        }
    }

    public void goDownTheSlope(Person person, SlopeType slope) {

        if (!allowedSLopes.containsKey(person)) {
            System.out.println("This person does not have a valid pass for slopes.");

        } else if (allowedSLopes.containsKey(person) && !allowedSLopes.containsValue(slope)) {
            System.out.println("This person does not have a valid pass for " + slope);
        }

        if (allowedSLopes.containsKey(person) && allowedSLopes.containsValue(slope)
                && takenSki.containsKey(person)) {

            if (takenSki.get(person).getCondition() <= 40 && !(slope.equals(SlopeType.EASY_1) || slope.equals(SlopeType.EASY_2))) {
                System.out.println("The condition of the ski(" + takenSki.get(person).getCondition() + "%) is too dangerous for skiing on slopes different than " + SlopeType.EASY_1 + " and " + SlopeType.EASY_2);

            } else {
                takenSki.get(person).setCondition(takenSki.get(person).getCondition() - slope.getDmg());
                System.out.println(person.getName() + " went down on slope " + slope + ". Ski info and state: " + takenSki.get(person).getSki().getBrand() + ", id:" + takenSki.get(person).getId() + ", condition:" + takenSki.get(person).getCondition() + "%.");
            }
        }
    }

    public void repairSki(int skiID) {

        if (skiID > availableSkis.size() + takenSki.size()) {
            System.out.println("Wrong ID");
            return;
        }

        for (int i = 0; i < availableSkis.size(); i++) {

            if (skiID == availableSkis.get(i).getId()) {

                if (100 - availableSkis.get(i).getTimesRepaired() * 20 == 20) {
                    System.out.println("Those ski can not be repaired anymore");

                } else if (availableSkis.get(i).getCondition() > 10) {
                    System.out.println("These ski do not required repairing");

                } else {
                    availableSkis.get(i).setTimesRepaired(availableSkis.get(i).getTimesRepaired() + 1);
                    availableSkis.get(i).setCondition(100 - availableSkis.get(i).getTimesRepaired() * 20);

                    System.out.println("Ski " + availableSkis.get(i).getSki().getBrand() + " (" + availableSkis.get(i).getId() + ")" + "\n"
                            + "have been repaired (times repaired: " + availableSkis.get(i).getTimesRepaired() + ")" + "\n"
                            + "new condition: " + availableSkis.get(i).getCondition() + "%");
                }
            }
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

    public double putItOnTab(Person person, double price) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to be put on your tab? If yes insert Y/y:");
        String answer = scanner.nextLine().toLowerCase(Locale.ROOT);

        if(answer.equals("y")) {

            if(person.getTab() + price <= (person.getSalary() * 30) / 100) {

                person.setTab(person.getTab() + price);
                System.out.println(person.getName() + " new tab balance:" + Utility.formatNumber(person.getTab()) + "$");
                return 0;

            } else {

                System.out.println("You will get over the limit:" + Utility.formatNumber((person.getSalary() * 30) / 100) + "$" +"\n"
                + "New balance will be: " + Utility.formatNumber(person.getTab() + price) + "$" + "\n"
                + "You can put part of the price on your tab and you must pay rest. If yes, insert Y/y: ");
                String answer1 = scanner.nextLine().toLowerCase(Locale.ROOT);

                if(answer1.equals("y")) {

                    double rest = (person.getTab() + price) - ((person.getSalary() * 30) / 100);
                    person.setTab((person.getSalary() * 30) / 100);
                    System.out.println(person.getName() +  " new tab balance: " + Utility.formatNumber(person.getTab()) + "$" + "\n"
                    + "Price: " + Utility.formatNumber(rest) + "$");
                } else {
                    System.out.println("Refused");
                    return price;
                }
            }
        } else {
            System.out.println("Refused");
            return price;
        }
        return 0;
    }
}
