package com.yunjaena.dagger2practice.provider;

import dagger.Component;

@Component(modules = CounterModule.class)
public interface CounterComponent {
    void inject(Counter counter);
}
