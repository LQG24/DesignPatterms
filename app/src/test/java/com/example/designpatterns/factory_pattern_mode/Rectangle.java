package com.example.designpatterns.factory_pattern_mode;


//创建实现接口的实体类。
public class Rectangle implements Shape {
    
    @Override
    public void draw() {
        System.out.println("Retangle::draw() method");
    }
}
