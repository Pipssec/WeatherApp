package com.example.weatherapp.di

import android.content.Context
import androidx.room.Room
import com.example.weatherapp.data.room.dao.CityDao
import com.example.weatherapp.data.room.database.CityDb
import com.example.weatherapp.data.room.repository.CityRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideBookDb(
        @ApplicationContext
        context : Context
    ) = Room.databaseBuilder(
        context,
        CityDb::class.java,
        "city_table"
    ).build()

    @Provides
    fun provideCityDao(
        cityDb: CityDb
    ) = cityDb.CityDao()

    @Provides
    fun provideCityRepository(
        cityDao: CityDao
    ): CityRepository = CityRepository(cityDao)
}