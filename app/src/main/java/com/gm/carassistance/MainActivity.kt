package com.gm.carassistance

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.gm.carassistance.adapter.ViewPagerAdapter

// TODO: This application is a sample to test the POC for Dialoflow
class MainActivity : AppCompatActivity() {

    private var appLinkAction: String? = null
    private var appLinkData: Uri? = null
    lateinit var viewPager: ViewPager
    var controlView = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("Intent test", "onCreate test method viewPager:")

        handleIntent(intent)

        viewPager = findViewById<ViewPager>(R.id.viewpager) as ViewPager
        viewPager.adapter = ViewPagerAdapter(
            supportFragmentManager,
            applicationContext
        )

        when {
            appLinkData != null -> {
                when {
                    appLinkData.toString().contains("oil", true) -> {
                        viewPager.currentItem = 0
                    }
                    appLinkData.toString().contains("hazard", true) -> {
                        viewPager.currentItem = 1
                    }
                    appLinkData.toString().contains("trunk", true) -> {
                        viewPager.currentItem = 2
                    }
                }
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        Log.d("Intent test", "onNewIntent test Method")
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {
        if (appLinkData == null) {
            appLinkAction = intent.action
            appLinkData = intent.data
        }

        Log.d(
            "Intent test", "handleIntent test Method appLinkAction: " + appLinkAction +
                    "appLinkData: " + appLinkData
        )

        if (Intent.ACTION_VIEW == appLinkAction) {
        // TODO: conditions based on the requirement,
            // this will get triggred
        }
    }
}
