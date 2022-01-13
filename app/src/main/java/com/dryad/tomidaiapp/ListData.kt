package com.dryad.tomidaiapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_list_data.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import android.os.Looper




class ListData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("kokomadekitayo")
        setContentView(R.layout.activity_list_data)
        val intent = intent
        getdata = intent.getStringExtra("SEND_DATA").toString()
        println(getdata)
        println("kokomadekitayo")
    }

    var getdata = ""

    override fun onStart() {
        super.onStart()

        //onShow()
        //onResumeでも呼び出すのでいらない
    }

    override fun onResume() {
        super.onResume()

        onShow()
    }

    @SuppressLint("Range")
    fun onShow() {
        /**コルーチンの中にどこまで入れるか要注意**/
        var mainHandler: Handler? = Handler(Looper.getMainLooper())
        val listView = findViewById<ListView>(R.id.listView_syllabus)
        var syllabusData: Syllabus
        var mCustomAdapter: CustomAdapter
        var mSyllabusList: ArrayList<Syllabus> = arrayListOf()
        val launch = GlobalScope.launch {
            val searched: Array<DataBase> = AppDatabase.getDatabase(applicationContext).DataBaseDao().SerachByClassregicode(getdata)
            val searchedList = searched.toList()
            println(searched)
            println(searched.size)
            if(searched.isEmpty()){
                Log.d("ListData", "検索結果がありません" )
            }else {
                Log.d("ListData", "${searched[0]}")
                for (i in searched) {
                    println(i)
                    /**ゴリ押しでカスタムアダプターへ**/
                    syllabusData = Syllabus(
                        classname = i.classname,
                        teacher = i.teacher,
                        classcategory = i.classcategory,
                        classtype = i.classtype,
                        coc = i.coc,
                        period = i.period,
                        faculty = i.faculty,
                        classregicode = i.classregicode,
                        grade = i.grade,
                        classnumcode = i.classnumcode,
                        credit = i.credit,
                        latestupdate = i.latestupdate,
                        officehours = i.officehours,
                        rtadvice = i.rtadvice,
                        objective = i.objective,
                        edugoals = i.edugoals,
                        goals = i.goals,
                        schedule = i.schedule,
                        studyoutside = i.studyoutside,
                        keywords = i.keywords,
                        notice = i.notice,
                        evaluation = i.evaluation,
                        textbooks = i.textbooks,
                        related = i.related,
                        link = i.link,
                        notes = i.notes
                    )
                    mSyllabusList = arrayListOf(syllabusData)
                }
            }
            println(mSyllabusList)
            // adapterを作成します
            mCustomAdapter = CustomAdapter(
                applicationContext, mSyllabusList
            )

            // adapterをlistViewに紐付けます。
            // メインスレッド外でUIはいじれないのでハンドラーで処理するよ
            println(mCustomAdapter)
            mainHandler!!.post { listView_syllabus.adapter = mCustomAdapter }

        }

        println("コルーチン外")
        /*println(mSyllabusList)
        // adapterを作成します
        mCustomAdapter = CustomAdapter(
            this, mSyllabusList
        )

        println(mCustomAdapter)

        // adapterをlistViewに紐付けます。
        listView_syllabus.adapter = mCustomAdapter
*/
        /**カスタムアダプターはコルーチン外のほうが都合よさそう**/
    }





}