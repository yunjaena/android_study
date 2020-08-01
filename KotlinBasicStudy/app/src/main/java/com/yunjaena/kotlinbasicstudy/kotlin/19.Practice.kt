package com.yunjaena.kotlinbasicstudy.kotlin

fun main(args: Array<String>) {
    // 1번
    val calculator: Calculator = Calculator()
    println(calculator.sum(1, 2, 3, 4))
    println(calculator.minus(1, 2, 3, 4))
    println(calculator.multiply(1, 2, 3, 4))
    println(calculator.divide(1, 2, 3, 4))

    println()
    // 2번
    val tomBankAccount: BankAccount = BankAccount("Tom", "1996/11/11")
    println(tomBankAccount.checkBalance())
    tomBankAccount.deposit(1000)
    println(tomBankAccount.checkBalance())
    tomBankAccount.withdraw(800)
    println(tomBankAccount.checkBalance())

    println()
    // 3번
    val television : Television = Television()
    television.turnOnTelevision()
    println(television.getChannelName())
    television.goToChannel(2)
    println(television.getChannelName())
    television.turnOffTelevision()
    television.goToChannel(2)
}

// 1) 사칙 연산을 수행할 수 있는 클래스
class Calculator {
    fun sum(vararg numbers: Int): Int {
        var result: Int = 0
        for (number in numbers) {
            result += number
        }
        return result
    }

    fun minus(vararg numbers: Int): Int {
        var result: Int = numbers[0]
        for (i in 1 until numbers.size) {
            result -= numbers[i]
        }
        return result
    }

    fun multiply(vararg numbers: Int): Int {
        var result: Int = 1
        for (number in numbers) {
            result *= number
        }
        return result
    }

    fun divide(vararg numbers: Int): Float {
        var result: Float = numbers[0].toFloat()
        for (i in 1 until numbers.size) {
            result /= numbers[i].toFloat()
        }
        return result
    }
}


// 2) 이행 계좌 만들기
//  - 계좌 생성 기능 (이름, 생년 월일)
//  - 잔고를 확인 하는 기능
//  - 출금 기능
//  - 예금 기능

class BankAccount(val name: String, val birthDay: String) {
    var balance: Int = 0

    fun checkBalance(): Int = balance
    fun withdraw(money: Int) {
        if (money < 0 || balance < money) return
        balance -= money
    }

    fun deposit(money: Int) {
        balance += money
    }
}

// 3) TV 클래스
//   - on/off 기능
//   - 채널을 돌리는 기능
//   - 초기 채널은 (S사 M사 K사 3개)

class Television {
    var isOn: Boolean = false
    var currentChannelID = 0
    val channel = mutableListOf<String>()

    init {
        channel.add("S사")
        channel.add("M사")
        channel.add("K사")
    }

    fun turnOnTelevision() {
        isOn = true
    }

    fun turnOffTelevision() {
        isOn = false
    }

    fun goToChannel(channelID: Int) {
        if (!isOn) {
            println("Turn on Television please")
        }

        if (channelID > channel.size) {
            println("No channel valid")
        }

        currentChannelID = channelID
    }

    fun getChannelName() = channel[currentChannelID]


}

