package com.gkd.huawei;

import com.gkd.IComputer;
import com.gkd.IPhone;
import com.gkd.IProduceFactory;

public class HuaweiFactory implements IProduceFactory {
    @Override
    public IPhone createPhone() {
        return new HuaweiPhone();
    }

    @Override
    public IComputer createComputer() {
        return new HuaweiComputer();
    }
}
