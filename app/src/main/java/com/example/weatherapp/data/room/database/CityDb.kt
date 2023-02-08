package com.example.weatherapp.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weatherapp.data.model.City
import com.example.weatherapp.data.room.dao.CityDao

@Database(entities = [City::class], version = 1, exportSchema = false)
abstract class CityDb : RoomDatabase() {
    abstract fun CityDao(): CityDao
}