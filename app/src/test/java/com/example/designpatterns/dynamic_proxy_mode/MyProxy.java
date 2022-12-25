package com.example.designpatterns.dynamic_proxy_mode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @name:DesignPatterns
 * @package:com.example.designpatterns.dynamic_proxy_mode
 * @class: MyProxy
 * @created:2022/12/25 5:51 下午
 * @description:代理类，根据接口等信息动态地创建代理对象，其中 MyProxy 是 InvocationHandler 的实现类，用于绑定方法
 */

public class MyProxy implements InvocationHandler {
    // tar用于接收目标类的参数
    private Object tar;

    // 绑定目标类，根据目标类的类加载器和接口创建代理对象，并返回
    public Object bind(Object target) {
        this.tar = target;
        // 注意：此处代码返回代理类
        return Proxy.newProxyInstance(tar.getClass().getClassLoader(), tar.getClass().getInterfaces(), this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        // 执行一些方法
        System.out.println("Do something before");

        // 目标类的方法执行，这里实际上是执行目标对象的方法，
        // 也就是 bind(Object target)参数 object target 的方法
        result = method.invoke(tar, args);

        System.out.println("Do something after");
        return result;
    }
}
