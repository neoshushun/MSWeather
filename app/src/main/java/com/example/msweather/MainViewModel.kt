package com.example.msweather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.msweather.adapters.WeatherModel

class MainViewModel : ViewModel() {
    val liveDataCurrent = MutableLiveData<WeatherModel>()
    val liveDataList = MutableLiveData<List<WeatherModel>>()
}