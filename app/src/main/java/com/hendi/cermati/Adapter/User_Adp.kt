package com.hendi.cermati.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hendi.cermati.R
import com.hendi.cermati.Response.Detail
import kotlinx.android.synthetic.main.layout_users.view.*

class User_Adp (internal var mContext : Context, internal var list : List<Detail>) : RecyclerView.Adapter<User_Adp.viewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): User_Adp.viewHolder {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.layout_users,parent,false)

        return viewHolder(layout)
    }

    inner class viewHolder(view : View) : RecyclerView.ViewHolder(view) {
        fun data(item: Detail) {
            Glide.with(mContext).load(item.avatar_url).into(itemView.id_image_user)
            itemView.id_name_user.text = item.login
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: User_Adp.viewHolder, position: Int) {
        holder.data(list[position])
    }
}