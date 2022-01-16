package com.dryad.tomidaiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat.startActivities
import kotlinx.android.synthetic.main.activity_search_data.*
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader

class TimetableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable)
        setTimeTable()
    }

    fun setTimeTable(){
        val assetManager = resources.assets
        val inputStream = assetManager.open("empty_timetable.json")
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val str: String = bufferedReader.readText()
        Log.d("check", str)
        try {
            val jsonObject = JSONObject(str)
            val jsonArray = jsonObject.getJSONArray("timetable")
            for (i in 0 until jsonArray.length()) {
                val jsonData = jsonArray.getJSONObject(i)

                Log.d("Check", "$i : ${jsonData.getString("classname")}")
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        
    }

    fun ButtonTapped(view: View){
        val str_btn_id = resources.getResourceEntryName(view.id)//そのままだと数字の羅列で出てくるからこれで変換してるよ
        println(str_btn_id)
        val intent = Intent(this, TimetableRegistrationActivity::class.java)
        intent.putExtra("id", str_btn_id)
        startActivities(arrayOf(intent))
    }
}
