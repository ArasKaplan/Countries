package com.araskaplan.countries.data.local

import com.araskaplan.countries.data.model.CountryLocalModel
import com.araskaplan.countries.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CountryLocalDataSource @Inject constructor(
    private val countryDao: CountryDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
){
    suspend fun insertCountry(countryLocalModel: CountryLocalModel) = withContext(ioDispatcher){
        countryDao.insertCountry(countryLocalModel)
    }

    suspend fun getCountries() = withContext(ioDispatcher){
        countryDao.getCountries()
    }
}