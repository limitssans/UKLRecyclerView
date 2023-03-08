package com.example.uklrecyclerview

import Shoes

object ShoesData {
    private val data = arrayOf(
        arrayOf(
            "New Balance 992 JJJJound Grey",
            "IDR !7.350.000",
            R.drawable.nbjjjjound_grey
        ),
        arrayOf(
            "New Balance 990v3 JJJJound Olive",
            "IDR 7.250.000",
            R.drawable.newbalance_jjjjound_olive
        ),
        arrayOf(
            "Nike Air Force 1 Low Louis Vuitton By Virgil Abloh White Green",
            "IDR 68,150,000",
            R.drawable.airforce1_lv_virgiabloh
        ),
        arrayOf(
            "ASICS Gel-Kayano 14 JJJJound Silver Black",
            "IDR 8,700,000",
            R.drawable.asicsgel_jjjjound
        ),
        arrayOf(
            "New Balance 990v4 JJJJound Navy",
            "IDR 6,300,000",
            R.drawable.nbblack_jjjjound
        ),
        arrayOf(
            "Salomon XT-6 Adv Dover Street Market Black",
            "IDR 7,800,000",
            R.drawable.salomonxtblackwebp
        ),
        arrayOf(
            "Nike SB Dunk Low Travis Scott",
            "IDR 13,000,000",
            R.drawable.sbdunklowtravisscott
        ),
        arrayOf(
            "Adidas Campus Invincible x Neighborhood",
            "IDR 4,450,000",
            R.drawable.adidascampusneighborhoodxinvincible
        ),
        arrayOf(
            "Nike Air Force 1 Low Valentine's Day 2023 (W)",
            "IDR 3,550,000",
            R.drawable.nikeaf1valentinelow
        ),
        arrayOf(
            "Nike Dunk Low Retro PRM Valentine's Day (2023)",
            "IDR 1,950,000",
            R.drawable.nikedunklowvalentine
        )
    )

    val listData: ArrayList<Shoes>
        get() {
            val list = arrayListOf<Shoes>()
            for (aData in data) {
                val shoes = Shoes()
                shoes.name = aData[0] as String
                shoes.price = aData[1] as String
                shoes.photo = aData[2] as Int

                list.add(shoes)
            }

            return list
        }
}