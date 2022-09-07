package com.araskaplan.countries.domain.usecase.remote

import com.araskaplan.countries.data.repository.CountryRepository
import com.araskaplan.countries.di.DefaultDispatcher
import com.araskaplan.countries.domain.model.CountryDTO.toCountryDetailsUiModel
import com.araskaplan.countries.domain.model.CountryDTO.toCountryLocalModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class fetchCountryUseCase @Inject constructor(
    private val countryRepository: CountryRepository,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
) {

    suspend fun fetchCountry(countryCode:String) = withContext(defaultDispatcher){
        countryRepository.fetchCountry(countryCode).data.toCountryDetailsUiModel()
    }
}