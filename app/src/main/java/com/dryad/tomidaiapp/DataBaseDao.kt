package com.dryad.tomidaiapp

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DataBaseDao {
    @Insert
    suspend fun insertAll(syllabus: List<DataBase>)
    @Query("SELECT * FROM syllabus_tbl")
    suspend fun getAll(): List<DataBase>
    @Query("SELECT * FROM syllabus_tbl WHERE classregicode = :regicode")
    suspend fun SerachByClassregicode(regicode: String): Array<DataBase>
    @Query("SELECT classname, teacher, period FROM syllabus_tbl WHERE classregicode = :regicode")
    suspend fun SearchDataForRegistration(regicode: String): Array<SylalbusforRegist>
}