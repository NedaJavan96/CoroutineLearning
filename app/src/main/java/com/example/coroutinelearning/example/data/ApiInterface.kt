package com.example.coroutinelearning.example.data

import com.example.coroutinelearning.example.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("/data/3.0/onecall")
    suspend fun callWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") APIkey: String
    ): WeatherResponse
}