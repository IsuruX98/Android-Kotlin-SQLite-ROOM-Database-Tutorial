package com.example.lab03.database

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User)

}