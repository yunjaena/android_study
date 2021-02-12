package com.yunjaena.tdd

import com.yunjaena.tdd.utils.MainCoroutineScopeRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class EngineTest {
    @get:Rule
    var coroutineTestRule = MainCoroutineScopeRule()

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