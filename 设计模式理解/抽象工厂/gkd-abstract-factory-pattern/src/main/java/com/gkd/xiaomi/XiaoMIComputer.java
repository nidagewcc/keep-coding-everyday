package com.gkd.xiaomi;

import com.gkd.IComputer;

public class XiaoMIComputer implements IComputer {
    @Override
    public void produce() {
        System.out.println("produce xiaomi computer");
    }
}
