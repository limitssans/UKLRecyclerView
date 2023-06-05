package com.example.uklrecyclerview

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserRegistrasi (
    @PrimaryKey(autoGenerate = true)
    val userId: Int? = null,
    val nama : String,
    val email: String,
    val password : String,
    val date: String
)