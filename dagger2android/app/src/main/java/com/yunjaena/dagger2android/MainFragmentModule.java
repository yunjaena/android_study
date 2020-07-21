package com.yunjaena.dagger2android;

import com.yunjaena.dagger2android.scope.FragmentScope;

import java.util.Random;

import dagger.Module;
import dagger.Provides;

@Module
public class MainFragmentModule {

    @Provides
    @FragmentScope
    Integer provideInt(){
        return new Random().nextInt();
    }
}
