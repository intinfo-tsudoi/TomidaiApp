package com.dryad.tomidaiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_list_data.*
import kotlinx.android.synthetic.main.activity_timetable_registration.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TimetableRegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable_registration)

        // Spinnerの取得
        val spinner = findViewById<Spinner>(R.id.spinner1)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)

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