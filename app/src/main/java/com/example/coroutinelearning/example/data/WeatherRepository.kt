package com.example.coroutinelearning.example.data

import com.example.coroutinelearning.base.RetrofitClient
import com.example.coroutinelearning.example.data.model.WeatherResponse

class WeatherRepository() {
    var client: ApiInterface? = RetrofitClient().getClient()?.create(ApiInterface::class.java)

    suspend fun getWeatherInfo(
        lat: Double,
        lon: Double,
        type: String,
        key: String
    ): WeatherResponse {
        return client?.callWeather(lat, lon, key)!!
    }
}