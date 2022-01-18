package com.dryad.tomidaiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_timetable_registration.*
import kotlinx.coroutines.runBlocking

class TimetableRegistrationActivity : AppCompatActivity() {

    var getdata: String = "000000"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable_registration)
        val intent = intent
        getdata = intent.getStringExtra("id").toString()
        println(getdata)

        var date: String?
        var time: String?
        var date_str: String? = null
        /* getdataへの処理 */
        date = getdata.substring(0, 3)
        time = getdata.substring(3)
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

        var datetime_str = date_str+time+"限"

        println(datetime_str)

        var set_str = "登録する時間：$datetime_str"

        var datetime_text = findViewById<TextView>(R.id.textView_date_time_timetableRegist)
        datetime_text.text = set_str

        // Spinnerの取得
        //val spinner = findViewById<Spinner>(R.id.spinner1)
        //val spinner2 = findViewById<Spinner>(R.id.spinner2)

    }

    fun SearchButtonTapped(view: View){
        val text_classregicode = editText_classregicode.text.toString()
        Log.d("Searched", text_classregicode)
        if(text_classregicode.length == 6) {
            //コルーチンだけど他のスレッドブロックするよ
            val launch = runBlocking {
                val mainHandler = Handler(Looper.getMainLooper())
                val searched: Array<SylalbusforRegist> =
                    AppDatabase.getDatabase_sy(applicationContext).DataBaseDao_sy()
                        .SearchDataForRegistration(text_classregicode)
                if (searched.isEmpty()) {
                    Log.d("Coroutine", "NoData")
                } else if (searched.size > 1) {
                    Log.d("Coroutine", "検索結果が複数あります")
                    println(searched[0])
                    println(searched.size)
                    mainHandler.post {
                        editText_classname.setText(
                            searched[0].classname,
                            TextView.BufferType.NORMAL
                        )
                        editText_teacher.setText(searched[0].teacher, TextView.BufferType.NORMAL)
                    }
                } else {
                    Log.d("Coroutine", "正常に検索されました")
                    println(searched[0])
                    println(searched.size)
                    mainHandler.post {
                        editText_classname.setText(
                            searched[0].classname,
                            TextView.BufferType.NORMAL
                        )
                        editText_teacher.setText(searched[0].teacher, TextView.BufferType.NORMAL)
                    }
                }
            }
        }
    }

    fun TourokuButtonTapped(view: View){
        val text_classregicode = editText_classregicode.text.toString()
        val text_classname = editText_classname.text.toString()
        val text_teacher = editText_teacher.text.toString()
        val text_classroom = editText_classroom.text.toString()
        val text_memo = editText_memo.text.toString()
        val launch = runBlocking {
            println(getdata)
            val text_classname_jp = AppDatabase.getDatabase_tt(applicationContext).DataBaseDao_sy().getClassname_jp(getdata)
            val text_classname_en = AppDatabase.getDatabase_tt(applicationContext).DataBaseDao_sy().getClassname_jp(getdata)
            val result = AppDatabase.getDatabase_tt(applicationContext).DataBaseDao_tt()
                .updateTimetable(
                    getdata,
                    text_classname,
                    text_classname_jp,
                    text_classname_en,
                    text_teacher,
                    text_classregicode,
                    text_classroom,
                    text_memo
                )
            println("clear")
            Log.d("result", "$result")//1だったら適切に１列更新できているはず
        }
    }

    fun onBackPressed(view: View) {
        super.onBackPressed()
    }


}