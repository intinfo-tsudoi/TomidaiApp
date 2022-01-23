package com.dryad.tomidaiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_timetable_registration.*
import kotlinx.coroutines.runBlocking

class TimetableRegistrationActivity : AppCompatActivity(), check_update_DialogFragment.check_update_DialogLister {

    var getdata: String = "Mon1"
    var datetime_str: String = "月曜１限"

    var text_classname = ""
    var text_teacher = ""
    var text_classroom = ""
    var text_memo = ""
    var text_classregicode = ""
    var text_classname_jp = ""
    var text_classname_en = ""


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

        datetime_str = date_str+time+"限"
        //db側を時限半角にするならいらないよーー
        datetime_str = datetime_str.replace("1","１" ).replace("2","２" ).replace("3","３" ).replace("4","４" ).replace("5","５" ).replace("6","６" ).replace("7","７" )
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
                    val dialogFragment: DialogFragment = result_null_DialogFragment()
                    dialogFragment.show(supportFragmentManager, "result_null_dialog")
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
                    println(searched[0].period)
                    println(searched[0].period!!.indexOf(datetime_str))
                    println(datetime_str)
                    if(searched[0].period!!.indexOf(datetime_str) == -1){
                        val dialogFragment: DialogFragment = result_nomacth_DialogFragment()
                        val args = Bundle()
                        args.putString("date_time", datetime_str)
                        dialogFragment.arguments = args
                        dialogFragment.show(supportFragmentManager, "resulr_nomatch_dialog")
                    }else{
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
        }else{
            val dialogFragment: DialogFragment = result_inputerror_DialogFragment()
            dialogFragment.show(supportFragmentManager, "result_inputerror_dialog")
        }
    }

    fun TourokuButtonTapped(view: View){
        text_classname = editText_classname.text.toString()
        text_teacher = editText_teacher.text.toString()
        text_classroom = editText_classroom.text.toString()
        text_memo = editText_memo.text.toString()
        text_classregicode = editText_classregicode.text.toString()
        if(text_classregicode.length != 6){
            val dialogFragment: DialogFragment = result_inputerror_DialogFragment()
            dialogFragment.show(supportFragmentManager, "result_inputerror_dialog")
        }else{
            val launch = runBlocking {
                println(getdata)
                text_classname_jp = AppDatabase.getDatabase_sy(applicationContext).DataBaseDao_sy()
                    .getClassname_jp(text_classregicode)
                text_classname_en = AppDatabase.getDatabase_sy(applicationContext).DataBaseDao_sy()
                    .getClassname_en(text_classregicode)
                if(AppDatabase.getDatabase_tt(applicationContext).DataBaseDao_tt().check_empty(getdata).isNotEmpty()){
                    val dialogFragment: DialogFragment = check_update_DialogFragment()
                    val args = Bundle()
                    args.putString("date_time", datetime_str)
                    dialogFragment.arguments = args
                    dialogFragment.show(supportFragmentManager, "check_update_dialog")
                }else{
                    println(getdata)
                    set_classdata()
                }
            }
        }
    }

    override fun onDialogPositiveClick(dialog: DialogFragment) {
        println("NoticeDialogでOKボタンが押されたよ！")
        set_classdata()
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        println("NoticeDialogでCancelボタンが押されたよ！")
    }

    public fun set_classdata(){
        val launch = runBlocking {
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