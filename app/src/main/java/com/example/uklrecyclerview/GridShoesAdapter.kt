package com.example.uklrecyclerview

import Shoes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridShoesAdapter (private val listShoes: ArrayList<Shoes>): RecyclerView.Adapter<GridShoesAdapter.GridViewHolder>() {


    class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.nama)
        var tvHarga: TextView = itemView.findViewById(R.id.harga)
        var imgPhoto: ImageView = itemView.findViewById(R.id.gridshoes)
               }

    override fun onCreateViewHolder( viewGroup: ViewGroup, i: Int): GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_grid_shoes, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val(name,price,photo)=listShoes[position]
        Glide.with(holder.itemView.context)
            .load(listShoes[position].photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvHarga.text = price
    }

    override fun getItemCount(): Int {
        return listShoes.size
    }
}