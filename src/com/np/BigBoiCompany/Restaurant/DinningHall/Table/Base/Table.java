package com.np.BigBoiCompany.Restaurant.DinningHall.Table.Base;

public class Table {

    private int peopleToSit;
    private TableTypes type;

    public Table(int peopleToSit, TableTypes type) {
        this.peopleToSit = peopleToSit;
        this.type = type;
    }

    public int getPeopleToSit() {
        return peopleToSit;
    }
}
