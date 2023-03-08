package com.example.uklrecyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val viewpager: ViewPager = findViewById(R.id.view_pager)
        val tabs : TabLayout = findViewById(R.id.tabs)
        viewpager.adapter = ViewPagerAdapter(this, supportFragmentManager)
        tabs.setupWithViewPager(viewpager)
    }
}