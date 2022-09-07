package com.araskaplan.countries.domain.usecase.local

import com.araskaplan.countries.data.model.CountryLocalModel
import com.araskaplan.countries.data.repository.CountryRepository
import com.araskaplan.countries.di.DefaultDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class insertCountryUseCase @Inject constructor(
    private val countryRepository: CountryRepository,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
){

    suspend fun insertCountry(countryLocalModel: CountryLocalModel) = withContext(defaultDispatcher){
        countryRepository.insertCountry(countryLocalModel)
    }
}