package com.example.designpatterns.abstract_pattern_mode;

import org.junit.Test;
/**
 * https://www.runoob.com/design-pattern/abstract-factory-pattern.html
 *
 * 系统的产品有多于一个的产品族，而系统只消费其中某一族的产品。
 *
 * 优点：当一个产品族中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一个产品族中的对象。
 *
 * 缺点：产品族扩展非常困难，要增加一个系列的某一产品，既要在抽象的 Creator 里加代码，又要在具体的里面加代码。
 *
 * 使用场景： 1、QQ 换皮肤，一整套一起换。 2、生成不同操作系统的程序。
 *
* */
public class AbstractFactoryPatternDemo {
    
    @Test
    public void test() {
        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        //获取形状为 Circle 的对象
        Shape circleShape = shapeFactory.getShape("CIRCLE");
        circleShape.draw();
        
        Shape rectangleShape = shapeFactory.getShape("RECTANGLE");
        rectangleShape.draw();
        
        Shape squareShape = shapeFactory.getShape("SQUARE");
        squareShape.draw();
        
        
        //获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
     
        Color colorRed = colorFactory.getColor("RED");
        colorRed.fill();
    
        //获取颜色为 Green 的对象
        Color colorGreen = colorFactory.getColor("Green");
        colorGreen.fill();
    
        //获取颜色为 Blue 的对象
        Color colorBlue = colorFactory.getColor("BLUE");
        colorBlue.fill();
        
    }
    
}
