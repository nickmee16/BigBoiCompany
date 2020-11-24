package com.np.BigBoiCompany.Restaurant.Menu;

import com.np.BigBoiCompany.Restaurant.Menu.Items.*;
import com.np.BigBoiCompany.Restaurant.Menu.Items.Base.Items;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    private HashMap<MenuItemsEnum, Items> itemsMap;
    private HashMap<MenuItemsEnum, Integer> availableProducts;



    public Menu() {
        this.itemsMap = new HashMap<>();
        this.availableProducts = new HashMap<>();
        populateItemsMap();
        populateAvailableProducts();
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

    private void populateAvailableProducts() {
        availableProducts.put(MenuItemsEnum.SALAD, 8);
        availableProducts.put(MenuItemsEnum.DISH, 4);
        availableProducts.put(MenuItemsEnum.DESERT, 0);
        availableProducts.put(MenuItemsEnum.WATER, 10);
        availableProducts.put(MenuItemsEnum.JUICE, 7);
        availableProducts.put(MenuItemsEnum.NON_ALCOHOLIC, 6);
        availableProducts.put(MenuItemsEnum.ALCOHOL, 5);
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

    public int checkIsItInStock(MenuItemsEnum item) {
        return availableProducts.get(item);
    }

    public void changeTheValueOfAvailable(MenuItemsEnum item, int quantity) {
        availableProducts.put(item, availableProducts.get(item) + quantity);
    }

    public double getPriceOfAProduct(MenuItemsEnum item) {
        return itemsMap.get(item).getPriceToGet();
    }

    public boolean canBeReturned(MenuItemsEnum item) {
        return itemsMap.get(item).isItReturnable();
    }

}
