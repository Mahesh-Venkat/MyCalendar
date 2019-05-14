package com.maheshvenkat.mycalendar.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

import com.maheshvenkat.mycalendar.entity.Event

@Dao
interface EventDao {

    @Query("SELECT * FROM event")
    fun getAllEvents(): List<Event>

    @Query("SELECT * FROM event where event_ID LIKE  :eventID AND event_title LIKE :eventTitle")
    fun findByName(eventID: String, eventTitle: String): Event

    @Query("SELECT COUNT(*) from event")
    fun countUsers(): Int

    @Insert
    fun insertAll(event: Event)

    @Insert
    fun insert(event: Event)

    @Delete
    fun delete(event: Event)
}