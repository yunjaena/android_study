package com.yunjaena.dagger2practice.singleton;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SingletonModule {
    @Provides
    @Singleton
    Object provideObject() {
        return new Object();
    }
}
