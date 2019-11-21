package com.gkd.add;

import com.gkd.ICalculator;
import com.gkd.ICalculatorFactory;

/**
 * @author Weishuo Zhang
 * @date 2019/11/21
 * @description
 */
public class AddCalculatorFactory implements ICalculatorFactory {
    public ICalculator create() {
        return new AddCalculator();
    }
}
