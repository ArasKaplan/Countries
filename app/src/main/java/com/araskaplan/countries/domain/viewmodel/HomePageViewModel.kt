package com.araskaplan.countries.domain.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.araskaplan.countries.di.DefaultDispatcher
import com.araskaplan.countries.domain.model.CountryHomePageUiModel
import com.araskaplan.countries.domain.usecase.remote.fetchCountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(
    private val fetchCountriesUseCase: fetchCountriesUseCase
) : ViewModel() {
    val countryList = MutableLiveData<List<CountryHomePageUiModel>>(arrayListOf())






    fun fetchCountries(){
        viewModelScope.launch {
            countryList.value = fetchCountriesUseCase.fetchCountries()
        }
    }


}