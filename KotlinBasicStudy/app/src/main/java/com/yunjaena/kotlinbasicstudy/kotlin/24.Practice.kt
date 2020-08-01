package com.yunjaena.kotlinbasicstudy.kotlin

fun main(args: Array<String>) {
    val knight = Knight(20, 4)
    val monster = Monster(15, 5)
    knight.attack(monster)
    monster.attack(knight)

}

class Knight(private var hp: Int, private var power: Int) {

    fun attack(monster: Monster) {
        monster.defense(power)
    }

    fun defense(damage: Int) {
        hp -= damage
        if (hp > 0) {
            heal()
            println("기사 현재 체력은 $hp 입니다.")
        } else println("기사가 죽었습니다.")
    }

    private fun heal() {
        // 아무때나 사용하는 것이 아니라
        // 공격을 당했을떄 죽지 않았다면 힐을 한다
        hp += 3
    }
}

class Monster(private var hp: Int, private var power: Int) {
    fun attack(knight: Knight) {
        knight.defense(power)
    }

    fun defense(damage: Int) {
        hp -= damage
        if (hp > 0) println("몬스터 현재 체력은 $hp 입니다.")
        else println("몬스터가 죽었습니다.")
    }
}