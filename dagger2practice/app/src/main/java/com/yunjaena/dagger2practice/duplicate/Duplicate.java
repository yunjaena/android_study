package com.yunjaena.dagger2practice.duplicate;

import javax.inject.Inject;
import javax.inject.Named;

public class Duplicate {
    @Inject
    @Named("hello")
    String strHello;

    @Inject
    @Named("world")
    String strWorld;

    public String getStrHello() {
        return strHello;
    }

    public String getStrWorld() {
        return strWorld;
    }
}
