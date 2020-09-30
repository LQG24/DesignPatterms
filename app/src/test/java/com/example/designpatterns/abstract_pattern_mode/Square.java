package com.example.designpatterns.abstract_pattern_mode;

//创建实现接口的实体类。
public class Square implements Shape {
    
    @Override
    public void draw() {
        System.out.println("Square::draw() method");
    }
}
