package com.yunjaena.tdd.unittests

import com.nhaarman.mockitokotlin2.mock
import com.yunjaena.tdd.outsideintddexample.Car
import com.yunjaena.tdd.outsideintddexample.Engine
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.times

class CarShould {

    private val engine : Engine = mock()
    private val car = Car(engine,5.0)


    @Test
    fun loseFuelWhenTurnOn(){
        car.turnOn()

        assertEquals(4.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine(){
        car.turnOn()

        Mockito.verify(engine, times(1)).turnOn()
    }
}