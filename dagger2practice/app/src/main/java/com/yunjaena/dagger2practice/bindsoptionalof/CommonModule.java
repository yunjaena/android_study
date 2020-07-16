package com.yunjaena.dagger2practice.bindsoptionalof;

import dagger.BindsOptionalOf;
import dagger.Module;

@Module
public abstract class CommonModule {
    @BindsOptionalOf
    abstract String bindsOptionalString();
}
