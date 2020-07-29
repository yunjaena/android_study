package com.yunjaena.kotlinbasicstudy.kotlin

fun main(array: Array<String>) {
    val a = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)

    // 반복하는 방법(1)
    for(item in a){
        if(item == 5)
            println("item is Five")
        else
            println("item is not Five")
    }
    println()

    // 반복하는 방법(2)
    for((index, item) in a.withIndex()){
        println("index : " + index + " value : " + item)
        // 문자열 + Int(정수) = 문자열
        // 문자열 + 아무거나 =  문자열
    }



}