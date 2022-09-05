package com.araskaplan.countries.domain.usecase.remote

import com.araskaplan.countries.domain.model.CountryDTO.toCountryHomePageUiModel
import com.araskaplan.countries.data.repository.CountryRepository
import com.araskaplan.countries.di.DefaultDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class fetchCountriesUseCase @Inject constructor(
    private val countryRepository: CountryRepository,
    @DefaultDispatcher private val defaultDispatcher : CoroutineDispatcher
) {
    suspend fun fetchCountries() = withContext(defaultDispatcher){
        countryRepository.fetchCountries().data.map {
            it.toCountryHomePageUiModel(true)//TODO : check if starred
        }
    }
}