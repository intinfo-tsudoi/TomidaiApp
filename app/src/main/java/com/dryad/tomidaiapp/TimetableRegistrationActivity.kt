package com.dryad.tomidaiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class TimetableRegistrationActivity : AppCompatActivity() {
    // 選択肢
    private val spinnerDayOfWeek = arrayOf("月曜", "火曜", "水曜", "木曜", "金曜")
    private val spinnerPeriodOfTime = arrayOf("1限", "2限", "3限", "4限", "5限", "6限", "7限")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable_registration)

        // Spinnerの取得
        val spinner = findViewById<Spinner>(R.id.spinner1)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)

        // Adapterの生成
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerDayOfWeek)
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerPeriodOfTime)

        // 選択肢の各項目のレイアウト
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // AdapterをSpinnerのAdapterとして設定
        spinner.adapter = adapter1
        spinner2.adapter = adapter2
    }
}