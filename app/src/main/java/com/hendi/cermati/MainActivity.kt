package com.hendi.cermati

import android.app.ActionBar
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.hendi.cermati.Adapter.User_Adp
import com.hendi.cermati.Model.User_Imp
import com.hendi.cermati.Model.User_View
import com.hendi.cermati.Response.Detail
import com.hendi.cermati.Response.User
import com.hendi.cermati.Service.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), User_View {

    var list: MutableList<Detail> = ArrayList()
    lateinit var user_adp: User_Adp
    lateinit var userImp: User_Imp
    var status = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        id_rv.layoutManager = LinearLayoutManager(this)
        user_adp = User_Adp(this, list)
        id_rv.adapter = user_adp
        id_kosong.visibility = View.VISIBLE

        userImp = User_Imp(this)

        serach()
    }

    private fun serach() {
        id_search.addTextChangeListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                status = false
                Handler().postDelayed({
                    if (s!!.isNotEmpty()) {
                        searchUser(s.toString())
                    }
                }, 5000)

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s!!.isNotEmpty()){
                    id_rv.visibility = View.GONE
                    id_kosong.visibility = View.GONE
                    id_loading.visibility = View.VISIBLE
                } else {
                    id_loading.visibility = View.GONE
                    if (list.size > 0) {
                        id_rv.visibility = View.VISIBLE
                        id_kosong.visibility = View.GONE
                    } else{
                        id_rv.visibility = View.GONE
                        id_kosong.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    private fun searchUser(s: String) {
        if (!status && s.isNotEmpty()) {
            userImp.get(s,1,10)
        }
        status = true
    }

    override fun Response(response: User) {
        if (response.items!!.size > 0) {
            id_loading.visibility = View.GONE
            id_rv.visibility = View.VISIBLE
            id_kosong.visibility = View.GONE

            list = response.items as MutableList<Detail>
            user_adp = User_Adp(this, list)
            id_rv.adapter = user_adp
            user_adp.notifyDataSetChanged()
        } else {
            list.clear()
            id_loading.visibility = View.GONE
            id_rv.visibility = View.GONE
            id_kosong.visibility = View.VISIBLE

        }
    }

    override fun Error(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}
