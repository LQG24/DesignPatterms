package com.example.designpatterns.decorator_pattern_mode;

public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        this.decoratedShape.draw();
    }
}
