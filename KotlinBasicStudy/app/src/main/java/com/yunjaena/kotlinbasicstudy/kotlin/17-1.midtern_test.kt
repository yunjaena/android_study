package com.yunjaena.kotlinbasicstudy.kotlin

fun main(args: Array<String>) {
    first()
    println(second(80))
    println(third(89))
    gugudan()
}

fun first() {
    val a = mutableListOf<Int>()
    val b = mutableListOf<Boolean>()
    for (i in 1..9) {
        a.add(i)
        if (i % 2 == 0)
            b.add(true)
        else
            b.add(false)
    }
    println(a)
    println(b)
}

fun second(score: Int): String =
    when (score) {
        in 80..90 -> "A"
        in 70..79 -> "B"
        in 60..69 -> "C"
        else -> "F"
    }

fun third(number: Int) : Int {
    var sum = 0
    sum += number % 10
    sum += number / 10
    return sum
}

fun gugudan() {
    for (x in 1..9) {
        for (y in 1..9)
            println("$x x $y = ${x * y}")
    }
}