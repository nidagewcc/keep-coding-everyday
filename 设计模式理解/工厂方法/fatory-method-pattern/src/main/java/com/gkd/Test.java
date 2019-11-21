package com.gkd;

/**
 * @author Weishuo Zhang
 * @date 2019/11/21
 * @description
 */
public class Test {

    public static void main(String[] args) {
        ICalculatorFactory factory1 = new AddCalculatorFactory();
        ICalculator calculator1 = factory1.create();
        System.out.println(calculator1.calculate(1d, 2d));

        ICalculatorFactory factory2 = new SubCalculatorFactory();
        ICalculator calculator2 = factory2.create();
        System.out.println(calculator2.calculate(1d, 2d));

        ICalculatorFactory factory3 = new MultiplyCalculatorFactory();
        ICalculator calculator3 = factory3.create();
        System.out.println(calculator3.calculate(1d, 2d));

        ICalculatorFactory factory4 = new DivideCalculatorFactory();
        ICalculator calculator4 = factory4.create();
        System.out.println(calculator4.calculate(1d, 2d));
    }
}
