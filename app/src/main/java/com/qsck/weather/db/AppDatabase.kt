package com.qsck.weather.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.qsck.weather.model.AdCode
import com.qsck.weather.model.Weather

@Database(entities = [Weather::class, AdCode::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao

    abstract fun adCodeDao(): AdCodeDao

}