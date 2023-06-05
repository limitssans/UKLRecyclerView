package com.example.uklrecyclerview

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahuser(user: UserRegistrasi)
    @Query("SELECT * FROM UserRegistrasi")
    fun ambiluser(): LiveData<List<UserRegistrasi>>
}