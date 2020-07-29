package com.yunjaena.kotlinbasicstudy.kotlin

fun main(args: Array<String>) {
    val array = arrayOf<Int>(1, 2, 3)

    // get, set
    val number = array.get(0)
    println(number)
    // val number1 = array.get(100) => ArrayIndexOutOfBoundsException 인덱스에 주의 해야 한다.
    array.set(0, 100)
    val number2 = array.get(0)
    println(number2)

    // array.set(100, 100)  => ArrayIndexOutOfBoundsException 인덱스에 주의 해야 한다.

    // Array 의 Bounds
    // - 처음 만들때 결정 된다.

    // Array 를 만드는 방법(3)
    val a1 = intArrayOf(1, 2, 3)
    val a2 = charArrayOf('b', 'c') // char -> ' ' , string -> ""
    val a3 = doubleArrayOf(1.2, 100.345)
    val a4 = booleanArrayOf(true, false, true)

    // Array 를 만드는 방법(4) -> lamda를 활용한 방법
    var a5 = Array(10, { 0 }) //
    var a6 = Array(5) { i -> i * i }

    for (i in a6) {
        println(i)
    }
}