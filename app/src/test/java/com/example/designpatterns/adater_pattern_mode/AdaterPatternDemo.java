package com.example.designpatterns.adater_pattern_mode;

import org.junit.Test;

/**
 *
 适配器模式（Adapter Pattern）是作为两个不兼容的接口之间的桥梁。
 这种类型的设计模式属于结构型模式，它结合了两个独立接口的功能。

 优点： 1、可以让任何两个没有关联的类一起运行。 2、提高了类的复用。 3、增加了类的透明度。 4、灵活性好。

 缺点： 1、过多地使用适配器，会让系统非常零乱，不易整体进行把握。
 比如，明明看到调用的是 A 接口，其实内部被适配成了 B 接口的实现，一个系统如果太多出现这种情况，无异于一场灾难。
* */
public class AdaterPatternDemo {
   @Test
    public void test(){
       AudioPlayer audioPlayer = new AudioPlayer();

       audioPlayer.play("mp3", "beyond the horizon.mp3");
       audioPlayer.play("mp4", "alone.mp4");
       audioPlayer.play("vlc", "far far away.vlc");
       audioPlayer.play("avi", "mind me.avi");
    }
}
