package com.yunjaena.dagger2practice.person;

import javax.inject.Inject;

public class PersonB {
    @Inject // 필드 주입
    String name;

    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Inject // 메서드 주입
    public void setAge(int age) {
        this.age = age;
    }
}
