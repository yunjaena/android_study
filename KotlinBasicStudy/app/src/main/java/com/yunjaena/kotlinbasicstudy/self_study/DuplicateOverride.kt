package com.yunjaena.kotlinbasicstudy.self_study

open class A {
    open fun f() {}
    fun a() {}
}

interface B {
    fun f() {}
    fun b() {}
}

class C : A(), B {
    override fun f() {
        super<A>.f()
        super<B>.f()
    }
}