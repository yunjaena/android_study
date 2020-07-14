package com.yunjaena.dagger2practice.duplicate;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class DuplicateModule {
    @Provides
    @Named("hello")
    String provideHello() {
        return "Hello";
    }

    @Provides
    @Named("world")
    String provideWorld() {
        return "World";
    }
}
