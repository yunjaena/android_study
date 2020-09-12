package com.yunjaena.kotlinbasicstudy.self_study

import android.app.AlertDialog
import android.content.Context

open class Figure(vertex: Int) {
    open fun onFinishDraw() {

    }
}

class Triangle() : Figure(3) {
    override fun onFinishDraw() {
        super.onFinishDraw()
    }
}

class CustomDialog : AlertDialog
{
    constructor(context : Context) : this(context, android.R.style.Theme_NoTitleBar_Fullscreen)
    constructor(context: Context, themId : Int) : super(context, themId)
}