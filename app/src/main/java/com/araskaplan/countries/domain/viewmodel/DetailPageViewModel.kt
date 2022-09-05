package com.araskaplan.countries.domain.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.araskaplan.countries.domain.model.CountryDetailsUiModel
import com.araskaplan.countries.domain.usecase.remote.fetchCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailPageViewModel @Inject constructor(
    private val fetchCountryUseCase: fetchCountryUseCase
): ViewModel() {

    val countryDetails = MutableLiveData<CountryDetailsUiModel>()


    fun fetchCountryDetails(countryCode:String){
        viewModelScope.launch {
            countryDetails.value = fetchCountryUseCase.fetchCountry(countryCode)
        }
    }
}