package com.np;

import com.np.BigBoiCompany.BigBoiCompany;
import com.np.BigBoiCompany.SharedComponent.Base.HotelTypes;

public class Main {

    public static void main(String[] args) {


        BigBoiCompany bigBoiCompany = new BigBoiCompany();
        bigBoiCompany.companyProfit();
        bigBoiCompany.showAvailableHotels();
        bigBoiCompany.showAvailableApartments(HotelTypes.SKI_HOTEL);
        bigBoiCompany.rentApartment(HotelTypes.SKI_HOTEL, 12, 8);
        bigBoiCompany.rentApartment(HotelTypes.SKI_HOTEL, 3, 8);
        bigBoiCompany.rentApartment(HotelTypes.SKI_HOTEL, 4, 8);
        bigBoiCompany.showAvailableApartments(HotelTypes.SKI_HOTEL);
        bigBoiCompany.companyProfit();


    }
}
