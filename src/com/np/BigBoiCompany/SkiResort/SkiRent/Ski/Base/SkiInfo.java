package com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base;

import com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base.Ski;

public class SkiInfo {

    private int id;
    private Ski ski;
    private int condition;

    public SkiInfo(int id, Ski ski, int condition) {
        this.id = id;
        this.ski = ski;
        this.condition = condition;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSki(Ski ski) {
        this.ski = ski;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }
}
