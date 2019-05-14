package com.maheshvenkat.mycalendar

import android.content.Context;
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.maheshvenkat.mycalendar.dao.EventDao
import com.maheshvenkat.mycalendar.entity.Event


@Database(entities = [Event::class], version = 1)
public abstract class MyCalendarDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao

    companion object {
        var INSTANCE: MyCalendarDatabase? = null

        fun getAppDataBase(context: Context): MyCalendarDatabase? {
            if (INSTANCE == null){
                synchronized(MyCalendarDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, MyCalendarDatabase::class.java, "myCalendarDB").allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}