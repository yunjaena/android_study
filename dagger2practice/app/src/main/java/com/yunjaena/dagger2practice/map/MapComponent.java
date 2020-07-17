package com.yunjaena.dagger2practice.map;

import java.util.Map;

import dagger.Component;

@Component(modules = MapModule.class)
public interface MapComponent {
    Map<String, Long> getLongsByString();

    Map<Class<?>, String> getStringByClass();
}
