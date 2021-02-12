package com.yunjaena.tdd.outsideintddexample

import android.util.Log
import kotlinx.coroutines.delay

class Engine(
    var temperature: Int = 15,
    var isTurnedOn: Boolean = false
) {

    suspend fun turnOn() {
        Log.d("COURSE", "Engine has turned on start")
        isTurnedOn = true
        delay(6000)
        temperature = 95

        Log.d("COURSE", "Engine has turned on end")
    }
}