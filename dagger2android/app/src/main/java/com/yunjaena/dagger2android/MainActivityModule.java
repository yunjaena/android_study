package com.yunjaena.dagger2android;

import com.yunjaena.dagger2android.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = MainFragmentComponent.class)
public class MainActivityModule {
    @Provides
    @ActivityScope
    String provideActivityName() {
        return MainActivity.class.getSimpleName();
    }
}
