package com.np.BigBoiCompany.SharedComponent;

import com.np.BigBoiCompany.SharedComponent.Base.Hotel;
import com.np.BigBoiCompany.SharedComponent.Base.HotelTypes;

public class BeachHotel extends Hotel {
    public BeachHotel() {
        super(1, 5, HotelTypes.BEACH_HOTEL);
    }

    @Override
    public void info() {
        System.out.println("This is a beach hotel");
    }
}
