package com.yunjaena.tdd

import org.junit.Assert.assertEquals
import org.junit.Test

class EngineTest {

    private val engine = Engine(2000, 189, 15, false)

    @Test
    fun engineTurnsOn() {
        engine.turnOn()

        assertEquals(true, engine.isTurnOn)
        assertEquals(95, engine.temperature)
    }

    @Test
    fun engineTurnsOff() {
        engine.turnOn()
        engine.turnOff()

        assertEquals(false, engine.isTurnOn)
        assertEquals(15, engine.temperature)
    }
}