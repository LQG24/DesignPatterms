package com.example.designpatterns.facade_pattern_mode;

import org.junit.Test;
/**
 * 外观模式
 * 外观模式（Facade Pattern）隐藏系统的复杂性，并向客户端提供了一个客户端可以访问系统的接口。这种类型的设计模式属于结构型模式，它向现有的系统添加一个接口，来隐藏系统的复杂性。
 *
 *意图：为子系统中的一组接口提供一个一致的界面，外观模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
 * 主要解决：降低访问复杂系统的内部子系统时的复杂度，简化客户端与之的接口。
 *
 * 何时使用： 1、客户端不需要知道系统内部的复杂联系，整个系统只需提供一个"接待员"即可。 2、定义系统的入口。
 * 如何解决：客户端不与系统耦合，外观类与系统耦合。
 *
 * 优点： 1、减少系统相互依赖。 2、提高灵活性。 3、提高了安全性。
 *
 * 缺点：不符合开闭原则，如果要改东西很麻烦，继承重写都不合适。
 *
 * */
public class FacadePatternDemo {
    @Test
    public void test(){
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
