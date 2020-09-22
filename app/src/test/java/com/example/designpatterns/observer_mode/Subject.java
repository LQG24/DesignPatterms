package com.example.designpatterns.observer_mode;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notify(String message);
}
