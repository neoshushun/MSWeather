package com.example.msweather.adapters

import java.time.temporal.Temporal

data class WeatherModel(
    val city: String,
    val time: String,
    val condition: String,
    val currentTemp: String,
    val maxTemp: String,
    val minTemp: String,
    val imgUrl: String,
    val hours: String
)