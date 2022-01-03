package com.dryad.tomidaiapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.*

class SyllabusDBHelper
    (context: Context, DBNAME:String, factory: SQLiteDatabase.CursorFactory?, VERSION: Int) :
    SQLiteOpenHelper(context, DBNAME, factory, VERSION) {

    private val serialVersionUID = 1L
    private val DB_FILE_NAME = "SBSyllabus.db" //assetsにあるDBファイル名

    private val DB_NAME = "Syllabus.db" //androidが使うDBファイル名

    private val DB_VERSION = 1
    private var context: Context? = null
    private var dbPath: File? = null
    private var databaseExist = true //適切なDBファイルが存在するか


    fun DatabaseOpenHelper(context: Context) {
        this.context = context
        dbPath = context.getDatabasePath(DB_NAME)
        println(dbPath)
    }

    override fun onCreate(db: SQLiteDatabase?) {
        super.onOpen(db)
        databaseExist = false
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        println(dbPath)
        val databasePath: String? = dbPath?.absolutePath
        val file = File(databasePath)
        if (file.exists()) {
            file.delete()
        }
        databaseExist = false
    }

    override fun getWritableDatabase(): SQLiteDatabase? {
        var database = super.getWritableDatabase()
        if (!databaseExist) {
            try {
                database.close()
                database = copyDatabaseFromAssets()
                databaseExist = true
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return database
    }


    /**
     * assetsにあるデータベースをdata/data/package/databasesにコピーする
     * @throws IOException
     */
    @Throws(IOException::class)
    private fun copyDatabaseFromAssets(): SQLiteDatabase {
        val inputStream: InputStream = context!!.assets.open(DB_FILE_NAME)
        val outputStream: OutputStream = FileOutputStream(dbPath)
        val buffer = ByteArray(1024)
        var size: Int
        while (inputStream.read(buffer).also { size = it } > 0) {
            outputStream.write(buffer, 0, size)
        }
        outputStream.flush()
        outputStream.close()
        inputStream.close()
        return super.getWritableDatabase()
    }

}