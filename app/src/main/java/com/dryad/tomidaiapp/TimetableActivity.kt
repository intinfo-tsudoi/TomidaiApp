package com.dryad.tomidaiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_search_data.*
import kotlinx.android.synthetic.main.activity_timetable.*
import kotlinx.android.synthetic.main.activity_timetable_registration.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TimetableActivity : AppCompatActivity() {

    var set_classnamelang:String = "JP"
    var set_timetable_extend:Boolean = false
    var editable:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable)
    }

    override fun onResume() {
        super.onResume()
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this /* Activity context */)
        set_classnamelang = sharedPreferences.getString("timetable_lang", "JP")!!
        set_timetable_extend = sharedPreferences.getBoolean("timetable_extend", false)
        if(set_timetable_extend) {
            setContentView(R.layout.activity_timetable_extend)
        }else{
            setContentView(R.layout.activity_timetable)
        }
        println(set_classnamelang)
        setTimeTable()
        if(editable){
            edit_tt.text = "編集終了"
        }else{
            edit_tt.text = "編集する"
        }
    }

    fun setTimeTable(){
        var id: Int = resources.getIdentifier("Mon1", "id", packageName)
        var btn: Button
        val launch = GlobalScope.launch {
            val mainHandler = Handler(Looper.getMainLooper())
            AppDatabase.getDatabase_tt(applicationContext).DataBaseDao_tt().getAll().forEach {
                Log.d("MainActivity", "${it.date_time}${it.classname_jp}${it.classname_en}")
                /*ログに授業名吐き出すよ*/
                if(!set_timetable_extend){
                    if(it.date_time!!.contains("6") || it.date_time!!.contains("7")) {
                        return@forEach
                    }
                }
                if(it.classname != null){
                    id = resources.getIdentifier(it.date_time, "id", packageName)
                    btn = findViewById(id)
                    if (set_classnamelang == "JP") {
                        println(it.classname_jp)
                        btn.text = it.classname_jp
                    } else if (set_classnamelang == "EN") {
                        btn.text = it.classname_en
                        println(it.classname_en)
                    }
                }
            }
        }
    }

    fun onEachButtonTapped(view: View){
        val str_btn_id = resources.getResourceEntryName(view.id)//そのままだと数字の羅列で出てくるからこれで変換してるよ
        println(str_btn_id)
        if(editable){
            val intent = Intent(this, TimetableRegistrationActivity::class.java)
            intent.putExtra("id", str_btn_id)
            startActivities(arrayOf(intent))
        }else{
            /*授業詳細がでるようにしたい*/
            var classregicode: String
            val launch = runBlocking {
                classregicode = AppDatabase.getDatabase_tt(applicationContext).DataBaseDao_tt().getClassregicode(str_btn_id)
            }
            if(classregicode.isNotEmpty()) {
                val intent = Intent(this, ListData::class.java)
                intent.putExtra("SEND_DATA", classregicode)
                startActivities(arrayOf(intent))
            }
        }
    }

    fun onTappedEdit(view: View){
        if(editable){
            editable = false
            edit_tt.text = "編集する"
            println("editable = false")
        }else{
            editable = true
            edit_tt.text = "完了"
            println("editable = true")
        }

    }
}
