package com.araskaplan.countries.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.araskaplan.countries.data.model.CountryLocalModel

@Dao
interface CountryDao {
    @Query("Select * From countrylocalmodel")
    fun getCountries():List<CountryLocalModel>

    @Query("Select * From countrylocalmodel Where code = :code")
    fun getCountryByCode(code:String):CountryLocalModel

    @Insert
    fun insertCountry(countryLocalModel: CountryLocalModel)

    @Delete
    fun deleteCountry(countryLocalModel: CountryLocalModel)
}