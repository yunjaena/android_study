package com.yunjaena.dagger2practice.duplicateannotation;

import dagger.Module;
import dagger.Provides;

@Module
public class DuplicationAnnotationModule {
    @Provides
    @Hello
    String provideHello(){
        return "Hello";
    }

    @Provides
    String provideWorld(){
        return "World";
    }
}
