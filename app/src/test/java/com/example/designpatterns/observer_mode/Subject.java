package com.example.designpatterns.observer_mode;

//抽象被观察者（Subject）
public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notify(String message);
}
