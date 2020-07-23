package com.yunjaena.dagger2boilerplate;

import com.yunjaena.dagger2boilerplate.scope.ActivityScope;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents =  MainFragmnetSubcomponent.class)
public abstract class MainActivityModule {
    @Named("activity")
    @Provides
    @ActivityScope
    static String provideString(){
        return "String from MainActivityModule";
    }

    @Binds
    @IntoMap
    @ClassKey(MainFragment.class)
    abstract AndroidInjector.Factory<?> bindInjectorFactory(MainFragmnetSubcomponent.Factory factory);
}
