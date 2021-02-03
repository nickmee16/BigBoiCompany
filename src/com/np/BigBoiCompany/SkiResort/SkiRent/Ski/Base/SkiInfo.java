package com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base;

public class SkiInfo {

    private int id;
    private Ski ski;
    private int condition;
    private int timesRepaired;

    public SkiInfo(int id, Ski ski, int condition, int timesRepaired) {
        this.id = id;
        this.ski = ski;
        this.condition = condition;
        this.timesRepaired = timesRepaired;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ski getSki() {
        return ski;
    }

    public void setSki(Ski ski) {
        this.ski = ski;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getTimesRepaired() {
        return timesRepaired;
    }

    public void setTimesRepaired(int timesRepaired) {
        this.timesRepaired = timesRepaired;
    }
}
