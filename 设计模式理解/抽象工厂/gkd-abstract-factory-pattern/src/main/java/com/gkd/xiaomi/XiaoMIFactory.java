package com.gkd.xiaomi;

import com.gkd.IComputer;
import com.gkd.IPhone;
import com.gkd.IProduceFactory;

public class XiaoMIFactory implements IProduceFactory {
    @Override
    public IPhone createPhone() {
        return new XiaoMIPhone();
    }

    @Override
    public IComputer createComputer() {
        return new XiaoMIComputer();
    }
}
