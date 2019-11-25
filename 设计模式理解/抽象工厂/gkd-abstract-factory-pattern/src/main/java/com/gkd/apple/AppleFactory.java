package com.gkd.apple;

import com.gkd.IComputer;
import com.gkd.IPhone;
import com.gkd.IProduceFactory;

public class AppleFactory implements IProduceFactory {
    @Override
    public IPhone createPhone() {
        return new ApplePhone();
    }

    @Override
    public IComputer createComputer() {
        return new AppleComputer();
    }
}
