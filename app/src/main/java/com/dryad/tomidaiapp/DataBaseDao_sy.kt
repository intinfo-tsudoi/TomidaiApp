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
    @Query("SELECT classname, classname_jp, classname_en,teacher, period FROM syllabus_tbl WHERE classregicode = :regicode")
    suspend fun SearchDataForRegistration(regicode: String): Array<SylalbusforRegist>
    @Query("SELECT classname_jp FROM Syllabus_tbl WHERE classregicode = :regicode")
    suspend fun getClassname_jp(regicode: String): String
    @Query("SELECT classname_en FROM Syllabus_tbl WHERE classregicode = :regicode")
    suspend fun getClassname_en(regicode: String): String

    @Query("SELECT * FROM syllabus_tbl WHERE classname LIKE '%' || :name || '%' ")
    suspend fun SerachByClassname(name: String): Array<SyllabusDatabase>
    @Query("SELECT * FROM syllabus_tbl WHERE teacher LIKE '%' || :teacher || '%' ")
    suspend fun SerachByTeacher(teacher: String): Array<SyllabusDatabase>
    @Query("SELECT * FROM syllabus_tbl WHERE period LIKE '%' || :period || '%' ")
    suspend fun SerachByPeriod(period: String): Array<SyllabusDatabase>
    @Query("SELECT * FROM syllabus_tbl WHERE faculty = :faculty1")
    suspend fun SerachByFaculty1(faculty1: String): Array<SyllabusDatabase>
    @Query("SELECT * FROM syllabus_tbl WHERE faculty LIKE '%' || :faculty2 || '%' ")
    suspend fun SerachByFaculty2(faculty2: String): Array<SyllabusDatabase>
    @Query("SELECT * FROM syllabus_tbl WHERE grade LIKE '%' || :grade || '%' ")
    suspend fun SerachByGrade(grade: String): Array<SyllabusDatabase>
}