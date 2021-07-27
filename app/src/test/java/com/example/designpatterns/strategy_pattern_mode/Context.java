package com.example.designpatterns.strategy_pattern_mode;

import java.util.HashMap;

public class Context {
    private String operate;
    private static HashMap<String,Strategy> sHashMap = new HashMap<>();
    static {
        sHashMap.put("*", new OperationMultiply());
        sHashMap.put("+",new OperationAdd());
        sHashMap.put("-",new OperationSubstract());
    }

    public Context(String operate) {
        this.operate = operate;
    }


    public int executeStrategy(int num1, int num2) {
        Strategy strategy;
        strategy = sHashMap.get(operate);
        return strategy.doOperation(num1, num2);
    }
}
