package com.dryad.tomidaiapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import kotlinx.android.synthetic.main.activity_results1.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import android.os.Looper
import androidx.fragment.app.DialogFragment
import java.util.*
import kotlin.collections.ArrayList

class Results2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.`activity_results2`)

        val intent = intent
        getdata1 = intent.getStringExtra("SEND_DATA1").toString()
        println(getdata1)
        getdata2 = intent.getStringExtra("SEND_DATA2").toString()
        println(getdata2)
        getdata3 = intent.getStringExtra("SEND_DATA3").toString()
        println(getdata3)
        getdata4 = intent.getStringExtra("SEND_DATA4").toString()
        println(getdata4)
        getdata5 = intent.getStringExtra("SEND_DATA5").toString()
        println(getdata5)
        getdata6 = intent.getStringExtra("SEND_DATA6").toString()
        println(getdata6)

        if(getdata1 == "教養教育"){
            getdata2 = "教養教育"
        }
        if(getdata1 == "人文学部"){
            getdata2 = "人文学部"
        }
        if(getdata1 == "人間発達科学部"){
            getdata2 = "人間発達科学部"
        }
        if(getdata1 == "芸術文化学部"){
            getdata2 = "芸術文化学部"
        }

        if(getdata4 == "1年"){
            getdata4 = "1"
        }else if(getdata4 == "2年"){
            getdata4 = "2"
        }else if(getdata4 == "3年"){
            getdata4 = "3"
        }else{
            getdata4 = "4"
        }

        if(getdata3 == "通年"){
            kikan2 = "通"
        }else {
            kikan1 = "$getdata3・$getdata5$getdata6"
            kikan2 = kikan1.removeSuffix("限")
        }

    }

    var getdata1 = ""
    var getdata2 = ""
    var getdata3 = ""
    var getdata4 = ""
    var getdata5 = ""
    var getdata6 = ""

    var kikan1 = ""
    var kikan2 = ""


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
        var syllabusData: Syllabus
        var mCustomAdapter: CustomAdapter
        var mSyllabusList: ArrayList<Syllabus> = arrayListOf()
        val launch = GlobalScope.launch {
            val searched1_1: Array<SyllabusDatabase> = AppDatabase.getDatabase_sy(applicationContext).DataBaseDao_sy().SerachByFaculty1(getdata2)
            val searched1_2: Array<SyllabusDatabase> = AppDatabase.getDatabase_sy(applicationContext).DataBaseDao_sy().SerachByFaculty2(getdata2)
            val searched1_3: Array<SyllabusDatabase> = AppDatabase.getDatabase_sy(applicationContext).DataBaseDao_sy().SerachByFaculty1(getdata1)
            val searched1_4: Array<SyllabusDatabase> = AppDatabase.getDatabase_sy(applicationContext).DataBaseDao_sy().SerachByFaculty2(getdata1)
            val searched2: Array<SyllabusDatabase> = AppDatabase.getDatabase_sy(applicationContext).DataBaseDao_sy().SerachByPeriod(kikan2)
            val searched3: Array<SyllabusDatabase> = AppDatabase.getDatabase_sy(applicationContext).DataBaseDao_sy().SerachByGrade(getdata4)
            var j = 0
            var k = 0
            for(i in searched3){
                if(searched2.contains(searched3[j])){
                    if(searched1_1.contains(searched3[j])){
                        println(i)
                        /**ゴリ押しでカスタムアダプターへ**/
                        /**classname_jp,classname_enは今のところ入れない**/
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
                        mSyllabusList += arrayListOf(syllabusData)
                        k += 1
                    }else if(searched1_2.contains(searched3[j])){
                        println(i)
                        /**ゴリ押しでカスタムアダプターへ**/
                        /**classname_jp,classname_enは今のところ入れない**/
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
                        mSyllabusList += arrayListOf(syllabusData)
                        k += 1
                    }
                    if(getdata1 == "理学部"){
                        if(searched1_3.contains(searched3[j])){
                            println(i)
                            /**ゴリ押しでカスタムアダプターへ**/
                            /**classname_jp,classname_enは今のところ入れない**/
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
                            mSyllabusList += arrayListOf(syllabusData)
                            k += 1
                        }else if(searched1_4.contains(searched3[j])){
                            println(i)
                            /**ゴリ押しでカスタムアダプターへ**/
                            /**classname_jp,classname_enは今のところ入れない**/
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
                            mSyllabusList += arrayListOf(syllabusData)
                            k += 1
                        }
                    }

                }
                j+=1
            }

            if(k == 0){
                Log.d("Results2", "検索結果がありません" )
                val dialogFragment: DialogFragment = result_404_DialogFragment()
                dialogFragment.show(supportFragmentManager, "result_404_dialog")
            }else{
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
