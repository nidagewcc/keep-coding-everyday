package com.gkd.sub;

import com.gkd.ICalculator;
import com.gkd.ICalculatorFactory;

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
