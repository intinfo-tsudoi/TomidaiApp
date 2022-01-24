package com.dryad.tomidaiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class P2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p2)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val webView: WebView = findViewById(R.id.webViewP2)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.u-toyama.ac.jp/anpic/")
    }
}