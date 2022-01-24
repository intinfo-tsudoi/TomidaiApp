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
    @Query("UPDATE Timetable_tbl SET classname = :classname, classname_jp = :classname_jp, classname_en = :classname_en, teacher = :teacher, classregicode = :classregicode, classroom = :classroom, memo = :memo, color = :color WHERE date_time = :date_time")
    suspend fun updateTimetable(date_time: String,classname: String,classname_jp: String,classname_en: String,teacher: String,classregicode: String,classroom: String,memo: String?, color: Int): Int
    @Query("SELECT classname FROM Timetable_tbl WHERE date_time = :date_time")
    suspend fun check_empty(date_time: String): String
    @Query("SELECT classregicode FROM TIMETABLE_TBL WHERE date_time = :date_time")
    suspend fun getClassregicode(date_time: String): String
}