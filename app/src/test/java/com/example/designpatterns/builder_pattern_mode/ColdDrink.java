package com.example.designpatterns.builder_pattern_mode;

public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }
}
