package com.example.designpatterns.builder_pattern_mode;
//纸类包装
public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "Wrapper";
    }
}
