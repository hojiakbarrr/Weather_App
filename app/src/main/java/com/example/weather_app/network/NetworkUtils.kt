package com.example.weather_app.network

import com.example.weather_app.data.Utils
import com.example.weather_app.data.Weather
import okio.Utf8
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkUtils {

    @GET("weather")
    fun getWeather(
        @Query("q") q: String,
        @Query("appid") appid: String,
        @Query("lang") lang: String,
        @Query("units") units: String,
    ) : Call<Weather>


    companion object{
        private var retrofitService: NetworkUtils? = null
        fun getInstance(): NetworkUtils{
            if (retrofitService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl(Utils.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                retrofitService = retrofit.create(NetworkUtils::class.java)
            }
            return retrofitService!!
        }
    }



}