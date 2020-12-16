package com.itvillage.chapter02;


import io.reactivex.Observable;

public class HelloRxJava {
    public static void main(String[] args) {
        Observable<String> observable = Observable.just("hello", "RxJava"); // 데이터를 생성하고 통제하는 생성자쪽 코드.
        observable.subscribe(data -> System.out.println(data)); // 데이터를 구독하는 소비자쪽 코드.
    }
}
