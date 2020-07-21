package com.yunjaena.dagger2android;

import com.yunjaena.dagger2android.scope.ActivityScope;

import dagger.BindsInstance;
import dagger.Subcomponent;

@Subcomponent(modules = MainActivityModule.class)
@ActivityScope
public interface MainActivityComponent {
    MainFragmentComponent.Builder mainFragmentComponentBuilder();

    void inject(MainActivity activity);

    @Subcomponent.Builder
    interface Builder {
        Builder setModule(MainActivityModule module);
        @BindsInstance
        Builder setActivity(MainActivity activity);
        MainActivityComponent build();
    }
}
