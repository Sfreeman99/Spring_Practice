package com.example.hello;

import java.util.HashMap;

public class Item {
    public String name;
    public double moneyGiven;
    public double charged;

    public Item() {}

    public Item(String name, double moneyGiven, double charged){
        this.name = name;
        this.moneyGiven = moneyGiven;
        this.charged = charged;
    }
}
