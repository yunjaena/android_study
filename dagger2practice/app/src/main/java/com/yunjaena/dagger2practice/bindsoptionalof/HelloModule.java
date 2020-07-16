package com.yunjaena.dagger2practice.bindsoptionalof;

import dagger.Module;
import dagger.Provides;

@Module
public class HelloModule {
    @Provides
    String provideString(){
        return "Hello";
    }
}
