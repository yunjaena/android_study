package com.yunjaena.dagger2practice.custommap;

import dagger.MapKey;

@MapKey
public @interface AnimalKey {
    Animal value();
}
