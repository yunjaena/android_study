package com.yunjaena.melon

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("/youtube/list")
    fun getSongList(): Call<ArrayList<Song>>
}