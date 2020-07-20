package com.yunjaena.dagger2practice.dependency;

import dagger.Component;

@Component(
        modules = ModuleB.class,
        dependencies = ComponentA.class
)
public interface ComponentB {
    void inject(Foo foo);
}
