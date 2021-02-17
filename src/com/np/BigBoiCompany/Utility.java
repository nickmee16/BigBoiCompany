package com.np.BigBoiCompany;

import com.np.BigBoiCompany.Person.Base.Person;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Utility {
    private static DecimalFormat df = new DecimalFormat("0.00");

    public static String formatNumber(double num) {
        return df.format(num);
    }

    public static double putItOnTab(Person person, double price) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to be put on your tab! If yes insert Y/y:");
        String answer = scanner.nextLine().toLowerCase(Locale.ROOT);

        if(answer.equals("y")) {

            if(person.getTab() + price <= (person.getSalary() * 30) / 100) {

                person.setTab(person.getTab() + price);
                System.out.println(person.getName() + " new tab balance:" + Utility.formatNumber(person.getTab()) + "$");
                return 0;

            } else {

                System.out.println("You will get over the limit:" + Utility.formatNumber((person.getSalary() * 30) / 100) + "$" +"\n"
                        + "New balance will be: " + Utility.formatNumber(person.getTab() + price) + "$" + "\n"
                        + "You can put part of the price on your tab and you must pay rest! If yes insert Y/y: ");
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
