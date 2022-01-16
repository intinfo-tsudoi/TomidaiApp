package com.dryad.tomidaiapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SyllabusDatabase::class, TimetableDatabase::class], version = 1, exportSchema = false)
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
                    .createFromAsset("DBtimetable.db")
                    .build()
                INSTANCE_tt = instance

                instance
            }
        }
    }
}