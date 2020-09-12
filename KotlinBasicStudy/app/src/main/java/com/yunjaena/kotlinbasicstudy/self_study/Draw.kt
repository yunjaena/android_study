package com.yunjaena.kotlinbasicstudy.self_study

interface FinishDraw {
    var distance: Int

    open fun onFinishDraw()
}

open class FigureTwo(var vertex: Int) : FinishDraw {
    override var distance: Int
        get() = vertex
        set(value) {}

    override fun onFinishDraw() {

    }
}