package com.dryad.tomidaiapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import java.time.LocalDate

/**
 * The number of pages (wizard steps) to show in this demo.
 */
private const val NUM_PAGES = 5

class MainActivity : AppCompatActivity() {

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private lateinit var viewPager: ViewPager2

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.pager)

        // The pager adapter, which provides the pages to the view pager widget.
        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewPager.adapter = pagerAdapter

        val channelId = "NOTIFICATION_CHANNEL_ID"
        val channelName = "NOTIFICATION_CHANNEL_NAME"
        val channelDescription = "NOTIFICATION_CHANNEL_DESCRIPTION"

        //Android 8.0 以上ではアプリの通知チャンネルを登録することが必要。
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT //---*1
            val channel = NotificationChannel(channelId, channelName, importance).apply {
                description = channelDescription
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }

        //日付の取得。
        val date = LocalDate.now()

        //通知をシステムに登録しています。
        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.notification_icon)
            .setContentTitle("今日は")
            .setContentText(date.toString()+"です。")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val id = 0 //---*4
        NotificationManagerCompat.from(this).notify(id, builder.build())

    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = NUM_PAGES

        // スワイプ位置によって表示するFragmentを変更
        override fun createFragment(position: Int): Fragment =
            when(position) {
                0 -> {
                    ScreenSlidePageFragment()
                }
                1 -> {
                    ScreenSlidePageFragment()
                }
                2 -> {
                    ScreenSlidePageFragment2()
                }
                else -> {
                    ScreenSlidePageFragment2()
                }
            }
    }

    fun onTimetableBtnTapped(view: View){
        val intent = Intent(this, TimetableActivity::class.java)
        startActivities(arrayOf(intent))
    }

    fun onSyllabusButtonTapped(view: View){
        val intent = Intent(this, SearchActivity::class.java)
        startActivities(arrayOf(intent))
    }

    fun onMapButtonTapped(view: View){
        val intent = Intent(this, MapsMainActivity::class.java)
        startActivities(arrayOf(intent))
    }

    fun onBusBtnTapped(view: View?) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.u-toyama.ac.jp/studentsupport/student-support/shuttle_bus/"))
        startActivity(intent)
    }

    fun onSettingBtnTapped(view: View?) {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivities(arrayOf(intent))
    }

    fun onContactBtnTapped(view: View?) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.u-toyama.ac.jp/wp/wp-content/uploads/campusguide_cg02.pdf"))
        startActivity(intent)
    }

    fun onLinksBtnTapped(view: View){
        val intent = Intent(this, LinksMainActivity::class.java)
        startActivities(arrayOf(intent))
    }

    fun onTestBtnTapped(view: View){
        //val intent = Intent(this, SearchData::class.java)
        //startActivities(arrayOf(intent))
        val dialogFragment = AppDialogFragment()
        dialogFragment.show(supportFragmentManager, "test_dialog")
    }

}