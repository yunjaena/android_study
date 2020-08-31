package com.yunjaena.androidbasic

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Internet : AppCompatActivity() {
    lateinit var urlInputEditText: TextView
    lateinit var openWebBrowserButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internet)
        urlInputEditText = findViewById(R.id.internet_address_input_edit_text)
        openWebBrowserButton = findViewById(R.id.open_internet_page_button)
        openWebBrowserButton.setOnClickListener {
            var url = urlInputEditText.text.toString()
            if (url.contains("http") || url.contains("https"))
                Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                    startActivity(this)
                }
            else
                Toast.makeText(applicationContext, "check url", Toast.LENGTH_SHORT).show()
        }

        urlInputEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString() == "abc")
                    Log.d("edit", "text is abc")
                Log.d("edit", "afterTextChanged : " + s)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("edit", "beforeTextChanged : " + s)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("edit", "onTextChanged : " + s)
            }
        })
    }


}
