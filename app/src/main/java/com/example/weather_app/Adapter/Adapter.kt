package com.example.weather_app.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weather_app.R
import com.example.weather_app.data.Weather
import com.example.weather_app.data.WeatherData
import com.example.weather_app.databinding.ItemBinding
import kotlinx.coroutines.newFixedThreadPoolContext

class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    var cityList: List<Weather> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    inner class ViewHolder(var binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(weather: Weather) = with(binding) {
            binding.apply {
                nameOfCity.text = weather.name
                temperature.text = weather.main.temp.toString()
                feels.text = weather.main.feelsLike.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val binding = ItemBinding.bind(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var holder = holder as ViewHolder
        holder.bind(cityList[position])
    }

    override fun getItemCount() = cityList.size


    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Weather>){
        cityList = list
        notifyDataSetChanged()
    }

}

