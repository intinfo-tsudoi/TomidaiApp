package com.dryad.tomidaiapp

data class Syllabus(
    var classname: String? = null,
    var classname_jp: String? = null,
    var classname_en: String? = null,
    var teacher: String? = null,
    var classcategory: String? = null,
    var classtype: String? = null,
    var coc: String? = null,
    var period: String? = null,
    var faculty: String? = null,
    var classregicode: String? = null,
    var grade: String? = null,
    var classnumcode: String? = null,
    var credit: String? = null,
    var latestupdate: String? = null,
    var officehours: String? = null,
    var rtadvice: String? = null,
    var objective: String? = null,
    var edugoals: String? = null,
    var goals: String? = null,
    var schedule: String? = null,
    var studyoutside: String? = null,
    var keywords: String? = null,
    var notice: String? = null,
    var evaluation: String? = null,
    var textbooks: String? = null,
    var related: String? = null,
    var link: String? = null,
    var notes: String? = null
)

data class SylalbusforRegist(
    var classname: String? = null,
    var classname_jp: String? = null,
    var classname_en: String? = null,
    var teacher: String? = null,
    var period: String? = null,
)