package com.gkd.apple;

import com.gkd.IComputer;

public class AppleComputer implements IComputer {
    @Override
    public void produce() {
        System.out.println("produce apple computer");
    }
}
