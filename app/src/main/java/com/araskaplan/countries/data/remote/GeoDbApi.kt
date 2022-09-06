package com.araskaplan.countries.data.remote

import com.araskaplan.countries.data.model.CountryDetailsModel
import com.araskaplan.countries.data.model.CountryDetailsResponse
import com.araskaplan.countries.data.model.CountryRemoteModel
import com.araskaplan.countries.data.model.CountryRemoteResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface GeoDbApi {

    @GET("v1/geo/countries")
    suspend fun fetchCountries(
        @Query("limit") limit: Int = 10,
    ): CountryRemoteResponse



    @GET("v1/geo/countries/{countryCode}")
    suspend fun fetchCountry(
        @Path("countryCode") countryCode: String
    ): CountryDetailsResponse

}