package com.araskaplan.countries.data.model


data class CountryRemoteModel(
    val code: String,
    val name: String,
    val wikiDataId: String
)

data class CountryRemoteResponse(
    val data: List<CountryRemoteModel>
)