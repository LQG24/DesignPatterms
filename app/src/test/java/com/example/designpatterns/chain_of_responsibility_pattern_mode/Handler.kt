package com.example.designpatterns.chain_of_responsibility_pattern_mode

interface Handler {
    /**
     * 处理请求
     */
    fun handleRequest(dayNum: Int): String?

    /**
     *设置下一个执行者
     */
    fun setNextExecutor(handler: Handler)

    /**
     * 获取下一个执行者
     */
    fun getNextExecutor(): Handler?
}