package com.qsck.weather.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.qsck.weather.model.AdCode
import kotlinx.coroutines.flow.Flow

@Dao
interface AdCodeDao {

    @Query("SELECT * FROM adcodes")
    suspend fun getALl(): List<AdCode>

    @Query("SELECT * FROM adcodes WHERE find_address LIKE :address LIMIT 1")
    suspend fun findByAddress(address: String): AdCode?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg adCodes: AdCode)

    @Delete
    suspend fun delete(adCode: AdCode)
}