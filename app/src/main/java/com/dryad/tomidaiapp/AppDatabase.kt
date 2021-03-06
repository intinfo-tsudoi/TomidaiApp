package com.dryad.tomidaiapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = [SyllabusDatabase::class, TimetableDatabase::class], version = 4, exportSchema = false)//最終アップデート：2022/01/25
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
                        addMigrations(MIGRATION_sy_1_2)
                        addMigrations(MIGRATION_sy_2_3)
                        addMigrations(MIGRATION_sy_3_4)
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
                        addMigrations(MIGRATION_tt_1_2)
                        addMigrations(MIGRATION_tt_2_3)
                        addMigrations(MIGRATION_tt_3_4)
                    }
                    .createFromAsset("DBtimetable.db")
                    .build()
                INSTANCE_tt = instance

                instance
            }
        }
    }
}

val MIGRATION_sy_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE Syllabus_tbl add classname_jp TEXT DEFAULT null;")
        database.execSQL("ALTER TABLE Syllabus_tbl add classname_en TEXT DEFAULT null;")
        println("sy Migration Complete")
    }
}

val MIGRATION_tt_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE Timetable_tbl add classname_jp TEXT DEFAULT null;")
        database.execSQL("ALTER TABLE Timetable_tbl add classname_en TEXT DEFAULT null;")
        println("tt Migration Complete")
    }
}

val MIGRATION_sy_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("DELETE FROM Timetable_tbl")
        println("sy Migration Complete")
    }
}

val MIGRATION_tt_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {

    }
}

val MIGRATION_sy_3_4 = object : Migration(3, 4) {
    override fun migrate(database: SupportSQLiteDatabase) {
    }
}

val MIGRATION_tt_3_4 = object : Migration(3, 4) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE Timetable_tbl add color INTEGER DEFAULT 1;")
        println("tt Migration Complete")
    }
}
