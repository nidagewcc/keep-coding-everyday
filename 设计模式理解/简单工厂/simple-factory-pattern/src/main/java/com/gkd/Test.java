package com.gkd;

/**
 * @author Weishuo Zhang
 * @date 2019/11/21
 * @description
 */
public class Test {

    public static void main(String[] args) {
        ICalculator calculator1 = CalculatorFactory.create('+');
        System.out.println(calculator1.calculate(1d, 2d));

        ICalculator calculator2 = CalculatorFactory.create('-');
        System.out.println(calculator2.calculate(1d, 2d));


        ICalculator calculator3 = CalculatorFactory.create('*');
        System.out.println(calculator3.calculate(1d, 2d));

        ICalculator calculator4 = CalculatorFactory.create('/');
        System.out.println(calculator4.calculate(1d, 2d));
    }
}
