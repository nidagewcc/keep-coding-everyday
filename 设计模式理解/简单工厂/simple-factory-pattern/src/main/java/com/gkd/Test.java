package com.gkd;

/**
 * @author Weishuo Zhang
 * @date 2019/11/21
 * @description
 */
public class Test {

    public static void main(String[] args) {
        ICalculator calculator = CalculatorFactory.create('+');
        System.out.println(calculator.calculate(1d, 2d));
    }
}
