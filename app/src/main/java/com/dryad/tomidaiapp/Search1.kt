package com.dryad.tomidaiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_search1.*
import kotlinx.android.synthetic.main.activity_timetable_registration.*

class Search1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search1)
    }

    fun onTappedSearch1(view: View){
        val text_search = editText.text.toString()
        Log.d("Searched", text_search)
        if(text_search.length == 0){
            val dialogFragment: DialogFragment = search_notext_DialogFragment()
            dialogFragment.show(supportFragmentManager, "search_notext_dialog")
        }else{
            val intent = Intent(this, Results1::class.java)
            intent.putExtra("SEND_DATA", editText.text.toString())
            startActivities(arrayOf(intent))
        }
    }

    fun onBackPressed(view: View) {
        super.onBackPressed()
    }

    /*リストに授業名でも流し込んでとりあえず表示したい*/


    override fun onDestroy() {

        // アクティビティの終了
        super.onDestroy()
    }

}