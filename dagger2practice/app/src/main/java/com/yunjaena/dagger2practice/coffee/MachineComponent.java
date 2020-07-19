package com.yunjaena.dagger2practice.coffee;

import dagger.Subcomponent;

@Subcomponent(modules = MachineModule.class)
public interface MachineComponent {
    Coffee getCoffee();

    void inject(Machine machine);

    @Subcomponent.Builder
    interface Builder {
        Builder setMachineModule(MachineModule machineModule);

        MachineComponent build();
    }
}
