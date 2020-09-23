package com.example.designpatterns.singleton_mode;

//静态内部类单例模式
/**
 * 这种方式不仅能够确保线程安全，也能够保证单例对象的唯一性，
 * 同时也延迟了单例的实例化，
 * 所以是推荐使用的单例模式实现化
* */
public class StaticInnerSingleton {
    private StaticInnerSingleton(){

    }

    public static StaticInnerSingleton getInstance(){
      return SingletonHoler.staticInnerSingleton;
    }
    private static class SingletonHoler{
        private static final StaticInnerSingleton staticInnerSingleton = new StaticInnerSingleton();
    }
}
