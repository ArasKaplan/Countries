package com.araskaplan.countries.domain.usecase.local

import com.araskaplan.countries.data.repository.CountryRepository
import com.araskaplan.countries.di.DefaultDispatcher
import com.araskaplan.countries.domain.model.CountryDTO.toCountryHomePageUiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class getCountriesUseCase @Inject constructor(
    private val countryRepository: CountryRepository,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
) {

    suspend fun getCountries() = withContext(defaultDispatcher){
        countryRepository.getCountries().map { it.toCountryHomePageUiModel() }
    }
}