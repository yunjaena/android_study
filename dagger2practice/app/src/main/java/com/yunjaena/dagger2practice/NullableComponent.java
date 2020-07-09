package com.yunjaena.dagger2practice;

import androidx.annotation.Nullable;

import dagger.Component;

@Component(modules = NullableModule.class)
public interface NullableComponent {
    @Nullable // 이 애노테이션이 없으면 에러가 발생한다.
    Integer getInteger();
}
