package com.example.designpatterns.observer_mode;

import org.junit.Test;

public class ObserverModeTest {
    @Test
    public void test() {
        WeixiaoBao weixiaoBao = new WeixiaoBao();

        GirlFriend girlFriend1 = new GirlFriend("双儿");
        GirlFriend girlFriend2 = new GirlFriend("建宁");
        GirlFriend girlFriend3 = new GirlFriend("阿珂");

        weixiaoBao.attach(girlFriend1);
        weixiaoBao.attach(girlFriend2);
        weixiaoBao.attach(girlFriend3);

        weixiaoBao.notify("小宝在线撩妹了，速速围观！！！");

        weixiaoBao.detach(girlFriend3);
        weixiaoBao.notify("小包下次不敢了！！！");
    }
}
