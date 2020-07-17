package com.yunjaena.dagger2practice.map;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public class MapModule {

    @Provides
    @IntoMap
    @StringKey("foo")
    static Long provideFooValue(){
        return 100L;
    }

    @Provides
    @IntoMap
    @ClassKey(FooMap.class)
    static String provideFooStr(){
        return "Foo String";
    }
}
