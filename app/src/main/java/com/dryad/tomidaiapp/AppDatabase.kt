package com.dryad.tomidaiapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [SyllabusDatabase::class, TimetableDatabase::class], version = 2, exportSchema = false)//最終アップデート：2022/01/19
abstract class AppDatabase: RoomDatabase() {
    abstract fun DataBaseDao_sy(): DataBaseDao_sy
    abstract fun DataBaseDao_tt(): DataBaseDao_tt

    companion object {
        @Volatile
        private var INSTANCE_sy: AppDatabase? = null
        private var INSTANCE_tt: AppDatabase? = null

        fun getDatabase_sy(
            context: Context
        ): AppDatabase {
            return INSTANCE_sy ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "syllabus_database"
                )
                    .apply {
                        addMigrations(MIGRATION_1_2)
                    }
                    .createFromAsset("DBsyllabus.db")
                    .build()
                INSTANCE_sy = instance

                instance
            }
        }

        fun getDatabase_tt(
            context: Context
        ): AppDatabase {
            return INSTANCE_tt ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "timetable_database"
                )
                    .apply {
                        addMigrations(MIGRATION_1_2)
                    }
                    .createFromAsset("DBtimetable.db")
                    .build()
                INSTANCE_tt = instance

                instance
            }
        }
    }
}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("CREATE TABLE Syllabus_tbl(" +
                " id INTEGER PRIMARY KEY, classname TEXT, classname_jp TEXT, classname_en TEXT, teacher TEXT, classcategory TEXT, classtype TEXT, coc TEXT, period TEXT, faculty TEXT, classregicode TEXT, grade TEXT, classnumcode TEXT, credit TEXT, latestupdate TEXT, officehours TEXT, rtadvice TEXT, objective TEXT, edugoals TEXT, goals TEXT, schedule TEXT, studyoutside TEXT, keywords TEXT, notice TEXT, evaluation TEXT, textbooks TEXT, related TEXT, link TEXT, notes TEXT)")
        database.execSQL("CREATE TABLE Timetable_tbl(" +
                " id INTEGER PRIMARY KEY, date_time TEXT, classname TEXT, classname_jp TEXT, classname_en TEXT, teacher TEXT, classregicode TEXT, classroom TEXT, memo TEXT)")
    }
}