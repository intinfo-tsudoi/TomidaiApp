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
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://lms.u-toyama.ac.jp/login/index.php"))
        startActivity(intent)
    }
    fun onHearnBtnTapped(view: View?) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.t-gakujo.adm.u-toyama.ac.jp/campusweb/campusportal.do"))
        startActivity(intent)
    }
}