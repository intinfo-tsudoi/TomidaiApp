package com.dryad.tomidaiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_timetable_registration.*
import kotlinx.coroutines.runBlocking

class TimetableRegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable_registration)
        val intent = intent
        val getdata = intent.getStringExtra("id")
        println(getdata)

        var date: String? = null
        var time: String? = null
        var date_str: String? = null
        var datetime_str: String? = null
        //getdataへの処理
        if(getdata!=null) {
            date = getdata.substring(0, 3)
            time = getdata.substring(3)
        }
        println(date)
        println(time)

        if(date == "Mon"){
            date_str = "月曜"
        }else if(date == "Tue"){
            date_str = "火曜"
        }else if(date == "Wed"){
            date_str = "水曜"
        }else if(date == "Thu"){
            date_str = "木曜"
        }else if(date == "Fri"){
            date_str = "金曜"
        }

        datetime_str = date_str+time+"限"

        println(datetime_str)

        var datetime_text = findViewById<TextView>(R.id.textView_date_time_timetableRegist)
        datetime_text.text = "登録する時間：$datetime_str"

        // Spinnerの取得
        //val spinner = findViewById<Spinner>(R.id.spinner1)
        //val spinner2 = findViewById<Spinner>(R.id.spinner2)

        // 各EditTextの取得
        var edit_Classregicode = findViewById<EditText>(R.id.editText_classregicode)
        var edit_Classname = findViewById<EditText>(R.id.editText_classname)
        var edit_Teacher = findViewById<EditText>(R.id.editText_teacher)
        var edit_classroom = findViewById<EditText>(R.id.editText_classroom)
    }

    fun SearchButtonTapped(view: View){
        val text_classregicode = editText_classregicode.text.toString()
        var flag: Int = 0
        Log.d("Searched", "$text_classregicode")
        if(text_classregicode.length == 6) {
            var searchedData: SylalbusforRegist? = null
            //コルーチンだけど他のスレッドブロックするよ
            val launch = runBlocking {
                var mainHandler: Handler? = Handler(Looper.getMainLooper())
                val searched: Array<SylalbusforRegist> =
                    AppDatabase.getDatabase(applicationContext).DataBaseDao()
                        .SearchDataForRegistration(text_classregicode)
                if (searched.isEmpty()) {
                    Log.d("Coroutine", "NoData")
                    flag = 1
                } else if (searched.size > 1) {
                    Log.d("Coroutine", "検索結果が複数あります")
                    println(searched[0])
                    println(searched.size)
                    mainHandler!!.post {
                        editText_classname.setText(
                            searched[0].classname,
                            TextView.BufferType.NORMAL
                        )
                        editText_teacher.setText(searched[0].teacher, TextView.BufferType.NORMAL)
                    }
                    flag = 1
                } else {
                    Log.d("Coroutine", "正常に検索されました")
                    println(searched[0])
                    println(searched.size)
                    mainHandler!!.post {
                        editText_classname.setText(
                            searched[0].classname,
                            TextView.BufferType.NORMAL
                        )
                        editText_teacher.setText(searched[0].teacher, TextView.BufferType.NORMAL)
                    }
                    flag = 1
                }
            }
        }
    }

    fun TourokuButtonTapped(view: View){
        val text_classregicode = editText_classregicode.text.toString()
        val text_classname = editText_classname.text.toString()
        val text_teacher = editText_teacher.text.toString()
        val text_classroom = editText_classroom.text.toString()

    }

    fun onBackPressed(view: View) {
        super.onBackPressed()
    }


}