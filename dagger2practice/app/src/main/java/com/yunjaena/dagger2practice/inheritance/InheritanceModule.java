package com.yunjaena.dagger2practice.inheritance;

import dagger.Module;
import dagger.Provides;

@Module
public class InheritanceModule {
    @Provides
    A getA() {
        return new A();
    }

    @Provides
    B getB() {
        return new B();
    }

    @Provides
    C getC() {
        return new C();
    }
}
