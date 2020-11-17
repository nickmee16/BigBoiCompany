package com.np.BigBoiCompany.Restaurant.Menu;

import com.np.BigBoiCompany.Restaurant.Menu.Items.*;
import com.np.BigBoiCompany.Restaurant.Menu.Items.Base.Items;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    private HashMap<MenuItemsEnum, Items> itemsMap;


    public Menu() {
        this.itemsMap = new HashMap<>();
        populateItemsMap();
    }

    public void printMenu() {
        System.out.println("---------------------------------");
        for (Map.Entry<MenuItemsEnum, Items> item : itemsMap.entrySet()) {
            item.getValue().getInfoItem();
            System.out.println();
        }
        System.out.println("---------------------------------");
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

    public Items getItem(MenuItemsEnum item) {
        return itemsMap.get(item);
    }

    public double getPriceForItem(MenuItemsEnum item) {
        return itemsMap.get(item).getPrice();
    }

    public void getOrderInfo(MenuItemsEnum item) {
        itemsMap.get(item).getInfoItem();
    }

}
