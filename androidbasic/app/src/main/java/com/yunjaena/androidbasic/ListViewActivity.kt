package com.yunjaena.androidbasic

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val carList = ArrayList<CarForList>()
        for (i in 0 until 50) {
            carList.add(CarForList("$i 번째 자동차", "$i 순위 엔진"))
        }

        val adapter = ListViewAdapter(carList, this as android.content.Context)
        list_view.adapter = adapter
        list_view.setOnItemClickListener { parent, view, position, id ->
            val carName = (adapter.getItem(position) as CarForList).name
            val carEngine = (adapter.getItem(position) as CarForList).engine
            Toast.makeText(this@ListViewActivity, "$carName $carEngine", Toast.LENGTH_SHORT).show()
        }
    }
}

class ListViewAdapter(
    val carForList: ArrayList<CarForList>,
    val context: android.content.Context
) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(context)
//        val view = layoutInflater.inflate(R.layout.item_view, null)
//        val carNameTextView = view.findViewById<TextView>(R.id.car_name)
//        val carEngineTextView = view.findViewById<TextView>(R.id.car_engine)
//
//        carNameTextView.text = carForList.get(position).name
//        carEngineTextView.text = carForList.get(position).engine
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            Log.d("convert", "1")
            view = layoutInflater.inflate(R.layout.item_view, null)
            holder = ViewHolder()

            holder.carName = view.findViewById(R.id.car_name)
            holder.carEngine = view.findViewById(R.id.car_name)

            view.tag = holder
        } else {
            Log.d("convert", "2")
            holder = convertView.tag as ViewHolder
            view = convertView
        }

        holder.carName?.text = carForList.get(position).name
        holder.carEngine?.text = carForList.get(position).engine
        return view
    }

    override fun getItem(position: Int): Any {
        // 그리고자 하는 아이템 리스트의 하나(포지션에 해당하는)
        return carForList.get(position)
    }

    override fun getItemId(position: Int): Long {
        // 해당 포지션에 위치해 있는 아이템 뷰의 아이디 설정
        return position.toLong()
    }

    override fun getCount(): Int {
        // 그리고자 ㅎ나느 아이템 리슽의 전체 갯수
        return carForList.size
    }

}

class ViewHolder {
    var carName: TextView? = null
    var carEngine: TextView? = null
}