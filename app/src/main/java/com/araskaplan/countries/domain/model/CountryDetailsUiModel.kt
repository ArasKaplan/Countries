package com.araskaplan.countries.domain.model

data class CountryDetailsUiModel( //Not necessary now but may need in future modifications
    val code: String,
    val callingCode: String,
    val flagImageUri: String,
    val name: String,
    val numRegions: String,
    val wikiDataId: String
)