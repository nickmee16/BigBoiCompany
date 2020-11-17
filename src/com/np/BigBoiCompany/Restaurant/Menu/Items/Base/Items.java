package com.np.BigBoiCompany.Restaurant.Menu.Items.Base;

import com.np.BigBoiCompany.Restaurant.Menu.MenuItemsEnum;

public abstract class Items {

    protected MenuItemsEnum name;
    protected double quantity;
    protected double price;
    protected boolean isFood;

    public Items(MenuItemsEnum name, double quantity, double price, boolean isFood) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.isFood = isFood;
    }

    public MenuItemsEnum getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isFood() {
        return isFood;
    }

    public abstract void getInfoItem();
}
