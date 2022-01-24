package com.dryad.tomidaiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_app_info.*
import kotlinx.android.synthetic.main.activity_settings_and_other.*

class AppInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_info)

        val appInfo = arrayOf("アプリ名：TomidaiApp", "制作：創造ものづくりW班")
        val adapter: ArrayAdapter<*> =
            ArrayAdapter<Any>(this, android.R.layout.simple_list_item_1, appInfo)
        listView_appInfo.adapter = adapter

    }
}