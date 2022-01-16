package com.dryad.tomidaiapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DataBaseDao_sy{
    @Insert
    suspend fun insertAll(syllabus: List<SyllabusDatabase>)
    @Query("SELECT * FROM syllabus_tbl")
    suspend fun getAll(): List<SyllabusDatabase>
    @Query("SELECT * FROM syllabus_tbl WHERE classregicode = :regicode")
    suspend fun SerachByClassregicode(regicode: String): Array<SyllabusDatabase>
    @Query("SELECT classname, teacher, period FROM syllabus_tbl WHERE classregicode = :regicode")
    suspend fun SearchDataForRegistration(regicode: String): Array<SylalbusforRegist>
}