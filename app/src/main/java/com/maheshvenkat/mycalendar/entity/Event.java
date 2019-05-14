package com.maheshvenkat.mycalendar.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "event")
public class Event {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "event_ID")
    private int eventId;

    @ColumnInfo(name = "event_title")
    private String eventTilte;

    @ColumnInfo(name = "event_description")
    private String eventDescription;

    @ColumnInfo(name = "start_time")
    private long startTime;

    @ColumnInfo(name = "end_time")
    private long endTime;

    @ColumnInfo(name = "theme_color")
    private String themeColor;

    @ColumnInfo(name = "event_color")
    private String eventColor;

    @ColumnInfo(name = "event_text_color")
    private String eventTextColor;

    @ColumnInfo(name = "dark_theme_event_color")
    private String darkThemeEventColor;

    @ColumnInfo(name = "dark_theme_event_text_color")
    private String darkThemeEventTextColor;

    @ColumnInfo(name = "event_location")
    private String eventLocation;

    @ColumnInfo(name = "event_start_date")
    private String eventStartDate;

    @ColumnInfo(name = "event_end_date")
    private String eventEndDate;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventTilte() {
        return eventTilte;
    }

    public void setEventTilte(String eventTilte) {
        this.eventTilte = eventTilte;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(String themeColor) {
        this.themeColor = themeColor;
    }

    public String getEventColor() {
        return eventColor;
    }

    public void setEventColor(String eventColor) {
        this.eventColor = eventColor;
    }

    public String getEventTextColor() {
        return eventTextColor;
    }

    public void setEventTextColor(String eventTextColor) {
        this.eventTextColor = eventTextColor;
    }

    public String getDarkThemeEventColor() {
        return darkThemeEventColor;
    }

    public void setDarkThemeEventColor(String darkThemeEventColor) {
        this.darkThemeEventColor = darkThemeEventColor;
    }

    public String getDarkThemeEventTextColor() {
        return darkThemeEventTextColor;
    }

    public void setDarkThemeEventTextColor(String darkThemeEventTextColor) {
        this.darkThemeEventTextColor = darkThemeEventTextColor;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }
}
