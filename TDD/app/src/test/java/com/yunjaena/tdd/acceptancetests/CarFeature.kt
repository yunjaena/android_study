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
    fun carIsTurningOnItsEngineAndIncreasesTheTemperatureGradually() = runBlockingTest {
        car.turnOn()

        coroutineTestRule.advanceTimeBy(2000)

        assertEquals(25, car.engine.temperature)

        coroutineTestRule.advanceTimeBy(2000)

        assertEquals(50, car.engine.temperature)

        coroutineTestRule.advanceTimeBy(2000)

        assertEquals(95, car.engine.temperature)

        assertTrue(car.engine.isTurnedOn)
    }
}