package com.example.designpatterns.builder_pattern_mode;
//用瓶子包装
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
