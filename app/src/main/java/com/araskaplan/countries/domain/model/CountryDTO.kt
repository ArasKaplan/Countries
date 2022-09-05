package com.araskaplan.countries.domain.model

import com.araskaplan.countries.data.model.CountryRemoteModel

object CountryDTO {

    fun CountryRemoteModel.toCountryHomePageUiModel(isStarred: Boolean): CountryHomePageUiModel {
        return CountryHomePageUiModel(
            this.name,
            isStarred,
            this.code
        )
    }

}