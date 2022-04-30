package com.example.designpatterns.chain_of_responsibility_pattern_mode

open class Leader(open val name: String, open val couldHandleCount: Int) : Handler {
    var nextHandler: Handler? = null
    override fun handleRequest(dayNum:Int):String? {
        return if(couldHandleCount >= dayNum){
            "${name}同意你的${dayNum}假期"
        }else {
            getNextExecutor()?.handleRequest(dayNum) ?: "${name}拒绝你的${dayNum}假期"
        }
    }

    override fun setNextExecutor(handler: Handler) {
        nextHandler = handler
    }

    override fun getNextExecutor(): Handler? {
        return nextHandler
    }
}