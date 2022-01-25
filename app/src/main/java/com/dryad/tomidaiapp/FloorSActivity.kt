package com.dryad.tomidaiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.joanzapata.pdfview.PDFView


class FloorSActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floor_g_activity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val pdfView: PDFView = findViewById<View>(R.id.pdfview) as PDFView
        pdfView.fromAsset("m2sugitani.pdf")
            .enableSwipe(true) //スワイプオンオフ
            .swipeVertical(false) //縦スクロールでページ切り替え
            .showMinimap(true)
            .defaultPage(1) //初期表示ページ。表示ページのstate復旧はこれで
            .load()
    }
}