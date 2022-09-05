package com.araskaplan.countries.data.model


data class CountryRemoteModel(
    val code: String,
    val name: String,
    val wikiDataId: String
)

data class CountryRemoteResponse(
    val data: List<CountryRemoteModel>
)

data class CountryDetailsModel(
    val code: String,
    val callingCode: String,
    val flagImageUri: String,
    val name: String,
    val numRegions: String,
    val wikiDataId: String
)

data class CountryDetailsResponse(
    val data: CountryDetailsModel
)