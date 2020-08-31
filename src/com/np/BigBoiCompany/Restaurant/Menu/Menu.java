package com.np.BigBoiCompany.Restaurant.Menu;

import com.np.BigBoiCompany.Restaurant.Menu.Items.*;
import com.np.BigBoiCompany.Restaurant.Menu.Items.Base.Items;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {

    private ArrayList<Items> items;
    private HashMap<Integer, Items> itemsMap;


    public Menu() {
        this.items = new ArrayList<>();
        this.itemsMap = new HashMap<>();
        populateItemsMap();
    }

    public void printMenu() {
        for (Integer i = 1; i <= itemsMap.size(); i++) {
            System.out.print(i + " ");
            itemsMap.get(i).getInfoItem();
        }
    }

    private void populateItemsMap() {
        itemsMap.put(1, new Salad());
        itemsMap.put(2, new Dish());
        itemsMap.put(3, new Dessert());
        itemsMap.put(4, new Water());
        itemsMap.put(5, new Juice());
        itemsMap.put(6, new NonAlcoholic());
        itemsMap.put(7, new Alcoholic());

    }

    public double getPriceForItem(Integer items) {
        return itemsMap.get(items).getPrice();
    }

    public void getOrderInfo(Integer items) {
        itemsMap.get(items).getInfoItem();
    }

    public String kitchenOrder(Integer items) {
        if(itemsMap.get(items).isFood()) {
            return itemsMap.get(items).getName();
        }
        return "";
    }

}
