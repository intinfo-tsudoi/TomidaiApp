package com.dryad.tomidaiapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DataBaseDao_tt{
    @Insert
    suspend fun insertAll(Timetable: List<TimetableDatabase>)
    @Query("SELECT * FROM Timetable_tbl")
    suspend fun getAll(): List<TimetableDatabase>
    @Query("UPDATE Timetable_tbl SET classname = :classname, teacher = :teacher, classregicode = :classregicode, classroom = :classroom, memo = :memo WHERE date_time = :date_time")
    suspend fun updateTimetable(date_time: String,classname: String,teacher: String,classregicode: String,classroom: String,memo: String?): Int
}