package com.dryad.tomidaiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun ButtonTapped(view: View){
        val intent = Intent(this, SubActivity::class.java)
        startActivities(arrayOf(intent))
    }






}