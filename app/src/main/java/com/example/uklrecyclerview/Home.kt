package com.example.uklrecyclerview

import Shoes
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationBarView

class Home : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    private lateinit var rvShoes: RecyclerView
    private var list: ArrayList<Shoes> = arrayListOf()
    lateinit var topNav: NavigationBarView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()

        rvShoes = findViewById(R.id.rv_shoes)
        rvShoes.setHasFixedSize(true)

        topNav = findViewById(R.id.top_navbar)
        topNav.setOnItemSelectedListener(this)

        list.addAll(ShoesData.listData)
        showRecyclerList()

    }

    private fun showRecyclerList() {
        rvShoes.layoutManager = LinearLayoutManager(this)
        val listShoesAdapter = ListShoesAdapter (list)
        rvShoes.adapter = listShoesAdapter


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.navbar_bawah,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }



    private fun showRecyclerGrid(){
        rvShoes.layoutManager = GridLayoutManager(this, 2)
        val gridShoesAdapter = GridShoesAdapter(list)
        rvShoes.adapter= gridShoesAdapter
    }
        private fun setActionBarTitle(title:String){
            if(supportActionBar != null){
                (supportActionBar as ActionBar).title = title
            }
        }

        private fun showSelectedShoes (shoes: Shoes){
            Toast.makeText(this, "Kamu Memilih"+shoes.name, Toast.LENGTH_SHORT).show()



    }




    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.id_list -> {
                Toast.makeText(applicationContext, "List", Toast.LENGTH_SHORT).show()
                title = "Mode List"
                showRecyclerList()
            }
            R.id.id_grid -> {
                Toast.makeText(applicationContext, "Grid", Toast.LENGTH_SHORT).show()
                title = "Mode Grid"
                showRecyclerGrid()
            }
        }
        return true
    }

}