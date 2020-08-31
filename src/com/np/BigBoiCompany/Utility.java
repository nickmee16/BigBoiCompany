package com.np.BigBoiCompany;

import java.text.DecimalFormat;

public class Utility {
    private static DecimalFormat df = new DecimalFormat("0.00");

    public static String formatNumber(double num) {
        return df.format(num);
    }
}
