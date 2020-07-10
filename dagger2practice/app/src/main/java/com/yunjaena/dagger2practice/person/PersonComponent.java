package com.yunjaena.dagger2practice.person;

import dagger.Component;

@Component(modules =  PersonModule.class)
public interface PersonComponent {

    PersonA getPersonA();

    void inject(PersonB personB); // 멤버 - 인젝션 메서드
}
