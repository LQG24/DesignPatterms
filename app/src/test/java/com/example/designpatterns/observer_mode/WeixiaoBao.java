package com.example.designpatterns.observer_mode;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体被观察者(ConcreteSubject)
* */
public class WeixiaoBao implements Subject{
    private List<Observer> observerList = new ArrayList<>();
    /**
     *  增加订阅者
    * */
    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    /**
     * 删除订阅者
    * */
    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    /**
     *  通知订阅者更新消息
    * */
    @Override
    public void notify(String message) {
        for (Observer o:observerList) {
            o.update(message);
        }
    }
}
