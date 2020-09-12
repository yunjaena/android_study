package com.yunjaena.kotlinbasicstudy.self_study

open class OuterClass {
    private val a = 1 // OuterClass 내부에서만 접근이 가능하다.
    protected val b = 2 // 상속을 받은 클래스에서만 접근이 가능하다.
    internal val c = 2 // 같은 모듈 안에 클래스에서 접근 가능하다.
    val d = 4 // 접근 제한자가 선언되어 있지 않으면 public 으로 간주된다. 이변수는 프로그램 어디서든 접근이 가능하다.
}