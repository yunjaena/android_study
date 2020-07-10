package com.yunjaena.dagger2practice.inheritance;

import javax.inject.Inject;

public class Self extends Parent {
    @Inject
    B b;

    public B getB() {
        return b;
    }
}
