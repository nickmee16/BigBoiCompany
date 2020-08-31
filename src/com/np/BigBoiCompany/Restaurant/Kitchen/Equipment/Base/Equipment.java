package com.np.BigBoiCompany.Restaurant.Kitchen.Equipment.Base;

public abstract class Equipment {

    private String typeEquip;
    private int numEquip;
    private boolean isClean;

    public Equipment(String typeEquip, int numEquip, boolean isClean) {
        this.typeEquip = typeEquip;
        this.numEquip = numEquip;
        this.isClean = isClean;

        setNumEquip(numEquip);
    }

    private void setNumEquip(int numEquip) {
        if(numEquip < 0) {
            this.numEquip = 0;
        } else {
            this.numEquip = numEquip;
        }
    }

    public String getTypeEquip() {
        return typeEquip;
    }

    public int getNumEquip() {
        return numEquip;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    public abstract void getInfoEquip();
}

