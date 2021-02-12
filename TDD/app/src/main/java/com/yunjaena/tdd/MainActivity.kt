package com.yunjaena.tdd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yunjaena.tdd.outsideintddexample.Car
import com.yunjaena.tdd.outsideintddexample.Engine

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val engine = Engine()
        val car = Car(engine, 20.0)

        car.turnOn()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}