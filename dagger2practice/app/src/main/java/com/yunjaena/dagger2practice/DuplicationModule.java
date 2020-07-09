package com.yunjaena.dagger2practice;

import dagger.Module;
import dagger.Provides;

@Module
public class DuplicationModule {
//    @Provides
//    String provideHelloWorld(){
//        return "Hello World";
//    }

    @Provides
    String provideCharles(){
        return "Charles";
    }
}
