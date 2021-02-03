package com.np.BigBoiCompany.SkiResort.SkiRent.Slopes;

import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base.Slope;
import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base.SlopeType;

public class M1 extends Slope {
    public M1() {
        super(SlopeType.MEDIUM_1, "M1", SlopeType.MEDIUM_1.getPrice(), SlopeType.MEDIUM_1.getDmg());
    }
}
