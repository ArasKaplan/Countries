package com.araskaplan.countries.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.araskaplan.countries.data.model.CountryLocalModel

@Database(entities = [CountryLocalModel::class], version = 1)
abstract class CountryDatabase: RoomDatabase() {
    abstract fun countryDao(): CountryDao
}