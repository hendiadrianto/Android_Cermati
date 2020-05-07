package com.hendi.cermati.Model

import com.hendi.cermati.Response.User
import com.hendi.cermati.Service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class User_Imp (user : User_View) : User_Prest {
    var user_view : User_View? = null
    var api = ApiService
    init {
        user_view = user
    }

    override fun get(name: String, page: Int, per_page: Int) {
        api.retrofit.getUser(name,page,per_page).enqueue(object : Callback<User>{
            override fun onFailure(call: Call<User>, t: Throwable) {
                user_view!!.Error(t.message!!)
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful){
                    user_view!!.Response(response.body()!!)
                }
            }
        })
    }
}