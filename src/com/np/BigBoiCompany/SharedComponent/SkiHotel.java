package com.np.BigBoiCompany.SharedComponent;

import com.np.BigBoiCompany.SharedComponent.Base.Hotel;

public class SkiHotel extends Hotel {
    public SkiHotel() {
        super(5, 7);
    }

    @Override
    public void info() {
        System.out.println("This is a Ski hotel");
    }
}
