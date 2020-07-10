package com.yunjaena.dagger2practice.person;

import dagger.Module;
import dagger.Provides;

@Module
public class PersonModule {
    @Provides
    String provideName() {
        return "Charles";
    }

    @Provides
    int provideAge() {
        return 100;
    }
}
