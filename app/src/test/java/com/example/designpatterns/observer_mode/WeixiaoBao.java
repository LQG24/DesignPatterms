package com.example.designpatterns.observer_mode;

import java.util.ArrayList;
import java.util.List;

public class WeixiaoBao implements Subject{
    private List<Observer> observerList = new ArrayList<>();
    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer o:observerList) {
            o.update(message);
        }
    }
}
