package com.np.BigBoiCompany.SkiResort.SkiRent.Slopes;

import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base.Slope;
import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base.SlopeType;

public class M2 extends Slope {
    public M2() {
        super(SlopeType.MEDIUM_2, "M2", SlopeType.MEDIUM_2.getPrice(), SlopeType.MEDIUM_2.getDmg());
    }
}
