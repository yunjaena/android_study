package com.itvillage.section3;

import com.itvillage.section03.SampleObservable;
import org.junit.BeforeClass;

public class RxJavaTest {
    protected static SampleObservable sampleObservable;

    @BeforeClass
    public static void setup(){
        sampleObservable = new SampleObservable();
    }
}