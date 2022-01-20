package com.dryad.tomidaiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat.startActivities
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_search_data.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader

class TimetableActivity : AppCompatActivity() {

    var set_classnamelang = "JP"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable)
    }

    override fun onResume() {
        super.onResume()
        setContentView(R.layout.activity_timetable)
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this /* Activity context */)
        set_classnamelang = sharedPreferences.getString("timetable_lang", "")!!
        println(set_classnamelang)
        setTimeTable()
    }

    fun setTimeTable(){
        var id: Int = resources.getIdentifier("Mon1", "id", packageName)
        var btn: Button
        val launch = GlobalScope.launch {
            AppDatabase.getDatabase_tt(applicationContext).DataBaseDao_tt().getAll().forEach {
                Log.d("MainActivity", "${it.date_time}${it.classname_jp}${it.classname_en}")
                /*ログに授業名吐き出すよ*/
                if(it.classname != null){
                    id = resources.getIdentifier(it.date_time, "id", packageName)
                    btn = findViewById(id)
                    if(set_classnamelang == "JP"){
                        println(it.classname_jp)
                        btn.text = it.classname_jp
                    }else if(set_classnamelang == "EN"){
                        btn.text = it.classname_en
                        println(it.classname_en)
                    }
                }
            }
        }
    }

    fun onButtonTapped(view: View){
        val str_btn_id = resources.getResourceEntryName(view.id)//そのままだと数字の羅列で出てくるからこれで変換してるよ
        println(str_btn_id)
        val intent = Intent(this, TimetableRegistrationActivity::class.java)
        intent.putExtra("id", str_btn_id)
        startActivities(arrayOf(intent))
    }
}
