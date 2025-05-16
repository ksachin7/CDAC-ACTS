package com.cdac.acts.day9.calc;

public class IntegerCalculator extends Calculator {

    @Override
    public Integer add(Number a, Number b) {
        return a.intValue() + b.intValue();
    }
}
