package com.np.BigBoiCompany.SkiResort.SkiRent.Slopes;

import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base.Slope;
import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base.SlopeType;

public class E2 extends Slope {
    public E2() {
        super(SlopeType.EASY_2, "E2", SlopeType.EASY_2.getPrice(), SlopeType.EASY_2.getDmg());
    }
}
