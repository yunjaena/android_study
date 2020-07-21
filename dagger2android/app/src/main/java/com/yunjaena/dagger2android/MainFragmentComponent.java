package com.yunjaena.dagger2android;

import com.yunjaena.dagger2android.scope.FragmentScope;

import dagger.BindsInstance;
import dagger.Subcomponent;

@Subcomponent(modules = MainFragmentModule.class)
@FragmentScope
public interface MainFragmentComponent {
    void inject(MainFragment mainFragment);

    @Subcomponent.Builder
    interface Builder {
        MainFragmentComponent.Builder setModule(MainFragmentModule module);

        @BindsInstance
        MainFragmentComponent.Builder setFragment(MainFragment fragment);

        MainFragmentComponent build();
    }
}
