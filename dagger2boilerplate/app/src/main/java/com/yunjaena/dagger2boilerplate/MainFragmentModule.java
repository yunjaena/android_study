package com.yunjaena.dagger2boilerplate;

import com.yunjaena.dagger2boilerplate.scope.FragmentScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MainFragmentModule {
    @Named("fragment")
    @Provides
    @FragmentScope
    String provideString(){
        return "String from fragment";
    }
}
