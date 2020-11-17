package com.np.BigBoiCompany.SkiResort.SkiRent.Ski.Base;

public enum SkiSizeTypes {
    NONE(0),
    VERY_SMALL(150),
    SMALL(160),
    MEDIUM(170),
    LONG(180),
    VERY_LONG(190);

    private final int id;
    SkiSizeTypes(int id) {
        this.id = id;
    }
    public int getValue() {
        return id;
    }

}
