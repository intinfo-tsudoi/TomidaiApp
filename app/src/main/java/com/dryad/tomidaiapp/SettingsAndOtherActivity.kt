package com.dryad.tomidaiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_settings_and_other.*

import android.widget.ArrayAdapter


class SettingsAndOtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_and_other)
        textView_versionname.text =
            "バージョン：${packageManager.getPackageInfo(packageName, 0).versionName}"

        val settings_title = arrayOf("時間割の設定", "その他", "アプリ情報")
        val adapter: ArrayAdapter<*> =
            ArrayAdapter<Any>(this, android.R.layout.simple_list_item_1, settings_title)
        listView_settings.adapter = adapter

        listView_settings.setOnItemClickListener {parent, view, position, id ->
            JampActivity(position)
        }

    }

    fun JampActivity(position: Int){
        when(position){
            0 -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivities(arrayOf(intent))
            }
            1 -> {}
            2 -> {}
        }
    }
}