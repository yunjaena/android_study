package com.yunjaena.dagger2practice.set;

import dagger.Component;

@Component(modules = SetModule.class)
public interface SetComponent {
    void inject(FooSet fooSet);
}
