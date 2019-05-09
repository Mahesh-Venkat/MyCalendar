package com.maheshvenkat.mycalendar.activities

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.util.Log
import android.widget.TextView

import com.maheshvenkat.mycalendar.MyCalendarApplication
import com.maheshvenkat.mycalendar.R
import com.maheshvenkat.mycalendar.businessobjects.CalendarEvent
import com.roundtableapps.timelinedayviewlibrary.EventView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyCalendarApplication.gsContext!!.get()

        var myEventView = EventView(this,
                CalendarEvent().apply {
                    startTime = 10F
                    endTime = 11F
                },
                itemsMargin = 1, //optional
                layoutResourceId = R.layout.calendar_event_layout, //optional
                setupView = { myView ->
                    //SETUP VIEW
                    myView.setBackgroundColor(resources.getColor(android.R.color.holo_blue_dark))
                    myView.findViewById<TextView>(R.id.tvTitle).text = "First Event"
                },
                onItemClick = { event ->
                    //CLICK EVENT
                }
        )

        timelineLayout_day_view.addEvent(myEventView)
    }
}
