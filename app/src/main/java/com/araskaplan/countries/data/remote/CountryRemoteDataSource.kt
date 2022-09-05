package com.araskaplan.countries.data.remote

import com.araskaplan.countries.common.Common
import com.araskaplan.countries.data.model.CountryRemoteModel
import com.araskaplan.countries.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CountryRemoteDataSource @Inject constructor(
    private val geoDbApi: GeoDbApi,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun fetchCountries() = withContext(ioDispatcher){
        geoDbApi.fetchCountries(Common.API_KEY,Common.API_HOST)
    }
}