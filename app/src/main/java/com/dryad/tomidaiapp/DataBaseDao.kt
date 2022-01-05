package com.dryad.tomidaiapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DataBaseDao {
    @Insert
    suspend fun insertAll(syllabus: List<DataBase>)
    @Query("SELECT * FROM syllabus_tbl")
    suspend fun getAll(): List<DataBase>
}