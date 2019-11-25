package com.gkd;

import com.gkd.calculator.AddCalculator;
import com.gkd.calculator.DivideCalculator;
import com.gkd.calculator.MultiplyCalculator;
import com.gkd.calculator.SubCalculator;

/**
 * @author Weishuo Zhang
 * @date 2019/11/21
 * @description
 */
public class CalculatorFactory {

    /**
     * 如果增加一种计算类型，就得修改此工厂逻辑
     *
     * @param calcType
     * @return
     */
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
