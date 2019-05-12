package com.maheshvenkat.mycalendar.utils;

import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;

import com.maheshvenkat.mycalendar.MyCalendarDatabase;
import com.maheshvenkat.mycalendar.entity.Event;

import java.util.List;

public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getName();

    public static void populateAsync(@NonNull final MyCalendarDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final MyCalendarDatabase db) {
        populateWithTestData(db);
    }

    private static Event addEvent(final MyCalendarDatabase db, Event event) {
        db.eventDao().insertAll(event);
        return event;
    }

    private static void populateWithTestData(MyCalendarDatabase db) {
        Event event = new Event();
        event.setEventTilte("HairCut Appointment");
        event.setEventDescription("Haircut appointment with Ismail");
        event.setStartTime("12:30");
        event.setEndTime("01:30");
        event.setEventLocation("970 Sidney Marcus Blvd Atlanta GA 30324");
        event.setEventColor("#f49f9a");
        event.setEventTextColor("#000000");
        event.setThemeColor("#FFFFFF");
        event.setDarkThemeEventColor("#f49f9a");
        event.setDarkThemeEventTextColor("#FFFFFF");
        event.setEventStartDate("05-08-2019");
        event.setEventEndDate("05-08-2019");

        addEvent(db, event);


        Event event1 = new Event();
        event1.setEventTilte("Dinner");
        event1.setEventDescription("Diner With Mehboob");
        event1.setStartTime("06:30");
        event1.setEndTime("07:30");
        event1.setEventLocation("787 Ponce Deleon Terrace");
        event1.setEventColor("#fdfd96");
        event1.setEventTextColor("#000000");
        event1.setDarkThemeEventColor("#fdfd96");
        event1.setDarkThemeEventTextColor("#FFFFFF");
        event1.setThemeColor("#FFFFFF");
        event1.setEventStartDate("05-08-2019");
        event1.setEventEndDate("05-08-2019");

        addEvent(db, event1);

        Event event2 = new Event();
        event2.setEventTilte("BreakFast");
        event2.setEventDescription("BreakFast With Candace");
        event2.setStartTime("08:30");
        event2.setEndTime("10:30");
        event2.setEventLocation("1065 Peachtree st");
        event2.setEventColor("#afaffd");
        event2.setEventTextColor("#000000");
        event2.setThemeColor("#FFFFFF");
        event2.setDarkThemeEventColor("#afaffd");
        event2.setDarkThemeEventTextColor("#FFFFFF");
        event2.setEventStartDate("05-08-2019");
        event2.setEventEndDate("05-08-2019");

        addEvent(db, event2);

        List<Event> eventList = db.eventDao().getAll();
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + eventList.size());
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final MyCalendarDatabase mDb;

        PopulateDbAsync(MyCalendarDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }
    }
}
