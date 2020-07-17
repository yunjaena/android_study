package com.yunjaena.dagger2practice.multibind;

import com.yunjaena.dagger2practice.set.SetModule;

import java.util.Set;

import dagger.Component;

@Component(modules = {MultibindsModule.class, SetModule.class})
public interface MultibindsComponent {
    Set<String> getString();
}
