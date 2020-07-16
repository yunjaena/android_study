package com.yunjaena.dagger2practice.bindsoptionalof;

import dagger.Component;

@Component(modules = CommonModule.class)
public interface NoStrComponent {
    void inject(Foo foo);
}
