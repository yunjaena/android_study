package com.yunjaena.dagger2practice.basic;

import dagger.Module;
import dagger.Provides;

@Module
public class MyModule {
    @Provides
    String provideHelloWorld(){
        return "Hello World";
    }
}
