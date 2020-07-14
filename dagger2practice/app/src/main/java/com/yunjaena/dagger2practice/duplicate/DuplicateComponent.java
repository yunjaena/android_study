package com.yunjaena.dagger2practice.duplicate;

import dagger.Component;

@Component(modules = DuplicateModule.class)
public interface DuplicateComponent {
    void inject(Duplicate duplicate);

}
