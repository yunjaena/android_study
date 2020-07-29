package com.yunjaena.kotlinbasicstudy.kotlin

fun main(args: Array<String>) {
    firstAnswer()
    println(secondAnswer(80))
    println(thirdAnswer(89))
    gugudanAnswer()
}

fun firstAnswer() {
    val list1 = MutableList(9, { 0 })
    val list2 = MutableList(9, { true })
    for (i in 0..8) {
        list1[i] = i + 1
    }
    println(list1)

    list1.forEachIndexed { index, value ->
        if (value % 2 == 0) {
            // 짝수
            list2[index] = true
        } else {
            // 홀수
            list2[index] = false
        }
    }
    println(list2)
}

fun secondAnswer(score: Int): String {
    return when (score) {
        in 80..90 -> "A"
        in 70..79 -> "B"
        in 60..69 -> "C"
        else -> "F"
    }
}

fun thirdAnswer(number: Int): Int {
    val a = number % 10
    val b = number / 10
    return a + b
}

fun gugudanAnswer() {
    for (x in 1..9) {
        for (y in 1..9)
            println("$x x $y = ${x * y}")
    }
}