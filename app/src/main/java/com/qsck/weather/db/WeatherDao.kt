package com.qsck.weather.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.qsck.weather.model.Weather
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weathers")
    fun getALl(): Flow<List<Weather>>

    @Query("SELECT * FROM weathers WHERE ad_code LIKE :adCode AND date LIKE :date LIMIT 1")
    fun findByAdCode(adCode: String, date: String): Weather?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg weathers: Weather)

    @Delete
    suspend fun delete(weather: Weather)
}