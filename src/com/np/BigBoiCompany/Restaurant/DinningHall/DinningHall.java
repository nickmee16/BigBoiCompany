package com.np.BigBoiCompany.Restaurant.DinningHall;

import com.np.BigBoiCompany.Restaurant.Menu.Menu;
import com.np.BigBoiCompany.Restaurant.Menu.MenuItemsEnum;

import java.util.ArrayList;

public class DinningHall {

    private int tables;
    private Menu menu;
    private int tablesLimit;
    private double profit;
    private ArrayList<String> tableCounter;
    ArrayList<String> strItems;


    public DinningHall(int tables, Menu menu) {
        this.tables = tables;
        this.menu = menu;
        this.tablesLimit = 25;
        this.profit = 0;
        this.tableCounter = new ArrayList<>();
        this.strItems = new ArrayList<>();
        setTables(tables);
        populateTables();
    }

    public double getProfit() {
        return profit;
    }

    public ArrayList<String> getStrItems() {
        return strItems;
    }

    private void setTables(int tables) {
        if(tables <= 0) {
            this.tables = 1;
        } else if(tables > tablesLimit) {
            this.tables = tablesLimit;
        } else {
            this.tables = tables;
        }
    }

    private void populateTables() {
        for(int i = 0; i < tables; i++) {
            tableCounter.add("free");
        }
    }

    public void availableTables() {
        System.out.println("Available tables - " + tableCounter.size());
    }

    public void takeTable() {
        if(tableCounter.size() == 0) {
            System.out.println("There are no free tables");
        } else {
            System.out.println("Your table is over there");
            tableCounter.remove("free");
        }
    }

    public void freeTable() {
        if(tableCounter.size() == tables) {
            System.out.println("All tables are free");
        } else {
            System.out.println("Comeback again");
            tableCounter.add("free");
        }
    }

    public void printMenu() {
        menu.printMenu();
    }

    public void makeAnOrder(ArrayList<MenuItemsEnum> orderedItems) {
        double orderPrice = 0;
        for (MenuItemsEnum orderedItem: orderedItems) {
            orderPrice = orderPrice + menu.getPriceForItem(orderedItem);
            ordersForKitchen(menu.kitchenOrder(orderedItem));
            menu.getOrderInfo(orderedItem);
        }
        profit += orderPrice;
    }

    private ArrayList<String> ordersForKitchen(String item) {
        strItems.add(item);

        for (int i = 0; i < strItems.size(); i++) {
            if(strItems.get(i).equals("")) {
                strItems.remove(i);
            }
        }

        return strItems;
    }
}
