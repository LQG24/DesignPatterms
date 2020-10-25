package com.example.designpatterns.builder_pattern_mode;

public class VegBurger extends Burget {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
