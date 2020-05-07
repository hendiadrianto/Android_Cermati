package com.hendi.cermati.Model

interface User_Prest {
    fun get(name : String,page : Int = 1,per_page : Int = 10)
}