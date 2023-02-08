package com.example.weatherapp.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherapp.data.model.City

@Dao
interface CityDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(city: City)

    @Query("SELECT * FROM city_table")
    fun getCity(): LiveData<List<City>>

    @Query("DELETE FROM city_table")
    suspend fun deleteAll()
}