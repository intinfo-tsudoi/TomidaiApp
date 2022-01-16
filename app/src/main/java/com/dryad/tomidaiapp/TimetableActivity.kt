package com.dryad.tomidaiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat.startActivities
import kotlinx.android.synthetic.main.activity_search_data.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader

class TimetableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable)
        setTimeTable()
    }

    fun setTimeTable(){
        val launch = GlobalScope.launch {
            AppDatabase.getDatabase_tt(applicationContext).DataBaseDao_tt().getAll().forEach {
                Log.d("MainActivity", "${it.date_time}${it.classname}")
                /*ログに授業名吐き出すよ*/
            }
        }
    }

    fun ButtonTapped(view: View){
        val str_btn_id = resources.getResourceEntryName(view.id)//そのままだと数字の羅列で出てくるからこれで変換してるよ
        println(str_btn_id)
        val intent = Intent(this, TimetableRegistrationActivity::class.java)
        intent.putExtra("id", str_btn_id)
        startActivities(arrayOf(intent))
    }
}
