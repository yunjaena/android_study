package com.yunjaena.dagger2practice;

import javax.inject.Inject;

public class MyClass {
    @Inject
    String str;

    public String getStr(){
        return str;
    }
}
