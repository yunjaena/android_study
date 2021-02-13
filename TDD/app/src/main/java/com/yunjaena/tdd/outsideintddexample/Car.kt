package com.yunjaena.tdd.outsideintddexample

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class Car(
    val engine: Engine,
    var fuel: Double
) {

    fun turnOn() {
        fuel -= 0.5
        CoroutineScope(Dispatchers.Main).launch {
            engine.turnOn().collect { temprature ->
                Log.d("COURSE", "collected engine temperature: $temprature")
            }
        }

    }
}