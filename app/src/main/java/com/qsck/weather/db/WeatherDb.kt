package com.qsck.weather.db

import android.content.Context
import androidx.room.Room

object WeatherDb {

    private var db: AppDatabase? = null

    fun getDb(context: Context): AppDatabase {
        if (db == null) {
            synchronized(WeatherDb::class) {
                if (db == null) {
                    db = Room.databaseBuilder(
                        context, AppDatabase::class.java, "database-name"
                    ).build()
                }
            }
        }
        return db!!
    }
}