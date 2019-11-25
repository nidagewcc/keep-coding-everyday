package com.gkd.calculator;

import com.gkd.ICalculator;

/**
 * @author Weishuo Zhang
 * @date 2019/11/21
 * @description
 */
public class SubCalculator implements ICalculator {
    public double calculate(double a, double b) {
        return a - b;
    }
}
