package com.yunjaena.dagger2practice.set;

import java.util.Iterator;
import java.util.Set;

import javax.inject.Inject;

public class FooSet {
    @Inject
    Set<String> strings;

    public void print() {
        for (Iterator itr = strings.iterator(); itr.hasNext(); ) {
            System.out.println(itr.next());
        }
    }
}
