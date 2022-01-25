package com.dryad.tomidaiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_settings_and_other.*

import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_search_data.*


class SettingsAndOtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_and_other)
        textView_versionname.text =
            "バージョン：${packageManager.getPackageInfo(packageName, 0).versionName}"

        val settings_title = arrayOf("設定", "お問い合わせ・フィードバック", "アプリ情報", "ライセンス情報")
        val adapter: ArrayAdapter<*> =
            ArrayAdapter<Any>(this, android.R.layout.simple_list_item_1, settings_title)
        listView_settings.adapter = adapter

        listView_settings.setOnItemClickListener {parent, view, position, id ->
            JampActivity(position)
        }

        appIcon.setImageResource(resources.getIdentifier("tomidaiapp_icon", "drawable", packageName))

    }

    fun JampActivity(position: Int){
        when(position){
            0 -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivities(arrayOf(intent))
            }
            1 -> {
                val intent = Intent(this, WebViewActivity::class.java)
                intent.putExtra("URL", "https://forms.gle/FNqo8SFQq3bKmHiU8")
                startActivities(arrayOf(intent))
            }
            2 -> {}
            3 -> {
                val intent = Intent(this, AppLicenceActivity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}