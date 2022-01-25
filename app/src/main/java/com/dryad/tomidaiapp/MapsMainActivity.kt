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
        val intent = Intent(this, PDFViewActivity::class.java)
        intent.putExtra("FILE", "m0gofuku1.pdf")
        startActivities(arrayOf(intent))
    }

    fun onFloorGBtnTapped(view: View?) {
        val intent = Intent(this, PDFViewActivity::class.java)
        intent.putExtra("FILE", "m1gofuku2.pdf")
        startActivities(arrayOf(intent))
    }

    fun onFloorSBtnTapped(view: View?) {
        val intent = Intent(this, PDFViewActivity::class.java)
        intent.putExtra("FILE", "m2sugitani.pdf")
        startActivities(arrayOf(intent))
    }

    fun onFloorTBtnTapped(view: View?) {
        val intent = Intent(this, PDFViewActivity::class.java)
        intent.putExtra("FILE", "m3takaoka.pdf")
        startActivities(arrayOf(intent))
    }
}