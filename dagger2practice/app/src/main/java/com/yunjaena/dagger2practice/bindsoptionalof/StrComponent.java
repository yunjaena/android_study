package com.yunjaena.dagger2practice.bindsoptionalof;

import dagger.Component;

@Component(modules = {HelloModule.class, CommonModule.class})
public interface StrComponent {
    void inject(Foo foo);
}
