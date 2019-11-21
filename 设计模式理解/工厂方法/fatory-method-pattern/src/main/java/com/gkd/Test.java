package com.gkd;

import com.gkd.add.AddCalculatorFactory;
import com.gkd.divide.DivideCalculatorFactory;
import com.gkd.multiply.MultiplyCalculatorFactory;
import com.gkd.sub.SubCalculatorFactory;

/**
 * @author Weishuo Zhang
 * @date 2019/11/21
 * @description
 */
public class Test {

    /**
     * 这样如果要加一种新的计算类型的话，需要新增对应的计算实现和工厂
     * 并且分别实现ICalculator、ICalculatorFactory两个接口，达到了专人干专事儿的目的
     * 不用像简单工厂那样，需要在统一的工厂中添加判断应该创建哪个实例的逻辑，只需要修改自己的实现类的逻辑就ok
     * <p>
     * 扩展业务功能方便，但是对修改关闭，由于顶层接口ICalculator中的接口方法制约，如果要修改，会导致其他类型的计算报错
     * 此为 开闭原则
     *
     * @param args
     */
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
