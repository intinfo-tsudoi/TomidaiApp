package com.dryad.tomidaiapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CustomAdapter(context: Context, var mSyllabusList: ArrayList<Syllabus>) : ArrayAdapter<Syllabus>(context, 0, mSyllabusList) {

    private val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // syllabusの取得
        val syllabus = mSyllabusList[position]
        println("シラバス："+syllabus)

        // レイアウトの設定
        var view = convertView //valにするとviewがnullになって死ぬよ⇒valはReadOnly varはReadableWriteable
        if(convertView ==null) {
            view = layoutInflater.inflate(R.layout.list_item, parent, false)
        }
        // 各Viewの設定
        val classname = view?.findViewById<TextView>(R.id.classname)
        classname?.text = syllabus.classname

        val teacher = view?.findViewById<TextView>(R.id.teacher)
        teacher?.text = syllabus.teacher

        val classcategory = view?.findViewById<TextView>(R.id.classcategory)
        classcategory?.text = syllabus.classcategory

        val classtype = view?.findViewById<TextView>(R.id.classtype)
        classtype?.text = syllabus.classtype

        val coc = view?.findViewById<TextView>(R.id.coc)
        coc?.text = syllabus.coc

        val period = view?.findViewById<TextView>(R.id.period)
        period?.text = syllabus.period

        val faculty = view?.findViewById<TextView>(R.id.faculty)
        faculty?.text = syllabus.faculty

        val classregicode = view?.findViewById<TextView>(R.id.classregicode)
        classregicode?.text = syllabus.classregicode

        val grade = view?.findViewById<TextView>(R.id.grade)
        grade?.text = syllabus.grade

        val classnumcode = view?.findViewById<TextView>(R.id.classnumcode)
        classnumcode?.text = syllabus.classnumcode

        val credit = view?.findViewById<TextView>(R.id.credit)
        credit?.text = syllabus.credit

        val latestupdate = view?.findViewById<TextView>(R.id.latestupdate)
        latestupdate?.text = syllabus.latestupdate

        val officehours = view?.findViewById<TextView>(R.id.officehours)
        officehours?.text = syllabus.officehours

        val rtadvice = view?.findViewById<TextView>(R.id.rtadvice)
        rtadvice?.text = syllabus.rtadvice

        val objective = view?.findViewById<TextView>(R.id.objective)
        objective?.text = syllabus.objective

        val edugoals = view?.findViewById<TextView>(R.id.edugoals)
        edugoals?.text = syllabus.edugoals

        val goals = view?.findViewById<TextView>(R.id.goals)
        goals?.text = syllabus.goals

        val schedule = view?.findViewById<TextView>(R.id.schedule)
        schedule?.text = syllabus.schedule

        val studyoutside = view?.findViewById<TextView>(R.id.studyoutside)
        studyoutside?.text = syllabus.studyoutside

        val keywords = view?.findViewById<TextView>(R.id.keywords)
        keywords?.text = syllabus.keywords

        val notice = view?.findViewById<TextView>(R.id.notice)
        notice?.text = syllabus.notice

        val evaluation = view?.findViewById<TextView>(R.id.evaluation)
        evaluation?.text = syllabus.evaluation

        val textbooks = view?.findViewById<TextView>(R.id.textbooks)
        textbooks?.text = syllabus.textbooks

        val related = view?.findViewById<TextView>(R.id.related)
        related?.text = syllabus.related

        val link = view?.findViewById<TextView>(R.id.link)
        link?.text = syllabus.link

        val notes = view?.findViewById<TextView>(R.id.notes)
        notes?.text = syllabus.notes

        println(view)

        return view!!
    }
}