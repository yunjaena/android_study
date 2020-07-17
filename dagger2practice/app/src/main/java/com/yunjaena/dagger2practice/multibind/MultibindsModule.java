package com.yunjaena.dagger2practice.multibind;

import java.util.Set;

import dagger.Module;
import dagger.multibindings.Multibinds;

@Module
public abstract class MultibindsModule {
    @Multibinds
    abstract Set<String> strings();
}
