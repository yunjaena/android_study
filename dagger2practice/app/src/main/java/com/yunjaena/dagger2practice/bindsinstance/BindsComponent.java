package com.yunjaena.dagger2practice.bindsinstance;

import dagger.BindsInstance;
import dagger.Component;

@Component
public interface BindsComponent {
    void inject(FooBindsInstance foo);

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder setString(String str);
        BindsComponent build();
    }
}
