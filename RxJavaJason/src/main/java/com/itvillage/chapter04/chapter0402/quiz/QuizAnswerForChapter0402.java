package com.itvillage.chapter04.chapter0402.quiz;

import com.itvillage.common.Car;
import com.itvillage.common.CarType;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class QuizAnswerForChapter0402 {
    public static void main(String[] args) {
        Predicate<String> p = s -> s.isEmpty();
        Predicate<String> p1 = String::isEmpty;
        System.out.println("문제 1번 결과: " + p1.test("Not Empty"));

        Function<Integer, String> f = i -> String.valueOf(i);
        Function<Integer, String> f1 = String::valueOf;
        System.out.println("문제 2번 결과: " + f1.apply(3));


        BiPredicate<List<Integer>, Integer> q = (list, num) -> list.contains(num);
        BiPredicate<List<Integer>, Integer> q1 = List::contains;
        System.out.println("문제 3번 결과: " + q1.test(Arrays.asList(1, 3, 5, 7, 9), 9));

        Consumer<String> c = s -> System.out.println(s);
        Consumer<String> c1 = System.out::println;
        c1.accept("문제 4번 결과: Hello!");

        BiFunction<String, CarType, Car> t = (s1, s2) -> new Car(s1, s2);
        BiFunction<String, CarType, Car> t1 = Car::new;
        Car car = t1.apply("말리부", CarType.SEDAN);
        System.out.println("문제 5번 결과: " + car.getCarName() + " / " + car.getCarType());
    }
}
