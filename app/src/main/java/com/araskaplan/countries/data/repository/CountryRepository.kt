package com.araskaplan.countries.data.repository

import com.araskaplan.countries.data.local.CountryLocalDataSource
import com.araskaplan.countries.data.remote.CountryRemoteDataSource
import javax.inject.Inject

class CountryRepository @Inject constructor(
    private val countryRemoteDataSource: CountryRemoteDataSource,
    private val countryLocalDataSource: CountryLocalDataSource
) {

    suspend fun fetchCountries() = countryRemoteDataSource.fetchCountries()
}