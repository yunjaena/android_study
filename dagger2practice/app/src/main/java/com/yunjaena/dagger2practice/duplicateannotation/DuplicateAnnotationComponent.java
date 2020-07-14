package com.yunjaena.dagger2practice.duplicateannotation;

import dagger.Component;

@Component(modules =  DuplicationAnnotationModule.class)
public interface DuplicateAnnotationComponent {
    void inject(DuplicateAnnotation duplicateAnnotation);
}
