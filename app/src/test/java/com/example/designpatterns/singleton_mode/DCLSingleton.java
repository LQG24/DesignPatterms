package com.example.designpatterns.singleton_mode;
//DCL 方式实现单例
public class DCLSingleton {

    /**
     * volatile 避免指令重排
     * instance = new DCLSingleton（）
     * 这句代码会被编译成多条汇编指令，它大致做了三件事
     * （1）给instance分配堆内存空间
     * （2）调用 DCLSingleton（）的构造函数，初始化成员变量
     * （3）将instance对象指向分配的内存空间（此时instance就不是null了）
     *
     *
     * java编译器允许处理器乱序执行，以及JDK1.5之前（2）、（3）顺序是无法保证。
     * 所以有可能出现（1）-》（3）—》（2）
     * 此时被synchronized挡在外面的线程是没什么影响的，因为一定要等到对象创建完，首个拿锁者才会释放锁。
     * 关键是如果在（3）完成而（2）没有完成的这个临界点，又一个新的线程调用getInstance（），指向地址已经非空，
     * 那么此时返回的是未完成初始化的instance实例。
     * 那么如果在Singleton里边有个变量int number，有个方法int getNumber返回number，
     * 那么此时调用getInstance().getNumber()变量还未初始化，可能会报错。
    * */
    private static volatile DCLSingleton  instance;

    private DCLSingleton(){

    }

    public static DCLSingleton getInstance(){
        //判断instance 是否为空，如果不为空，则直接返回
        if(instance == null){
            //synchronized 加锁类，确保只有一个线程能够进入
            synchronized (DCLSingleton.class){
                //进入以后第二次非空判断，对首个拿锁的那它的instance肯定为空，
                // 那么进入new instance 创建对象。而在首个拿锁创建对象期间，
                // 可能有其他线程同步调用getInstance，那么会通过第一个if进入代码块，试图拿锁阻塞。
                //当首个拿锁创建对象，之后线程都不会进入第一个 if，而试图拿锁阻塞的线程
                //此时被唤醒，则需要第二个if来避免再次创建对象，所以作用总结就是避免重复创建对象。
                if(instance == null){
                    instance = new DCLSingleton();
                }
            }
        }

        return instance;
    }

}
