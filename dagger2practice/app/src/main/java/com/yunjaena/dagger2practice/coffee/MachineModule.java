package com.yunjaena.dagger2practice.coffee;

import dagger.Module;
import dagger.Provides;

@Module
public class MachineModule {
    @Provides
    CoffeeBean provideCoffeeBean() {
        return new CoffeeBean();
    }
}
