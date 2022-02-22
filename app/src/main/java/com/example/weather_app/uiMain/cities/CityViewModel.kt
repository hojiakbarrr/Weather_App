package com.example.weather_app.uiMain.cities

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather_app.data.Utils
import com.example.weather_app.data.Weather
import com.example.weather_app.model.Repository
import com.example.weather_app.network.NetworkUtils
import retrofit2.Call
import retrofit2.Response

class CityViewModel : ViewModel() {
    var liveDataForCurrent1 = MutableLiveData<Weather> ()
    var liveDataForCurrent2 = MutableLiveData<Weather> ()
    var liveDataForCurrent3 = MutableLiveData<Weather> ()
    var liveDataForCurrent4 = MutableLiveData<Weather> ()

    private val repository = Repository(NetworkUtils.getInstance())


    fun getWeather1() {
        repository.getCurrentCity("Bishkek", Utils.API_KEY, "ru", "metric")
            .enqueue(object : retrofit2.Callback<Weather>{
                override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                    if (response.isSuccessful){
                        val weather1 = response.body() as Weather
                        Log.i("MyTag1", weather1.toString())
                        liveDataForCurrent1.value = weather1
                    }
                }

                override fun onFailure(call: Call<Weather>, t: Throwable) {
                    Log.i("MyTag1", t.message.toString())
                }

            })
    }


    fun getWeather2() {
        repository.getCurrentCity("Moscow", Utils.API_KEY, "ru", "metric")
            .enqueue(object : retrofit2.Callback<Weather>{
                override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                    if (response.isSuccessful){
                        val weather2 = response.body() as Weather
                        Log.i("MyTag2", weather2.toString())
                        liveDataForCurrent2.value = weather2
                    }
                }

                override fun onFailure(call: Call<Weather>, t: Throwable) {
                    Log.i("MyTag2", t.message.toString())
                }

            })
    }


    fun getWeather3() {
        repository.getCurrentCity("Antalya", Utils.API_KEY, "ru", "metric")
            .enqueue(object : retrofit2.Callback<Weather>{
                override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                    if (response.isSuccessful){
                        val weather3 = response.body() as Weather
                        Log.i("MyTag3", weather3.toString())
                        liveDataForCurrent3.value = weather3
                    }
                }

                override fun onFailure(call: Call<Weather>, t: Throwable) {
                    Log.i("MyTag3", t.message.toString())
                }

            })
    }




    fun getWeather4() {
        repository.getCurrentCity("Tashkent", Utils.API_KEY, "ru", "metric")
            .enqueue(object : retrofit2.Callback<Weather>{
                override fun onResponse(call4: Call<Weather>, response: Response<Weather>) {
                    if (response.isSuccessful){
                        val weather4 = response.body() as Weather
                        Log.i("MyTag4", weather4.toString())
                        liveDataForCurrent4.value = weather4
                    }
                }

                override fun onFailure(call: Call<Weather>, t: Throwable) {
                    Log.i("MyTag4", t.message.toString())
                }

            })
    }


}