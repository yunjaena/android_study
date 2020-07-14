package com.yunjaena.dagger2practice.provider;

import javax.inject.Inject;
import javax.inject.Provider;

public class Counter {
    @Inject
    Provider<Integer> provider;

    public void printProvider(){
        System.out.println("printing...");
        System.out.println(provider.get());
        System.out.println(provider.get());
        System.out.println(provider.get());
    }
}
