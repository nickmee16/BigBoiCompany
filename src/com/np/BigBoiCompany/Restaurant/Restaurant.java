package com.np.BigBoiCompany.Restaurant;

import com.np.BigBoiCompany.IProfitable;
import com.np.BigBoiCompany.Restaurant.DinningHall.DinningHall;
import com.np.BigBoiCompany.Restaurant.Kitchen.Kitchen;
import com.np.BigBoiCompany.Restaurant.Menu.Menu;
import com.np.BigBoiCompany.Restaurant.Menu.MenuItemsEnum;
import com.np.BigBoiCompany.Utility;

import java.util.ArrayList;

public class Restaurant implements IProfitable {

    private String name;
    private DinningHall hall;
    private Menu menu;
    private Kitchen kitchen;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new Menu();
        this.hall = new DinningHall(42, menu);
        this.kitchen = new Kitchen(hall);
    }

    @Override
    public double getProfit() {
        return hall.getProfit();
    }

    public void checkProfit() {
        System.out.println("The profit of Ski Resort " + name + " is " + Utility.formatNumber(hall.getProfit()) + "$");
        System.out.println();
    }

    public void availableTables() {
        hall.availableTables();
    }

    public void freeTable() {
        hall.takeTable();
    }

    public void printMenu() {
        hall.printMenu();
    }

    public void makeAnOrder(ArrayList<MenuItemsEnum> orderedItems) {
        hall.makeAnOrder(orderedItems);
    }

    public void checkIfKitchenIsClean() {
        kitchen.checkIsClean();
    }

    public void cleanKitchenEquipment() {
        kitchen.cleanEquip();
    }

    public void thingsToBeCooked() {
        kitchen.thingsToCook();
    }
}
