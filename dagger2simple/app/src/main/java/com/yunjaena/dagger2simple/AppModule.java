package com.yunjaena.dagger2simple;

import com.yunjaena.dagger2simple.scope.ActivityScope;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module
public abstract class AppModule {
    @Named("app")
    @Provides
    @Singleton
    static String provideString(){
        return "String from AppModule";
    }

    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivity();

}
