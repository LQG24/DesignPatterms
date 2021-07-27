package com.example.designpatterns.observer_mode;

import androidx.annotation.NonNull;

/**
 * 具体观察者（ConcrereObserver）
* */
public class GirlFriend implements Observer {
    private String mGirlName;

    public GirlFriend(String girlName) {
        this.mGirlName = girlName;
    }
    
    public void changeName(String girlName){
        this.mGirlName = girlName;
    }

    @Override
    public void update(String message) {
        System.out.println(this.mGirlName + "receive message:" + message);
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "mGirlName='" + mGirlName + '\'' +
                '}';
    }
}
