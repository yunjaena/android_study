package com.yunjaena.dagger2android;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
    MainActivityComponent.Builder mainActivityBuilder();

    void inject(App app);

    @Component.Factory
    interface Factory {
        AppComponent create(
                @BindsInstance App app,
                AppModule appModule
        );
    }
}
