package com.dryad.tomidaiapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LinksMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_links_main)
    }
    fun onMoodleBtnTapped(view: View?) {
        val intent = Intent(this, MoodleActivity::class.java)
        startActivity(intent)
    }
    fun onHearnBtnTapped(view: View?) {
        val intent = Intent(this, HearnActivity::class.java)
        startActivity(intent)
    }
}