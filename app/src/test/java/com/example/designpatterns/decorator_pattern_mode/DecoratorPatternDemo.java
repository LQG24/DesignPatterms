package com.example.designpatterns.decorator_pattern_mode;

import org.junit.Test;
/**
 * 装饰器模式：
 * https://www.runoob.com/design-pattern/decorator-pattern.html
 *
 * 意图：动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相比生成子类更为灵活。
 *
 * 主要解决：一般的，我们为了扩展一个类经常使用继承方式实现，由于继承为类引入静态特征，并且随着扩展功能的增多，子类会很膨胀
 *
 * 应用实例： 1、孙悟空有 72 变，当他变成"庙宇"后，他的根本还是一只猴子，但是他又有了庙宇的功能。 2、不论一幅画有没有画框都可以挂在墙上，但是通常都是有画框的，并且实际上是画框被挂在墙上。
 * 在挂在墙上之前，画可以被蒙上玻璃，装到框子里；这时画、玻璃和画框形成了一个物体。
 *
 *
 * 优点：装饰类和被装饰类可以独立发展，不会相互耦合，装饰模式是继承的一个替代模式，装饰模式可以动态扩展一个实现类的功能。
 *
 * 缺点：多层装饰比较复杂。
 *
 * 使用场景： 1、扩展一个类的功能。 2、动态增加功能，动态撤销。
 *
 * 注意事项：可代替继承。
* */
public class DecoratorPatternDemo {
    @Test
    public  void main(){
        Shape circle = new Circle();
        Rectangle rectangle = new Rectangle();

        ShapeDecorator redCircle = new RedShapeDecorator(circle);
        ShapeDecorator redRectangle = new RedShapeDecorator(rectangle);

        System.out.println("normal border#######");
        circle.draw();
        rectangle.draw();

        System.out.println("\n Circle of red border");
        redCircle.draw();

        System.out.println("\n Rectangle of red border");
        redRectangle.draw();

    }
}
