package com.yunjaena.dagger2practice;

import com.yunjaena.dagger2practice.bindsinstance.BindsComponent;
import com.yunjaena.dagger2practice.bindsinstance.DaggerBindsComponent;
import com.yunjaena.dagger2practice.bindsinstance.FooBindsInstance;
import com.yunjaena.dagger2practice.bindsoptionalof.DaggerNoStrComponent;
import com.yunjaena.dagger2practice.bindsoptionalof.DaggerStrComponent;
import com.yunjaena.dagger2practice.bindsoptionalof.Foo;
import com.yunjaena.dagger2practice.custommap.Animal;
import com.yunjaena.dagger2practice.custommap.DaggerMapKeyComponent;
import com.yunjaena.dagger2practice.custommap.MapKeyComponent;
import com.yunjaena.dagger2practice.duplicate.DaggerDuplicateComponent;
import com.yunjaena.dagger2practice.duplicate.Duplicate;
import com.yunjaena.dagger2practice.duplicateannotation.DaggerDuplicateAnnotationComponent;
import com.yunjaena.dagger2practice.duplicateannotation.DuplicateAnnotation;
import com.yunjaena.dagger2practice.inheritance.Child;
import com.yunjaena.dagger2practice.inheritance.DaggerInheritanceComponent;
import com.yunjaena.dagger2practice.inheritance.InheritanceComponent;
import com.yunjaena.dagger2practice.lazy.Counter;
import com.yunjaena.dagger2practice.lazy.CounterComponent;
import com.yunjaena.dagger2practice.lazy.DaggerCounterComponent;
import com.yunjaena.dagger2practice.map.DaggerMapComponent;
import com.yunjaena.dagger2practice.map.FooMap;
import com.yunjaena.dagger2practice.map.MapComponent;
import com.yunjaena.dagger2practice.person.DaggerPersonComponent;
import com.yunjaena.dagger2practice.person.PersonA;
import com.yunjaena.dagger2practice.person.PersonB;
import com.yunjaena.dagger2practice.person.PersonComponent;
import com.yunjaena.dagger2practice.set.DaggerSetComponent;
import com.yunjaena.dagger2practice.set.FooSet;
import com.yunjaena.dagger2practice.singleton.DaggerSingletonComponent;
import com.yunjaena.dagger2practice.singleton.SingletonComponent;
import com.yunjaena.dagger2practice.subcomponentmultibinding.ChildComponent;
import com.yunjaena.dagger2practice.subcomponentmultibinding.DaggerParentComponent;
import com.yunjaena.dagger2practice.subcomponentmultibinding.ParentComponent;

import org.junit.Test;

import java.util.Iterator;

import dagger.MembersInjector;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

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
    public void testMemberInjectionWithMembersInjectorClass() {
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
    public void testInjection() {
        PersonComponent personComponent = DaggerPersonComponent.create();
        PersonA personA = personComponent.getPersonA();

        System.out.println(personA.getName() + ":" + personA.getAge());
        PersonB personB = new PersonB();
        personComponent.inject(personB);
        assertEquals("Charles", personB.getName()); // 이름
        assertEquals(100, personB.getAge()); // 나이
    }

    @Test
    public void inheritanceTest() {
        InheritanceComponent inheritanceComponent = DaggerInheritanceComponent.create();
        Child child = new Child();
        inheritanceComponent.inject(child);
        assertNotNull(child.getA()); // child.a != null
        assertNotNull(child.getB()); // child.b != null
        assertNull(child.getC()); // child.c -= null
    }

    @Test
    public void builderTest() {
        MyComponent myComponent = DaggerMyComponent.builder().setMyModule(new MyModule()).build();
        System.out.println(myComponent.getString());
        myComponent = DaggerMyComponent.create();
        System.out.println(myComponent.getString());
    }

    @Test
    public void testLazy() {
        CounterComponent counterComponent = DaggerCounterComponent.create();
        Counter counter = new Counter();
        counterComponent.inject(counter);
        counter.printLazy();
    }

    @Test
    public void testProvider() {
        com.yunjaena.dagger2practice.provider.CounterComponent counterComponent = com.yunjaena.dagger2practice.provider.DaggerCounterComponent.create();
        com.yunjaena.dagger2practice.provider.Counter counter = new com.yunjaena.dagger2practice.provider.Counter();
        counterComponent.inject(counter);
        counter.printProvider();
    }

    @Test
    public void duplicateTest() {
        Duplicate duplicate = new Duplicate();
        DaggerDuplicateComponent.create().inject(duplicate);
        System.out.println(duplicate.getStrHello());
        System.out.println(duplicate.getStrWorld());
    }

    @Test
    public void duplicateAnnotationTest() {
        DuplicateAnnotation duplicateAnnotation = new DuplicateAnnotation();
        DaggerDuplicateAnnotationComponent.create().inject(duplicateAnnotation);
        System.out.println(duplicateAnnotation.getStrHello());
        System.out.println(duplicateAnnotation.getStrWorld());
    }

    @Test
    public void testObjectIdentify() {
        SingletonComponent singletonComponent = DaggerSingletonComponent.create();
        Object temp1 = singletonComponent.getObject();
        Object temp2 = singletonComponent.getObject();
        System.out.println(temp1.hashCode());
        System.out.println(temp2.hashCode());
        assertNotNull(temp1);
        assertNotNull(temp2);
        assertSame(temp1, temp2);
    }

    @Test
    public void testBindsOptionalOf() {
        Foo foo = new Foo();
        DaggerStrComponent.create().inject(foo);
        System.out.println(foo.str.isPresent());
        System.out.println(foo.str.get());
        System.out.println(foo.str2.isPresent());
        System.out.println(foo.str2.get().get());
        System.out.println(foo.str3.isPresent());
        System.out.println(foo.str3.get().get());


        DaggerNoStrComponent.create().inject(foo);
        System.out.println(foo.str.isPresent());
        System.out.println(foo.str.get());
        System.out.println(foo.str2.isPresent());
        System.out.println(foo.str2.get().get());
        System.out.println(foo.str3.isPresent());
        System.out.println(foo.str3.get().get());
    }

    @Test
    public void testBindsInstance() {
        String hello = "Hello World";

        FooBindsInstance foo = new FooBindsInstance();
        BindsComponent component = DaggerBindsComponent.builder()
                .setString(hello)
                .build();
        component.inject(foo);
        assertEquals("Hello World", foo.str);
    }

    @Test
    public void testMultibindingSet() {
        FooSet fooSet = new FooSet();
        DaggerSetComponent.create().inject(fooSet);
        fooSet.print();
    }

    @Test
    public void testMultibindingMapTest() {
        MapComponent component = DaggerMapComponent.create();
        long value = component.getLongsByString().get("foo");
        String str = component.getStringByClass().get(FooMap.class);

        System.out.println(value);
        System.out.println(str);
    }

    @Test
    public void testCustomMapKey() {
        MapKeyComponent component = DaggerMapKeyComponent.create();
        String cat = component.getStringsByAnimal().get(Animal.CAT);
        String dog = component.getStringsByAnimal().get(Animal.DOG);
        String number = component.getStringsByNumber().get(Float.class);

        System.out.println(cat);
        System.out.println(dog);
        System.out.println(number);
    }

    @Test
    public void testMultibindingWithSubcomopnent() {
        ParentComponent parentComp = DaggerParentComponent.create();
        ChildComponent childComp = parentComp.childCompBuilder().build();
        System.out.println("List set in Parent");

        Iterator itr = parentComp.strings().iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("List set In Child");

        itr = childComp.strings().iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

}