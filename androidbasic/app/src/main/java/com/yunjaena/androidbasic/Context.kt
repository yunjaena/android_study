package com.yunjaena.androidbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Context : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context)

        val context : android.content.Context= this
        val applicationContext : android.content.Context = applicationContext
    }
}
