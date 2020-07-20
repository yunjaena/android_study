package com.yunjaena.dagger2practice.dependency;

import dagger.Component;

@Component(modules = ModuleA.class)
public interface ComponentA {
    String provideString();
}
