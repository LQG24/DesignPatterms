package com.example.designpatterns.strategy_pattern_mode;

import org.junit.Test;

/**
 * 在策略模式（Strategy Pattern）中，一个类的行为或其算法可以在运行时更改。这种类型的设计模式属于行为型模式。
 *
 * 在策略模式中，我们创建表示各种策略的对象和一个行为随着策略对象改变而改变的 context 对象。策略对象改变 context 对象的执行算法。
 *
 *
 * 应用实例： 1、诸葛亮的锦囊妙计，每一个锦囊就是一个策略。
 * 2、旅行的出游方式，选择骑自行车、坐汽车，每一种旅行方式都是一个策略。
 * 3、JAVA AWT 中的 LayoutManager。
 *
 * 优点： 1、算法可以自由切换。 2、避免使用多重条件判断。 3、扩展性良好。
 *
 * 缺点： 1、策略类会增多。 2、所有策略类都需要对外暴露。
 *
 * 使用场景：
 * 1、如果在一个系统里面有许多类，它们之间的区别仅在于它们的行为，那么使用策略模式可以动态地让一个对象在许多行为中选择一种行为。
 * 2、一个系统需要动态地在几种算法中选择一种。 3、如果一个对象有很多的行为，如果不用恰当的模式，这些行为就只好使用多重的条件选择语句来实现。
 *
* */
public class StrategyPatternDemo {
    @Test
    public  void main() {
//        String operate = "";
//        if(operate.equals("+")){
//
//        }else if(operate.equals("-")){
//
//        }else if(operate.equals("*")){
//
//        }


        Context context = new Context("+");
        System.out.println("10+5=" + context.executeStrategy(10, 5));

        context = new Context("-");
        System.out.println("10-5=" + context.executeStrategy(10, 5));


        context = new Context("*");
        System.out.println("10*5=" + context.executeStrategy(10, 5));
    }
}
