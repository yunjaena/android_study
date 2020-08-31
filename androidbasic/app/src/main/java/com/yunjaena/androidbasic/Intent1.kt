package com.yunjaena.androidbasic

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_intent.*

class Intent1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        change_activity.setOnClickListener {
            val intent = Intent(this@Intent1, Intent2::class.java)
            // Key, Value 방식 -> Key와 value를 쌍으로 만들어 저장한다. -> Dictionary
            intent.putExtra("number1", 1)
            intent.putExtra("number2", 2)
            //startActivity(intent)

            val intent2 =  Intent(this@Intent1, Intent2::class.java)
            // Apply ->
            intent2.apply {
                putExtra("number1", 1)
                putExtra("number2", 2)
                startActivity(this)
            }
            
        }
    }
}
