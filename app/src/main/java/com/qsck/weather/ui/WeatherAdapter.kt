package com.qsck.weather.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qsck.weather.R
import com.qsck.weather.common.Utils
import com.qsck.weather.model.Weather

class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTemp: TextView = itemView.findViewById(R.id.tv_temp)
        val tvAddressMore: TextView = itemView.findViewById(R.id.tv_address_more)
        val tvWeather: TextView = itemView.findViewById(R.id.tv_weather)
        val tvWind: TextView = itemView.findViewById(R.id.tv_wind)
        val tvPower: TextView = itemView.findViewById(R.id.tv_power)
    }


    private val data = mutableListOf<Weather>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val weather = data[position]

        holder.tvTemp.text = "%s°/%s°".format(weather.daytemp, weather.nighttemp)
        holder.tvAddressMore.text = "%s 明天 %s".format(weather.city, Utils.getWeek(weather.week))
        holder.tvWeather.text = "%s/%s".format(weather.dayweather, weather.nightweather)
        holder.tvWind.text = "%s/%s".format(weather.daywind, weather.nightwind)
        holder.tvPower.text = "%s/%s".format(weather.daypower, weather.nightpower)
    }

    fun add(weather: Weather) {
        val index = data.indexOf(weather)
        if (index != -1) {
            data.remove(weather)
            notifyItemRemoved(index)
        }

        data.add(weather)
        notifyItemInserted(data.lastIndex)
    }

}