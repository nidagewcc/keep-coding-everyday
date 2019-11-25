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

        // 如果想加一种运算，就得新增一个ICalculator实现，并且修改factory类逻辑
        // 虽然对扩展开放了，但同时也对修改开放了，违反了开闭原则（对扩展开放，对修改关闭）

        /**
         * 优点：
         * 1. 实现了对象的创建和使用的分离
         * 2. 客户端无需知道创建产品的类名，只需要传对应的参数即可
         * 3. 新增产品类型时，所有客户端代码无需修改，只需要添加新产品的实现，以及修改工厂类逻辑，提高了系统灵活性
         *
         *
         * 缺点：
         * 1. 工厂类职责过重，工厂类有问题整个系统就会出问题
         * 2. 违反了开闭原则
         * 3. 简单工厂中的静态方法，使得工厂角色无法形成基于继承的等级结构
         *
         */

    }
}
