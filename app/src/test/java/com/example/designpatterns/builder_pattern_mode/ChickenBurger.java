package com.example.designpatterns.builder_pattern_mode;

public class ChickenBurger extends Burget {

    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}
