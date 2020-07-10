package com.yunjaena.dagger2practice.inheritance;

import javax.inject.Inject;

public class Parent {
    @Inject
    A a;

    public A getA() {
        return a;
    }
}
