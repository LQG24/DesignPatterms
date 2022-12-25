package com.example.designpatterns.dynamic_proxy_mode;

/**
 * @name:DesignPatterns
 * @package:com.example.designpatterns.dynamic_proxy_mode
 * @class: RealTeacher
 * @created:2022/12/25 5:50 下午
 * @description:
 */

public class RealTeacher implements Teacher{
    @Override
    public void teach() {
        // 老师正在教书
        System.out.println("I am a teacher, I am teaching!");
    }
}
