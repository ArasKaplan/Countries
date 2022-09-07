package com.araskaplan.countries.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.araskaplan.countries.data.model.CountryLocalModel

@Dao
interface CountryDao {
    @Query("Select * From countrylocalmodel")
    suspend fun getCountries():List<CountryLocalModel>

    @Query("Select * From countrylocalmodel Where code = :code")
    suspend fun getCountryByCode(code:String):CountryLocalModel

    @Insert
    suspend fun insertCountry(countryLocalModel: CountryLocalModel)

    @Delete
    suspend fun deleteCountry(countryLocalModel: CountryLocalModel)
}