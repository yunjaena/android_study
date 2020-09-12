package com.yunjaena.kotlinbasicstudy.self_study

class Person(val name: String = "hello") {
    var age = 0

    constructor(name: String, age: Int) : this(name) {
        this.age = age;
    }
}

class PersonTypeTwo(var name: String?) {
    var age = 0

    init {
        if (name.isNullOrEmpty())
            name = "no name"
    }

    constructor(name: String, age: Int) : this(name) {
        this.age = age;
    }
}

fun main() {
    val personOne = Person()
    val personTwo = Person("bob", 27)
    println(personOne.age)
    println(personTwo.age)

    val personThree = PersonTypeTwo(null)
    val personFour = PersonTypeTwo("bob", 27)
    println(personThree.name)
    println(personFour.name)
    println(personThree.age)
    println(personFour.age)
}