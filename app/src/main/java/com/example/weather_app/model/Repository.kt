package com.example.weather_app.model

import com.example.weather_app.data.Weather
import com.example.weather_app.network.NetworkUtils
import retrofit2.Call
import java.net.NetworkInterface

class Repository(val networkUtils: NetworkUtils) : RepoImp {


    //    override fun getCurrentCity(): Weather {
//        //TODO api request для получения текущей погоды
//        return Weather("Moscow","55.78","37.61","24","23")
//    }
//
//    override fun getListOfCities(): List<Weather> {
//        val weatherList = mutableListOf<Weather>()
//        weatherList.add(Weather("Moscow","55.78","37.61","24","23"))
//        weatherList.add(Weather("Moscow","55.78","37.61","25","21"))
//        weatherList.add(Weather("Moscow","55.78","37.61","25","22"))
//        return weatherList
//    }
    override fun getCurrentCity(q: String, appId: String, lang: String, units: String,
    ): Call<Weather> {
        return networkUtils.getWeather(q, appId, lang, units)
    }


}