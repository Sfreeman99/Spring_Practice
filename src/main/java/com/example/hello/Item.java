package com.example.hello;

import java.util.HashMap;

public class Item {
    public String name;
    public double moneyGiven;
    public double charged;

    public Item(String productName, double paid, double charging){
        this.name = productName;
        this.moneyGiven = paid;
        this.charged = charging;
    }
}
