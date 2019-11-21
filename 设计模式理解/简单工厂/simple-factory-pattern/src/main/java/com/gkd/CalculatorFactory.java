package com.gkd;

/**
 * @author Weishuo Zhang
 * @date 2019/11/21
 * @description
 */
public class CalculatorFactory {

    public static ICalculator create(char calcType) {
        ICalculator calculator = null;
        switch (calcType) {
            case '+':
                calculator = new AddCalculator();
                break;
            case '-':
                calculator = new SubCalculator();
                break;
            case '*':
                calculator = new MultiplyCalculator();
                break;
            case '/':
                calculator = new DivideCalculator();
                break;
            default:
                break;
        }
        return calculator;
    }

}
