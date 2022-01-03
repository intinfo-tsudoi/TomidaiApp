package com.dryad.tomidaiapp
import android.provider.BaseColumns

// データベースのテーブル名・項目名を定義
class DBContract  // 誤ってインスタンス化しないようにコンストラクタをプライベート宣言

private constructor() {
    // テーブルの内容を定義
    object DBSyllabus : BaseColumns {
        // BaseColumns インターフェースを実装することで、内部クラスは_IDを継承できる
        const val PRIMARYKEY = "PRIMARYKEY"
        const val C_classname = "classname"
        const val C_teacher = "teacher"
        const val C_classcategory = "classcategory"
        const val C_classtype = "classtype"
        const val C_coc = "coc"
        const val C_period = "period"
        const val C_faculty = "faculty"
        const val C_classregicode = "classregicode"
        const val C_grade = "grade"
        const val C_classnumcode = "classnumcode"
        const val C_credit = "credit"
        const val C_latestupdate = "latestupdate"
        const val C_officehours = "officehours"
        const val C_rtadvice = "rtadvice"
        const val C_objective = "objective"
        const val C_edugoals = "edugoals"
        const val C_goals = "goals"
        const val C_schedule = "schedule"
        const val C_studyoutside = "studyoutside"
        const val C_keywords = "keywords"
        const val C_notice = "notice"
        const val C_evaluation = "evaluation"
        const val C_textbooks = "textbooks"
        const val C_related = "related"
        const val C_link = "link"
        const val C_notes = "notes"

    }

}