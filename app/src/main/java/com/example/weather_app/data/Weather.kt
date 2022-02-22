package com.example.weather_app.data

class Weather(
     val coord: Coordinate,
     val weather: List<WeatherData>,
     val main: WeatherMain,
     val name: String
)
