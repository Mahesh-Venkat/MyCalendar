package com.maheshvenkat.mycalendar.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.TextView

import com.maheshvenkat.mycalendar.MyCalendarApplication
import com.maheshvenkat.mycalendar.MyCalendarDatabase
import com.maheshvenkat.mycalendar.R
import com.maheshvenkat.mycalendar.businessobjects.CalendarEvent
import com.maheshvenkat.mycalendar.dao.EventDao
import com.maheshvenkat.mycalendar.entity.Event
import com.maheshvenkat.mycalendar.utils.DatabaseInitializer
import com.roundtableapps.timelinedayviewlibrary.EventView

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit
import android.util.Log
import java.util.*


class MainActivity1 : AppCompatActivity() {
    private var db: MyCalendarDatabase? = null
    private var eventDao: EventDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DatabaseInitializer.populateAsync(MyCalendarDatabase.getAppDataBase(this)!!)

        MyCalendarApplication.gsContext!!.get()

        db = MyCalendarDatabase?.getAppDataBase(context = this)
        eventDao = db?.eventDao()

        var eventList: List<Event>? = eventDao?.getAllEvents()

        eventList?.forEach {

            //Display Event here

        }
    }
}
