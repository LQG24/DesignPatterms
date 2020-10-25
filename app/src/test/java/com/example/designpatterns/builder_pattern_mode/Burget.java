package com.example.designpatterns.builder_pattern_mode;

public abstract class Burget implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }

}
