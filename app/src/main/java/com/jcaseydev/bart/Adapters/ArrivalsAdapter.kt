package com.jcaseydev.bart.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jcaseydev.bart.Model2.Arrivals.Etd
import com.jcaseydev.bart.R

class ArrivalsAdapter(private val context: Context, private val stations: List<Etd>) : RecyclerView.Adapter<ArrivalsAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_arrivals, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val stationArrivals = stations[position].estimate
        val minutes = stationArrivals!![0].minutes
        val platform = stationArrivals[0].platform
        val length = stationArrivals[0].length

        holder.stationName.text = stations[position].destination
        holder.minutes.text = context.getString(R.string.arrivals_minutes, minutes)
        holder.platform.text = context.getString(R.string.arrivals_platform, platform)
        holder.length.text = context.getString(R.string.arrivals_length, length)
    }

    override fun getItemCount(): Int {
        return stations.size
    }

    inner class CustomViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {

        var stationName: TextView = mView.findViewById(R.id.destination_text_view)
        var minutes: TextView = mView.findViewById(R.id.minutes_text_view)
        var platform: TextView = mView.findViewById(R.id.platform_text_view)
        var length: TextView = mView.findViewById(R.id.train_length_text_view)

    }

}
