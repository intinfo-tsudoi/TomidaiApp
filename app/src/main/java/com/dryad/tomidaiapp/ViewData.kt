package com.dryad.tomidaiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_view_data.*

class ViewData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_data)
    }

    fun onTappedSearch(view: View){
        val intent = Intent(this, ListData::class.java)
        intent.putExtra("SEND_DATA", edit_text.text.toString())
        startActivities(arrayOf(intent))
    }

    val dbhelper = SyllabusDBHelper(this,"DBSyllabus",null,1)
    val db = dbhelper.writableDatabase

    override fun onDestroy() {

        // DatabaseHelperオブジェクトの解放
        // SQLiteOpenHelper.close(): Databaseオブジェクトの解放
        dbhelper.close()

        // アクティビティの終了
        super.onDestroy()
    }
}