package com.dryad.tomidaiapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.view.WindowManager
import android.R.id

import android.R.id.button1
import android.widget.Button

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
        val intent = Intent(this, FloorActivity::class.java)
        startActivity(intent)
    }

    fun onFloorGBtnTapped(view: View?) {
        val intent = Intent(this, FloorGActivity::class.java)
        startActivity(intent)
    }

    fun onFloorSBtnTapped(view: View?) {
        val intent = Intent(this, FloorSActivity::class.java)
        startActivity(intent)
    }

    fun onFloorTBtnTapped(view: View?) {
        val intent = Intent(this, FloorTActivity::class.java)
        startActivity(intent)
    }
}