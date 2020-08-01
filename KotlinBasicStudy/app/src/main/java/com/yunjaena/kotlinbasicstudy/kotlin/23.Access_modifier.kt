package com.yunjaena.kotlinbasicstudy.kotlin

// 23. 접근 제어자

fun main(args: Array<String>) {
    val testAccess: TestAccess = TestAccess("아무개")
    // private 키워드 때문에 외부에서 사용할 수 없다
//    testAccess.test()
//    println(testAccess.name)
//    testAccess.name = "아무개 투"
//    println(testAccess.name)

    var reward: Reward = Reward()
    reward.rewardAmount = 2000

    val runningCar: RunningCar = RunningCar()
    runningCar.runFast()
    // runningCar.run() => 외부에서 접근 못함

}

class Reward() {
    var rewardAmount: Int = 1000
}

class TestAccess {
    private var name: String = "홍길동"

    constructor(name: String) {
        this.name = name
    }

    fun changeName(newName: String) {
        this.name = newName
    }

    private fun test() {
        println("테스트")
    }
}

class RunningCar() {
    fun runFast() {
        run()
    }

    private fun run() {

    }
}