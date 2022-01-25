package com.dryad.tomidaiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class HearnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hearn)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val webView: WebView = findViewById(R.id.webView2)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.t-gakujo.adm.u-toyama.ac.jp/campusweb/campusportal.do")
    }
}