package com.yunjaena.dagger2practice;

import androidx.annotation.Nullable;

import dagger.Module;
import dagger.Provides;

@Module
public class NullableModule {
    @Provides
    @Nullable // null을 반환할 가능성이 있는 경우
    Integer provideInteger(){
        return null;
    }
}
