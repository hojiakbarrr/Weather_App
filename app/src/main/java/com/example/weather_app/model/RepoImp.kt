package com.example.weather_app.model

import com.example.weather_app.data.Weather
import retrofit2.Call

interface RepoImp {

    fun getCurrentCity(q: String, appId: String, lang: String, units: String) : Call<Weather>
//    fun getListOfCities() : List<Weather>

}