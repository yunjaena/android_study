package com.yunjaena.dagger2practice;

import com.yunjaena.dagger2practice.inheritance.Child;
import com.yunjaena.dagger2practice.inheritance.DaggerInheritanceComponent;
import com.yunjaena.dagger2practice.inheritance.InheritanceComponent;
import com.yunjaena.dagger2practice.inheritance.Self;
import com.yunjaena.dagger2practice.person.DaggerPersonComponent;
import com.yunjaena.dagger2practice.person.PersonA;
import com.yunjaena.dagger2practice.person.PersonB;
import com.yunjaena.dagger2practice.person.PersonComponent;

import org.junit.Test;

import dagger.MembersInjector;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNull;

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
        assertNull("조회 결과 null", str); // null임을 확인
        MemberInjectionComponent memberInjectionComponent = DaggerMemberInjectionComponent.create();
        memberInjectionComponent.inject(myClass);
        str = myClass.getStr();
        assertEquals("Hello World", str); // str = Hello world
        System.out.println(str);
    }

    @Test
    public void testMemberInjectionWithMembersInjectorClass(){
        MyClass myClass = new MyClass();
        String str = myClass.getStr();
        System.out.println("result = " + str); // str = null;
        MemberInjectionComponent memberInjectionComponent = DaggerMemberInjectionComponent.create();
        MembersInjector<MyClass> injector = memberInjectionComponent.getInjector();
        injector.injectMembers(myClass);
        str = myClass.getStr();
        System.out.println("result = " + str); // str != null;
    }

    @Test
    public void testInjection(){
        PersonComponent personComponent = DaggerPersonComponent.create();
        PersonA personA = personComponent.getPersonA();

        System.out.println(personA.getName() + ":" + personA.getAge());
        PersonB personB = new PersonB();
        personComponent.inject(personB);
        assertEquals("Charles", personB.getName()); // 이름
        assertEquals(100, personB.getAge()); // 나이
    }

    @Test
    public void inheritanceTest(){
        InheritanceComponent inheritanceComponent = DaggerInheritanceComponent.create();
        Child child = new Child();
        inheritanceComponent.inject(child);
        assertNotNull(child.getA()); // child.a != null
        assertNotNull(child.getB()); // child.b != null
        assertNull(child.getC()); // child.c -= null
    }
}