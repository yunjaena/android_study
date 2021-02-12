package com.yunjaena.tdd.acceptancetests

import com.yunjaena.tdd.outsideintddexample.Car
import com.yunjaena.tdd.outsideintddexample.Engine
import com.yunjaena.tdd.utils.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

class CarFeature {

    private val engine = Engine()

    private val car = Car(engine, 6.0)

    @get:Rule
    var coroutineTestRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() = runBlockingTest {
        car.turnOn()

        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperature() = runBlockingTest {
        car.turnOn()

        coroutineTestRule.advanceTimeBy(6001)

        assertEquals(95, car.engine.temperature)

        assertTrue(car.engine.isTurnedOn)
    }
}