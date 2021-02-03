package com.np.BigBoiCompany.SkiResort.SkiRent.Slopes;

import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base.Slope;
import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base.SlopeType;

public class H2 extends Slope {
    public H2() {
        super(SlopeType.HARD_2, "E2", SlopeType.HARD_2.getPrice(), SlopeType.HARD_2.getDmg());
    }
}
