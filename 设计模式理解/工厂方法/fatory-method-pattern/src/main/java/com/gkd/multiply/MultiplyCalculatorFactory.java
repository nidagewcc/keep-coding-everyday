package com.gkd.multiply;

import com.gkd.ICalculator;
import com.gkd.ICalculatorFactory;

/**
 * @author Weishuo Zhang
 * @date 2019/11/21
 * @description
 */
public class MultiplyCalculatorFactory implements ICalculatorFactory {
    public ICalculator create() {
        return new MultiplyCalculator();
    }
}
