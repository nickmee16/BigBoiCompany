package com.np.BigBoiCompany.Restaurant.Menu;

import com.np.BigBoiCompany.Restaurant.Menu.Items.*;
import com.np.BigBoiCompany.Restaurant.Menu.Items.Base.Items;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {

    private ArrayList<Items> items;
    private HashMap<MenuItemsEnum, Items> itemsMap;


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
        itemsMap.put(MenuItemsEnum.SALAD, new Salad());
        itemsMap.put(MenuItemsEnum.DISH, new Dish());
        itemsMap.put(MenuItemsEnum.DESERT, new Dessert());
        itemsMap.put(MenuItemsEnum.WATER, new Water());
        itemsMap.put(MenuItemsEnum.JUICE, new Juice());
        itemsMap.put(MenuItemsEnum.NON_ALCOHOLIC, new NonAlcoholic());
        itemsMap.put(MenuItemsEnum.ALCOHOL, new Alcoholic());

    }

    public double getPriceForItem(MenuItemsEnum item) {
        return itemsMap.get(item).getPrice();
    }

    public void getOrderInfo(MenuItemsEnum item) {
        itemsMap.get(item).getInfoItem();
    }

    public String kitchenOrder(MenuItemsEnum item) {
        if(itemsMap.get(item).isFood()) {
            return itemsMap.get(item).getName();
        }
        return "";
    }

}
