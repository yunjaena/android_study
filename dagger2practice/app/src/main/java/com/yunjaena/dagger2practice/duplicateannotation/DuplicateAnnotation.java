package com.yunjaena.dagger2practice.duplicateannotation;

import javax.inject.Inject;

public class DuplicateAnnotation {
    @Inject
    @Hello
    String strHello;

    @Inject
    String strWorld;

    public String getStrHello() {
        return strHello;
    }

    public String getStrWorld() {
        return strWorld;
    }
}
