package com.example.designpatterns.builder_pattern_mode;

public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Code";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
