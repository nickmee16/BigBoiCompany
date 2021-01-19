package com.np.BigBoiCompany.Restaurant.Bar;

import com.np.BigBoiCompany.Restaurant.DinningHall.DinningHall;
import com.np.BigBoiCompany.Restaurant.DinningHall.Order.Order;

import java.util.ArrayList;

public class Bar {

    private final ArrayList<Order> items = new ArrayList<>();

    public void provideItem(Order order) {
        items.add(order);
    }

    public ArrayList<Order> getItems() {
        return items;
    }

    public void liquidsToPrepare() {
        if(items.size() == 0) {
            System.out.println("There is nothing to be cooked");

        } else {
            System.out.println("Things to cook:");

            for (int i = 0; i <items.size(); i++) {
                System.out.println(items.get(i));
            }

            items.clear();
        }
    }
}
