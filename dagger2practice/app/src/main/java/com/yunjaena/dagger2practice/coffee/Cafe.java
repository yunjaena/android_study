package com.yunjaena.dagger2practice.coffee;

import javax.inject.Inject;

public class Cafe {
    @Inject
    Machine coffeeMachine;

    public Cafe(){
        DaggerCafeComponent.create().inject(this);
    }

    public Coffee orderCoffee(){
        return coffeeMachine.extract();
    }
}
