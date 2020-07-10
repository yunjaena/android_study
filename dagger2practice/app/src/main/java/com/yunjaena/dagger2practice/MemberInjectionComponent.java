package com.yunjaena.dagger2practice;

import dagger.Component;

@Component(modules =  MyModule.class)
public interface MemberInjectionComponent {
    void inject(MyClass myClass);
}
