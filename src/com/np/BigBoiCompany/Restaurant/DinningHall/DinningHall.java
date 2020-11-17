package com.np.BigBoiCompany.Restaurant.DinningHall;

import com.np.BigBoiCompany.Restaurant.Menu.Menu;
import com.np.BigBoiCompany.Restaurant.Menu.MenuItemsEnum;

import java.util.ArrayList;

public class DinningHall {

    private int tables;
    private final Menu menu;
    private int tablesLimit = 25;
    private double profit = 0;
    private final ArrayList<String> tableCounter = new ArrayList<>();
    private final ArrayList<MenuItemsEnum> itemsForKitchen = new ArrayList<>();
    private final ArrayList<MenuItemsEnum> itemsForBar = new ArrayList<>();


    public DinningHall(int tables, Menu menu) {
        this.tables = tables;
        this.menu = menu;
        setTables(tables);
        populateTables();
    }

    public double getProfit() {
        return profit;
    }

    public ArrayList<MenuItemsEnum> getItemsForKitchen() {
        return itemsForKitchen;
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

    public void orderItem(MenuItemsEnum item) {
        profit += menu.getItem(item).getPrice();

        if(menu.getItem(item).isFood()) {
            itemsForKitchen.add(item);
        } else {
            itemsForBar.add(item);
        }
    }

}
