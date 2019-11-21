package com.gkd;

/**
 * @author Weishuo Zhang
 * @date 2019/11/21
 * @description
 */
public class SubCalculatorFactory implements ICalculatorFactory {
    public ICalculator create() {
        return new SubCalculator();
    }
}
