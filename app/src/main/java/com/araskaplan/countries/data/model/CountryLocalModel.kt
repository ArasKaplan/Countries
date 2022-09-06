package com.araskaplan.countries.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CountryLocalModel(
    @PrimaryKey val code: String,
    val callingCode: String,
    val flagImage: String,
    val name: String,
    val numRegions: String,
    val wikiDataId: String
)