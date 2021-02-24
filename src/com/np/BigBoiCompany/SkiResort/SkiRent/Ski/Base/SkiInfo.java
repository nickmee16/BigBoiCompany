package com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base;
import com.np.BigBoiCompany.SkiResort.SkiConsts;

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

    public Ski getSki() {
        return ski;
    }

    public void setSki(Ski ski) {
        this.ski = ski;
    }

    public int getCondition() {
        return condition;
    }

    public int getTimesRepaired() {
        return timesRepaired;
    }

    public void wasRepaired() { timesRepaired +=1; }

    public void repair() {
        condition = SkiConsts.MAX_DURABILITY - timesRepaired * SkiConsts.DURABILITY_LOSS_ON_REPAIR;
    }

    public void damage(int inputDamage) { condition -= inputDamage; }
}
