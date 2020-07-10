package com.yunjaena.dagger2practice.inheritance;

import javax.inject.Inject;

public class Child extends Self {
    @Inject
    C c;

    public C getC() {
        return c;
    }
}
