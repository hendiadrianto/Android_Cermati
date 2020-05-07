package com.hendi.cermati.Service

import com.hendi.cermati.Response.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BaseApi {
    @GET("/search/users")
    fun getUser(
        @Query("q") user: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): Call<User>
}