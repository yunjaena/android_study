package com.yunjaena.tdd.unittests

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.yunjaena.tdd.outsideintddexample.Car
import com.yunjaena.tdd.outsideintddexample.Engine
import com.yunjaena.tdd.utils.MainCoroutineScopeRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.times

class CarShould {

    private val engine: Engine = mock()
    private val car: Car

    init {
        runBlockingTest {
            whenever(engine.turnOn()).thenReturn(flow {
                kotlinx.coroutines.delay(2000)
                emit(25)
                kotlinx.coroutines.delay(2000)
                emit(50)
                kotlinx.coroutines.delay(2000)
                emit(95)
            })
        }
        car = Car(engine, 5.0)
    }

    @get:Rule
    var coroutineTestRule = MainCoroutineScopeRule()

    @Test
    fun loseFuelWhenTurnOn() = runBlockingTest {
        car.turnOn()

        assertEquals(4.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() = runBlockingTest {
        car.turnOn()

        Mockito.verify(engine, times(1)).turnOn()
    }
}