package com.dryad.tomidaiapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MapsMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps_main)
    }
    fun onGofukuBtnTapped(view: View?) {
        val intent = Intent(this, MapsGofukuActivity::class.java)
        startActivity(intent)
    }

    fun onSugitaniBtnTapped(view: View?) {
        val intent = Intent(this, MapsSugitaniActivity::class.java)
        startActivity(intent)
    }

    fun onTakaokaBtnTapped(view: View?) {
        val intent = Intent(this, MapsTakaokaActivity::class.java)
        startActivity(intent)
    }

    fun onFloorBtnTapped(view: View?) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.u-toyama.ac.jp/wp/wp-content/uploads/campusguide_cg01.pdf"))
        startActivity(intent)
    }
}