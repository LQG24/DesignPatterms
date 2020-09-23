package com.example.designpatterns.singleton_mode;

//枚举单例
/**
 * 枚举单例是线程安全的，并且在任何情况下它都是一个单例,即使反序列化它也不会重新生成新的实例
 *
 * 因为前面其他单例可以被反序列化生成新的对象，可以通过下面方式杜绝反序列化生成新的对象
 * private Object readResolve() throws ObjectStreamException{
 *     return sInstance;
 * }
 *
* */
public enum  SingletonEnum {
    INSTANCE;
    public void doSomething(){
        System.out.println("do sth.");
    }
}
