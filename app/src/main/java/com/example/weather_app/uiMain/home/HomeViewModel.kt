package com.example.weather_app.uiMain.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather_app.data.Utils
import com.example.weather_app.data.Weather
import com.example.weather_app.model.Repository
import com.example.weather_app.network.NetworkUtils
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class HomeViewModel:ViewModel() {

     var liveDataForCurrent = MutableLiveData<Weather> ()

    private val repository = Repository(NetworkUtils.getInstance())

    fun getWeather() {
        repository.getCurrentCity("Osh", Utils.API_KEY, "ru", "metric")
            .enqueue(object : retrofit2.Callback<Weather>{
                override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                    if (response.isSuccessful){
                        val weather = response.body() as Weather
                        Log.i("MyTag", weather.toString())
                        liveDataForCurrent.value = weather
                    }
                }

                override fun onFailure(call: Call<Weather>, t: Throwable) {
                    Log.i("MyTag", t.message.toString())
                }

            })
    }


    ///принимает и передает в viewModel то что снизу
//    fun getCurrentWeather(){
//        liveDataForCurrent.value = repository.getCurrentCity()
//    }
//
//    fun getListOfCities(){
//        liveDataForList.value = repository.getListOfCities()
//    }
//
//    fun subscribeCity() : MutableLiveData<Weather>{
//        return liveDataForCurrent
//    }
//
//    fun subscribeList() : MutableLiveData<List<Weather>>{
//        return liveDataForList
//    }
}