package com.gkd;

import com.gkd.apple.AppleFactory;

public class Test {

    public static void main(String[] args) {
        IProduceFactory factory = new AppleFactory();
        IPhone phone = factory.createPhone();
        phone.produce();

        IComputer computer = factory.createComputer();
        computer.produce();

        // 抽象工厂有点复杂，它有两个维度的概念，产品等级和产品族两个维度的概念，参考readme的图

        // 假如我再想扩展一种产品ipad，就得增加IIpad接口，抽象工厂IProduceFactory就得增加ipad的抽象方法，然后各个实现工厂就都得增加该实现方法，这明显违背了开闭原则。
        // 但是如果我单纯的想增加一种品牌产品，比如三星，只需要增加相关的实现工厂和产品实现类即可，扩展很方便。又符合开闭原则
        // 所以抽象工厂有向开闭原则靠拢的趋势

        /**
         * 优点：
         *  在我看来，包含了工厂方法的优点，扩展产品族很方便，符合开闭原则
         *
         *  缺点：
         *  这还用问么，这么多类，抽象性和复杂性。
         *  修改产品等级困难，违背开闭原则
         *
         */
    }
}
