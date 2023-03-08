package com.example.uklrecyclerview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button

    private val key_Email = "MM"
    private val key_password = "EE"

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        email = findViewById(R.id.username)
        password = findViewById(R.id.password)

        val btnLogin: Button = findViewById(R.id.btnLogin)
        btnRegister = findViewById(R.id.btnRegister)
        btnLogin.setOnClickListener(this)
        btnRegister.setOnClickListener(this)
    }

    override fun onClick(v: View){
        val username = email.text.toString()
        val password = password.text.toString()
        when(v.id) {
            R.id.btnLogin ->{
                if (username.isNotBlank() && password.isNotBlank()){
                    val moveIntent = Intent(this@MainActivity, Home::class.java)
                    moveIntent.putExtra(key_Email, username)
                    moveIntent.putExtra(key_password, password)
                    startActivity(moveIntent)
                }
            }
            R.id.btnRegister ->{
                val moveIntent = Intent(this@MainActivity, RegisterActivity::class.java)
                startActivity(moveIntent)
            }
        }

    }

}

