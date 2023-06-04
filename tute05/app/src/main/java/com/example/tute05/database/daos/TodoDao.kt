package com.example.tute05.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.tute05.database.entities.Todo

@Dao
interface TodoDao {

    @Insert
    suspend fun insertTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)

    @Query("SELECT * FROM Todo")
    fun getAllTodos(): List<Todo>

}