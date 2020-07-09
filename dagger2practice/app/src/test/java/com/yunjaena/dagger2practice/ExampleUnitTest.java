package com.yunjaena.dagger2practice;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testHelloWorld(){
        MyComponent myComponent = DaggerMyComponent.create();
        System.out.println("result = " + myComponent.getString());
        DuplicationComponent duplicationComponent = DaggerDuplicationComponent.create();
        System.out.println("result = " + duplicationComponent.getString());
    }

    @Test
    public void nullableTest(){
        NullableComponent nullableComponent = DaggerNullableComponent.create();
        System.out.println(nullableComponent.getInteger());
    }
}