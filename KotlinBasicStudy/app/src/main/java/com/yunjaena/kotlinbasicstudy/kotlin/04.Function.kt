package com.yunjaena.kotlinbasicstudy.kotlin

// 04. Function
// - 함수
//      - 어떤 input 을 넣어주면 어떤 output 나오는 것
//      - y = x + 2

// - 함수를 선언하는 방법
// fun 함수명 (변수명: 타입, 변수명:타입 ....) : 반환형 {
//       함수 내용
//      return 반환값
// }

fun plus(first: Int, second: Int): Int {
    println(first)
    println(second)
    val result = first + second
    println(result)
    return result
}

fun main(array: Array<String>) {
    // 함수를 호출하는 방법
    val result = plus(5, 10)
    println(result)

    // 인수를 명시적으로 전달하는 방법
    val result2 = plus(first = 20, second = 30)
    println(result2)

    val result3 = plus(second = 100, first = 10)
    println(result3)
}