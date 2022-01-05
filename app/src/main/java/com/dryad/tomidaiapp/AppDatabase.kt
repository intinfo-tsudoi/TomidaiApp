package com.dryad.tomidaiapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DataBase::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun DataBaseDao(): DataBaseDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(
            context: Context
        ): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "syllabus_database"
                )
                    .createFromAsset("DBsyllabus.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}