package com.example.coroutinelearning.example.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutinelearning.example.data.WeatherRepository
import com.example.coroutinelearning.example.data.model.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class WeatherViewModel() : ViewModel() {

    private val _uiState = MutableLiveData<WeatherUiState>()
    val uiState: LiveData<WeatherUiState> = _uiState
    var weatherRepository: WeatherRepository = WeatherRepository()

    init {
        getWeatherInfo()
    }

    private fun getWeatherInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.postValue( WeatherUiState(true, WeatherResponse(), ""))
            try {
                _uiState.postValue ( WeatherUiState(true, WeatherResponse(), ""))
                val info = weatherRepository.getWeatherInfo(
                    12.01,
                    12.01,
                    "",
                    "ff5fac6f7f2fa7e226c2fdffa8ed096c"
                )
                _uiState.value = WeatherUiState(false, info, "")
            } catch (e: Exception) {
                val errorMessage = e.message ?: ""
                _uiState.postValue( WeatherUiState(false, WeatherResponse(), errorMessage))
            }
        }
    }

data class WeatherUiState(
    var loading: Boolean,
    var info: WeatherResponse,
    var errorMessage: String
)
}