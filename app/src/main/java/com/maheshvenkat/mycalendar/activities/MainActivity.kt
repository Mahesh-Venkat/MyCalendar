package com.maheshvenkat.mycalendar.activities

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.util.Log

import com.maheshvenkat.mycalendar.MyCalendarApplication
import com.maheshvenkat.mycalendar.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyCalendarApplication.gsContext!!.get()

        Log.e("Service URL", MyCalendarApplication.serviceURl)
        Log.e("Test Url", MyCalendarApplication.testURL)
        Log.e("Mob Username", MyCalendarApplication.mobileUserName)
        Log.e("MOB Pass", MyCalendarApplication.mobilePassword)
        Log.e("OS Version", MyCalendarApplication.osVersion)
    }
}
