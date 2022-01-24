package com.dryad.tomidaiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        GlobalScope.launch {
            AppDatabase.getDatabase_sy(applicationContext).DataBaseDao_sy().getAll().forEach {
                Log.d("MainActivity", "${it.id}")
                /*ログに授業名吐き出すよ*/
            }
        }
    }
}