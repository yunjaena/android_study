package com.yunjaena.dagger2practice.dependency;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleB {
    @Provides
    Integer provideInteger(){
        return 100;
    }
}
