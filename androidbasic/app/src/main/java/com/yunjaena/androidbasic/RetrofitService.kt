package com.yunjaena.androidbasic

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("json/students/")
    fun getStudentsList() : Call<ArrayList<PersonFromServer>>
}