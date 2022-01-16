package com.dryad.tomidaiapp

import androidx.room.ColumnInfo
import androidx.room.ColumnInfo.*
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Syllabus_tbl")
data class SyllabusDatabase(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int?,
    @ColumnInfo(name = "classname", typeAffinity = TEXT) val classname: String?,
    @ColumnInfo(name = "teacher", typeAffinity = UNDEFINED) val teacher: String?,
    @ColumnInfo(name = "classcategory", typeAffinity = UNDEFINED) val classcategory: String?,
    @ColumnInfo(name = "classtype", typeAffinity = UNDEFINED) val classtype: String?,
    @ColumnInfo(name = "coc", typeAffinity = UNDEFINED) val coc: String?,
    @ColumnInfo(name = "period", typeAffinity = UNDEFINED) val period: String?,
    @ColumnInfo(name = "faculty", typeAffinity = UNDEFINED) val faculty: String?,
    @ColumnInfo(name = "classregicode", typeAffinity = UNDEFINED) val classregicode: String?,
    @ColumnInfo(name = "grade", typeAffinity = UNDEFINED) val grade: String?,
    @ColumnInfo(name = "classnumcode", typeAffinity = UNDEFINED) val classnumcode: String?,
    @ColumnInfo(name = "credit", typeAffinity = UNDEFINED) val credit: String?,
    @ColumnInfo(name = "latestupdate", typeAffinity = UNDEFINED) val latestupdate: String?,
    @ColumnInfo(name = "officehours", typeAffinity = UNDEFINED) val officehours: String?,
    @ColumnInfo(name = "rtadvice", typeAffinity = UNDEFINED) val rtadvice: String?,
    @ColumnInfo(name = "objective", typeAffinity = UNDEFINED) val objective: String?,
    @ColumnInfo(name = "edugoals", typeAffinity = UNDEFINED) val edugoals: String?,
    @ColumnInfo(name = "goals", typeAffinity = UNDEFINED) val goals: String?,
    @ColumnInfo(name = "schedule", typeAffinity = UNDEFINED) val schedule: String?,
    @ColumnInfo(name = "studyoutside", typeAffinity = UNDEFINED) val studyoutside: String?,
    @ColumnInfo(name = "keywords", typeAffinity = UNDEFINED) val keywords: String?,
    @ColumnInfo(name = "notice", typeAffinity = UNDEFINED) val notice: String?,
    @ColumnInfo(name = "evaluation", typeAffinity = UNDEFINED) val evaluation: String?,
    @ColumnInfo(name = "textbooks", typeAffinity = UNDEFINED) val textbooks: String?,
    @ColumnInfo(name = "related", typeAffinity = UNDEFINED) val related: String?,
    @ColumnInfo(name = "link", typeAffinity = UNDEFINED) val link: String?,
    @ColumnInfo(name = "notes", typeAffinity = UNDEFINED) val notes: String?
)
