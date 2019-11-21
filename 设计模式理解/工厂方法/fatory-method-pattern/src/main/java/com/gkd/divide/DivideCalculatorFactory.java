package com.gkd.divide;

import com.gkd.ICalculator;
import com.gkd.ICalculatorFactory;

/**
 * @author Weishuo Zhang
 * @date 2019/11/21
 * @description
 */
public class DivideCalculatorFactory implements ICalculatorFactory {
    public ICalculator create() {
        return new DivideCalculator();
    }
}
