package com.yunjaena.androidbasic.phonebook

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.yunjaena.androidbasic.R
import kotlinx.android.synthetic.main.activity_phone_book_main.*
import java.util.*


class PhoneBookMainActivity : AppCompatActivity() {
    private val max: Int = 20
    private val iconUrl: String =
        "https://i.pinimg.com/originals/d9/82/f4/d982f4ec7d06f6910539472634e1f9b1.png"
    private val list: ArrayList<Person> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_main)
        init()
    }

    private fun init() {
        val layoutInflater: LayoutInflater = LayoutInflater.from(this)
        val container: LinearLayout = phone_book_container
        for (i in 0 until max) {
            list.add(Person(getRandomString(5), getRandomPhoneNumber(), iconUrl))
            val itemView = layoutInflater.inflate(R.layout.item_phone_book, null)
            itemView.findViewById<LinearLayout>(R.id.phone_book_item_linear_layout)
                .setOnClickListener { v: View? ->
                    goToPhoneBookDetail(v, i)
                }
            itemView.findViewById<TextView>(R.id.name_text_view).text = list[i].name
            Glide.with(this)
                .load(list[i].iconUrl)
                .into(itemView.findViewById(R.id.icon_image_view))
            container.addView(itemView)
        }
    }

    private fun goToPhoneBookDetail(view: View?, index: Int) {
        Intent(this@PhoneBookMainActivity, PhoneBookDetailActivity::class.java).apply {
            putExtra("name", list[index].name)
            putExtra("number", list[index].phoneNumber)
            putExtra("icon", list[index].iconUrl)
            startActivity(this)
        }
    }

    private fun getRandomString(size: Int): String {
        val generator = Random()
        val randomStringBuilder = StringBuilder()
        var tempChar: Char
        for (i in 0 until size) {
            tempChar = (generator.nextInt(26) + 65).toChar()
            randomStringBuilder.append(tempChar)
        }
        return randomStringBuilder.toString()
    }

    private fun getRandomNumber(size: Int): String {
        val generator = Random()
        val randomStringBuilder = StringBuilder()
        for (i in 0 until size) {
            randomStringBuilder.append(generator.nextInt(10))
        }
        return randomStringBuilder.toString()
    }

    private fun getRandomPhoneNumber(): String {
        val randomStringBuilder = StringBuilder()
        randomStringBuilder.append("010-")
            .append(getRandomNumber(4))
            .append("-")
            .append(getRandomNumber(4))

        return randomStringBuilder.toString()
    }
}
