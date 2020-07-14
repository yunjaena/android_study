package com.yunjaena.dagger2practice.singleton;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = SingletonModule.class)
public interface SingletonComponent {
    Object getObject();
}
