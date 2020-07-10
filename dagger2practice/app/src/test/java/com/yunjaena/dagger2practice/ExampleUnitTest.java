package com.yunjaena.dagger2practice;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testHelloWorld() {
        MyComponent myComponent = DaggerMyComponent.create();
        System.out.println("result = " + myComponent.getString());
        DuplicationComponent duplicationComponent = DaggerDuplicationComponent.create();
        System.out.println("result = " + duplicationComponent.getString());
    }

    @Test
    public void nullableTest() {
        NullableComponent nullableComponent = DaggerNullableComponent.create();
        System.out.println(nullableComponent.getInteger());
    }

    @Test
    public void testMemberInjection() {
        MyClass myClass = new MyClass();
        String str = myClass.getStr();
       // assertNotNull("조회 결과 null",str); // null이 아님을 확인
        MemberInjectionComponent memberInjectionComponent = DaggerMemberInjectionComponent.create();
        memberInjectionComponent.inject(myClass);
        str = myClass.getStr();
        assertEquals("Hello World", str); // str = Hello world
        System.out.println(str);
    }
}