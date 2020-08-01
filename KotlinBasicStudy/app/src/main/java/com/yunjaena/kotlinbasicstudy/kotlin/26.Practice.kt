package com.yunjaena.kotlinbasicstudy.kotlin

// 과제
// Knight, Monster (부모) -> 캐릭터
// SuperKnight, SuperMonster (자식)

fun main(args: Array<String>) {
    val monster = SuperMonster(100, 10)
    val knight = SuperKnight(130, 8)
    monster.attack(knight)
    monster.bite(knight)
}

// 상속이 만들어낸 특장
// - 자식 클래스는 부모 클래스의 타입이다.
// - 부모 클래스는 자식 클래스의 타입이 아니다!

open class Character(var hp : Int, val power : Int){
    fun attack(character: Character, power : Int = this.power){
        character.defense(power)
    }

   open fun defense(damage: Int){
        hp -= damage
        if(hp > 0) println("${javaClass.simpleName}의 남은 체력 $hp 입니다")
        else println("사망 했습니다.")
    }
}


// 자식 클래스가 인스턴스화 되기 위해서 부모 클래스 선행되서 인스턴스화 되어야 한다
open class SuperMonster(hp: Int, power: Int) : Character(hp, power) {
    fun bite(character: Character){
        super.attack(character, power + 2)
    }
}

open class SuperKnight(hp: Int, power: Int) : Character(hp, power) {
    val defensePower = 2
    override fun defense(damage: Int) {
        super.defense(damage - defensePower)
    }
}