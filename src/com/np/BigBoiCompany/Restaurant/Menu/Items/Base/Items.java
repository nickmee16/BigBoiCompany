package com.np.BigBoiCompany.Restaurant.Menu.Items.Base;

import com.np.BigBoiCompany.Restaurant.Menu.MenuItemsEnum;

public abstract class Items {

    private MenuItemsEnum name;
    private double quantityOfAProduct;
    private double price;
    private boolean isFood;
    private double priceToGet;
    private boolean isItReturnable;


    public Items(MenuItemsEnum name, double quantityOfAProduct, double price, boolean isFood, double priceToGet, boolean isItReturnable) {
        this.name = name;
        this.quantityOfAProduct = quantityOfAProduct;
        this.price = price;
        this.isFood = isFood;
        this.priceToGet = priceToGet;
        this.isItReturnable = isItReturnable;
    }

    public MenuItemsEnum getName() {
        return name;
    }

    public double getQuantityOfAProduct() {
        return quantityOfAProduct;
    }

    public double getPrice() {
        return price;
    }

    public boolean isFood() {
        return isFood;
    }

    public double getPriceToGet() {
        return priceToGet;
    }

    public abstract void getInfoItem();

    public boolean isItReturnable() {
        return isItReturnable;
    }
}
