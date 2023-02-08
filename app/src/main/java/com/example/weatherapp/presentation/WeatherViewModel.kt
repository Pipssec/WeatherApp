package com.example.weatherapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.model.City
import com.example.weatherapp.data.room.repository.CityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: CityRepository): ViewModel() {
    private val _allWords: LiveData<List<City>> = repository.cityList
    val allWords: LiveData<List<City>>
        get() = _allWords



    fun insert(city: City) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(city)
    }

    fun delete() = viewModelScope.launch(Dispatchers.IO) {
        repository.delete()
    }
}