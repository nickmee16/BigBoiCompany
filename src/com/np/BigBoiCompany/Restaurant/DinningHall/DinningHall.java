package com.np.BigBoiCompany.Restaurant.DinningHall;

import com.np.BigBoiCompany.Restaurant.Bar.Bar;
import com.np.BigBoiCompany.Restaurant.DinningHall.Order.Order;
import com.np.BigBoiCompany.Restaurant.Menu.Menu;
import com.np.BigBoiCompany.Restaurant.Menu.MenuItemsEnum;
import com.np.BigBoiCompany.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DinningHall {

    private int tables;
    private final Menu menu;
    private final Bar bar;
    private double profit = 0;
    private final ArrayList<Integer> availableTables = new ArrayList<>();
    private final ArrayList<Order> itemsForKitchen = new ArrayList<>();
    private final HashMap<Integer, ArrayList<Order>> tableOrders = new HashMap<>();



    public DinningHall(int tables, Menu menu, Bar bar) {
        this.bar = bar;
        this.tables = tables;
        this.menu = menu;
        setTables(tables);
        populateTables();
    }

    public double getProfit() {
        return profit;
    }

    public ArrayList<Order> getItemsForKitchen() {
        return itemsForKitchen;
    }

//    public ArrayList<Order> getItemsForBar() {
//        return itemsForBar;
//    }

    private void setTables(int tables) {
        int tablesLimit = 25;
        if (tables <= 0) {
            this.tables = 1;

        } else if (tables > tablesLimit) {
            this.tables = tablesLimit;

        } else {
            this.tables = tables;
        }
    }

    private void populateTables() {
        for (int i = 0; i < tables; i++) {
            availableTables.add(i + 1);
        }
    }

    public void availableTables() {
        System.out.println("Available tables - " + availableTables.size());
    }

    public void takeTable(int table) {

        if(!availableTables.contains(table)) {
            System.out.println("Wrong table number or already taken");

        } else {
            tableOrders.put(table, new ArrayList<>());
            System.out.println("Your table is over there");
            availableTables.remove(Integer.valueOf(table));

        }
    }

    public void printMenu() {
        menu.printMenu();
    }

    public void orderItem(int table, MenuItemsEnum item, int quantity) {

        if(availableTables.contains(table)) {
            System.out.println("Wrong table number");

        } else if (quantity <= 0) {
            System.out.println("Wrong quantity");

        } else if (menu.checkIsItInStock(item) == 0) {
            System.out.println("Out of stock");

        } else if (menu.checkIsItInStock(item) < quantity) {
            System.out.println("Only " + menu.checkIsItInStock(item) + " in stock (Required: " + quantity + ")");

        } else {
            System.out.println("You order + " + item + ": " + quantity);
            fixOrder(tableOrders.get(table), item, quantity);


            menu.changeTheValueOfAvailable(item, -1 * quantity);

            if (menu.getItem(item).isFood()) {
                fixOrder(itemsForKitchen, item, quantity);

            } else {
                fixOrder(bar.getItems(), item, quantity);
            }
        }
    }

    public void returnOrder(int table, MenuItemsEnum item, int quantity) {

        if(availableTables.contains(table)) {
            System.out.println("Wrong table number");

        } else if(!menu.canBeReturned(item)) {
            System.out.println(item + " can not be returned");

        } else {

            for (int i = 0; i < tableOrders.get(table).size(); i++) {

                if (tableOrders.get(table).get(i).getItem() == item) {
                    if (tableOrders.get(table).get(i).getQuantity() <= quantity) {
                        tableOrders.get(table).remove(i);
                        System.out.println("Order " + item + " was returned");

                    } else {
                        tableOrders.get(table).get(i).setQuantity(tableOrders.get(table).get(i).getQuantity() - quantity);
                        tableOrders.get(table).get(i).setMoney(tableOrders.get(table).get(i).getMoney() -menu.getItem(item).getPrice() * quantity);
                        System.out.println("Order " + item + " was reduced to " + tableOrders.get(table).get(i).getQuantity());
                    }

                    break;
                }
            }
        }
    }

    public void checkBill(int table) {

        if(availableTables.contains(table)) {
            System.out.println("Wrong table number");

        } else {

            for(int i = 0; i < tableOrders.get(table).size(); i++) {
                System.out.print(tableOrders.get(table).get(i).getItem() + " ");
                System.out.print(tableOrders.get(table).get(i).getQuantity() + " ");
                System.out.print(Utility.formatNumber(tableOrders.get(table).get(i).getMoney()) + "$");
                System.out.println();

            }

            System.out.println("Total: " + Utility.formatNumber(price(table)) + "$");
        }
    }

    public void pay(int table) {
        if(availableTables.contains(table)) {
            System.out.println("Wrong table number or already free");
        } else {

            profit += price(table);

            tableOrders.remove(table);
            availableTables.add(table);
            Collections.sort(availableTables);

            System.out.println("Welcome back! :)");
        }
    }

    private double price(int table) {
        double price = 0;

        for(int i = 0; i < tableOrders.get(table).size(); i++) {
            price += tableOrders.get(table).get(i).getMoney();
        }

        return price;
    }

    private void fixOrder(ArrayList<Order> order, MenuItemsEnum item, int quantity) {
        if(order.size() == 0) {
            order.add(Order.createOrder(item, quantity, menu.getItem(item).getPrice() * quantity));

        } else {
            boolean hasItem = false;

            for(int i = 0; i < order.size(); i++) {

                if(order.get(i).getItem() == item) {
                    order.get(i).setQuantity(order.get(i).getQuantity() + quantity);
                    order.get(i).setMoney(order.get(i).getMoney() + menu.getItem(item).getPrice() * quantity);
                    hasItem = true;
                    break;
                }
            }

            if(!hasItem) {
                order.add(Order.createOrder(item, quantity, menu.getItem(item).getPrice() * quantity));
            }
        }
    }

}