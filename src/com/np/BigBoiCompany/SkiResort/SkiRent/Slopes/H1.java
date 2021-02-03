package com.np.BigBoiCompany.SkiResort.SkiRent.Slopes;

import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base.Slope;
import com.np.BigBoiCompany.SkiResort.SkiRent.Slopes.Base.SlopeType;

public class H1 extends Slope {
    public H1() {
        super(SlopeType.HARD_1, "H1", SlopeType.HARD_1.getPrice(), SlopeType.HARD_1.getDmg());
    }
}
