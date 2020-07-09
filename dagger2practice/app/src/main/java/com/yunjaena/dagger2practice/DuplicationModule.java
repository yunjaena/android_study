package com.yunjaena.dagger2practice;

import dagger.Module;
import dagger.Provides;

@Module
public class DuplicationModule {
//    @Provides
//    String provideHelloWorld(){
//        return "Hello World"; // 동일한 타입이 2개 이상 존재하므로 에러
//    }

    @Provides
    String provideCharles(){
        return "Charles";
    }
}
