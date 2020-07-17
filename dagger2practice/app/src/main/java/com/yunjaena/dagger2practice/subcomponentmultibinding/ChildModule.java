package com.yunjaena.dagger2practice.subcomponentmultibinding;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;

@Module
public class ChildModule {
    @Provides
    @IntoSet
    String string3(){
        return "child string 1";
    }

    @Provides
    @IntoSet
    String string4(){
        return "child string 2";
    }
}
