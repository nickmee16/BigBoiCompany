package com.np.BigBoiCompany;

import java.util.ArrayList;

public class BigBoiCompany {
    private ArrayList<IProfitable> assets = new ArrayList<>();

    public void companyProfit() {
        double profit = 0;

        for (IProfitable asset: assets) {
            profit += asset.getProfit();
        }

        System.out.println("Big Boi Company Profit: " + Utility.formatNumber(profit) + "$");
    }

    public void addAssets(IProfitable asset) {
        assets.add(asset);
    }
}
