package com.yunjaena.dagger2practice.coffee;

import javax.inject.Inject;

public class Coffee {
    @Inject
    public Coffee(CoffeeBean coffeeBean, Water water) {
    }
}
