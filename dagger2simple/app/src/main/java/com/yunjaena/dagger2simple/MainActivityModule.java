package com.yunjaena.dagger2simple;

import com.yunjaena.dagger2simple.scope.ActivityScope;
import com.yunjaena.dagger2simple.scope.FragmentScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {
    @Named("activity")
    @Provides
    @ActivityScope
    static String provideString() {
        return "String from MainActivityModule";
    }

    @FragmentScope
    @ContributesAndroidInjector(modules = MainFragmentModule.class)
    abstract MainFragment mainFragment();
}
