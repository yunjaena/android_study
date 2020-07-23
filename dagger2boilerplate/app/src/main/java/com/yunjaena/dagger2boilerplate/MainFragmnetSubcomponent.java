package com.yunjaena.dagger2boilerplate;

import com.yunjaena.dagger2boilerplate.scope.FragmentScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@FragmentScope
@Subcomponent(modules = MainFragmentModule.class)
public interface MainFragmnetSubcomponent extends AndroidInjector<MainFragment>{
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MainFragment>{
    }

}
