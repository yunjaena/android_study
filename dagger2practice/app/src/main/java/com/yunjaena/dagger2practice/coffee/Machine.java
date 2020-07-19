package com.yunjaena.dagger2practice.coffee;

public class Machine {
    private MachineComponent component;

    public Machine(MachineComponent.Builder builder) {
        component = builder.setMachineModule(new MachineModule())
                .build();
        component.inject(this);
    }

    public Coffee extract() {
        return component.getCoffee();
    }
}
