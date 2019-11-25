package com.gkd.huawei;

import com.gkd.IComputer;

public class HuaweiComputer implements IComputer {
    @Override
    public void produce() {
        System.out.println("produce huawei computer");
    }
}
