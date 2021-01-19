package com.np.BigBoiCompany.Restaurant;

import com.np.BigBoiCompany.IProfitable;
import com.np.BigBoiCompany.Restaurant.Bar.Bar;
import com.np.BigBoiCompany.Restaurant.DinningHall.DinningHall;
import com.np.BigBoiCompany.Restaurant.Kitchen.Kitchen;
import com.np.BigBoiCompany.Restaurant.Menu.Menu;
import com.np.BigBoiCompany.Restaurant.Menu.MenuItemsEnum;
import com.np.BigBoiCompany.Utility;


public class Restaurant implements IProfitable {
    private Bar bar;
    private String name;
    private DinningHall hall;
    private Menu menu;
    private Kitchen kitchen;
    private double availableMoney;
    private double loses;

    public Restaurant(String name, double availableMoney) {
        this.bar = new Bar();
        this.name = name;
        this.availableMoney = availableMoney;
        this.loses = 0;
        this.menu = new Menu();
        this.hall = new DinningHall(42, this.menu, this.bar);
        this.kitchen = new Kitchen(hall);
    }

    @Override
    public double getProfit() {
        return hall.getProfit() - loses;
    }

    public void checkProfit() {
        System.out.println("The profit of Restaurant " + name + " is " + Utility.formatNumber(hall.getProfit() - loses) + "$");
    }

    public void availableTables() {
        hall.availableTables();
    }

    public void takeTable(int table) {
        hall.takeTable(table);
    }

    public void freeTable(int table) {
        hall.freeTable(table);
    }

    public void printMenu() {
        hall.printMenu();
    }

    public void makeAnOrder(int table, MenuItemsEnum item, int quantity) {
        hall.orderItem(table, item, quantity);
    }

    public void returnOrder(int table, MenuItemsEnum item, int quantity) {
        hall.returnOrder(table, item, quantity);
    }

    public void checkBill(int table) {
        hall.checkBill(table);
    }

    public void checkQuantityOfAProduct(MenuItemsEnum item) {
        System.out.println(item + ": " + menu.checkIsItInStock(item));
    }

    public void orderProducts(MenuItemsEnum item, int quantity) {
        if(quantity <= 0) {
            System.out.println("Wrong quantity");

        } else if(menu.getPriceOfAProduct(item) * quantity > availableMoney + hall.getProfit()) {
            System.out.println("Not enough money!" + "\n"
            + "Available: " + Utility.formatNumber(availableMoney + hall.getProfit()) + "$" + "\n"
            + "Required: " + Utility.formatNumber(menu.getPriceOfAProduct(item) * quantity) + "$");

        } else {
            loses = menu.getPriceOfAProduct(item) * quantity;
            availableMoney = hall.getProfit() + availableMoney - menu.getPriceOfAProduct(item) * quantity;
            menu.changeTheValueOfAvailable(item, quantity);
            System.out.println("Product ordered: " + item + " * " + quantity + ". Price: " + Utility.formatNumber(menu.getPriceOfAProduct(item) * quantity) + "$");
        }
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
