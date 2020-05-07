package com.hendi.cermati

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hendi.cermati.Service.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
