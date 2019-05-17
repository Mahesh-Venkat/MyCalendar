package com.maheshvenkat.mycalendar.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import java.util.*

import com.maheshvenkat.mycalendar.R
import com.maheshvenkat.mycalendar.entity.Event

import kotlinx.android.synthetic.

class EventsAdapter(val context: Context?, val eventList: ArrayList<Event>?) : RecyclerView.Adapter<EventsAdapter.EventViewHolder>() {

    override fun getItemCount(): Int {
        return eventList?.size ?: 0
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = eventList?.get(position)

        holder.titleView.text = item?.name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recyclerview_list_item, parent, false)
        return EventViewHolder(view)
    }

    inner class EventViewHolder (override val container : View) : RecyclerView.ViewHolder(containerView)
}