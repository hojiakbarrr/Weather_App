package com.example.weather_app.data

import com.google.gson.annotations.SerializedName

data class WeatherMain(

     val temp: Double,
    @SerializedName("feels_like")
     val feelsLike: Double,

    )
