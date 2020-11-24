package com.np.BigBoiCompany.Restaurant.DinningHall.Order;

import com.np.BigBoiCompany.Restaurant.Menu.MenuItemsEnum;

public class Order {

    private MenuItemsEnum item;
    private int quantity;
    private double money;

    public Order(MenuItemsEnum item, int quantity, double money) {
        this.item = item;
        this.quantity = quantity;
        this.money = money;
    }

    public MenuItemsEnum getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getMoney() {
        return money;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public static Order createOrder(MenuItemsEnum item, int quantity, double money) {
        return new Order(item, quantity, money);
    }
}