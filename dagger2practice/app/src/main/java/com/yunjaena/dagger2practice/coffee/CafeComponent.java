package com.yunjaena.dagger2practice.coffee;

import dagger.Component;

@Component(modules = CafeModule.class)
public interface CafeComponent {
    void inject(Cafe cafe);
}
