package com.dryad.tomidaiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val intent = intent
        val getURL = intent.getStringExtra("URL").toString()
        println(getURL)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val webView: WebView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(getURL)
    }
}