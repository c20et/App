package com.dev.ehb.stockmarket20;

import android.app.Application;

/**
 * Created by eeshant on 5/30/16.
 */
public class MyAppApplication extends Application {
    private double money = 10000;

    public double getMoney() {
        return money;
    }

    public void setMoney(double d) {
        money = d;
    }
}
