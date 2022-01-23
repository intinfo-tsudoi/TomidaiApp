package com.dryad.tomidaiapp

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
        }

        override fun onPreferenceTreeClick(preference: Preference?): Boolean {

            return when (preference?.key) {
                "delete_timetable" -> {
                    AlertDialog.Builder(requireContext())
                        .setTitle("時間割の削除")
                        .setMessage("保存されている時間割を削除します\n削除されたデータは元に戻せません")
                        .setPositiveButton("OK") { _, _ ->
                            deleteTimetable()
                        }
                        .setNegativeButton("キャンセル", null)
                        .show()
                    false
                }
                else -> {
                    true
                }
            }
        }

        private fun deleteTimetable(){
            GlobalScope.launch {
                AppDatabase.getDatabase_tt(requireContext()).DataBaseDao_tt().getAll().forEach {
                    Log.d("MainActivity", "${it.date_time}${it.classname_jp}${it.classname_en}")
                    AppDatabase.getDatabase_tt(requireContext()).DataBaseDao_tt().updateTimetable("${it.date_time}","","","","","","","")
                }
            }
        }

    }


}