package com.yunjaena.kotlinbasicstudy.self_study

class Person(val name: String = "hello") {
    var age = 0

    constructor(name: String, age: Int) : this(name) {
        this.age = age;
    }
}

class PersonTypeTwo(var name: String?) {
    var age = 0
    private set

    init {
        if (name.isNullOrEmpty())
            name = "no name"
    }

    constructor(name: String, age: Int) : this(name) {
        this.age = age;
    }
}

class PersonTypeThree(email: String){
    var email : String = email.required()
    set(value){
        field = value.required()
    }
    get() = "email : $field"


    private fun String.required() = this.also {
        require(it.trim().isNotEmpty()){
            "The email can not be blank"
        }
    }

}

fun PersonTypeThree.pureEmail() : String{
    return this.email.replace("email : ", "")
}
fun PersonTypeThree.clear() = this.also {
    it.email = ""
}

fun main() {
    val personOne = Person()
    val personTwo = Person("bob", 27)
    println(personOne.age)
    println(personTwo.age)

    val personThree = PersonTypeTwo(null)
    val personFour = PersonTypeTwo("bob", 27)
    // personFour.age =2
    println(personThree.name)
    println(personFour.name)
    println(personThree.age)
    println(personFour.age)

    val personTypeThree = PersonTypeThree("1")
    println(personTypeThree.email)
    println(personTypeThree.pureEmail())
    println(personTypeThree.clear())

}