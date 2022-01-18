package com.dryad.tomidaiapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Timetable_tbl")
data class TimetableDatabase(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "date_time") val date_time: String?,
    @ColumnInfo(name = "classname") val classname: String?,
    @ColumnInfo(name = "classname_jp") val classname_en: String?,
    @ColumnInfo(name = "classname_en") val classname_jp: String?,
    @ColumnInfo(name = "teacher") val teacher: String?,
    @ColumnInfo(name = "classregicode") val classregicode: String?,
    @ColumnInfo(name = "classroom") val classroom: String?,
    @ColumnInfo(name = "memo") val memo: String?
)
