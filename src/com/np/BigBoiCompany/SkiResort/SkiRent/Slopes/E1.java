package com.np.BigBoiCompany.SkiResort.SkiRent.Slopes;

import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base.Slope;
import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base.SlopeType;

public class E1 extends Slope {
    public E1() {
        super(SlopeType.EASY_1, "E1", SlopeType.EASY_1.getPrice(), SlopeType.EASY_1.getDmg());
    }
}
