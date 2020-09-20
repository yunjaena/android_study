package com.yunjaena.clonecoding

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {
    @GET("json/students/")
    fun getStudentsList(): Call<ArrayList<PersonFromServer>>

    @POST("json/students/")
    fun createStudent(@Body params: HashMap<String, Any>): Call<PersonFromServer>

    @POST("json/students/")
    fun createStudentEasy(@Body params: PersonFromServer): Call<PersonFromServer>

    @POST("user/signup/")
    @FormUrlEncoded
    fun register(
        @Field("username") username: String,
        @Field("password1") password1: String,
        @Field("password2") password2: String
    ): Call<User>

    @POST("user/login/")
    @FormUrlEncoded
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<User>

    @GET("/instagram/post/list/all/")
    fun getAllPost(): Call<ArrayList<Post>>

    @Multipart
    @POST("instagram/post/")
    fun uploadPost(
        @Part image: MultipartBody.Part,
        @Part("content") requestBody: RequestBody
    ): Call<Post>
}