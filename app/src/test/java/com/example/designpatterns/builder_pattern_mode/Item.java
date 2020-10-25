package com.example.designpatterns.builder_pattern_mode;

//创建一个表示食物条目和食物包装的接口。
public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
