package com.yunjaena.dagger2practice.inheritance;

import dagger.Component;

@Component(modules =  InheritanceModule.class)
public interface InheritanceComponent {
    void inject(Self self);
}
