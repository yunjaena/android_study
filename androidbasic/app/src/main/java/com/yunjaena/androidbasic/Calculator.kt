package com.yunjaena.androidbasic

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculator.*

class Calculator : AppCompatActivity(), View.OnClickListener {
    var isFirstInput = true
    var currentValue = 0
    var tempNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        init();
    }

    private fun init() {
        one_text_view.setOnClickListener(this)
        two_text_view.setOnClickListener(this)
        three_text_view.setOnClickListener(this)
        ca_text_view.setOnClickListener(this)
        four_text_view.setOnClickListener(this)
        five_text_view.setOnClickListener(this)
        six_text_view.setOnClickListener(this)
        seven_text_view.setOnClickListener(this)
        eight_text_view.setOnClickListener(this)
        nine_text_view.setOnClickListener(this)
        plus_text_view.setOnClickListener(this)
        zero_text_view.setOnClickListener(this)
        updateUI(0)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.one_text_view -> pressNumber(1)
            R.id.two_text_view -> pressNumber(2)
            R.id.three_text_view -> pressNumber(3)
            R.id.ca_text_view -> clearButton()
            R.id.four_text_view -> pressNumber(4)
            R.id.five_text_view -> pressNumber(5)
            R.id.six_text_view -> pressNumber(6)
            R.id.seven_text_view -> pressNumber(7)
            R.id.eight_text_view -> pressNumber(8)
            R.id.nine_text_view -> pressNumber(9)
            R.id.plus_text_view -> pressedPlusButton()
            R.id.zero_text_view -> pressNumber(0)
        }
    }

    private fun pressNumber(num: Int) {
        if (isFirstInput && num == 0)
            return
        else if (isFirstInput) {
            tempNumber = num
            isFirstInput = false
            updateUI(tempNumber)
            return
        }

        tempNumber = (result_text_view.text.toString() + num.toString()).toInt()
        updateUI(tempNumber)
    }

    private fun clearButton() {
        isFirstInput = true
        tempNumber = 0
        currentValue = 0
        updateUI(currentValue)
    }

    private fun pressedPlusButton() {
        isFirstInput = true
        currentValue += tempNumber
        updateUI(currentValue)
        tempNumber = 0
    }


    private fun updateUI(num : Int) {
        result_text_view.text = num.toString()
    }


}
