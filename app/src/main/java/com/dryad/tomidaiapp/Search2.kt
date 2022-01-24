package com.dryad.tomidaiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.dryad.tomidaiapp.databinding.ActivitySearch2Binding
import kotlinx.android.synthetic.main.activity_search1.*
import kotlinx.android.synthetic.main.activity_search2.*

class Search2 : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivitySearch2Binding
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null

    /*companion object {
        const val EXTRA_TEXTDATA = "com.usaco_pg.intentsample.TEXTDATA"
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearch2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        spinner1 = findViewById<Spinner>(R.id.spinner1)
        spinner2 = findViewById<Spinner>(R.id.spinner2)
        val adapter1 = ArrayAdapter.createFromResource(
            this,
            R.array.list1, android.R.layout.simple_spinner_item
        )
        spinner1?.adapter = adapter1
        spinner1?.onItemSelectedListener = this


        binding.shosai.setOnClickListener {
            val intent = Intent(this, Results2::class.java)
            val spinner1 : Spinner = findViewById(R.id.spinner1)
            intent.putExtra("SEND_DATA1", spinner1.selectedItem.toString())
            val spinner2 : Spinner = findViewById(R.id.spinner2)
            intent.putExtra("SEND_DATA2", spinner2.selectedItem.toString())
            val spinner3 : Spinner = findViewById(R.id.spinner3)
            intent.putExtra("SEND_DATA3", spinner3.selectedItem.toString())
            val spinner4 : Spinner = findViewById(R.id.spinner4)
            intent.putExtra("SEND_DATA4", spinner4.selectedItem.toString())
            val spinner5 : Spinner = findViewById(R.id.spinner5)
            intent.putExtra("SEND_DATA5", spinner5.selectedItem.toString())
            val spinner6 : Spinner = findViewById(R.id.spinner6)
            intent.putExtra("SEND_DATA6", spinner6.selectedItem.toString())
            startActivities(arrayOf(intent))
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the main; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onItemSelected(
        parent: AdapterView<*>, view: View, position: Int,
        id: Long
    ) {
        if (spinner1?.selectedItem == "教養教育") {
            Toast.makeText(
                applicationContext, "Mobil dipilih",
                Toast.LENGTH_SHORT
            ).show()
            val adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.kyoyo, android.R.layout.simple_spinner_item
            )
            spinner2?.adapter = adapter2
        }
        if (spinner1?.selectedItem == "人文学部") {
            val adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.jinbun, android.R.layout.simple_spinner_item
            )
            spinner2?.adapter = adapter2
        }
        if (spinner1?.selectedItem == "人間発達科学部") {
            val adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.jinpatsu, android.R.layout.simple_spinner_item
            )
            spinner2?.adapter = adapter2
        }
        if (spinner1?.selectedItem == "経済学部") {
            val adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.keizai, android.R.layout.simple_spinner_item
            )
            spinner2?.adapter = adapter2
        }
        if (spinner1?.selectedItem == "理学部") {
            val adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.rigaku, android.R.layout.simple_spinner_item
            )
            spinner2?.adapter = adapter2
        }
        if (spinner1?.selectedItem == "医学部") {
            val adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.igaku, android.R.layout.simple_spinner_item
            )
            spinner2?.adapter = adapter2
        }
        if (spinner1?.selectedItem == "薬学部") {
            val adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.yakugaku, android.R.layout.simple_spinner_item
            )
            spinner2?.adapter = adapter2
        }
        if (spinner1?.selectedItem == "工学部") {
            val adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.kogaku, android.R.layout.simple_spinner_item
            )
            spinner2?.adapter = adapter2
        }
        if (spinner1?.selectedItem == "芸術文化学部") {
            val adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.geibun, android.R.layout.simple_spinner_item
            )
            spinner2?.adapter = adapter2
        }
        if (spinner1?.selectedItem == "都市デザイン学部") {
            val adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.toshideza, android.R.layout.simple_spinner_item
            )
            spinner2?.adapter = adapter2
        }
    }
    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    fun onBackPressed(view: View) {
        super.onBackPressed()
    }
}
