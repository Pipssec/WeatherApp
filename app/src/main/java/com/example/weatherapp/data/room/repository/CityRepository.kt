package com.example.weatherapp.data.room.repository

import androidx.lifecycle.LiveData
import com.example.weatherapp.data.model.City
import com.example.weatherapp.data.room.dao.CityDao

class CityRepository(private val cityDao: CityDao) {
    val cityList: LiveData<List<City>> = cityDao.getCity()

    suspend fun insert(city: City){
        cityDao.insert(city)
    }

    suspend fun delete(){
        cityDao.deleteAll()
    }
}