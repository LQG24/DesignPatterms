package com.example.designpatterns.facade_pattern_mode;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}
