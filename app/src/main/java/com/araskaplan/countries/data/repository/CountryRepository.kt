package com.araskaplan.countries.data.repository

import com.araskaplan.countries.data.local.CountryLocalDataSource
import com.araskaplan.countries.data.model.CountryLocalModel
import com.araskaplan.countries.data.remote.CountryRemoteDataSource
import javax.inject.Inject

class CountryRepository @Inject constructor(
    private val countryRemoteDataSource: CountryRemoteDataSource,
    private val countryLocalDataSource: CountryLocalDataSource
) {

    suspend fun fetchCountries() = countryRemoteDataSource.fetchCountries()

    suspend fun fetchCountry(countryCode:String) = countryRemoteDataSource.fetchCountry(countryCode)

    suspend fun insertCountry(countryLocalModel: CountryLocalModel) = countryLocalDataSource.insertCountry(countryLocalModel)

    suspend fun getCountries() = countryLocalDataSource.getCountries()
}