package com.jcaseydev.bart.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jcaseydev.bart.Model2.Stations.Station
import com.jcaseydev.bart.R

class StationListAdapter(private val context: Context, private val stationList: List<Station>,
                         private val stationListener: OnStationListener) : RecyclerView.Adapter<StationListAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_station, parent, false)
        return CustomViewHolder(view, stationListener)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val city = stationList[position].city
        val zipCode = stationList[position].zipcode
        holder.stationName.text = stationList[position].name
        holder.stationCity.text = context.getString(R.string.station_location, city, zipCode)
    }

    override fun getItemCount(): Int {
        return stationList.size
    }

    inner class CustomViewHolder(mView: View, var OnStationListener: OnStationListener) : RecyclerView.ViewHolder(mView), OnClickListener {
        var stationName: TextView = mView.findViewById(R.id.station_name)
        var stationCity: TextView = mView.findViewById(R.id.station_city)

        init {

            mView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            OnStationListener.onStationClick(adapterPosition)
        }
    }

    interface OnStationListener {
        fun onStationClick(position: Int)
    }
}
