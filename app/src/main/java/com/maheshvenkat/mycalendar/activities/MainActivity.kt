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


class MainActivity : AppCompatActivity() {
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
            addEvent(it)
        }


//        Observable.fromCallable({
//            db = MyCalendarDatabase.getAppDataBase(context = this)
//            eventDao = db?.eventDao()
//
//            db?.eventDao()?.getAllEvents()
//        }).doOnNext({ eventList ->
//            var eventView: EventView<CalendarEvent>? = null
//            eventList?.map { eventView = addEvent(it) }
//            timelineLayout_day_view.addEvent(eventView)
//
//        }).doOnError({ throwable -> Log.e("MainActivity", "Throwable " + throwable.message) }).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe()
    }

    private fun addEvent(event: Event) {
        val startTimecalendar = Calendar.getInstance()
        startTimecalendar.setTimeInMillis(event.startTime)

        var time: String = String.format("%d.%d",
                startTimecalendar.get(Calendar.HOUR),
                startTimecalendar.get(Calendar.MINUTE))

        var sTime: Double = time.toDouble()

        val endTimeCalendar = Calendar.getInstance()
        endTimeCalendar.setTimeInMillis(event.endTime)
        time = String.format("%d.%d",
                endTimeCalendar.get(Calendar.HOUR),
                endTimeCalendar.get(Calendar.MINUTE))

        var eTime: Double = time.toDouble()

        var myEventView = EventView(this,
                CalendarEvent().apply {
                    startTime = sTime.toFloat()
                    endTime = eTime.toFloat()
                },
                itemsMargin = 1, //optional
                layoutResourceId = R.layout.calendar_event_layout, //optional
                setupView = { myView ->
                    //SETUP VIEW
                    myView.setBackgroundColor(Color.parseColor(event.eventColor))
                    myView.findViewById<TextView>(R.id.textviewEventTitle).text = event.eventTilte
                    myView.findViewById<TextView>(R.id.textviewEventTitle).setTextColor(Color.parseColor(event.eventTextColor))
                },
                onItemClick = { event ->
                    //CLICK EVENT
                }
        )

        timelineLayout_day_view.addEvent(myEventView)
    }
}
