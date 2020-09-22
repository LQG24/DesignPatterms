package com.example.designpatterns.observer_mode;

public class GirlFriend implements Observer {
    private String mGirlName;

    public GirlFriend(String girlName) {
        this.mGirlName = girlName;
    }

    @Override
    public void update(String message) {
        System.out.println(this.mGirlName + "receive message:" + message);
    }
}
