package com.yunjaena.dagger2android;

import com.yunjaena.dagger2android.scope.ActivityScope;

import dagger.BindsInstance;
import dagger.Subcomponent;

@Subcomponent(modules = MainActivityModule.class)
@ActivityScope
public interface MainActivityComponent {

    @Subcomponent.Builder
    interface Builder {
        Builder setModule(MainActivityModule module);
        @BindsInstance
        Builder setActivity(MainActivity activity);
        MainActivityComponent build();
    }
}
