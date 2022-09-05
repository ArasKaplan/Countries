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
        @Header("X-RapidAPI-Key") APIKEY: String,//TODO:Should be moved to DI module since it should be kept in deeper layer--
        @Header("X-RapidAPI-Host") Host: String,//TODO:--shouldnt add parameters each time of calling
        @Query("limit") limit: Int = 10,
    ): CountryRemoteResponse



    @GET("v1/geo/countries/{countryCode}")
    suspend fun fetchCountry(
        @Header("X-RapidAPI-Key") APIKEY: String,//TODO:Should be moved to DI module since it should be kept in deeper layer--
        @Header("X-RapidAPI-Host") Host: String,//TODO:--shouldnt add parameters each time of calling
        @Path("countryCode") countryCode: String
    ): CountryDetailsResponse

}