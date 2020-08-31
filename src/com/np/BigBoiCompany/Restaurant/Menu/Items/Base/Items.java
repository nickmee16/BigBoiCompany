package com.np.BigBoiCompany.Restaurant.Menu.Items.Base;

public abstract class Items {

    protected String name;
    protected double quantity;
    protected double price;
    protected boolean isFood;

    public Items(String name, double quantity, double price, boolean isFood) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.isFood = isFood;
    }

    public String getName() {
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
