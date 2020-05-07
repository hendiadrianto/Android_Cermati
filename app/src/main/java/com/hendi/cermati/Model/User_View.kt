package com.hendi.cermati.Model

import com.hendi.cermati.Response.User
import java.lang.Error

interface User_View {
    fun Response(response : User)
    fun Error (text : String)
}