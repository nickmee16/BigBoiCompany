package com.np.BigBoiCompany.SharedComponent;

import com.np.BigBoiCompany.SharedComponent.Base.Hotel;

public class BeachHotelComponent extends Hotel {
    public BeachHotelComponent() {
        super(1, 5);
    }

    @Override
    public void info() {
        System.out.println("This is a beach hotel");
    }
}
