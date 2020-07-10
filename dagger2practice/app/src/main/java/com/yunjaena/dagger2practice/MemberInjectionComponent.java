package com.yunjaena.dagger2practice;

import dagger.Component;
import dagger.MembersInjector;

@Component(modules = MyModule.class)
public interface MemberInjectionComponent {
    void inject(MyClass myClass);

    MembersInjector<MyClass> getInjector();
}
