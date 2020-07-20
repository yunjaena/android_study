package com.yunjaena.dagger2practice.basic;

import dagger.Component;

@Component(modules = MyModule.class)
public interface MyComponent {
    String getString(); //프로비전 메서드, 바인드된 모듈로부터 의존성을 제공

    @Component.Builder
    interface Builder{
        Builder setMyModule(MyModule myModule);
        MyComponent build();
    }
}
