package com.yunjaena.dagger2practice.basic;

import javax.inject.Inject;

public class MyClass {
    @Inject
    String str;

    public String getStr(){
        return str;
    }
}
