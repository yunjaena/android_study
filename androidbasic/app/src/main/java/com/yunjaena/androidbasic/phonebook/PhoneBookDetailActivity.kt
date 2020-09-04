package com.yunjaena.androidbasic.phonebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.yunjaena.androidbasic.R
import kotlinx.android.synthetic.main.activity_phone_book_detail.*

class PhoneBookDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_detail)
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")
        val icon = intent.getStringExtra("icon") ?: ""

        name_text_view.text = name
        number_text_view.text = number
        Glide.with(this)
            .load(icon)
            .error(R.drawable.gradient)
            .circleCrop()
            .into(icon_image_view)
    }
}
