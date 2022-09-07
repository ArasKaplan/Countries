package com.araskaplan.countries.domain.model

import com.araskaplan.countries.data.model.CountryDetailsModel
import com.araskaplan.countries.data.model.CountryLocalModel
import com.araskaplan.countries.data.model.CountryRemoteModel

object CountryDTO {

    fun CountryRemoteModel.toCountryHomePageUiModel(isStarred: Boolean): CountryHomePageUiModel {
        return CountryHomePageUiModel(
            country = this.name,
            isStarred = isStarred,
            countryCode = this.code
        )
    }
    fun CountryDetailsModel.toCountryDetailsUiModel(): CountryDetailsUiModel {
        return CountryDetailsUiModel(
            code = code,
            callingCode = callingCode,
            flagImageUri = flagImageUri,
            name = name,
            numRegions = numRegions,
            wikiDataId = wikiDataId
        )
    }

    fun CountryDetailsUiModel.toCountryLocalModel(): CountryLocalModel {
        return CountryLocalModel(
            code = code,
            callingCode = callingCode,
            flagImageUrl = flagImageUri,
            name = name,
            numRegions = numRegions,
            wikiDataId = wikiDataId
        )
    }

    fun CountryLocalModel.toCountryHomePageUiModel(): CountryHomePageUiModel{
        return CountryHomePageUiModel(
            country = this.name,
            isStarred = true,
            countryCode = this.code
        )
    }

}