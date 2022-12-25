package com.example.designpatterns.dynamic_proxy_mode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @name:DesignPatterns
 * @package:com.example.designpatterns.dynamic_proxy_mode
 * @class: Test
 * @created:2022/12/25 5:32 下午
 * @description:
 *
 * https://blog.csdn.net/Justin_bibo/article/details/114888702
 * https://blog.csdn.net/lmj623565791/article/details/79278864
 */

public class Test {

    @org.junit.Test
    public void TestMethod(){

//        IUserService iUserService = (IUserService) Proxy.newProxyInstance(IUserService.class.getClassLoader(), new Class[]{IUserService.class}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("method = " + method.getName() +" , args = " + Arrays.toString(args));
//                return null;
//            }
//        });
//        System.out.println(iUserService.getClass());
//
//        iUserService.login("zhy","123");

        MyProxy myProxy = new MyProxy();
        // 传入目标对象，进行绑定
        Teacher teacher = (Teacher) myProxy.bind(new RealTeacher());
        // 执行代理对象的方法
        teacher.teach();
    }

    public interface IUserService {
        void login(String username, String password);
    }
}
