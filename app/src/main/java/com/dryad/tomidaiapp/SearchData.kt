package com.dryad.tomidaiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_search_data.*

class SearchData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_data)
    }

    fun onTappedSearch(view: View){
        val intent = Intent(this, ListData::class.java)
        intent.putExtra("SEND_DATA", input_to_search.text.toString())
        startActivities(arrayOf(intent))
    }

    /*リストに授業名でも流し込んでとりあえず表示したい*/


    override fun onDestroy() {

        // アクティビティの終了
        super.onDestroy()
    }
}