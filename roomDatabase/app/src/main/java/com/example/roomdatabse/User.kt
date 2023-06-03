package com.example.roomdatabse

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    val firstName: String = "",
    val lastname: String = "",
){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}
