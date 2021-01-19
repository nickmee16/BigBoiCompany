package com.np.BigBoiCompany.Restaurant.Kitchen;

import com.np.BigBoiCompany.Restaurant.DinningHall.DinningHall;
import com.np.BigBoiCompany.Restaurant.Kitchen.Equipment.*;
import com.np.BigBoiCompany.Restaurant.Kitchen.Equipment.Base.Equipment;

import java.util.ArrayList;

public class Kitchen {

    private DinningHall hall;
    private ArrayList<Equipment> equip;
    private ArrayList<Equipment> dirtyEquip;

    public Kitchen(DinningHall hall) {
        this.hall = hall;
        this.equip = new ArrayList<>();
        this.dirtyEquip = new ArrayList<>();
        populateEquipment();
    }

    private void populateEquipment() {
        Equipment fork = new Fork();
        Equipment spoon = new Spoon();
        Equipment knife = new Knife();
        Equipment plate = new Plate();
        Equipment oven = new Oven();

        equip.add(fork);
        equip.add(spoon);
        equip.add(knife);
        equip.add(plate);
        equip.add(oven);
    }

    public void checkIsClean() {
        int count = 0;

        for (int i = 0; i < equip.size(); i++) {
            if(!equip.get(i).isClean()) {
                System.out.println(equip.get(i).getTypeEquip() + " - dirty");
                dirtyEquip.add(equip.get(i));
                equip.get(i).setClean(true);
                count++;
            }
        }

        if(count == 0) {
            System.out.println("Everything is clean");
        }
    }

    public void cleanEquip() {
        for (int i = 0; i < dirtyEquip.size(); i++) {
            dirtyEquip.remove(i);
        }

        System.out.println("The equipment has been cleaned up");
    }

    public void thingsToCook() {
        if(hall.getItemsForKitchen().size() == 0) {
            System.out.println("There is nothing to be cooked");

        } else {
            System.out.println("Things to cook:");

            for (int i = 0; i < hall.getItemsForKitchen().size(); i++) {
                System.out.println(hall.getItemsForKitchen().get(i));
            }

            hall.getItemsForKitchen().clear();
        }
    }
}
