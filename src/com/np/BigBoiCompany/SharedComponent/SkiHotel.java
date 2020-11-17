package com.np.BigBoiCompany.SharedComponent;

import com.np.BigBoiCompany.SharedComponent.Base.Hotel;
import com.np.BigBoiCompany.SharedComponent.Base.HotelTypes;

public class SkiHotel extends Hotel {
    public SkiHotel() {
        super(5, 7, HotelTypes.SKI_HOTEL);
    }

    @Override
    public void info() {
        System.out.println("This is a Ski hotel");
    }
}
