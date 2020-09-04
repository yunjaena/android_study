package com.yunjaena.androidbasic

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AddViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view)
        // 아이템 리스트 준비
        val carList = ArrayList<CarForList>()
        for (i in 0 until 10) {
            carList.add(CarForList("$i 번째 자동차", "$i 순위 엔진"))
        }

        val container = findViewById<LinearLayout>(R.id.addview_container)
        val inflater = LayoutInflater.from(this@AddViewActivity)
        for (i in 0 until carList.size) {
            val itemView = inflater.inflate(R.layout.item_view, null)
            val carNameView: TextView = itemView.findViewById(R.id.car_name)
            val carEngineView: TextView = itemView.findViewById(R.id.car_engine)

            carNameView.text = carList[i].name
            carEngineView.text = carList[i].engine
            container.addView(itemView)
        }

    }


}

data class CarForList(val name: String, val engine: String)