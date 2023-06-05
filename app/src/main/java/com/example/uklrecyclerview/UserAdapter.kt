package com.example.uklrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val context: Context, private val items: ArrayList<UserRegistrasi>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    class ViewHolder (itemView:View):RecyclerView.ViewHolder(itemView) {
        private var txtUserName: TextView = itemView.findViewById(R.id.txtUserName)
        private var txtUserEmail: TextView = itemView.findViewById(R.id.txtUserEmail)
        private var txtDate: TextView = itemView.findViewById(R.id.txtDate)

        fun bindItem(item: UserRegistrasi){
            txtUserName.text = item.nama
            txtUserEmail.text = item.email
            txtDate.text = item.date
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(context).inflate(R.layout.user_item, parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        holder.bindItem(items.get(position))
    }
    override fun getItemCount(): Int = items.size
}